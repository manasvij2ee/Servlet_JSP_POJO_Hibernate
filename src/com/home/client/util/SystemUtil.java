package com.home.client.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemUtil {
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
	
	public static void main(String[] args) {
		String emailId = "svsdvsdbsdbmail.com";
		String password = "vivek12cdv3";
		String confirmPassword = "vivek123";	
		System.out.println(passwordValidation(password, confirmPassword));
		System.out.println(emailRegExpValidation(emailId));
		
		boolean isEverythingOk = false;
		isEverythingOk = SystemUtil.emailRegExpValidation(emailId) && SystemUtil.passwordValidation(password, confirmPassword);
		System.out.println(isEverythingOk);
	}
	
}