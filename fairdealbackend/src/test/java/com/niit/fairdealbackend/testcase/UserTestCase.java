package com.niit.fairdealbackend.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.fairdealbackend.dao.UserDAO;
import com.niit.fairdealbackend.dto.Address;
import com.niit.fairdealbackend.dto.User;


public class UserTestCase {

	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.fairdealbackend");
		context.refresh();
		
		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void getAllUsersTestCase()
	{
		int recordFromDB = userDAO.getAllUsers().size();
		
		assertEquals("getAllUsersTestCase", 5, recordFromDB);
	}
	
	@Test
	public void createUserTestCase()
	{
		Address addr=new Address();
		addr.setLocality("Delhi");
		addr.setCity("New Delhi");
addr.setState("India");		
addr.setPinCode("110034");
addr.setHouseNumber(420);
		
		
	addr.setUser(user);	
		
		user.setName("piyush");
		user.setPassword("piyush");
		user.setMail("piyush@gmail.com");
		user.setContact("098765645");
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		
		boolean flag = userDAO.createUser(user);
		
		assertEquals("createUserTestCase", true, flag);
		
		
		user.setName("admin");
		user.setPassword("admin123");
		user.setMail("admin@gmail.com");
		user.setContact("8745962587");
		user.setEnabled(true);
		user.setRole("ROLE_ADMIN");
		
		boolean flag1 = userDAO.createUser(user);
		
		assertEquals("createUserTestCase", true, flag1);
	}
	@Ignore
	@Test
	public void updateUserTestCase()
	{
		user.setName("Akhil");
		user.setPassword("akhil");
		user.setContact("8765432467");
		user.setRole("user");
		
		boolean flag = userDAO.updateUser(user);
		
		assertEquals("updateUserTestCase", true, flag);
	}
	
	@Test
	@Ignore
	public void deleteUserTestCase()
	{
		user.setPassword("siraj");
		
		boolean flag = userDAO.deleteUser(user);
		
		assertEquals("deleteUserTestCase", true, flag);
	}
	
	@Test
	@Ignore
	public void getUserByIDTestCase()
	{
		user = userDAO.getUserByID(01);
		
		assertEquals("getUserByIDTestCase", null, user);
	}
	
	@Test
	@Ignore
	public void getUserByNameTestCase()
	{
		user = userDAO.getUserByName("Siraj");
		
		assertEquals("getUserByNameTestCase", null, user);
	}
	
	@Test
	@Ignore
	public void validateUserTestCase()
	{
		User flag = userDAO.validateUser(01, "siraj");
		
		assertEquals("validateUserTestCase", true, flag);
	}
}
