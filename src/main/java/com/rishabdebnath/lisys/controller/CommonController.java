package com.rishabdebnath.lisys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/home")
    public String showHomePage() {
        return "Home";
    }

    @GetMapping("/aboutUs")
    public String showAboutUsPage() {
        return "AboutUs";
    }

    @GetMapping("/treks")
    public String showTreksPage() {
        return "Treks";
    }

    @GetMapping("/services")
    public String showServicesPage() {
        return "services";
    }

    @GetMapping("/heritage")
    public String showHeritagePage() {
        return "heritage";
    }

    @GetMapping("/food")
    public String showFoodPage() {
        return "food";
    }

    @GetMapping("/hiking")
    public String showHikingPage() {
        return "Hiking";
    }

    @GetMapping("/study")
    public String showStudyPage() {
        return "study";
    }

    @GetMapping("/camping")
    public String showCampingPage() {
        return "camping";
    }

    @GetMapping("/stargazing")
    public String showStargazingPage() {
        return "Stargazing";
    }

    @GetMapping("/corporate")
    public String showCorporatePage() {
        return "Corporate";
    }

}
