package com.maunghtay.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.maunghtay.model.Role;
import com.maunghtay.model.User;
import com.maunghtay.repository.RoleRepo;
import com.maunghtay.repository.UserRepo;

@Service
public class UserService {

	private RoleRepo myRoleRepo;
	private UserRepo myUserRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	public UserService(RoleRepo myRoleRepo, UserRepo myUserRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.myRoleRepo = myRoleRepo;
		this.myUserRepo = myUserRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public User findUserByEmail(String email) {
		return myUserRepo.findByEmail(email);
	}
	
	public User findUserByUserName(String userName) {
        return myUserRepo.findByUserName(userName);
    }
	public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       
        Role userRole = myRoleRepo.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return myUserRepo.save(user);
    }
	
}
