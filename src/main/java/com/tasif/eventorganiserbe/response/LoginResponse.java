package com.tasif.eventorganiserbe.response;

import lombok.Data;

@Data
public class LoginResponse {
	private int responseCode;
	private String responseMessage;
	private String token;
	private String userName;
	private String userEmail;
	
}
