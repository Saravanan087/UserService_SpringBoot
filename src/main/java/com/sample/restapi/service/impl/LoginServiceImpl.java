package com.sample.restapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sample.restapi.service.LoginService;
import com.sample.restapi.utils.ApiOperations;

@Service
public class LoginServiceImpl implements LoginService {
	
	
	@Autowired
	ApiOperations apiservice;
	
	
	@Override
	public ResponseEntity getLogin(String inpt) {
		 String strUrl="/AuthAccount/Login";
		return apiservice.callApi(inpt,strUrl,null);
	}

	@Override
	public ResponseEntity userRegistration(String inpt) {
		 String strUrl="/AuthAccount/Registration";
		return apiservice.callApi(inpt,strUrl,null);
	}

	@Override
	public ResponseEntity validateToken(String token) {
		 String strUrl="/Users";
		return apiservice.callApi(null,strUrl,token);
	}

}
