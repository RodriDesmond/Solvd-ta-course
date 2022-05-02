package com.rodrigocosta.models.airport;

import com.rodrigocosta.models.flights.Flight;
import com.rodrigocosta.models.people.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Airline extends AbstractEntity{


    private static final Logger LOGGER = LogManager.getLogger(Airline.class);

    private List<Flight> flights;
    private List<Staff> staff;
    private List<Airplane> airplanes;

    public Airline(List<Flight> flights, List<Staff> staff, List<Airplane> airplanes) {
        super();
        this.flights = flights;
        this.staff = staff;
        this.airplanes = airplanes;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }
}
