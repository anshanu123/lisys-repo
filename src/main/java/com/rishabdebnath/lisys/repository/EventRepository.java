package com.rishabdebnath.lisys.repository;

import com.rishabdebnath.lisys.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    Event save(Event event);
}
