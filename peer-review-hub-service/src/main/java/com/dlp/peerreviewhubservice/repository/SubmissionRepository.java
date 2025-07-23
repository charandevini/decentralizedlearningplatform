package com.dlp.peerreviewhubservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlp.peerreviewhubservice.model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

}
