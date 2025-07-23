package com.dlp.peerreviewhubservice.service;

import com.dlp.peerreviewhubservice.dto.PeerReviewRequest;
import com.dlp.peerreviewhubservice.dto.PeerReviewResponse;
import com.dlp.peerreviewhubservice.dto.UserReviewResponse;

public interface PeerReviewService {

	public PeerReviewResponse submitReview(PeerReviewRequest request);

	public UserReviewResponse getReviewsByUser(Long userId);

}
