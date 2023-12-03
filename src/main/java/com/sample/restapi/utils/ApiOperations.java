package com.sample.restapi.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiOperations {
	
	@Autowired
	RestTemplate restTemplate;
	
	String urlDomain="http://restapi.adequateshop.com/api";

	public ResponseEntity<?> callApi(String input, String endpoint,String Token){
		try {
			
			HttpEntity<?> entity=setHttpHeader(input,Token);
			return restTemplate.exchange(urlDomain+endpoint, HttpMethod.POST, entity, String.class);
			
		}catch(HttpStatusCodeException ex) {
			System.out.print("Exceptions ex"+ex);
			return new ResponseEntity(ex.getMessage(),ex.getStatusCode());
		}
		catch(Exception e) {
			
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	public HttpEntity<?> setHttpHeader(String user,String Token){
		HttpHeaders header=new HttpHeaders();
		
		if(Token !=null && !Token.isEmpty())
			header.add("Authorization", Token);
		
		header.add("Content-Type", "application/json");
		return new HttpEntity<>(user,header);
		
	}
	
}
