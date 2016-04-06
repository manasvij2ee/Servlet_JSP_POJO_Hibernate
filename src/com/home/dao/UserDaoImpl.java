package com.home.dao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.service.entity.Gender;
import com.home.service.entity.User;
import com.home.util.SystemUtil;

public class UserDaoImpl implements UserDao {
	public static Session getSession() {
		Session session;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		System.out.println(" Connection Established Successfully");
		return session;
	}

	public void saveUser(User userInfo) {
		Session session = getSession();
		session.beginTransaction();
		session.saveOrUpdate(userInfo);
		session.getTransaction().commit();
	}

	public User retrieveUserById(int id) {
		Session session = getSession();
		session.beginTransaction();
		User userInfo = (User) session.get(User.class, id);
		session.getTransaction().commit();
		return userInfo;
	}
	public User loadUserByEmailNamedQuery(String emailId){
		User user = null;
		Session session = getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("loadUserByEmailViaNamedQuery");
		query.setParameter("emailId", emailId);
		java.util.List<Object[]> list = query.list();
		if (list != null && list.size() > 0) {
			Object[] object = list.get(0);
			String retrievedEmailId = (String) object[0];
			String firstName = (String) object[1];
			String password = SystemUtil.decrypt((String) object[2]);
			String lastName = (String) object[3];
			Gender gender = SystemUtil.convertStringtoGender((String) object[4]);
		    String phoneNumber = (String) object[5];
			String createdIp = (String) object[6];
			Date dateTimeCreated = (Date) object[7];		   
			Date dateTimeMod = (Date) object[8];
			boolean active = SystemUtil.convertCharaterToBoolean((Character) object[9]);
			String createdBy = (String) object[10];
			String firmName = (String) object[11];
			double salary = (double) object[12];
			String modifiedBy=(String) object[13];
			
			user = new User();
			user.setEmailId(retrievedEmailId);
			user.setPassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPhoneNumber(phoneNumber);
			user.setCreatedIp(createdIp);
		    user.setDateTimeCreated(dateTimeCreated);
			user.setGender(gender);
			user.setDateTimeModified(dateTimeMod);
			user.setActive(active);
			user.setCreatedBy(createdBy);
			user.setSalary(salary);
			user.setModifiedBy(modifiedBy);
				}
		return user;
		
	}
	
	public User loadUserByEmailNamedNativeQuery(String emailId){
		User user = null;
		Session session = getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("loadUserByEmailViaNamedNativeQuery");
		query.setParameter("emailId", emailId);
		java.util.List<Object[]> list = query.list();
		if (list != null && list.size() > 0) {
			Object[] object = list.get(0);
			String retrievedEmailId = (String) object[0];
			String firstName = (String) object[1];
			String password = SystemUtil.decrypt((String) object[2]);
			String lastName = (String) object[3];
			Gender gender = SystemUtil.convertStringtoGender((String) object[4]);
		    String phoneNumber = (String) object[5];
			String createdIp = (String) object[6];
			Date dateTimeCreated = (Date) object[7];		   
			Date dateTimeMod = (Date) object[8];
			boolean active = SystemUtil.convertCharaterToBoolean((Character) object[9]);
			String createdBy = (String) object[10];
			String firmName = (String) object[11];
			double salary = (double) object[12];
			String modifiedBy=(String) object[13]; 
			
			user = new User();
			user.setEmailId(retrievedEmailId);
			user.setPassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPhoneNumber(phoneNumber);
			user.setCreatedIp(createdIp);
		    user.setDateTimeCreated(dateTimeCreated);
			user.setGender(gender);
			user.setDateTimeModified(dateTimeMod);
			user.setActive(active);
			user.setCreatedBy(createdBy);
			user.setSalary(salary);
			user.setModifiedBy(modifiedBy);
				}
		
		return user;
		
	}
	
	
	public User loadUserByEmailSql(String emailId) {
		User user = null;
		Session session = getSession();
		session.beginTransaction();
		String sqlQuery = "SELECT EMAIL_ID, FIRST_NAME, PASSWORD, LAST_NAME, "
				+ "[GENDER], PHONE_NUMBER, CREATED_IP, DATE_TIME_CREATED, "
				+ "DATE_TIME_MOD, ACTIVE, CREATED_BY, FIRM_NAME, SALARY, MOD_USER_ID FROM USER_INFORMATION  ui WHERE ui.EMAIL_ID = :emailId";
		Query query = session.createSQLQuery(sqlQuery);
		query.setParameter("emailId", emailId);
		java.util.List<Object[]> list = query.list(); //execute Query
		if (list != null && list.size() > 0) {
			Object[] object = list.get(0);
			String retrievedEmailId = (String) object[0];
			String firstName = (String) object[1];
			String password = SystemUtil.decrypt((String) object[2]);
			String lastName = (String) object[3];
			Gender gender = SystemUtil.convertStringtoGender((String) object[4]);
		    String phoneNumber = (String) object[5];
			String createdIp = (String) object[6];
			Date dateTimeCreated = (Date) object[7];		   
			Date dateTimeMod = (Date) object[8];
			boolean active = SystemUtil.convertCharaterToBoolean((Character) object[9]);
			String createdBy = (String) object[10];
			String firmName = (String) object[11];
			double salary = (double) object[12];
			String modifiedBy=(String) object[13];
			
			user = new User();
			user.setEmailId(retrievedEmailId);
			user.setPassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
		    user.setPhoneNumber(phoneNumber);
			user.setCreatedIp(createdIp);
		    user.setDateTimeCreated(dateTimeCreated);
			user.setGender(gender);
			user.setDateTimeModified(dateTimeMod);
			user.setActive(active);
			user.setCreatedBy(createdBy);
			user.setSalary(salary);
			user.setModifiedBy(modifiedBy);
				}
		return user;
	}
	
	
	
	public User loadUserByEmailHql(String emailId) {
		User user = null;
		Session session = getSession();
		session.beginTransaction();
		String hql = "SELECT emailId, firstName, password,"
	        		+ " lastName, gender, phoneNumber, createdIp, dateTimeCreated, "
	        		+ "dateTimeModified, active, createdBy, firmName,"
	        		+ "salary  MODIFIED_BY FROM User ui WHERE  ui.emailId = :emailId"  ;
		Query query = session.createQuery(hql)
		.setParameter("emailId", emailId);		
		
		java.util.List<Object[]> list = query.list();
		if (list != null && list.size() > 0) {
			Object[] object = list.get(0);
    	String retrievedEmailId = (String) object[0];
		String firstName = (String) object[1];
		String password = SystemUtil.decrypt((String) object[2]);
		String lastName = (String) object[3];
		Gender gender = SystemUtil.convertStringtoGender((String) object[4]);
	    String phoneNumber = (String) object[5];
		String createdIp = (String) object[6];
		Date dateTimeCreated = (Date) object[7];		   
		Date dateTimeMod = (Date) object[8];
		boolean active = SystemUtil.convertCharaterToBoolean((Character) object[9]);
		String createdBy = (String) object[10];
		String firmName = (String) object[11];
		double salary = (double) object[12];
		String modifiedBy=(String) object[13];
		
		user = new User();
		user.setEmailId(retrievedEmailId);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
	    user.setPhoneNumber(phoneNumber);
		user.setCreatedIp(createdIp);
	    user.setDateTimeCreated(dateTimeCreated);
		user.setGender(gender);
		user.setDateTimeModified(dateTimeMod);
		user.setActive(active);
		user.setCreatedBy(createdBy);
		user.setSalary(salary);
		user.setModifiedBy(modifiedBy);
		}
	
		return user;

	}
}
