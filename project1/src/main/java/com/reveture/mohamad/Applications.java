package com.reveture.mohamad;

import java.util.ArrayList;
import java.util.List;

public class Applications {
	private int id;
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private int c_score;
	public Applications(String firstname, String lastname, String username, String password, int c_score) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.c_score = c_score;
		
	}
	
	public Applications() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getC_score() {
		return c_score;
	}
	public void setC_score(int c_score) {
		this.c_score = c_score;
	}

	@Override
	public String toString() {
		return "Applications [id=" + id + " firstname=" + firstname + " lastname=" + lastname + " username="
				+ username + " password=" + password + " c_score=" + c_score + "]\n";
	}
	
	
	
}
