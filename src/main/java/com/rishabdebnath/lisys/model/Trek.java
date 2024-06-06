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
    @Pattern(regexp = "^[a-zA-Z0-9 ,.:\\[\\]()\\-\\n/]+$")
    @Column(length = 1000, nullable = false, columnDefinition = "TEXT")
    private String eventDescription;

    @NotEmpty
    @NotBlank
//    @Pattern(regexp = "^[a-zA-Z0-9 ,.:\[\]()\\-\\n/]+$", message = "must match the required pattern")
    @Column(name = "itinerary_description", length = 1000, nullable = false, columnDefinition = "TEXT")
    private String itineraryDescription;

//    @Pattern(regexp = "^[a-zA-Z0-9 ,.:\\[\\]()\\-\\n/]+$")
    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryTwo;

//    @Pattern(regexp = "^[a-zA-Z0-9 ,.:\\[\\]()\\-\\n/]+$")
    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryThree;

//    @Pattern(regexp = "^[a-zA-Z0-9 ,.:\\[\\]()\\-\\n/]+$")
    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryFour;

//    @Pattern(regexp = "^[a-zA-Z0-9 ,.:\\[\\]()\\-\\n/]+$")
    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryFive;

//    @Pattern(regexp = "^[a-zA-Z0-9 ,.:\\[\\]()\\-\\n/]+$")
    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itinerarySix;

//    @Pattern(regexp = "^[a-zA-Z0-9 ,.:\\[\\]()\\-\\n/]+$")
    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itinerarySeven;

//    @Pattern(regexp = "^[a-zA-Z0-9 ,.:\\[\\]()\\-\\n/]+$")
    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryEight;
//
//    @Pattern(regexp = "^[a-zA-Z0-9 ,.:\\[\\]()\\-\\n/]+$")
    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryNine;

//    @Pattern(regexp = "^[a-zA-Z0-9 ,.:\\[\\]()\\-\\n/]+$")
    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryTen;

    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryEleven;

    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryTwelve;

    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryThirteen;

    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryFourteen;

    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryFifteen;

    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itinerarySixteen;

    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itinerarySeventeen;

    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryEighteen;

    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryNineteen;

    @Column(length = 500, nullable = true, columnDefinition = "TEXT")
    private String itineraryTwenty;

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

    public Trek(Long id, Long eventId, String eventDescription, String itineraryDescription, String itineraryTwo, String itineraryThree, String itineraryFour, String itineraryFive, String itinerarySix, String itinerarySeven, String itineraryEight, String itineraryNine, String itineraryTen, String itineraryEleven, String itineraryTwelve, String itineraryThirteen, String itineraryFourteen, String itineraryFifteen, String itinerarySixteen, String itinerarySeventeen, String itineraryEighteen, String itineraryNineteen, String itineraryTwenty, String image, Date eventDate, String location) {
        this.id = id;
        this.eventId = eventId;
        this.eventDescription = eventDescription;
        this.itineraryDescription = itineraryDescription;
        this.itineraryTwo = itineraryTwo;
        this.itineraryThree = itineraryThree;
        this.itineraryFour = itineraryFour;
        this.itineraryFive = itineraryFive;
        this.itinerarySix = itinerarySix;
        this.itinerarySeven = itinerarySeven;
        this.itineraryEight = itineraryEight;
        this.itineraryNine = itineraryNine;
        this.itineraryTen = itineraryTen;
        this.itineraryEleven = itineraryEleven;
        this.itineraryTwelve = itineraryTwelve;
        this.itineraryThirteen = itineraryThirteen;
        this.itineraryFourteen = itineraryFourteen;
        this.itineraryFifteen = itineraryFifteen;
        this.itinerarySixteen = itinerarySixteen;
        this.itinerarySeventeen = itinerarySeventeen;
        this.itineraryEighteen = itineraryEighteen;
        this.itineraryNineteen = itineraryNineteen;
        this.itineraryTwenty = itineraryTwenty;
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

    public String getItineraryTwo() {
        return itineraryTwo;
    }

    public void setItineraryTwo(String itineraryTwo) {
        this.itineraryTwo = itineraryTwo;
    }

    public String getItineraryThree() {
        return itineraryThree;
    }

    public void setItineraryThree(String itineraryThree) {
        this.itineraryThree = itineraryThree;
    }

    public String getItineraryFour() {
        return itineraryFour;
    }

    public void setItineraryFour(String itineraryFour) {
        this.itineraryFour = itineraryFour;
    }

    public String getItineraryFive() {
        return itineraryFive;
    }

    public void setItineraryFive(String itineraryFive) {
        this.itineraryFive = itineraryFive;
    }

    public String getItinerarySix() {
        return itinerarySix;
    }

    public void setItinerarySix(String itinerarySix) {
        this.itinerarySix = itinerarySix;
    }

    public String getItinerarySeven() {
        return itinerarySeven;
    }

    public void setItinerarySeven(String itinerarySeven) {
        this.itinerarySeven = itinerarySeven;
    }

    public String getItineraryEight() {
        return itineraryEight;
    }

    public void setItineraryEight(String itineraryEight) {
        this.itineraryEight = itineraryEight;
    }

    public String getItineraryNine() {
        return itineraryNine;
    }

    public void setItineraryNine(String itineraryNine) {
        this.itineraryNine = itineraryNine;
    }

    public String getItineraryTen() {
        return itineraryTen;
    }

    public void setItineraryTen(String itineraryTen) {
        this.itineraryTen = itineraryTen;
    }

    public String getItineraryEleven() {
        return itineraryEleven;
    }

    public void setItineraryEleven(String itineraryEleven) {
        this.itineraryEleven = itineraryEleven;
    }

    public String getItineraryTwelve() {
        return itineraryTwelve;
    }

    public void setItineraryTwelve(String itineraryTwelve) {
        this.itineraryTwelve = itineraryTwelve;
    }

    public String getItineraryThirteen() {
        return itineraryThirteen;
    }

    public void setItineraryThirteen(String itineraryThirteen) {
        this.itineraryThirteen = itineraryThirteen;
    }

    public String getItineraryFourteen() {
        return itineraryFourteen;
    }

    public void setItineraryFourteen(String itineraryFourteen) {
        this.itineraryFourteen = itineraryFourteen;
    }

    public String getItineraryFifteen() {
        return itineraryFifteen;
    }

    public void setItineraryFifteen(String itineraryFifteen) {
        this.itineraryFifteen = itineraryFifteen;
    }

    public String getItinerarySixteen() {
        return itinerarySixteen;
    }

    public void setItinerarySixteen(String itinerarySixteen) {
        this.itinerarySixteen = itinerarySixteen;
    }

    public String getItinerarySeventeen() {
        return itinerarySeventeen;
    }

    public void setItinerarySeventeen(String itinerarySeventeen) {
        this.itinerarySeventeen = itinerarySeventeen;
    }

    public String getItineraryEighteen() {
        return itineraryEighteen;
    }

    public void setItineraryEighteen(String itineraryEighteen) {
        this.itineraryEighteen = itineraryEighteen;
    }

    public String getItineraryNineteen() {
        return itineraryNineteen;
    }

    public void setItineraryNineteen(String itineraryNineteen) {
        this.itineraryNineteen = itineraryNineteen;
    }

    public String getItineraryTwenty() {
        return itineraryTwenty;
    }

    public void setItineraryTwenty(String itineraryTwenty) {
        this.itineraryTwenty = itineraryTwenty;
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


