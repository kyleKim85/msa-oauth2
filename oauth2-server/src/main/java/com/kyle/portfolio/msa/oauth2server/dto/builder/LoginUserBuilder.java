package com.kyle.portfolio.msa.oauth2server.dto.builder;

import com.kyle.portfolio.msa.oauth2server.dto.LoginUser;

public class LoginUserBuilder {
	private String username;
	private String password;
	private String role;
	
	public LoginUserBuilder username(String username) {
		this.username = username;
		return this;
	}
	public LoginUserBuilder password(String password) {
		this.password = password;
		return this;
	}
	public LoginUserBuilder role(String role) {
		this.role = role;
		return this;
	}
	
	public LoginUser build() {
		LoginUser loginUser = new LoginUser();
		loginUser.setUsername(this.username);
		loginUser.setPassword(this.password);
		loginUser.setRole(this.role);
		return loginUser;
	}
}
