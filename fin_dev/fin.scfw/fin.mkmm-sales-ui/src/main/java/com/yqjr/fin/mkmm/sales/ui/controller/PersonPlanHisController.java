package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/personPlanHis")
public class PersonPlanHisController {

	//region generated by CodeRobot
	
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/personplanhis/personPlanHisList";
	}

    @RequestMapping(value = "/view")
    public String view() {
        return "framework/system/personplanhis/personPlanHisView";
    }

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/personplanhis/personPlanHisForm";
	}
	
	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/personplanhis/personPlanHisModify";
	}

	@RequestMapping(value = "/modal")
	public String modal() {
		return "framework/system/personplanhis/personPlanHisModal";
	}

	@RequestMapping(value = "/listModal")
	public String listModal() {
		return "framework/system/personplanhis/personPlanHisListModal";
	}
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
}