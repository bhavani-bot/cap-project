package com.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.configuration.FeignConfig;
import com.entity.Loan;

@FeignClient(name = "loan-microservice", url = "http://localhost:9002", configuration = FeignConfig.class)
public interface LoanClient {
    @GetMapping("/loan/{id}")
    Loan getLoanById(@PathVariable("id") Long id);

    @GetMapping("/loan/type/{type}")
    List<Loan> getLoansByType(@PathVariable("type") String type);
}

