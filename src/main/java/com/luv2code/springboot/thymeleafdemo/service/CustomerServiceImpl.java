package com.luv2code.springboot.thymeleafdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.CustomerRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Customer;



@Service
public class CustomerServiceImpl implements CustomerService {

//	private CustomerRepository customerRepository;
	
	List<Customer> list;
	public CustomerServiceImpl()
	{
		list=new ArrayList<>();
		list.add(new Customer(1,"Ajay","Ray","Ajay@gmail.com","998763432"));
		list.add(new Customer(2,"jay","Ray","jay@gmail.com","498763432"));
		list.add(new Customer(05,"ramjay","Ray","rmjay@gmail.com","978763432"));
		list.add(new Customer(11,"rjay","Ray","rjjay@gmail.com","998763432"));
	}
	
//	@Autowired
//	public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
//		customerRepository = theCustomerRepository;
//	}
	
//	@Override
//	public List<Customer> findAll() {
//		return customerRepository.findAllByOrderByLastNameAsc();
//	}
	
	@Override
	public List<Customer> findAll() {
		return list;
	}

//	@Override
//	public Customer findById(int theId) {
//		Optional<Customer> result = customerRepository.findById(theId);
//		
//		Customer theCustomer = null;
//		
//		if (result.isPresent()) {
//			theCustomer = result.get();
//		}
//		else {
//			// we didn't find the employee
//			throw new RuntimeException("Did not find employee id - " + theId);
//		}
//		
//		return theCustomer;
//	}
	
	@Override
	public Customer findById(int theId) {
		Customer c=null;
		for(Customer customer:list)
		{
			if(customer.getId()==theId)
			{
				c=customer;
				break;
			}
		}
		return c;
	}

//	@Override
//	public void save(Customer theEmployee) {
//		customerRepository.save(theEmployee);
//	}
	
	@Override
	public void save(Customer theCustomer) {
		list.add(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		list.remove(theId);
	}

//	@Override
//	public Optional<Customer> find(int theId) {
//		
//		return customerRepository.findById(theId);
//	}

}






