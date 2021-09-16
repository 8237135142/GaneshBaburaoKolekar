package com.ticketsbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@SpringBootApplication
public class BusTicketBookingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusTicketBookingsApplication.class, args);
		
	}

}
