package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/office")
public class OfficeController {
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/office/officeList";
	}

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/office/officeForm";
	}

	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/office/officeModify";
	}
	

}
