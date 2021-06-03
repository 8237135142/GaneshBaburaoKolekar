package com.trainbooking.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
//@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"emailId" , "phoneNo"})})
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@NotNull(message = "User Name may not be null")
	private String userName;
	
	@NotNull(message = "Password may not be null")
	private String password;
	
	@Email
	@NotNull(message = "email may not be null")
	private String emailId;
	
	@NotNull(message = "Phone number may not be null")
	private long phoneNo;
	
	@NotNull(message = "Age may not be null")
	private int age;
	
}
