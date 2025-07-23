package com.dlp.courseengineservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlp.courseengineservice.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
