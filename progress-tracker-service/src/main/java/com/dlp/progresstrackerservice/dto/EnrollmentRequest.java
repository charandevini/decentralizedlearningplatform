package com.dlp.progresstrackerservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class EnrollmentRequest {
	private Long userId;

	private Long courseId;

	@NotBlank(message = "Created By is Required")
	private String createdBy;

}
