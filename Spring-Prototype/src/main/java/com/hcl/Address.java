package com.hcl;

import org.springframework.context.annotation.Scope;

import lombok.Data;


@Data
@Scope("prototype")
public class Address {
       
    private String country;
    private String city;
    private int pincode;
}
