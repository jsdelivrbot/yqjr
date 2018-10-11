package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/feeMain")
public class FeeMainController {

	//region generated by CodeRobot
	
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/feemain/feeMainList";
	}

    @RequestMapping(value = "/view")
    public String view() {
        return "framework/system/feemain/feeMainView";
    }

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/feemain/feeMainForm";
	}
	
	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/feemain/feeMainModify";
	}

	@RequestMapping(value = "/modal")
	public String modal() {
		return "framework/system/feemain/feeMainModal";
	}

	@RequestMapping(value = "/listModal")
	public String listModal() {
		return "framework/system/feemain/feeMainListModal";
	}
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
}