package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/activeMainHis")
public class ActiveMainHisController {

	//region generated by CodeRobot
	
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/activemainhis/activeMainHisList";
	}

    @RequestMapping(value = "/view")
    public String view() {
        return "framework/system/activemainhis/activeMainHisView";
    }

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/activemainhis/activeMainHisForm";
	}
	
	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/activemainhis/activeMainHisModify";
	}

	@RequestMapping(value = "/modal")
	public String modal() {
		return "framework/system/activemainhis/activeMainHisModal";
	}

	@RequestMapping(value = "/listModal")
	public String listModal() {
		return "framework/system/activemainhis/activeMainHisListModal";
	}
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
}