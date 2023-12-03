package com.sample.restapi.service;

import java.util.List;

import com.sample.restapi.dto.User;

public interface UserService {

	public User createUser(User user);
	public User getUserById(String user);
	public List<User> getAllUser();
	public boolean updateUser(User user);
	public boolean deleteUser(String userId);
}
