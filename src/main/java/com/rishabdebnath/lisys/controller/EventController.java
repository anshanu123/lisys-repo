package com.rishabdebnath.lisys.controller;
import javax.servlet.http.HttpServletResponse;
import com.rishabdebnath.lisys.model.Event;
import com.rishabdebnath.lisys.model.ProgramMaterial;
import com.rishabdebnath.lisys.service.EventService;
import com.rishabdebnath.lisys.service.ProgramMaterialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"login"})
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private ProgramMaterialService programMaterialService;

    @PostMapping("/saveDetails")
    public String saveEvent(@Valid @ModelAttribute(name = "eventObj") Event event,
                            BindingResult br,
                            @RequestParam("file") MultipartFile file,
                            RedirectAttributes redirectAttributes) throws ParseException, IOException {
        if (br.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", br.getFieldError().getDefaultMessage());
            return "redirect:/eventsForm";
        } else {
            eventService.saveDetails(event, file);
            return "redirect:/eventList";
        }
    }

    @GetMapping("/eventsForm")
    public String Events(Model model){
        model.addAttribute("eventObj", new Event());
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "events/eventsForm";
    }

    @GetMapping("/eventList")
    public String eventList(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "events/eventList";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model){
        Optional<Event> event = eventService.findById(id);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            return "events/edit_eventForm";
        } else {
            return "redirect:/eventList?error=EventNotFound";
        }
    }

    @PostMapping("/update")
    public String updateEvent(@RequestParam("id") Long id,
                              @ModelAttribute("event") Event event,
                              @RequestParam("file") MultipartFile file) throws IOException {
        eventService.updateEvent(event, id, file);
        return "redirect:/eventList";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
        return "redirect:/eventList";
    }
    @GetMapping("/uploadProgramMaterials")
    public String uploadProgramMaterialsForm(Model model) {
        model.addAttribute("uploadMaterialObj", new ProgramMaterial());
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("eventName", events);
        return "events/uploadProgramMaterials";
    }

    @PostMapping("/uploadProgramMaterials")
    public String uploadProgramMaterials(@Valid @ModelAttribute("uploadMaterialObj") ProgramMaterial programMaterial,
                                         BindingResult br,
                                         @RequestParam("material") MultipartFile file,
                                         RedirectAttributes redirectAttributes) throws IOException {
        if (br.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", br.getFieldError().getDefaultMessage());
            return "redirect:/uploadProgramMaterials";
        } else {
            programMaterialService.saveMaterial(programMaterial, file);
            return "redirect:/listProgramMaterials"; // Correct view name redirection
        }
    }

    @GetMapping("/listProgramMaterials")
    public String listProgramMaterials(Model model) {
        List<ProgramMaterial> materials = programMaterialService.getAllMaterials();
        model.addAttribute("materials", materials);
        return "events/listProgramMaterials";
    }

    @GetMapping("/deleteProgramMaterial/{id}")
    public String deleteProgramMaterial(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        programMaterialService.deleteMaterial(id);
        redirectAttributes.addFlashAttribute("message", "Material deleted successfully.");
        return "redirect:/listProgramMaterials";
    }

    @GetMapping("/viewProgramMaterial/{id}")
    public String viewProgramMaterial(@PathVariable("id") Long id, Model model) throws IOException {
        Optional<ProgramMaterial> materialOpt = programMaterialService.findById(id);
        if (materialOpt.isPresent()) {
            ProgramMaterial material = materialOpt.get();
            // Assuming you have a method to convert byte array to Base64 string
            String materialBase64 = Base64.getEncoder().encodeToString(material.getMaterialFile());
            model.addAttribute("materialBase64", materialBase64);
            return "events/viewProgramMaterial"; // Assuming you have a view for displaying PDF
        } else {
            // Handle not found scenario
            return "redirect:/listProgramMaterials";
        }
    }
    @GetMapping("/uploadProgramMaterials/{id}")
    public String uploadProgramMaterialsForm(@PathVariable("id") Long eventId, Model model) {
        model.addAttribute("uploadMaterialObj", new ProgramMaterial(eventId, null));
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("eventName", events);
        return "events/uploadProgramMaterials";
    }


}
