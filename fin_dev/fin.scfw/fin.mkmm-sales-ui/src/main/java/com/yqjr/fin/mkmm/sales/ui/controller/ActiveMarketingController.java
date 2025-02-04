package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/activeMarketing")
public class ActiveMarketingController {

	//region generated by CodeRobot
	
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/activemarketing/activeMarketingList";
	}

    @RequestMapping(value = "/view")
    public String view() {
        return "framework/system/activemarketing/activeMarketingView";
    }

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/activemarketing/activeMarketingForm";
	}
	
	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/activemarketing/activeMarketingModify";
	}

	@RequestMapping(value = "/modal")
	public String modal() {
		return "framework/system/activemarketing/activeMarketingModal";
	}

	@RequestMapping(value = "/listModal")
	public String listModal() {
		return "framework/system/activemarketing/activeMarketingListModal";
	}
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
}