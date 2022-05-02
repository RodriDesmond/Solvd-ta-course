package com.rodrigocosta.models.flights;

import com.rodrigocosta.exceptions.FlightCapacityException;
import com.rodrigocosta.models.airport.Airplane;
import com.rodrigocosta.models.airport.Airport;
import com.rodrigocosta.models.enums.FlightStatus;
import com.rodrigocosta.models.people.Attendant;
import com.rodrigocosta.models.people.Passenger;
import com.rodrigocosta.models.people.Pilot;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PassengerFlight extends Flight {

    private static final Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(PassengerFlight.class);

    private List<Passenger> passengers;
    private List<Attendant> attendants;


    public PassengerFlight() {
    }

    public PassengerFlight(String flightNumber, Airport departure, Airport destination, Airplane airplane, Pilot pilot,
                           List<Passenger> passengers, List<Attendant> flightAtt, FlightStatus status) {
        super(flightNumber, departure, destination, airplane, pilot, status);
        this.passengers = passengers;
        this.attendants = flightAtt;
    }

    public PassengerFlight(String flightNumber, Airport departure, Airport destination, Airplane airplane, Pilot pilot, FlightStatus status) {
        super(flightNumber, departure, destination, airplane, pilot, status);
        this.passengers = new ArrayList<Passenger>();
        this.attendants = new ArrayList<Attendant>();
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void leavePassengers(List<Passenger> passengers) {
        passengers
                .forEach(passenger -> LOGGER.info("Passenger " + passenger.getPassport() + " got off the plane"));
        this.passengers.removeAll(passengers);
    }

    public void setPassengers(List<Passenger> passengers) throws FlightCapacityException{
        passengers
                .forEach(passenger -> {if (this.getPlane().getCapacity() == this.passengers.size())
                    try {
                        throw new FlightCapacityException("Cannot add passenger. The flight is full.");
                    } catch (FlightCapacityException e) {
                        LOGGER.error(e);
                    }
                else {
                    this.passengers.add(passenger);
                    LOGGER.info("Passenger " + passenger.getPassport() + " got on the plane");
                };
                });
    }

    public void addPassenger(Passenger p) {
        if (this.getPlane().getCapacity() > this.passengers.size()) {
            this.passengers.add(p);
            LOGGER.info("Passenger " + p.getPassport() + " got on the plane");
        }
        else
            try {
                throw new FlightCapacityException("Cannot add passenger. The flight is full.");
            } catch (FlightCapacityException e) {
                LOGGER.error(e);
            }
    }

    public List<Attendant> getAttendants() {
        return attendants;
    }

    public void setAttendants(List<Attendant> attendants) {
        this.attendants = attendants;
    }

    @Override
    public void fly() {
        LOGGER.info("Flight " + this.getFlightNumber() + " is flying");
    }
}
