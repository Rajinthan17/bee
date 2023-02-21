package com.bee.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@Value("${server.port}")
	private String port;
	
	@RequestMapping(value = "/pages")
	public String getAdminLogin(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/login";
	}
	
	@RequestMapping(value = "/pages/admin")
	public String getAdmin(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/index";
	}
}
