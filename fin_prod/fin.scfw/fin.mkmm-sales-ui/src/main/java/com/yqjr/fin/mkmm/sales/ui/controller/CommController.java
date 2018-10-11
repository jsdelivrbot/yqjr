package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comm")
public class CommController {
	@RequestMapping(value = "/login")
	public String login() {
		return "framework/login";
	}

	@RequestMapping(value = "/index")
	public String index() {
		return "framework/index";
	}
}
