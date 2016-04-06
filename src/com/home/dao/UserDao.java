package com.home.dao;

import com.home.service.entity.User;

public interface UserDao {
	
	public void saveUser(User userInfo) ;

	public User retrieveUserById(int id);

	public User loadUserByEmailSql(String emailId);	
	
	public User loadUserByEmailHql(String emailId);	
	
	public User loadUserByEmailNamedQuery(String emailId);	
	
	public User loadUserByEmailNamedNativeQuery(String emailId);
	
	


}
