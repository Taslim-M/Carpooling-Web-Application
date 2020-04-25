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
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.and;
import javax.sql.rowset.CachedRowSet;

public abstract class Ride {

    @Override
    public String toString() {
        return "Ride{" + "rideId=" + rideId + ", isToUni=" + isToUni + ", arrivalDepartureTime=" + arrivalDepartureTime + ", startingLocation=" + startingLocation + ", endingLocation=" + endingLocation + ", seatAvailability=" + seatAvailability + ", driver=" + driver + '}';
    }

    public Ride(Integer rideId, boolean isToUni, String arrivalDepartureTime, Location startingLocation, Location endingLocation, Integer seatAvailability, Driver driver) {
        this.rideId = rideId;
        this.isToUni = isToUni;
        this.arrivalDepartureTime = arrivalDepartureTime;
        this.startingLocation = startingLocation;
        this.endingLocation = endingLocation;
        this.seatAvailability = seatAvailability;
        this.driver = driver;
    }

    public Ride() {

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

    public static boolean createRequest(int rideId, String passengerId, String pickupLocation, String dropoffLocation) {
        CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
        try {
            crs.setCommand("INSERT INTO RIDE_REQUESTS (RIDE_ID, PASSENGER_ID, PICKUP_LOCATION, DROPOFF_LOCATION) VALUES (?,?,?,?)");
            crs.setInt(1, rideId);
            crs.setString(2, passengerId);
            crs.setString(3, pickupLocation);
            crs.setString(4, dropoffLocation);
            crs.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Ride.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public boolean updateRideInfo(){
        try {
            CachedRowSet crs1 = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs1.setCommand("select * from driver_applications where email_id = ?");
            crs1.setString(1,driver.getEmailID());
            crs1.execute();
            crs1.next();

            CachedRowSet crs2 = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs2.setCommand("INSERT INTO OFFERED_RIDES (driver_id, is_to_uni, arrival_dep_time, start_location, end_location, current_seat_avail) VALUES (?,?,?,?,?,?)");
            crs2.setString(1,driver.getEmailID());
            crs2.setString(2,isToUni ? "1" : "0");
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime t = LocalTime.parse(arrivalDepartureTime, formatter);
            LocalDateTime date = LocalDateTime.of(LocalDate.now(), t);
            Timestamp ts = Timestamp.valueOf(date);
            crs2.setTimestamp(3, ts);
            
            crs2.setString(4, startingLocation.toDbString());
            crs2.setString(5, endingLocation.toDbString());
            crs2.setInt(6,crs1.getInt("car_capacity"));

            crs2.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Ride.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean isValid(String rideTime) {
        String[] time1 = rideTime.split(":");
        Integer hours;
        try{
            hours = Integer.parseInt(time1[0]);
        }
        catch (NumberFormatException e){
            return false;
        }
        if (hours >= 22 || hours < 3) {
            return false;
        }
        return true;
    }


    public static Driver retrieveDriverInfo(String driverId) {
        Driver retrievedDriver = null;
        CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
        try {
            crs.setCommand("select u.email_id as email_id, u.FIRST_NAME as first_name, u.LAST_NAME as last_name, u.GENDER as gender, u.mobile_no as mobile_no, dra.CAR_MODEL as car_model from drivers dr, driver_applications dra, users u where dr.DRIVER_ID = u.EMAIL_ID AND u.EMAIL_ID = dra.EMAIL_ID AND dr.driver_id = ?");
            crs.setString(1, driverId);
            crs.execute();
            if (crs.next()) {
                retrievedDriver = new Driver(null, null, null,
                        new Car(crs.getString("car_model"), 0),
                        crs.getString("first_name"), crs.getString("last_name"),
                        crs.getString("gender"), crs.getString("mobile_no"), driverId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ride.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrievedDriver;
    }

}
