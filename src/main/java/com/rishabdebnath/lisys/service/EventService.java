package com.rishabdebnath.lisys.service;

import com.rishabdebnath.lisys.model.Event;
import com.rishabdebnath.lisys.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private EventRepository eventRepository;

    public void saveDetails(Event event, MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            String fileName = imageFile.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, imageFile.getBytes());
            event.setImageName(fileName);
        }
        eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    public void updateEvent(Event updevent, Long id, MultipartFile imageFile) throws IOException {
        Event event = eventRepository.findById(id).orElseThrow();
        event.setEventName(updevent.getEventName());
        event.setEventDescription(updevent.getEventDescription());
        if (!imageFile.isEmpty()) {
            String fileName = imageFile.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, imageFile.getBytes());
            event.setImageName(fileName);
        }
        event.setEventDate(updevent.getEventDate());
        event.setLocation(updevent.getLocation());
        eventRepository.save(event);
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}

//    public void saveDetails(Event event) {eventRepository.save(event);
//    }

//    public List<Event> getAllEvents() {return (List<Event>) eventRepository.findAll();
//    }
//
//    public void updateEvent(Event updevent, Long id) {
//        Event event1=eventRepository.findById(id).get();
//        event1.setEventName(updevent.getEventName());
//        event1.setEventDescription(updevent.getEventDescription());
//        event1.setImageName(updevent.getImageName());
//        event1.setEventDate(updevent.getEventDate());
//        event1.setLocation(updevent.getLocation());
//        eventRepository.save(event1);
//    }
//
//    public Optional<Event> findById(Long id) {
//        return eventRepository.findById(id);
//    }
//
//    public void deleteEvent(Long id) {
//        eventRepository.deleteById(id);
//    }


