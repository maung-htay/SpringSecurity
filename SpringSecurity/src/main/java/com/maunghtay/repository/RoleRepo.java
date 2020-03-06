package com.maunghtay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maunghtay.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

	Role findByRole(String role);
}
