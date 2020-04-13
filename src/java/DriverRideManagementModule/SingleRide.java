/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverRideManagementModule;

import PassengerRideManagementModule.Location;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

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

    @Override
    public boolean updateRideInfo() {
        boolean parentSucceeded = super.updateRideInfo();
        if (!parentSucceeded) return false;
        try {
            CachedRowSet crs1 = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs1.setCommand("select max(ride_id) as target_ride from offered_rides where driver_id = ?");
            crs1.setString(1, getDriver().getEmailID());
            crs1.execute();
            crs1.next();

            CachedRowSet crs2 = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs2.setCommand("INSERT INTO OFFERED_SINGLE_RIDES (ride_id, ride_date) VALUES (?,?)");
            crs2.setString(1,crs1.getString("target_ride"));
            crs2.setDate(2, java.sql.Date.valueOf( getDate() ));
            crs2.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Ride.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    

}
