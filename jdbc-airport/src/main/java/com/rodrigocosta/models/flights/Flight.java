package com.rodrigocosta.models.flights;

import com.rodrigocosta.models.airport.Airline;
import com.rodrigocosta.models.airport.Airplane;
import com.rodrigocosta.models.airport.Airport;
import com.rodrigocosta.models.enums.FlightStatus;
import com.rodrigocosta.models.people.Pilot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Flight implements IFly{

    private final static Logger LOGGER = LogManager.getLogger(Flight.class);

    private String flightNumber;
    private Airport departure;
    private Airport destination;
    private Airline airline;
    private Airplane plane;
    private Pilot pilot;
    private FlightStatus status;

    public Flight(String flightNumber, Airport departure, Airport destination, Airplane airplane, Pilot pilot, FlightStatus status) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.plane = airplane;
        this.pilot = pilot;
        this.status = status;
    }

    public Flight() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airplane getPlane() {
        return plane;
    }

    public void setPlane(Airplane plane) {
        this.plane = plane;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    @Override
    public void takeOFf(Airport departure) {
        LOGGER.info("Talking off from airport "+ departure.getName());
    }

    @Override
    public void land(Airport destination) {
        LOGGER.info("Landing at airport "+ destination.getName());
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departure=" + departure +
                ", destination=" + destination +
                ", airline=" + airline +
                ", plane=" + plane +
                ", pilot=" + pilot +
                ", status=" + status +
                '}';
    }
}
