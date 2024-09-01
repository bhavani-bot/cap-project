package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Loan;

@Repository
public interface LoanRepository  extends CrudRepository<Loan, Long> {

	 List<Loan> findByType(String type);
		
}
