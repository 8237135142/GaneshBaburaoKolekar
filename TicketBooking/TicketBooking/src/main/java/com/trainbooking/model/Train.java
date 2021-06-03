package com.trainbooking.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Train {
	
	@Id
	@GeneratedValue
	private int trainId;
	
	@NotNull(message = "Train Number may not be null")
	private int trainNumber;
	
	@NotNull(message = "Train Name may not be null")
	private String trainName;
	
	@NotNull
	private String source;
	@NotNull
	private String destination;
	
	@NotNull(message = "duration may not be null")
	private int duration;
	
	@NotNull(message = "availableSeats may not be null")
	private int availableSeats;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd") 
	private Date date;
}
