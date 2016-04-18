package com.home.util;

import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jasypt.util.text.BasicTextEncryptor;

import com.home.dao.UserDaoImpl;
import com.home.service.entity.Gender;
import com.home.service.entity.User;

public class SystemUtil {
	public static final String ENCRYPTION_KEY = "manasvi";

	public static String encrypt(String plainText) {
		BasicTextEncryptor cryptor=new BasicTextEncryptor();
		cryptor.setPassword(ENCRYPTION_KEY);				
		String encryptedText =cryptor.encrypt(plainText);
		return encryptedText;		
	}
	
	public static String decrypt(String encryptedText) {
		BasicTextEncryptor cryptor=new BasicTextEncryptor();
		cryptor.setPassword(ENCRYPTION_KEY);				
		String plainText =cryptor.decrypt(encryptedText);
		return plainText;		
	}
	
	public static Gender convertStringtoGender(String str) {
		Gender gender = null;
		gender = Gender.valueOf(str);		
		return gender;
	}

	public static boolean convertCharaterToBoolean(Character character) {
		boolean active = false;		
		if(character!=null && character.equals('Y')) {
			active = true;
		} else {
			active = false;
		}		
		return active;

	}

	public static java.sql.Date getSqlDateTime(java.util.Date dateTimeCreated) {
	    return new java.sql.Date(dateTimeCreated.getTime());
	}
	
	static java.sql.Date getDateTimeModified() {
	    java.util.Date dateTimeModified  = new java.util.Date();
	    return new java.sql.Date(dateTimeModified.getTime());
	}

	public static boolean emailSimpleValidation() {

		return false;

	}

	public static boolean emailRegExpValidation(String emailId) {
		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(emailId);
		return matcher.matches();
	}
	
	public static boolean passwordValidation(String pass1,String pass2){
		if(pass1.equals(pass2)){
			return true;
		} else{
			return false;
		}
	}
	
	// This method takes parameters. Returns true if all the Strings are not empty; Returns false if any one of the Strings is empty
	public static boolean nullAndblankValidation(String emailId,String pass1,
			String pass2, String firstName,String lastName,String gender,String phoneNumber,
			String firmName, String salary){
		if(!checkForNotNullOrEmpty(emailId)) {
			return false;
		}
		if(!checkForNotNullOrEmpty(pass1)) {
			return false;
		}
		if(!checkForNotNullOrEmpty(pass2)) {
			return false;
		}
		if(!checkForNotNullOrEmpty(firstName)) {
			return false;
		}
		if(!checkForNotNullOrEmpty(lastName)) {
			return false;
		}
		if(!checkForNotNullOrEmpty(gender)) {
			return false;
		}
		if(!checkForNotNullOrEmpty(phoneNumber)) {
			return false;
		}
		if(!checkForNotNullOrEmpty(firmName)) {
			return false;
		}
		if(!checkForNotNullOrEmpty(salary)) {
			return false;
		}
		return true;		
	}
	
	// This method takes a String Parameter and return true if that string is not null and not empty; if that string is empty or null then it returns false.
	private static boolean checkForNotNullOrEmpty(String string) {
		if(string!=null && !string.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private static double stringToDouble(String sal) {
	    double aDouble = Double.parseDouble(sal);
		return  aDouble ;
	}
	static Logger logger= Logger.getLogger(SystemUtil.class);
	public  static void main(String[] args) {
		/*PropertyConfigurator.configure("classpath:log4j.properties");
		Enumeration  appenders = logger.getAllAppenders();*/
		
		logger.debug("hi");
		
		//String randomString = "sdvsdvsv";
		//System.out.println(checkForNotNullOrEmpty(randomString));
		
	}
	
	
	
}