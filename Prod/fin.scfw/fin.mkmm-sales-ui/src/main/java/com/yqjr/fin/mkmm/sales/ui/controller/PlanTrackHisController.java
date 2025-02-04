package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/planTrackHis")
public class PlanTrackHisController {

	//region generated by CodeRobot
	
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/plantrackhis/planTrackHisList";
	}

    @RequestMapping(value = "/view")
    public String view() {
        return "framework/system/plantrackhis/planTrackHisView";
    }

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/plantrackhis/planTrackHisForm";
	}
	
	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/plantrackhis/planTrackHisModify";
	}

	@RequestMapping(value = "/modal")
	public String modal() {
		return "framework/system/plantrackhis/planTrackHisModal";
	}

	@RequestMapping(value = "/listModal")
	public String listModal() {
		return "framework/system/plantrackhis/planTrackHisListModal";
	}
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
}