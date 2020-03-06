package com.maunghtay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maunghtay.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
    User findByUserName(String userName);
}
