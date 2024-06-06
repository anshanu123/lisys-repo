package com.rishabdebnath.lisys.service;

import com.rishabdebnath.lisys.controller.InvalidItineraryDescriptionException;
import com.rishabdebnath.lisys.model.Event;
import com.rishabdebnath.lisys.model.Trek;
import com.rishabdebnath.lisys.repository.EventRepository;
import com.rishabdebnath.lisys.repository.TrekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrekService {

    @Autowired
    private TrekRepository trekRepository;

    @Autowired
    private EventRepository eventRepository;

    public List<Trek> getAllTreks() {
        return trekRepository.findAll();
    }

    public Trek saveTrek(Trek trek) {
        validateTrek(trek);
        return trekRepository.save(trek);
    }


    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Trek getTrekByEventId(Long eventId) {
        Optional<Trek> trek = trekRepository.findByEventId(eventId);
        return trek.orElse(null);
    }

    public void updateTrek(Trek trek) {
        validateTrek(trek);
        trekRepository.save(trek);
    }

    public Trek getTrekById(Long id) {
        Optional<Trek> trek = trekRepository.findById(id);
        return trek.orElse(null);
    }

    public void deleteTrek(Long id) {
        trekRepository.deleteById(id);
    }

    private void validateTrek(Trek trek) {
        String description = trek.getItineraryDescription();
        System.out.println("Validating itineraryDescription: " + description);
        if (description == null || !description.matches("^[a-zA-Z0-9 ,.:\\[\\]()\\-\\n/]+$")) {
            throw new InvalidItineraryDescriptionException("Invalid characters in itineraryDescription. Allowed characters are: letters, numbers, spaces, and punctuation (,.:-[]()\\n/).");
        }
    }

}
