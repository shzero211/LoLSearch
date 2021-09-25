package com.riot.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class indexController {
	public String index(Model model) {
		return "index";
	}
}
