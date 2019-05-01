package com.reveture.mohamad;

import java.util.List;

import com.revature.mohamad.project01.Applications;

public interface RejectedClassInterface {
	List<Applications> getAllApplications();

	/**
	 * Used to persist the animal to the datastore
	 * @param animalToSave
	 */
	void saveApplication(Applications app) throws Exception;

}
