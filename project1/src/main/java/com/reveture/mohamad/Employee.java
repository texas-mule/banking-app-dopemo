package com.reveture.mohamad;
import java.util.ArrayList;
public class Employee {
	private String firstname;
	private String lastname;
	private String Username;
	private String password;
	private int employeeid;
	private ArrayList<Customer> customer= new ArrayList<Customer>();
	
	public Employee(String name, String password) {
		this.Username=name;
		this.password=password;
		
	}
	


	public Employee() {
		// TODO Auto-generated constructor stub
	}



	public String getUsername() {
		return Username;
	}
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setUsername(String username) {
		Username = username;
	}
	public ArrayList getAllCustomers(){
		return this.customer;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public int getEmployeeid() {
		return employeeid;
	}



	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}



	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", lastname=" + lastname + ", Username=" + Username + ", password="
				+ password + ", employeeid=" + employeeid + ", customer=" + customer + "]";
	}
	
}
