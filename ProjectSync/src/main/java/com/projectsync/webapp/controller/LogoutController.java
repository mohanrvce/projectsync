package com.projectsync.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	// add request mapping for /access-denied
	@GetMapping("/afterLogout")
	public String showAccessDenied() {
		return "afterLogoutPage";
	}

}
