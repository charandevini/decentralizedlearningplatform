package com.dlp.peerreviewhubservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dlp.peerreviewhubservice.dto.PeerReviewRequest;
import com.dlp.peerreviewhubservice.dto.PeerReviewResponse;
import com.dlp.peerreviewhubservice.dto.UserReviewResponse;
import com.dlp.peerreviewhubservice.model.PeerReview;
import com.dlp.peerreviewhubservice.repository.PeerReviewRepository;
import com.dlp.peerreviewhubservice.service.PeerReviewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeerReviewServiceImpl implements PeerReviewService {

	private final PeerReviewRepository peerReviewRepository;

	@Override
	public PeerReviewResponse submitReview(PeerReviewRequest request) {
		PeerReview peerReview = PeerReview.builder().submissionId(request.getSubmissionId())
				.reviewerId(request.getReviewerId()).rating(request.getRating()).comments(request.getComments())
				.createdBy(request.getCreatedBy()).build();

		return PeerReviewResponse.fromEntity(peerReviewRepository.save(peerReview));
	}

	@Override
	public UserReviewResponse getReviewsByUser(Long userId) {
		List<PeerReview> reviews = peerReviewRepository.findByReviewerId(userId);

		List<UserReviewResponse.ReviewDetail> details = reviews.stream()
				.map((PeerReview r) -> UserReviewResponse.ReviewDetail.builder().submissionId(r.getSubmissionId())
						.reviewerId(r.getReviewerId()).rating(r.getRating()).comments(r.getComments()).build())
				.collect(Collectors.toList());

		return UserReviewResponse.builder().userId(userId).reviews(details).build();
	}

}
