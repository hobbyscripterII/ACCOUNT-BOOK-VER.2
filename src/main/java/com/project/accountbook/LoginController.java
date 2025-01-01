package com.project.accountbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}