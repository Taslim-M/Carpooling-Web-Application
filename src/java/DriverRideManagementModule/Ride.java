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
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;


public abstract class Ride {

    public Ride(Integer rideId, boolean isToUni, String arrivalDepartureTime, Location startingLocation, Location endingLocation, Integer seatAvailability, Driver driver) {
        this.rideId = rideId;
        this.isToUni = isToUni;
        this.arrivalDepartureTime = arrivalDepartureTime;
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
        this.seatAvailability = seatAvailability;
        this.driver = driver;
    }
    
    public Ride(){
        
    }

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
    
    public static boolean createRequest(int rideId, String passengerId, String pickupLocation, String dropoffLocation){
        CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
        try {
            crs.setCommand("INSERT INTO RIDE_REQUESTS (RIDE_ID, PASSENGER_ID, PICKUP_LOCATION, DROPOFF_LOCATION) VALUES (?,?,?,?)");
            crs.setInt(1,rideId);
            crs.setString(2,passengerId);
            crs.setString(3,pickupLocation);
            crs.setString(4,dropoffLocation);
            crs.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Ride.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
