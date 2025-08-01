package com.dlp.courseengineservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dlp.courseengineservice.dto.UserRequest;
import com.dlp.courseengineservice.dto.UserResponse;
import com.dlp.courseengineservice.model.User;
import com.dlp.courseengineservice.repository.UserRepository;
import com.dlp.courseengineservice.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public UserResponse createUser(UserRequest request) {
		User user = User.builder().userName(request.getUserName()).email(request.getEmail()).role(request.getRole())
				.createdBy(request.getCreatedBy()).build();

		return UserResponse.fromEntity(userRepository.save(user));
	}

	@Override
	public List<UserResponse> getAllUsers() {
		return userRepository.findAll().stream().map(UserResponse::fromEntity).toList();
	}

	@Override
	public UserResponse getUserById(Long userId) {
		return userRepository.findById(userId).map(UserResponse::fromEntity)
				.orElseThrow(() -> new RuntimeException("User not found"));
	}

}
