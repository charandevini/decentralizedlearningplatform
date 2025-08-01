package com.dlp.courseengineservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRequest {
	@NotBlank(message = "UserName is Mandatory")
	private String userName;

	@NotBlank(message = "Email is Mandatory")
	@Email
	private String email;

	@NotBlank(message = "Role is Mandatory")
	private String role; // 'instructor' or 'learner'

	@NotBlank(message = "Created By is Mandatory")
	private String createdBy;
}
