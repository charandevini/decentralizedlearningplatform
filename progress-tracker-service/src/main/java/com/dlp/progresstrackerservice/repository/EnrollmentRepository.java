package com.dlp.progresstrackerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlp.progresstrackerservice.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

	public List<Enrollment> findByUserId(Long userId);

}
