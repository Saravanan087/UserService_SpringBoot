package com.sample.restapi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.sample.restapi.service.LoginService;

@Component
public class JwtUtils {

	
	@Autowired
	LoginService login;
	
	public void validate(String Token) throws Exception {
		
			ResponseEntity res=login.validateToken(Token);
			if(res.getStatusCode().is4xxClientError())
				throw new AccessDeniedException(res.getBody().toString());
	}
	
}
