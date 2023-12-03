package com.sample.restapi.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.restapi.dto.User;
import com.sample.restapi.service.UserService;

@Service
public class UserServiceImpl implements UserService  {
	
	public List<User> usrlist=new ArrayList<>(Arrays.asList(
			new User("1","saravanan","saran@gmail.com"),
			new User("12","shanthini","shan@gmail.com"),
			new User("123","saipreethi","sai@gmail.com")));
	
	
	@Override
	public User createUser(User user) {
		usrlist.add(user);
		return user;
	}

	@Override
	public User getUserById(String id) {
		try {
			return usrlist.stream().filter(p-> p.getId().equals(id)).findFirst().get();	
		}catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public List<User> getAllUser() {
		return usrlist;
	}

	@Override
	public boolean updateUser(User user) {
		
		for(int i=0;i<usrlist.size();i++) {
			User us=usrlist.get(i);
			if(us.getId().equals(user.getId())) {
				usrlist.set(i, user);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteUser(String id) {
		return usrlist.removeIf(p -> p.getId().equals(id));
	}

	

}
