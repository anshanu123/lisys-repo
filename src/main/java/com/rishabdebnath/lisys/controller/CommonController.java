package com.rishabdebnath.lisys.controller;

import com.rishabdebnath.lisys.model.Event;
import com.rishabdebnath.lisys.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    private EventService eventService;

    @GetMapping("/home")
    public String showHomePage() {
        return "Home";
    }

    @GetMapping("/aboutUs")
    public String showAboutUsPage() {
        return "AboutUs";
    }

    @GetMapping("/treks")
    public String showTreksPage(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "Treks";
    }

//    @GetMapping("/treks")
//    public String showTreksPage() {
//        return "Treks";
//    }

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
