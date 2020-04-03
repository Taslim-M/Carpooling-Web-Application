/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverRideManagementModule;

import PassengerRideManagementModule.Location;
import java.time.LocalDate;

/**
 *
 * @author Tasli
 */
public class SingleRide extends Ride{

    public SingleRide(LocalDate date, Integer rideId, boolean isToUni, String arrivalDepartureTime, Location startingLocation, Location endingLocation, Integer seatAvailability, Driver driver) {
        super(rideId, isToUni, arrivalDepartureTime, startingLocation, endingLocation, seatAvailability, driver);
        this.date = date;
    }
    
    public SingleRide(){
        
    }

    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
