package com.reveture.mohamad;
import java.util.ArrayList;

public class Admin {
	private String userName;
	private String password;
	ArrayList<Customer> customers= new ArrayList<Customer>();
	ArrayList<Employee> employees=new ArrayList<Employee>();
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Admin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + "]";
	}
	public ArrayList getAllCustomers(){
		return this.customers;
	}
	public ArrayList getAllEmployees(){
		return this.employees;
	}
	
	
	


}
