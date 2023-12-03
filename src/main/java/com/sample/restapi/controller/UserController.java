package com.sample.restapi.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.restapi.dto.User;
import com.sample.restapi.service.UserService;
import com.sample.restapi.utils.ValidationException;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping(value="/add")
    public ResponseEntity<?> createUser(@RequestBody User user){
		
		if(user!=null && user.getId()!=null && !user.getId().isEmpty() && user.getName()!=null && !user.getName().isEmpty()) {		
        User savedUser = userservice.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
		}else {
			throw new ValidationException("Invalid User Request, Id/Name is Missing");
		}
    }
	
	@GetMapping(value="/getbyid")
	public ResponseEntity<?> getUserById(@RequestParam(value = "Id") String Id){
		if(Id!=null && !Id.isEmpty()) {
		User usobj=userservice.getUserById(Id);
		if(usobj!=null) {
			return new ResponseEntity<>(usobj,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No User Record Found for this Id #"+Id,HttpStatus.NO_CONTENT);
		}
		}else {
			throw new ValidationException("Invalid Request, Id is Mandatory/Missing");
		}
		
		
	}
	
	@GetMapping(value="/getall")
	public ResponseEntity<?> getAllUser(){
		List<User> userList=userservice.getAllUser();
		if(userList!=null && userList.size()>0) {
			return new ResponseEntity<>(userList,HttpStatus.OK);
		}else {
		return new ResponseEntity<>("No Record Found!",HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping(value="/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
		
		if(user!=null && user.getId()!=null && !user.getId().isEmpty()) {
		
	        boolean updval = userservice.updateUser(user);
	        if(updval) {
	        	return new ResponseEntity<>("User details Updated Successfully", HttpStatus.OK);
	        }else {
	        	return new ResponseEntity<>("Invalid User Id #"+user.getId(), HttpStatus.BAD_REQUEST);
	        }
        
		}else {
			throw new ValidationException("Invalid Request, Id is Mandatory/Missing");
		}
        
    }
	
	@DeleteMapping(value="/delete")
    public ResponseEntity<?> deleteUser(@RequestParam(value = "Id") String Id){
		if(Id!=null && !Id.isEmpty()) {
		 boolean delval = userservice.deleteUser(Id);
		 if(delval) {
			 return new ResponseEntity<>("User Successfully Deleted!", HttpStatus.OK);
		 }else {
			 return new ResponseEntity<>("Invalid User Id "+Id, HttpStatus.BAD_REQUEST);
		 }}
		else {
			throw new ValidationException("Invalid Request, Id is Mandatory/Missing");
		}
        
    }
	
}
