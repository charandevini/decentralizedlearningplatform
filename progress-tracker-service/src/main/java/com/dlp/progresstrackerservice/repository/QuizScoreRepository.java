package com.dlp.progresstrackerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlp.progresstrackerservice.model.QuizScore;

public interface QuizScoreRepository extends JpaRepository<QuizScore, Long> {

	List<QuizScore> findByEnrollmentId(Long enrollmentId);

}
