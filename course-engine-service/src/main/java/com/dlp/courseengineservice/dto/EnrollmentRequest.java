package com.dlp.courseengineservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EnrollmentRequest {
	private Long userId;

	private Long courseId;

	@NotBlank(message = "Created By is Required")
	private String createdBy;

}
