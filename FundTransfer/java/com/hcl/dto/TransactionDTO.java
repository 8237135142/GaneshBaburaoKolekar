package com.hcl.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.hcl.constants.TransactionType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yash.ghawghawe
 *
 */
@Getter
@Setter
@ToString
public class TransactionDTO {

	private int transactionId;

	@NotEmpty(message = "enter your account number")
	@Size.List({ @Size(min = 8, message = "The field must be of at least {min} characters"),
			@Size(max = 10, message = "The field cannot conatin more than 11 characters") })
	private String accountNo;

	@NotEmpty(message = "enter beneficiary account number")
	@Size.List({ @Size(min = 8, message = "The field must be of at least {min} characters"),
			@Size(max = 10, message = "The field cannot conatin more than 11 characters") })
	private String accountnoben;

	private Date date;

	@NotNull(message="amount must not be null")
	private BigDecimal amountBig;

	private double amount;

	private int userid;

	private String type;

	@NotEmpty(message = "enter transaction remarks")
	private String description;

}
