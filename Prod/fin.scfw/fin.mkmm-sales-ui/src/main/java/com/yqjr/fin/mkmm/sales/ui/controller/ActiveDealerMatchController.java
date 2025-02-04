package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/activeDealerMatch")
public class ActiveDealerMatchController {

	//region generated by CodeRobot
	
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/activedealermatch/activeDealerMatchList";
	}

    @RequestMapping(value = "/view")
    public String view() {
        return "framework/system/activedealermatch/activeDealerMatchView";
    }

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/activedealermatch/activeDealerMatchForm";
	}
	
	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/activedealermatch/activeDealerMatchModify";
	}

	@RequestMapping(value = "/modal")
	public String modal() {
		return "framework/system/activedealermatch/activeDealerMatchModal";
	}

	@RequestMapping(value = "/listModal")
	public String listModal() {
		return "framework/system/activedealermatch/activeDealerMatchListModal";
	}
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
}