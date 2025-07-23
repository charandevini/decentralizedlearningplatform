package com.dlp.courseengineservice.service;

import java.util.List;

import com.dlp.courseengineservice.dto.CourseRequest;
import com.dlp.courseengineservice.dto.CourseResponse;

public interface CourseService {

	public CourseResponse createCourse(CourseRequest request);

	public List<CourseResponse> getAllCourses();

	public CourseResponse getCourseById(Long courseId);

}
