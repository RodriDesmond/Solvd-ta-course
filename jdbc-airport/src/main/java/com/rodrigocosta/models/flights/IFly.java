package com.rodrigocosta.models.flights;

import com.rodrigocosta.models.airport.Airport;

public interface IFly {

    void fly();
    void takeOFf(Airport departure);
    void land(Airport destination);
}

