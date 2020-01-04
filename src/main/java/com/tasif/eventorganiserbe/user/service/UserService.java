package com.tasif.eventorganiserbe.user.service;

import com.tasif.eventorganiserbe.response.LoginResponse;
import com.tasif.eventorganiserbe.response.Response;
import com.tasif.eventorganiserbe.user.dto.LoginDto;
import com.tasif.eventorganiserbe.user.dto.UserDto;

public interface UserService {

	public Response createUser(UserDto userDto);
	
	public LoginResponse loginUser(LoginDto loginDto);
}
