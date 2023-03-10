package com.bee.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bee.repo.UserRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.bee.entity.User user = UserRepository.findByUsername(username);
		
		if (user != null) {
			return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	public com.bee.entity.User save(com.bee.entity.User user) {
		com.bee.entity.User newUser = new com.bee.entity.User();
		newUser.setUsername(user.getUsername());
		newUser.setType(user.getType());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return UserRepository.save(newUser);
	}
	
	public Boolean isUsernameExist(String username) {
		com.bee.entity.User user = UserRepository.findByUsername(username);
		if(user != null) {
			return true;
		}
		return false;
	}
}
