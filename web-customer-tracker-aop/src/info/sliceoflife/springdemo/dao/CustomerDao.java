package info.sliceoflife.springdemo.dao;

import java.util.List;

import info.sliceoflife.springdemo.entity.Customer;

public interface CustomerDao {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);

}
