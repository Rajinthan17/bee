package com.bee.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/pages/admin/category")
	public String getCategory(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/category";
	}
	
	@RequestMapping(value = "/pages/admin/category/create")
	public String getCategoryCreate(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/category_create";
	}
	
	@RequestMapping(value = "/pages/admin/category/{id}")
	public String getCategoryEdit(@PathVariable String id, Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		model.addAttribute("id", id);
		return "admin/category_edit";
	}
}
