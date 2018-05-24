package com.newnil.snowyowl.littlesnowyowl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

    /**
     * Matching everything that does not have a suffix and forward to "/",
     * this is for html5mode of ng.
     */
    @RequestMapping("/**/{[path:[^\\.]*}")
    public String forward() {
        return "forward:/";
    }
}
