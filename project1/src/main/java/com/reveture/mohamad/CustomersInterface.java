package com.reveture.mohamad;

import java.util.List;

public interface CustomersInterface {
	List<Customer> getAllCustomer();

	/**
	 * Used to persist the animal to the datastore
	 * @param animalToSave
	 */
	void saveApplication(Customer cust) throws Exception;
}
