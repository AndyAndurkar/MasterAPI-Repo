package test.dco;

import test.dto.*;

public class HelloDCO {
	
	
	public HelloResponseDTO getHelloResponse(String name) {
		
		HelloResponseDTO dto =  new HelloResponseDTO(name);
		
		return dto;
		
	}

}
