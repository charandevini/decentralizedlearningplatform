package com.dlp.progresstrackerservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dlp.progresstrackerservice.dto.QuizScoreRequest;
import com.dlp.progresstrackerservice.dto.QuizScoreResponse;
import com.dlp.progresstrackerservice.dto.UserProgressStats;
import com.dlp.progresstrackerservice.model.Enrollment;
import com.dlp.progresstrackerservice.model.QuizScore;
import com.dlp.progresstrackerservice.repository.EnrollmentRepository;
import com.dlp.progresstrackerservice.repository.QuizScoreRepository;
import com.dlp.progresstrackerservice.service.QuizScoreService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizScoreServiceImpl implements QuizScoreService {

	private final QuizScoreRepository quizScoreRepository;
	private final EnrollmentRepository enrollmentRepository;

	@Override
	public QuizScoreResponse submitQuiz(QuizScoreRequest request) {
		QuizScore quizScore = QuizScore.builder().enrollmentId(request.getEnrollmentId()).score(request.getScore())
				.createdBy(request.getCreatedBy()).build();

		return QuizScoreResponse.fromEntity(quizScoreRepository.save(quizScore));
	}

	@Override
	public UserProgressStats getUserStats(Long userId) {
		List<Enrollment> enrollments = enrollmentRepository.findByUserId(userId);
		List<UserProgressStats.CourseProgress> progressList = new ArrayList<>();

		for (Enrollment e : enrollments) {
			List<QuizScore> scores = quizScoreRepository.findByEnrollmentId(e.getEnrollmentId());
			List<Integer> scoreValues = scores.stream().map(QuizScore::getScore).toList();
			progressList.add(UserProgressStats.CourseProgress.builder().courseId(e.getCourseId())
					.progressPercent(e.getProgressPercent()).quizScores(scoreValues).build());
		}

		return UserProgressStats.builder().userId(userId).enrollments(progressList).build();
	}

}
