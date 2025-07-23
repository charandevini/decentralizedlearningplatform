package com.dlp.progresstrackerservice.service;

import com.dlp.progresstrackerservice.dto.QuizScoreRequest;
import com.dlp.progresstrackerservice.dto.QuizScoreResponse;
import com.dlp.progresstrackerservice.dto.UserProgressStats;

public interface QuizScoreService {

	public QuizScoreResponse submitQuiz(QuizScoreRequest request);

	public UserProgressStats getUserStats(Long userId);

}
