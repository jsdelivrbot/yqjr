package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/user/userList";
	}

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/user/userForm";
	}

	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/user/userModify";
	}

	@RequestMapping(value = "/modifyPwd")
	public String modifyPwd() {
		return "framework/system/user/userModifyPwd";
	}

	@RequestMapping(value = "/info")
	public String info() {
		return "framework/system/user/userInfo";
	}

}
