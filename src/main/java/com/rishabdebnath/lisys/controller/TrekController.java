package com.rishabdebnath.lisys.controller;

import com.rishabdebnath.lisys.model.Event;
import com.rishabdebnath.lisys.model.Trek;
import com.rishabdebnath.lisys.service.EventService;
import com.rishabdebnath.lisys.service.TrekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class TrekController {
    @Autowired
    private TrekService trekService;

    @GetMapping("/trekForm")
    public String showForm(Model model) {
        List<Event> events = trekService.getAllEvents();
        model.addAttribute("trek", new Trek());
        model.addAttribute("events", events);
        return "treks/trekForm";
    }

    @PostMapping("/save")
    public String saveTrek(@ModelAttribute Trek trek, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Save the file locally
                byte[] bytes = file.getBytes();
                Path path = Paths.get("uploads/" + file.getOriginalFilename());
                Files.write(path, bytes);
                trek.setImage(file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        trekService.saveTrek(trek);
        return "redirect:/trekList";
    }


    @GetMapping("/trek/{eventId}")
    public String getTrekDetails(@PathVariable Long eventId, Model model) {
        Trek trek = trekService.getTrekByEventId(eventId);
        model.addAttribute("trek", trek);
        return "treks/trekDetails";
    }

    @GetMapping("/trekList")
    public String listTreks(Model model) {
        List<Trek> treks = trekService.getAllTreks();
        model.addAttribute("treks", treks);
        return "treks/trekList";
    }

    @GetMapping("/editTrek/{id}")
    public String editTrek(@PathVariable Long id, Model model) {
        Trek trek = trekService.getTrekById(id);
        List<Event> events = trekService.getAllEvents();
        model.addAttribute("trek", trek);
        model.addAttribute("events", events);
        return "treks/editTrek";
    }

    @PostMapping("/updateTrek")
    public String updateTrek(@ModelAttribute Trek trek, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Save the file locally
                byte[] bytes = file.getBytes();
                Path path = Paths.get("uploads/" + file.getOriginalFilename());
                Files.write(path, bytes);
                trek.setImage(file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        trekService.updateTrek(trek);
        return "redirect:/trekList";
    }

    @GetMapping("/deleteTrek/{id}")
    public String deleteTrek(@PathVariable Long id) {
        trekService.deleteTrek(id);
        return "redirect:/trekList";
    }

}
