package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import com.luv2code.springboot.thymeleafdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theEmployee);
	
	public void deleteById(int theId);

	public Optional<Customer> find(int theId);
	
}
