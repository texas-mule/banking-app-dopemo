package com.reveture.mohamad;
import java.util.ArrayList;

public class Bank {
	public ArrayList<Admin> admins=new ArrayList<Admin>();
	public ArrayList<Employee> employees= new ArrayList<Employee>();
	public Bank() 
	{
		this.employees.add(new Employee("mohamad","password"));
		this.employees.add(new Employee("jeez","password1"));
	}
	public String toString() {
		String s="";
		for(Employee employee: employees) {
			s+=employee.getUsername();
			s+=" ";
			s+=employee.getPassword();
			s+=" ";
			
		}
		return s;
	}

}
