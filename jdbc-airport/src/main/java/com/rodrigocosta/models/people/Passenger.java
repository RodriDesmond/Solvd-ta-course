package com.rodrigocosta.models.people;

import com.rodrigocosta.models.enums.AirlineClass;

import java.math.BigDecimal;

public class Passenger extends Person {

    private String seatNumber;
    private BigDecimal ticketPrice;
    private AirlineClass airlaneClass;

    public Passenger() {
    }

    public Passenger(String firstName, String lastName, String seatNumber, BigDecimal ticketPrice, AirlineClass airlaneClass) {
        super(firstName, lastName);
        this.seatNumber = seatNumber;
        this.ticketPrice = ticketPrice;
        this.airlaneClass = airlaneClass;
    }
}
