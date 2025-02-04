package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/workFlow")
public class WorkFlowController {

	//region generated by CodeRobot
	
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/workflow/workFlowList";
	}

    @RequestMapping(value = "/view")
    public String view() {
        return "framework/system/workflow/workFlowView";
    }

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/workflow/workFlowForm";
	}
	
	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/workflow/workFlowModify";
	}

	@RequestMapping(value = "/modal")
	public String modal() {
		return "framework/system/workflow/workFlowModal";
	}

	@RequestMapping(value = "/listModal")
	public String listModal() {
		return "framework/system/workflow/workFlowListModal";
	}
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
}