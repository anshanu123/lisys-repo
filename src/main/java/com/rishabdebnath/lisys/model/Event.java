package com.rishabdebnath.lisys.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    @Column(length = 200, nullable = false)
    private String eventName;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    @Column(length = 200, nullable = false, columnDefinition = "TEXT")
    private String eventDescription;

    @NotEmpty
    @NotBlank
    @Column(nullable = false, length = 200)
    private String imageName;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private String eventDate;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    @Column(length = 200, nullable = false)
    private String location;

    public Event() {
    }

    public Event(Long eventId, String eventName, String eventDescription, String imageName, String eventDate, String location) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.imageName = imageName;
        this.eventDate = eventDate;
        this.location = location;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
