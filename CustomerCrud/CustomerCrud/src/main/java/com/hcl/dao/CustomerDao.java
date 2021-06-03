package com.hcl.dao;

import org.springframework.data.repository.CrudRepository;

import com.hcl.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Integer> {

}
