package com.rishabdebnath.lisys.controller;

public class InvalidItineraryDescriptionException extends RuntimeException{
    public InvalidItineraryDescriptionException(String message) {
        super(message);
    }
}
