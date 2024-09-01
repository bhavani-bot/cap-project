package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;  // Change to Long to match DTO type

    @Column(name = "customer_name")
    @NotEmpty(message = "Customer Name is Required")
    private String customerName;

    @Column(name = "email")
    @NotEmpty(message = "Email is Required")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Password is Required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @Column(name = "phone_number")
    @NotEmpty(message = "Phone Number is Required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    private String phoneNumber;

//    @Column(name = "hasAppliedForLoan")
//    private Boolean hasAppliedForLoan = false; // Default to false

    @Column(name = "loan_type")
    private String loanType;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public Boolean getHasAppliedForLoan() {
//        return hasAppliedForLoan;
//    }
//
//    public void setHasAppliedForLoan(Boolean hasAppliedForLoan) {
//        this.hasAppliedForLoan = hasAppliedForLoan;
//    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Customer(Long id, String customerName, String email, String password, String phoneNumber, Boolean hasAppliedForLoan, String loanType) {
        this.id = id;
        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
//        this.hasAppliedForLoan = hasAppliedForLoan;
        this.loanType = loanType;
    }

    public Customer() {
        // Default constructor
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", customerName=" + customerName + ", email=" + email + ", password=" + password 
            + ", phoneNumber=" + phoneNumber + " loanType=" + loanType + "]";
    }
}
