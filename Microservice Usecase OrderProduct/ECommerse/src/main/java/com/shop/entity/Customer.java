package com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class Customer {
	@NotNull
	@Id
	public int userId;
	
	@NotNull
	public String firstName;
	
	@NotNull
	public String lastName;
	
	@NotNull
	public long phoneNumber;
	
	@Email
	public String email;
	
	@NotNull
	public String password;
}
