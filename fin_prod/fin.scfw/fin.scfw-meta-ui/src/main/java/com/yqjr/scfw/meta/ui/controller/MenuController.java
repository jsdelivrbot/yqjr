package com.yqjr.scfw.meta.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/menu/menuList";
	}

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/menu/menuForm";
	}

	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/menu/menuModify";
	}

}
