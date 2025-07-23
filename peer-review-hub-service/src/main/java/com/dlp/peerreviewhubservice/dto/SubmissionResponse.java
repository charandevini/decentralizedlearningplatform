package com.dlp.peerreviewhubservice.dto;

import java.sql.Timestamp;

import com.dlp.peerreviewhubservice.model.Submission;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubmissionResponse {

	private Long submissionId;

	private Long enrollmentId;

	private String content;

	private Timestamp submittedAt;

	private String createdBy;

	private Timestamp createdAt;

	public static SubmissionResponse fromEntity(Submission submission) {
		return SubmissionResponse.builder().submissionId(submission.getSubmissionId())
				.enrollmentId(submission.getEnrollmentId()).content(submission.getContent())
				.submittedAt(submission.getSubmittedAt()).createdBy(submission.getCreatedBy())
				.createdAt(submission.getCreatedAt()).build();
	}
}
