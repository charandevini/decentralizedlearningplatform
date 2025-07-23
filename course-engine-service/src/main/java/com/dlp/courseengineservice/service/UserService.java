package com.dlp.courseengineservice.service;

import java.util.List;

import com.dlp.courseengineservice.dto.UserRequest;
import com.dlp.courseengineservice.dto.UserResponse;

public interface UserService {

	public UserResponse createUser(UserRequest request);

	public List<UserResponse> getAllUsers();

	public UserResponse getUserById(Long userId);

}
