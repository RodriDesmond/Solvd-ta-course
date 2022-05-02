package com.rodrigocosta.models.enums;

public enum FlightStatus {

    ACTIVE("Active Flight"),
    OPEN("Open Flight"),
    COMPLETE("Flight capacity completed"),
    HOLD("Flight on hold"),
    CLOSED("Finished flight"),
    CANCELLED("Flight cancelled");

    private final String description;
    private FlightStatus(String desc) {
        this.description = desc;
    }

    public String toString() {
        return description;
    }
}
