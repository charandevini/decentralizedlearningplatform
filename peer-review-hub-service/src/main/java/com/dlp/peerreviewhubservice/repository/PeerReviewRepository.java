package com.dlp.peerreviewhubservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlp.peerreviewhubservice.model.PeerReview;

public interface PeerReviewRepository extends JpaRepository<PeerReview, Long> {

	public List<PeerReview> findByReviewerId(Long userId);

}
