package com.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
    // Additional methods if needed
}
