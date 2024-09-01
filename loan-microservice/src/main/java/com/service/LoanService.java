package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Loan;
import com.exception.CustomException;
import com.repository.LoanRepository;
@Service
public class LoanService  {

	@Autowired
	LoanRepository loanRepository;

	private static Logger logger = LoggerFactory.getLogger(LoanService.class);
	
	 public Loan getLoanById(Long id) {
		 logger.info("iam here bye");
	        return loanRepository.findById(id).orElseThrow(() -> new CustomException("Loan not found for id: " + id));
	    }

	  public List<Loan> getLoansByType(String type) {
	        List<Loan> loans = loanRepository.findByType(type);
	        if (loans.isEmpty()) {
	            throw new CustomException("No loans found for type: " + type);
	        }
	        return loans;
	    }
}
