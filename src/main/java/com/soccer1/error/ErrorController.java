package com.soccer1.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	
	@GetMapping("/error/access-denied")
	public String showAccessDeniedPage() {
		return "error/access-denied";
	}
}