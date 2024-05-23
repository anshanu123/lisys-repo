package com.rishabdebnath.lisys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/aboutUs")
    public String showAboutUsPage() {
        return "AboutUs";
    }

}
