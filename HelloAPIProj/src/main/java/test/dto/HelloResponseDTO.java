package test.dto;

import java.io.Serializable;

public class HelloResponseDTO implements java.io.Serializable {
	
	String response ;
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = "Hello " + response;
	}

	public HelloResponseDTO() {
		
		this.response = "Hello ";
		
	}
	
	public HelloResponseDTO(String name) {
		
		this.response = "Hello " + name;
		
	}
	
	
}
