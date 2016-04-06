package com.home.service;

import com.home.exception.UserAlreadyExistsException;
import com.home.service.dto.UserDTO;
import com.home.service.entity.User;

public interface UserRegistrationService {
	
	public UserDTO registerUser(User user) throws UserAlreadyExistsException;

}
