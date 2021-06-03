package com.hcl.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Customer;
import com.hcl.service.CustomerService;

@RestController
@RequestMapping("/cust")

public class CustomerController {

	@Autowired
	CustomerService service;
	
	/*@RequestMapping("/demo")
	@ResponseBody
	public String getString()
	{
		return "Hii Guys";
	}*/
	
	
	@GetMapping("/")
	public List<Customer> getAllCustomer()
	{
		return (List<Customer>) service.getAllCustomer();
	}
	
	@GetMapping("/{customerId}")
	public Optional<Customer> getCustomer(@PathVariable int customerId)
	{
		return service.getCustomer(customerId);
	}
	
	@PostMapping("/add")
	public String addCustomer(@RequestBody Customer customer)
	{
		service.addCustomer(customer);
		return "Customer Added";
	}
	
	@PutMapping("/edit/{customerId}")
	public String updateCustomer(@PathVariable int customerId, @RequestBody Customer customer)
	{
		service.editDetails(customerId, customer);
		return "Customer Details Updated";
	}
	
	@DeleteMapping("/")
	public String deleteAll()
	{
		service.delete();
		return "All Details Deleted";
	}
	
	@DeleteMapping("/{customerId}")
	public String delete(@PathVariable int customerId)
	{
		service.deleteCustomer(customerId);
		return "Customer deleted";
	}
}
