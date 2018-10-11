package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class AttachController {
	@RequestMapping(value = "/modal")
	public String list() {
		return "framework/system/attach/attachModal";
	}

}
