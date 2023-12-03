package com.sample.restapi.service;

import org.springframework.http.ResponseEntity;

public interface LoginService {
	
	public ResponseEntity getLogin(String inpt);
	public ResponseEntity userRegistration(String inpt);
	
	public ResponseEntity validateToken(String inpt);

}
