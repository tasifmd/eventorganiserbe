package com.tasif.eventorganiserbe.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tasif.eventorganiserbe.response.LoginResponse;
import com.tasif.eventorganiserbe.response.Response;
import com.tasif.eventorganiserbe.user.dto.LoginDto;
import com.tasif.eventorganiserbe.user.dto.UserDto;
import com.tasif.eventorganiserbe.user.model.User;
import com.tasif.eventorganiserbe.user.repository.UserRepository;
import com.tasif.eventorganiserbe.user.service.UserService;
import com.tasif.eventorganiserbe.utility.JWTTokenHelper;
import com.tasif.eventorganiserbe.utility.ResponseHelper;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JWTTokenHelper jwtTokenHelper;
	
	@Override
	public Response createUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		String userEmail = user.getUserEmail();
		if(userRepository.existsByUserEmail(userEmail))
				throw new RuntimeException("User already exist with email " + userEmail);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		Response response = ResponseHelper.statusInfo("User created successfully", 1000);
		return response;
	}

	@Override
	public LoginResponse loginUser(LoginDto loginDto) {
		String userEmail = loginDto.getUserEmail();
		User user = userRepository.findByUserEmail(userEmail)
				.orElseThrow(() -> new RuntimeException("No user exist with email " + userEmail));
		boolean flag = passwordEncoder.matches(loginDto.getPassword(), user.getPassword());
		if (!flag) {
			throw new RuntimeException("Sorry password does not match");
		}
		String token = jwtTokenHelper.generateToken(user.getUserId());
		LoginResponse loginResponse = ResponseHelper.statusResponseInfo("Login success", 1000, token, user.getUserName(), userEmail);
		return loginResponse;
	}

}
