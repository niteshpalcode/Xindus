package com.xindus.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.xindus.entity.User;

public interface UserDetailService extends UserDetailsService {

	User signUp(User user);

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

	boolean existsByUsername(String username);

	boolean login(String username, String password); 

}
