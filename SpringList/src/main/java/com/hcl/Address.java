package com.hcl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {
       
    private String country;
    private String city;
    private int pincode;
}
