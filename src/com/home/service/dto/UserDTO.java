package com.home.service.dto;

import org.apache.log4j.Logger;

import com.home.util.SystemUtil;

public class UserDTO {
	Logger logger= Logger.getLogger(UserDTO.class);
	
	
	private String firstName;
	private String lastName;
	private String emailId;
	
	
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}

