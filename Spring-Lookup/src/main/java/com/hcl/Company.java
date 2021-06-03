package com.hcl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;

import lombok.Data;

@Data
public class Company {

	private String companyName;
	private int companyId;

	@Autowired
	private Address address;

	public Address getAddress() {
		Address address = address();
		return address;
	}

	@Lookup
	public Address address() {
		return null;
	}

	public Company() {
		System.out.println("HCL Tech");
	}

}
