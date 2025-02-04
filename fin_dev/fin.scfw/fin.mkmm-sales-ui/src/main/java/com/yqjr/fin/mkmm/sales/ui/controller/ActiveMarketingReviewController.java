package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/activeMarketingReview")
public class ActiveMarketingReviewController {

	//region generated by CodeRobot
	
	@RequestMapping(value = "/list")
	public String list() {
		return "framework/system/activemarketingreview/activeMarketingReviewList";
	}

    @RequestMapping(value = "/view")
    public String view() {
        return "framework/system/activemarketingreview/activeMarketingReviewView";
    }

	@RequestMapping(value = "/form")
	public String form() {
		return "framework/system/activemarketingreview/activeMarketingReviewForm";
	}
	
	@RequestMapping(value = "/modify")
	public String modify() {
		return "framework/system/activemarketingreview/activeMarketingReviewModify";
	}

	@RequestMapping(value = "/modal")
	public String modal() {
		return "framework/system/activemarketingreview/activeMarketingReviewModal";
	}

	@RequestMapping(value = "/listModal")
	public String listModal() {
		return "framework/system/activemarketingreview/activeMarketingReviewListModal";
	}
	
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ~此线上方代码自动生成，在此下方编写自定义代码。
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//endregion
}