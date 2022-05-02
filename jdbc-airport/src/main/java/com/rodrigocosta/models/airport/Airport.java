package com.rodrigocosta.models.airport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Airport extends AbstractEntity{

    private final static Logger LOGGER = LogManager.getLogger(Airport.class);


    private String country;
    private String city;
    private List<Airline> airline;
}
