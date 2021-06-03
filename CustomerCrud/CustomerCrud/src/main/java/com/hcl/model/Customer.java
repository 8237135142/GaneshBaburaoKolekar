package com.hcl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int customerId;
	
	private String customerName;
	
	private String customerAddress;

}
