package com.dlp.peerreviewhubservice.dto;

import java.sql.Timestamp;

import com.dlp.peerreviewhubservice.model.PeerReview;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PeerReviewResponse {
	private Long peerReviewId;

	private Long submissionId;

	private Long reviewerId;

	private Integer rating;

	private String comments;

	private String createdBy;

	private Timestamp createdAt;

	public static PeerReviewResponse fromEntity(PeerReview peerReview) {
		return PeerReviewResponse.builder().peerReviewId(peerReview.getPeerReviewId())
				.submissionId(peerReview.getSubmissionId()).reviewerId(peerReview.getReviewerId())
				.rating(peerReview.getRating()).comments(peerReview.getComments()).createdBy(peerReview.getCreatedBy())
				.createdAt(peerReview.getCreatedAt()).build();
	}
}
