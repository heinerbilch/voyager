package com.bilch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepository repository;

	@RequestMapping("/customer")
	String customer() {
		repository.save(new Customer("Jack","Bauer"));
		repository.save(new Customer("Heiner","Strauss"));
		Customer customer = repository.findOne(1L);
		return customer.toString();

	}

}
