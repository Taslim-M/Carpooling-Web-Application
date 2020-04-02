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
    private String arrivalDepartureTime;
    private Location startingLocation;
    private Location endingLocation;
    private Integer seatAvailability;
    private Driver driver;

    public Integer getRideId() {
        return rideId;
    }

    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

    public boolean isIsToUni() {
        return isToUni;
    }

    public void setIsToUni(boolean isToUni) {
        this.isToUni = isToUni;
    }

    public String getArrivalDepartureTime() {
        return arrivalDepartureTime;
    }

    public void setArrivalDepartureTime(String arrivalDepartureTime) {
        this.arrivalDepartureTime = arrivalDepartureTime;
    }

    public Location getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(Location startingLocation) {
        this.startingLocation = startingLocation;
    }

    public Location getEndingLocation() {
        return endingLocation;
    }

    public void setEndingLocation(Location endingLocation) {
        this.endingLocation = endingLocation;
    }

    public Integer getSeatAvailability() {
        return seatAvailability;
    }

    public void setSeatAvailability(Integer seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}
