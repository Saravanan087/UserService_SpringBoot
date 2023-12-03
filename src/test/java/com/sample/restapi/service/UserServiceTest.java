package com.sample.restapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sample.restapi.dto.User;
import com.sample.restapi.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@InjectMocks
	UserServiceImpl userService;
	
	private User usObj=null;
	
	@BeforeEach
	void init() {
			usObj=new User("4","Harthik","Harthik@gmail.com");
	}
	
	@Test
	public void testGetUserById_ExistingUser() {
	    
	    String existingId = "123"; 
	    User expectedUser = new User(existingId, "saipreethi", "sai@gmail.com");
	    userService.usrlist =Arrays.asList(expectedUser,usObj);
	    User actualUser = userService.getUserById(existingId);
	    assertEquals(expectedUser, actualUser);
	}
	
	@Test
	public void testGetUserById_NonExistingUser() {
	    
	    String nonExistingId = "657"; 
	    User expectedUser = new User("123", "saipreethi", "sai@gmail.com");
	    userService.usrlist =Arrays.asList(expectedUser,usObj);
	    User actualUser = userService.getUserById(nonExistingId);
	    assertNull(actualUser);
	}
	
	@Test
	public void testcreateUser() {
	    
	    String ExpectedId = "4"; 
	    User actualUser = userService.createUser(usObj);
	    assertEquals(ExpectedId,actualUser.getId());
	}
	
	@Test
	public void testGetAllUser() {
		User expectedUser = new User("123", "saipreethi", "sai@gmail.com");
		userService.usrlist =Arrays.asList(expectedUser,usObj);
		List<User> expectedUsers =userService.usrlist;

	    List<User> actualUsers = userService.getAllUser();

	    assertEquals(expectedUsers, actualUsers);
	    assertEquals(expectedUsers.size(), actualUsers.size());
	    for (int i = 0; i < expectedUsers.size(); i++) {
	        assertEquals(expectedUsers.get(i), actualUsers.get(i));
	    }
	}
	
	@Test
	public void testUpdateUser_WithExistingUserList() {
	    
	    String expectedName = "Suja"; 
	    User expectedUser = new User("123", expectedName, "sai@gmail.com");
	    userService.usrlist =Arrays.asList(new User("123", "saipreethi", "sai@gmail.com"),usObj);
	    
	    boolean actualboolval = userService.updateUser(expectedUser);
	    assertEquals(true, actualboolval);
	}
	
	@Test
	public void testUpdateUser_WithNonExistingUserInList() {
	    
	    String expectedName = "Suja"; 
	    User expectedUser = new User("957", expectedName, "sai@gmail.com");
	    userService.usrlist =Arrays.asList(new User("123", "saipreethi", "sai@gmail.com"),usObj);
	    
	    boolean actualboolval = userService.updateUser(expectedUser);
	    assertNotEquals(true, actualboolval);
	}
	
	@Test
	public void testDeleteUser_WithNonExistingUserList() {
	    
	    String existingId = "956"; 
	    userService.usrlist =Arrays.asList(new User("123", "saipreethi", "sai@gmail.com"),usObj);
	    int initialSizelist= userService.usrlist.size();
	    
	    boolean actualboolval = userService.deleteUser(existingId);
	    assertFalse(actualboolval);
	    assertEquals(initialSizelist, userService.usrlist.size());
	}
	
	@Test
	public void testDeleteUser_WithExistingUserList() {
	    String existingId = "666";
	    userService.usrlist.addAll(Arrays.asList(new User(existingId, "selvam", "selvam@gmail.com"),usObj));

	    boolean deleted = userService.deleteUser(existingId);
	    assertTrue(deleted);
	    assertFalse(userService.usrlist.stream().anyMatch(p -> p.getId().equals(existingId)));
	}
}
