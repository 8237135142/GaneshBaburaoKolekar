package com.hcl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString
@Component
public class Company {

	public Company() {
		System.out.println("HCL Technologies");
	}

	private String companyName;
	private int companyId;
	@Autowired
	// @Qualifier("address1")
	private Address address;
	
	public void setAddress(){
		Address address = getAdress();
	}

	@Lookup
	public Address getAdress() {
		// TODO Auto-generated method stub
		return null;
	}

}

// creates address bean
// creates company bean
// then injects address into company