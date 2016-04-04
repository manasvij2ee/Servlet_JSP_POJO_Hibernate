package com.home.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.client.util.SystemUtil;

public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegistrationServlet() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nextJSP = "/WEB-INF/view/printUserDetails.jsp";		
		RequestDispatcher dispatcher = null;
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		boolean isEverythingOk = false;
		isEverythingOk = SystemUtil.emailRegExpValidation(emailId) && SystemUtil.passwordValidation(password, confirmPassword);
		
		if(isEverythingOk) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String gender = request.getParameter("gender");
			String phoneNumber = request.getParameter("phoneNumber");
			String firmName = request.getParameter("firmName");
			String salary = request.getParameter("salary");
			
			request.setAttribute("emailId", emailId);
			request.setAttribute("password", password);
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("gender", gender);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("firmName", firmName);
			request.setAttribute("salary", salary);
			
			dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);						
		} else {			
			String errorMessage = "";
			if(!SystemUtil.emailRegExpValidation(emailId)) {
				errorMessage = "Invalid Email Id!";
			}			
			if(!SystemUtil.passwordValidation(password, confirmPassword)) {
				errorMessage = errorMessage.concat("\n Password and Confirm Password Does Not Match !");
			}			
			request.setAttribute("errorMessage", errorMessage);
			nextJSP = "/WEB-INF/view/userRegistration.jsp";
			dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
