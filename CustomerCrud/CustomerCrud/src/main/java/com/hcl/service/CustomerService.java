package com.hcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.CustomerDao;
import com.hcl.model.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao dao;
	
	public List<Customer> getAllCustomer()
	{
		return (List<Customer>) dao.findAll();
	}
	
	public Optional<Customer> getCustomer(int customerId)
	{
		return dao.findById(customerId);
	}
	
	public void addCustomer(Customer customer)
	{
		dao.save(customer);
	}
	
	public void editDetails(int customerId, Customer customer)
	{
		dao.save(customer);
	}
	
	public void delete()
	{
		dao.deleteAll();
	}
	
	public void deleteCustomer(int customerId)
	{
		dao.deleteById(customerId);
	}
}
