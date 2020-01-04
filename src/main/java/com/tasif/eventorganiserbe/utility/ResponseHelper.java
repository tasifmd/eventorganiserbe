package com.tasif.eventorganiserbe.utility;

import com.tasif.eventorganiserbe.response.LoginResponse;
import com.tasif.eventorganiserbe.response.Response;

public class ResponseHelper {

	public static Response statusInfo(String responseMessage, int responseCode) {
		Response response = new Response();
		response.setResponseMessage(responseMessage);
		response.setResponseCode(responseCode);
		return response;
	}

	public static LoginResponse statusResponseInfo(String responseMessage, int responseCode, String token,
			String userName, String userEmail) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setResponseMessage(responseMessage);
		loginResponse.setResponseCode(responseCode);
		loginResponse.setToken(token);
		loginResponse.setUserName(userName);
		loginResponse.setUserEmail(userEmail);
		return loginResponse;
	}
}
