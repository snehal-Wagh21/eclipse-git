package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Customer;
import com.luv2code.springboot.thymeleafdemo.service.CustomerService;



@Controller
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService customerService;
	
	public CustomerController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		// get employees from db
		List<Customer> theCustomers = customerService.findAll();
		
		// add to the spring model
		theModel.addAttribute("customer", theCustomers);
		
		return "customer/list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCUstomer = new Customer();
		
		theModel.addAttribute("customer", theCUstomer);
		
		return "customer/customer-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the employee from the service
		Customer theCustomer = customerService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form
		return "customer/customer-form";			
	}
	
//	@GetMapping("/customerDtl")
//	public String customerDetials() {
//		return "customer/getCustomer";			
//	}
//	@PostMapping("/customerDtl")
//	public String showcustomerDetials(@RequestParam("customerId") int theId, Model theModel) {
//		Optional<Customer> customer= customerService.find(theId);
//		System.out.println(customer.get().getFirstName());
//		theModel.addAttribute("customer", customer.get());
//		return "customer/showCustomer";			
//	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the employee
		customerService.save(theCustomer);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		
		// delete the employee
		customerService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/customer/list";
		
	}
}


















