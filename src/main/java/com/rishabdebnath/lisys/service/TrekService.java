package com.rishabdebnath.lisys.service;

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
        return trekRepository.save(trek);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Trek getTrekByEventId(Long eventId) {
        Optional<Trek> trek = trekRepository.findByEventId(eventId);
        return trek.orElse(null);
    }
}
