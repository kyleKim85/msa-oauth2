package com.kyle.portfolio.msa.apiservice.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {
	@GetMapping("/me")
	public String me(Principal user) {
		return user == null ? "Geust" : user.getName();
	}
}
