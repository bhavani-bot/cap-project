package com.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	 
	@Column(name = "type")
	@NotBlank(message = "Type of the loan required")
    @Size(min = 1, max = 50, message = "loan reference ID must be between 1 and 50 characters")
	private String type;

	@Column(name = "description")
	@NotBlank(message = "description is required")
    @Size(min = 1, max = 50, message = "description must be between 1 and 50 characters")
	private String description;

  
	@Column(name = "price")
	@NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be zero or a positive value")
	private BigDecimal price;
	   

	public Long getId() {
		return id;
	}

	public void setId(Long roomId) {
		this.id = roomId;
	}

	public String getLoanType() {
		return type;
	}

	public void setLoanType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Loan() {
		super();
			// TODO Auto-generated constructor stub
	}

	public Loan(Long id, String type, String description,BigDecimal price) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", type=" + type + ", description=" + description + ", price=" + price + "]";
	}
		
	
}
