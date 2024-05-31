package com.rishabdebnath.lisys.repository;

import com.rishabdebnath.lisys.model.Trek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrekRepository extends JpaRepository<Trek, Long> {
    Optional<Trek> findByEventId(Long eventId);
}
