/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverRideManagementModule;

/**
 *
 * @author Tasli
 */
import PassengerRideManagementModule.Location;
import java.time.LocalTime;

public abstract class Ride {

    private Integer rideId;
    private boolean isToUni;
    private LocalTime arrivalDepartureTime;
    private Location startingLocation;
    private Location endingLocation;
    private Integer seatAvailability;
    private Driver driver;
    
}
