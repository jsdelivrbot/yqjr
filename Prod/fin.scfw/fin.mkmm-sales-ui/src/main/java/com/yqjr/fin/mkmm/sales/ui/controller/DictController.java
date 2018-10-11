package com.yqjr.fin.mkmm.sales.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dict")
public class DictController {
    @RequestMapping(value = "/list")
    public String list() {
        return "framework/system/dict/dictList";
    }

    @RequestMapping(value = "/form")
    public String form() {
        return "framework/system/dict/dictForm";
    }

    @RequestMapping(value = "/modify")
    public String modify() {
        return "framework/system/dict/dictModify";
    }
}
