package com.xindus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xindus.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	boolean existsByUsername(String username);
}
