package com.javainuse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String name);
}
