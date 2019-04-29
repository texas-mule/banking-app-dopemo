package com.reveture.mohamad;

public  class Customer {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private double c_balance;
	private double s_balance;
	private int a_number;
	private boolean approved;
	private int employeid;
	public int getEmployeid() {
		return employeid;
	}
	public void setEmployeid(int employeid) {
		this.employeid = employeid;
	}
	public Customer(String firstName, String lastName, String userName, String password, double c_balance,
			double s_balance, int a_number) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.c_balance = c_balance;
		this.s_balance = s_balance;
		this.a_number = a_number;
		
		this.approved=false;
	}
	public Customer(){
		this.firstName = null;
		this.lastName = null;
		this.userName = null;
		this.password = null;
		this.c_balance =  0;
		this.s_balance = 0;
		this.a_number = 0;
		this.approved=false;
		
	}
	public void get_status(boolean flag){
		this.approved=flag;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
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
	public double getC_balance() {
		return c_balance;
	}
	public void setC_balance(double c_balance) {
		this.c_balance = c_balance;
	}
	public double getS_balance() {
		return s_balance;
	}
	public void setS_balance(double s_balance) {
		this.s_balance = s_balance;
	}
	public int getA_number() {
		return a_number;
	}
	public void setA_number(int a_number) {
		this.a_number = a_number;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", c_balance=" + c_balance + ", s_balance=" + s_balance + ", a_number=" + a_number
				+ ", approved=" + approved + ", employeid=" + employeid + "]\n";
	}
	public void saveCustomer(Customer customer) {
		
	}
	
	
	
	
	
	
}
