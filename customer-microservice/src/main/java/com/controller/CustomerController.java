package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Customer;
import com.entity.Loan;
import com.exception.CustomException;
import com.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer registeredCustomer = customerService.registerCustomer(customer);
        return ResponseEntity.status(201).body(registeredCustomer);
    }

    @PostMapping("/login")
    public ResponseEntity<Customer> login(@RequestParam String email, @RequestParam String password) {
        Customer customer = customerService.login(email, password);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/loans")
    public ResponseEntity<List<Loan>> viewLoanOptions(@RequestParam String type) {
        List<Loan> loans = customerService.viewLoanOptions(type);
        return ResponseEntity.ok(loans);
    }

    @PostMapping("/{customerId}/apply/{loanId}")
    public ResponseEntity<Loan> applyForLoan(@PathVariable Long customerId, @PathVariable Long loanId) {
        Loan loan = customerService.applyForLoan(customerId, loanId);
        return ResponseEntity.ok(loan);
    }

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<String> handleCustomerExceptions(Exception ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }
}

