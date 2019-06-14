package com.kyle.portfolio.msa.apiservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {
	@GetMapping("/me")
	public String me() {
		return "I'm guest";
	}
}
