package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/personMainHis")
public class PersonMainHisController {

	//region generated by CodeRobot
	
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/personmainhis/personMainHisList";
	}

    @RequestMapping(value = "/view")
    public String view() {
        return "framework/system/personmainhis/personMainHisView";
    }

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/personmainhis/personMainHisForm";
	}
	
	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/personmainhis/personMainHisModify";
	}

	@RequestMapping(value = "/modal")
	public String modal() {
		return "framework/system/personmainhis/personMainHisModal";
	}

	@RequestMapping(value = "/listModal")
	public String listModal() {
		return "framework/system/personmainhis/personMainHisListModal";
	}
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
}