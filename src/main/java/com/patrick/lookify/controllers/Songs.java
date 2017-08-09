package com.patrick.lookify.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Songs {
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
}
