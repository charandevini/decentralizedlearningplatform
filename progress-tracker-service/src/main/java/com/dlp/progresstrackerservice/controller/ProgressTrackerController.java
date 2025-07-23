package com.dlp.progresstrackerservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlp.progresstrackerservice.dto.EnrollmentRequest;
import com.dlp.progresstrackerservice.dto.ProgressUpdateRequest;
import com.dlp.progresstrackerservice.dto.QuizScoreRequest;
import com.dlp.progresstrackerservice.service.EnrollmentService;
import com.dlp.progresstrackerservice.service.QuizScoreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class ProgressTrackerController {

	private final EnrollmentService enrollmentService;
	private final QuizScoreService quizScoreService;

	// 🔹 Enroll a user in a course
	@PostMapping("/new")
	public ResponseEntity<?> enroll(@Valid @RequestBody EnrollmentRequest request) {
		return ResponseEntity.ok(enrollmentService.createEnrollment(request));
	}

	// 🔹 Update course progress
	@PutMapping("/progress")
	public ResponseEntity<?> updateProgress(@RequestBody ProgressUpdateRequest request) {
		return ResponseEntity.ok(enrollmentService.updateProgress(request));
	}

	// 🔹 Submit a quiz score
	@PostMapping("/quizzes")
	public ResponseEntity<?> submitQuiz(@RequestBody QuizScoreRequest request) {
		return ResponseEntity.ok(quizScoreService.submitQuiz(request));
	}

	// 🔹 Get user progress & quiz stats
	@GetMapping("/stats/{userId}")
	public ResponseEntity<?> getStats(@PathVariable Long userId) {
		return ResponseEntity.ok(quizScoreService.getUserStats(userId));
	}

	@PostMapping("/bulk")
	public ResponseEntity<?> bulkEnroll(@RequestBody List<EnrollmentRequest> requests) {
		return ResponseEntity.ok(enrollmentService.bulkCreate(requests));
	}

}
