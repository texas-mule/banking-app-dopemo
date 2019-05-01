package com.revature.mohamad;


import java.util.ArrayList;
import java.util.List;

import com.reveture.mohamad.Applications;
import com.reveture.mohamad.CustomerImp;
import com.reveture.mohamad.CustomersImp;
import com.reveture.mohamad.Employee;
import com.reveture.mohamad.EmployeeImp;
import com.revature.mohamad.*;

import junit.framework.TestCase;

public class JunitTesting extends TestCase {

	Applications app=new Applications("Mohamad","khalifa","usernamer","password",1344);
	int credit_score=app.getC_score();
	CustomerImp customerImp=new CustomerImp();
	List<Applications>apps=new ArrayList<>();
	CustomersImp customersImp=new CustomersImp();
	EmployeeImp employeeImp=new EmployeeImp();
	public void test1()
	{
		assertEquals(credit_score,1344);
	}
	public void test2() {
		
		
		apps=customerImp.getAllApplications();
		assertNotSame(apps,null);
	}
	public void test3() {
		try {
			customerImp.saveApplication(app);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		apps=customerImp.getAllApplications();
		
		for(Applications a: apps) {
			if(a.getFirstname().equals(app.getUsername())) {
				assertEquals(a,app);
			}
		}
		
		
	}
	public void tes4() {
		
		assertEquals(flag,true);
	
		
		
		
	}
	
}
