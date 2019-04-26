package com.reveture.mohamad;

import java.util.List;

public interface Cinterface {
	List<Customer> getAllCAccounts();

	/**
	 * Used to persist the animal to the datastore
	 * @param animalToSave
	 */
	void saveCAccount(Customer customer) throws Exception;


}
