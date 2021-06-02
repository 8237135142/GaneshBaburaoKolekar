package com.hcl;

import org.springframework.context.annotation.Scope;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString
@Scope("prototype")
public class Address {
       
    private String country;
    private String city;
    private int pincode;
}
