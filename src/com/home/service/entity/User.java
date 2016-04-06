package com.home.service.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@NamedNativeQueries(  
	    {  
	    	@NamedNativeQuery(  
	        name = "loadUserByEmailViaNamedNativeQuery",  
	        query = "SELECT EMAIL_ID, FIRST_NAME, PASSWORD, LAST_NAME, "
					+ "[GENDER], PHONE_NUMBER, CREATED_IP, DATE_TIME_CREATED, "
					+ "DATE_TIME_MOD, ACTIVE, CREATED_BY, FIRM_NAME, SALARY "
					+ "FROM USER_INFORMATION ui WHERE ui.EMAIL_ID = :emailId"
	        )  
	    }  
	)  

@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "loadUserByEmailViaNamedQuery",  
	        query = "SELECT emailId, firstName, password,"
	        		+ " lastName, gender, phoneNumber, createdIp, dateTimeCreated, "
	        		+ "dateTimeModified, active, createdBy, firmName,"
	        		+ "salary  FROM User ui WHERE  ui.emailId = :emailId"  
	        )  
	    }  
	)

@Entity
@Table(name = "USER_INFORMATION")

public class User {
	
		@Id
		@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
		@Column(name = "ID", nullable = false)
		private int id;
		
		@Column(name = "EMAIL_ID", unique = true, nullable = false)
		private String emailId;
		
		@Column(name = "PASSWORD",  nullable = false)
		private String password;
		
		@Column(name = "FIRST_NAME", nullable = true)
		private String firstName;
		
		@Column(name = "LAST_NAME", nullable = true)
		private String lastName;
		
		@Enumerated(EnumType.STRING)
		@Column(name = "GENDER", nullable = true)
		private Gender gender;
		
		@Column(name = "PHONE_NUMBER", nullable = true)
		private String phoneNumber;
		
		@Column(name = "CREATED_IP", nullable = true)
		private String createdIp ;
		 
		@Column(name = "DATE_TIME_CREATED", nullable = true)
		private Date dateTimeCreated = new Date();
		
		@Column(name = "DATE_TIME_MOD", nullable = true)
		private Date dateTimeModified = new Date();
		
		@Column(name = "MOD_USER_ID", nullable = true)
		private String  modifiedBy;
		
		@Type(type="yes_no")
		@Column(name = "ACTIVE", nullable = true)
		private boolean active = true;
		
		@Column(name = "CREATED_by", nullable = true)
		private String createdBy;
		
		@Column(name = "FIRM_NAME", nullable = true)
		private String firmName;
		
		@Column(name = "SALARY", nullable = true)
		private double salary;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEmailId() {
			return emailId;
		}

		public String getModifiedBy() {
			return modifiedBy;
		}

		public void setModifiedBy(String ModifiedBy) {
			this.modifiedBy = ModifiedBy;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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
		public Gender getGender() {
			return gender;
		}
		
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		
		
		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		public String  getCreatedIp() {
			return createdIp;
		}

		public void setCreatedIp(String string) {
			this.createdIp = string;
		}

		public Date getDateTimeCreated() {
			return  dateTimeCreated;
		}

		public void setDateTimeCreated(Date dateTimeCreated) {
			this.dateTimeCreated = dateTimeCreated;
		}

		public Date  getDateTimeModified() {
			return dateTimeModified;
		}

		public void setDateTimeModified(Date dateTimeModified) {
			this.dateTimeModified = dateTimeModified;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public String  getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy( String createdBy) {
			this.createdBy = createdBy;
		}

		public String getFirmName() {
			return firmName;
		}

		public void setFirmName(String firmName) {
			this.firmName = firmName;
		}

		public double  getSalary() {
			return salary;
		}

		public void setSalary(double d) {
			this.salary = d;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", emailId=" + emailId + ", password=" + password + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", createdIp="
					+ createdIp + ", dateTimeCreated=" + dateTimeCreated + ", dateTimeModified=" + dateTimeModified
					+ ", modifiedBy=" + modifiedBy + ", active=" + active + ", createdBy=" + createdBy + ", firmName="
					+ firmName + ", salary=" + salary + "]";
		}

		public void setGender(String string) {
			this.gender=Gender.valueOf(string.toUpperCase());		
		}
		
	}



