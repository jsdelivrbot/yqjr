package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/activeMatchTask")
public class ActiveMatchTaskController {

	//region generated by CodeRobot
	
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/activematchtask/activeMatchTaskList";
	}

    @RequestMapping(value = "/view")
    public String view() {
        return "framework/system/activematchtask/activeMatchTaskView";
    }

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/activematchtask/activeMatchTaskForm";
	}
	
	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/activematchtask/activeMatchTaskModify";
	}

	@RequestMapping(value = "/modal")
	public String modal() {
		return "framework/system/activematchtask/activeMatchTaskModal";
	}

	@RequestMapping(value = "/listModal")
	public String listModal() {
		return "framework/system/activematchtask/activeMatchTaskListModal";
	}
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
}