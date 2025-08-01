package com.dlp.progresstrackerservice.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class UserProgressStats {
	private Long userId;
	private List<CourseProgress> enrollments;
	
	@Data
    @Builder
    public static class CourseProgress {
        private Long courseId;
        private Integer progressPercent;
        private List<Integer> quizScores;
    }
}
