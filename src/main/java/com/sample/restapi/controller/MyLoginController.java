package com.sample.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.restapi.service.LoginService;

@RestController
@RequestMapping("/api")
public class MyLoginController {

	@Autowired
	LoginService login;
	
	@PostMapping(value="/register")
    public ResponseEntity<?> userRegister(@RequestBody String user){
		if(user!=null) {		
        
        return login.userRegistration(user);
		}else {
			return new ResponseEntity<>("Invalid Request", HttpStatus.BAD_REQUEST);
		}
    }
	
	@PostMapping(value="/login")
    public ResponseEntity<?> genToken(@RequestBody String user){
		if(user!=null) {		
        
        return login.getLogin(user);
		}else {
			return new ResponseEntity<>("Invalid Request", HttpStatus.BAD_REQUEST);
		}
    }
	
}
