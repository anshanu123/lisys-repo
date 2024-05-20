package com.rishabdebnath.lisys.controller;

import com.rishabdebnath.lisys.model.Event;
import com.rishabdebnath.lisys.repository.EventRepository;
import com.rishabdebnath.lisys.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"login"})
public class EventController {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventService eventService;

    @PostMapping("/saveDetails")
    public String saveEvent(@Valid @ModelAttribute(name = "eventObj") Event event,
                            BindingResult br,
                            @RequestParam("imageFile") MultipartFile imageFile,
                            RedirectAttributes redirectAttributes) throws ParseException, IOException {
        if (br.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", br.getFieldError().getDefaultMessage());
            return "redirect:/eventsForm";
        } else {
            eventService.saveDetails(event, imageFile);
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
                              @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        eventService.updateEvent(event, id, imageFile);
        return "redirect:/eventList";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
        return "redirect:/eventList";
    }
}
