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

    public Trek(Date eventDate, String location, String image, String eventDescription, Long eventId, Long id) {
        this.eventDate = eventDate;
        this.location = location;
        this.image = image;
        this.eventDescription = eventDescription;
        this.eventId = eventId;
        this.id = id;
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


