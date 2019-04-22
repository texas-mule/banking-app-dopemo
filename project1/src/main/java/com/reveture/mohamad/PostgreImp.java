package com.reveture.mohamad;
import java.util.List;
public interface PostgreImp {
	List<Applications> getAllApplications();

	/**
	 * Used to persist the animal to the datastore
	 * @param animalToSave
	 */
	void saveApplication(Applications app) throws Exception;

}
