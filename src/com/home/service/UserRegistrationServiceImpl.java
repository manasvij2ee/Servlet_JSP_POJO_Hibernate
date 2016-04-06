package com.home.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import com.home.dao.UserDao;
import com.home.dao.UserDaoImpl;
import com.home.exception.UserAlreadyExistsException;
import com.home.service.dto.UserDTO;
import com.home.service.entity.User;
import com.home.util.SystemUtil;

public class UserRegistrationServiceImpl implements UserRegistrationService {

	// To Do
	//(i) Check for whether user exitst. If exists throw a UserDefinedException name, UserAlreadyExistsException
	//userDTo firstName,lastName
	public UserDTO registerUser(User user) throws UserAlreadyExistsException  {
		UserDao userDao = new UserDaoImpl();
		String emailId = user.getEmailId();
		User retreivedUser = userDao.loadUserByEmailSql(emailId);
		if(retreivedUser != null){
			throw new UserAlreadyExistsException("User With this EMailId: "+ emailId + "Already Exists !" );
		}		
			
		user.setPassword(SystemUtil.encrypt(user.getPassword()));
		try {
			user.setCreatedIp(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException While Setting Ip Address.");
		}
		
		user.setCreatedBy(emailId);
		user.setModifiedBy(emailId); //Change it to String modifiedBy MOD_USER_ID
				
		userDao.saveUser(user);
		UserDTO userDTO = new UserDTO();
		userDTO.setEmailId(user.getEmailId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		return userDTO;
	}

}
