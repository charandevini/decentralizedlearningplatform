package com.dlp.progresstrackerservice.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quiz_scores", schema = "postgres")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizScore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quiz_score_id")
	private Long quizScoreId;

	@Column(name = "enrollment_id")
	private Long enrollmentId;

	private Integer score;

	@CreationTimestamp
	@Column(name = "taken_at")
	private LocalDateTime takenAt;

	@Column(name = "created_by")
	@NotBlank(message = "Created By is Mandatory")
	private String createdBy;

	@Column(name = "created_at")
	@UpdateTimestamp
	private Timestamp createdAt;
}
