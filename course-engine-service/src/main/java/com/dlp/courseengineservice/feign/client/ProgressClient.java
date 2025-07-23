package com.dlp.courseengineservice.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dlp.courseengineservice.dto.EnrollmentRequest;

@FeignClient(name = "progress-tracker-service")
public interface ProgressClient {

	@PostMapping("/api/enrollments/bulk")
	void bulkEnroll(@RequestBody List<EnrollmentRequest> requests);
}
