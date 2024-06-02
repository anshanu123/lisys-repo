package com.rishabdebnath.lisys.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="trek")
public class Trek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long eventId;

    @NotEmpty
    @NotBlank
//    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
//    @Column(nullable = false, columnDefinition = "TEXT")
    private String eventDescription;

    @NotEmpty
    @NotBlank
    private String itineraryDescription;

    @Column(nullable = true)
    private String image;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date eventDate;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    @Column(length = 200, nullable = false)
    private String location;

    public Trek() {
    }

    public Trek(Long id, Long eventId, String eventDescription, String itineraryDescription, String image, Date eventDate, String location) {
        this.id = id;
        this.eventId = eventId;
        this.eventDescription = eventDescription;
        this.itineraryDescription = itineraryDescription;
        this.image = image;
        this.eventDate = eventDate;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getItineraryDescription() {
        return itineraryDescription;
    }

    public void setItineraryDescription(String itineraryDescription) {
        this.itineraryDescription = itineraryDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}


