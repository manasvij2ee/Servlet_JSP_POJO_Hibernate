package com.home.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.home.util.SystemUtil;
import com.home.exception.UserAlreadyExistsException;
import com.home.service.UserRegistrationService;
import com.home.service.UserRegistrationServiceImpl;
import com.home.service.dto.UserDTO;
import com.home.service.entity.User;

public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger= Logger.getLogger(UserRegistrationServlet.class);

	public UserRegistrationServlet() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nextJSP = "/WEB-INF/view/printUserDetails.jsp";	
		logger.debug("requesting parameters");
		RequestDispatcher dispatcher = null;
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String phoneNumber = request.getParameter("phoneNumber");
		String firmName = request.getParameter("firmName");
		String salary = request.getParameter("salary");
		
		
		boolean isEverythingOk = false;
		logger.debug("validating the parameters");
		
		// Server side Validations in Client Layer.
		isEverythingOk = SystemUtil.emailRegExpValidation(emailId) && SystemUtil.passwordValidation(password, confirmPassword) && 
				SystemUtil.nullAndblankValidation(emailId, password, confirmPassword, firstName, lastName, gender, phoneNumber, firmName, salary);
		
		if(isEverythingOk) {
			logger.debug("validation success");
			
			UserRegistrationService userRegistrationService = new UserRegistrationServiceImpl();//create service layer to call service from client layer 
			User user=new User();
			user.setEmailId(emailId);
			user.setPassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setGender(gender);
			user.setPhoneNumber(phoneNumber);
			user.setFirmName(firmName);
			user.setSalary(Double.parseDouble(salary));     //Typecast From String to Double			
			
			//1.User, 2. user set all the instance variables			
			try {
				UserDTO userDTO = userRegistrationService.registerUser(user); 
				request.setAttribute("userDTO", userDTO);
			} catch (UserAlreadyExistsException e) {
				request.setAttribute("errorMessage", e.getErrorMessage());
				nextJSP = "/WEB-INF/view/userRegistration.jsp";
			}			
			dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);						
		} else {
			logger.debug("Validation Error occurred");
			
			String errorMessage = "";
			if(!SystemUtil.nullAndblankValidation(emailId, password, confirmPassword, firstName, lastName, gender, phoneNumber, firmName, salary)) {
				errorMessage = errorMessage.concat("\n Password and Confirm Password Does Not Match !");
			}			
			if(!SystemUtil.emailRegExpValidation(emailId)) {
				errorMessage = "\n Invalid Email Id!";
			}		
			if(!SystemUtil.passwordValidation(password, confirmPassword)) {
				errorMessage = errorMessage.concat("\n Password and Confirm Password Does Not Match !");
			}						
			request.setAttribute("errorMessage", errorMessage);
			nextJSP = "/WEB-INF/view/userRegistration.jsp";
				
			dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
			logger.debug("Redirecting to Registration page after Error Encountered");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
