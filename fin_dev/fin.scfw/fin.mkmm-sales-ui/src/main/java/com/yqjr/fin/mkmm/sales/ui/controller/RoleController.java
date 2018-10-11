package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/role/roleList";
	}

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/role/roleForm";
	}

	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/role/roleModify";
	}

}
