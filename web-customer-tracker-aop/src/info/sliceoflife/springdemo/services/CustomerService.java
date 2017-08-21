package info.sliceoflife.springdemo.services;

import java.util.List;

import info.sliceoflife.springdemo.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomers(int id);

	void deleteCustomer(int id);

}
