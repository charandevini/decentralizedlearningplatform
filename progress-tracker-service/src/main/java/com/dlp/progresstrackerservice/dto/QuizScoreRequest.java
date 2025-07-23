package com.dlp.progresstrackerservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class QuizScoreRequest {
	private Long enrollmentId;

	private Integer score;

	@NotBlank(message = "Created By is Mandatory")
	private String createdBy;

}
