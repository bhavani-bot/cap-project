package com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Customer;
import com.exception.CustomException;
import com.repository.CustomerRepository;
import com.repository.LoanApplicationRepository;
import com.repository.LoanClient;
import com.entity.Loan;
import com.entity.LoanApplication;

@Service
public class CustomerService {
	private static Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Autowired
    private LoanClient loanClient;

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer login(String email, String password) {
        Customer customer = customerRepository.findByEmail(email)
            .orElseThrow(() -> new CustomException("Customer not found for email: " + email));

        if (!customer.getPassword().equals(password)) {
            throw new CustomException("Invalid credentials");
        }

        return customer;
    }

    public List<Loan> viewLoanOptions(String type) {
        return loanClient.getLoansByType(type);
    }

    public Loan applyForLoan(Long customerId, Long loanId) {
        // Retrieve the customer from the repository
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new CustomException("Customer not found for id: " + customerId));
        logger.info("Customer details: {}", customer);

        // Fetch the loan details from the loan microservice
        Loan loan = null;
        try {
            loan = loanClient.getLoanById(loanId);
        } catch (Exception e) {
            logger.error("Error fetching loan details", e);
        }
        
        logger.info("Loan details: {}", loan);

        // Check if the customer has already applied for the loan
        if (customer.getLoanType() != null && customer.getLoanType().equals(loan.getLoanType())) {
            throw new CustomException("Customer has already applied for this type of loan: " + loan.getLoanType());
        }

        // Set the loan type for the customer
        customer.setLoanType(loan.getLoanType());
        
        // Save the updated customer details
        customerRepository.save(customer);
        
        logger.info("Loan applied successfully for customer ID: {}", customerId);

        // Return the loan details
        return loan;
    }

}

