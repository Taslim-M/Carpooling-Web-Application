/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverRideManagementModule;

import PassengerRideManagementModule.Location;

/**
 *
 * @author Tasli
 */
public class WeeklyRide extends Ride{

    public WeeklyRide(String day, Integer rideId, boolean isToUni, String arrivalDepartureTime, Location startingLocation, Location endingLocation, Integer seatAvailability, Driver driver) {
        super(rideId, isToUni, arrivalDepartureTime, startingLocation, endingLocation, seatAvailability, driver);
        this.day = day;
    }
    public WeeklyRide(){
        
    }
    private String day;
}
