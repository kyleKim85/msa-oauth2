package com.kyle.portfolio.msa.oauth2server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kyle.portfolio.msa.oauth2server.dto.LoginUser;
import com.kyle.portfolio.msa.oauth2server.entity.User;
import com.kyle.portfolio.msa.oauth2server.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("UsernameNotFound [" + username + "]");
		}
		return LoginUser.Builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.role(user.getRole())
				.build();
	}
	

}
