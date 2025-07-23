package com.dlp.courseengineservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlp.courseengineservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByRole(String string);

}
