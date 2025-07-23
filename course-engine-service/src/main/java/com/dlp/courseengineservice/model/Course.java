package com.dlp.courseengineservice.model;

import java.sql.Timestamp;

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
@Table(name = "courses", schema = "postgres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Course {

	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;

	@Column(name = "instructor_id")
	private Long instructorId;

	@Column(name = "instructor_name")
	private String instructorName;

	private String title;

	private String description;

	@NotBlank(message = "Created By is Required")
	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_at")
	@UpdateTimestamp
	private Timestamp createdAt;

}
