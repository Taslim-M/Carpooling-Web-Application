/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PassengerRideManagementModule;

import Controller.ViewPassengerConfirmedRidesController;
import DriverRideManagementModule.Driver;
import DriverRideManagementModule.Ride;
import DriverRideManagementModule.SingleRide;
import DriverRideManagementModule.WeeklyRide;
import UserManagementModule.User;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Tasli
 */
public class Passenger extends User {

    public Passenger(String firstName, String lastName, String gender, String mobileNumber, String emailID) {
        super(firstName, lastName, gender, mobileNumber, emailID);
    }
    
    public Passenger() {
      
    }


 

    public boolean isDriver() {
         try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("Select * from DRIVERS WHERE DRIVER_ID = ? ");
            crs.setString(1, this.getEmailID());
            crs.execute();
            if (crs.next()) {
                return true;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    public static Passenger getPassenger(String emailID) {
        Passenger p = new Passenger();
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("Select * from USERS WHERE EMAIL_ID = ? ");
            crs.setString(1, emailID);
            crs.execute();
            if (crs.next()) {
                p.setEmailID(emailID);
                p.setFirstName(crs.getString("FIRST_NAME"));                
                p.setLastName(crs.getString("LAST_NAME"));
                p.setGender(crs.getString("GENDER"));
                p.setMobileNumber(crs.getString("MOBILE_NO"));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    public boolean checkDriverRegistrationDetails(String carModel,Integer capacity, Part eid, Part license, Part carReg){
        if(eid != null && license != null && carReg != null && carModel !=null && capacity != null){
            return true;
        }
        return false;
    }

    public static ArrayList<Ride> searchRides(boolean isSingle, String isToUni, LocalDate rideDate, ArrayList<String> rideDays, Location pickupLocation, Location dropoffLocation, String rideTime){
        ArrayList<Ride> foundRides = new ArrayList<>();
        CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
        ArrayList<Ride> ridesWithoutLocationFilter = new ArrayList<>();
        if (isSingle){
            try {
                crs.setCommand("select offr.driver_id as driver_id, offr.ride_id as ride_id, offr.is_to_uni as is_to_uni, offr.arrival_dep_time as arrival_dep_time, offr.start_location as start_location, offr.end_location as end_location, offr.current_seat_avail as current_seat_avail, offsr.ride_date as ride_date from offered_rides offr, offered_single_rides offsr where offr.ride_id = offsr.ride_id AND offr.is_to_uni = ? AND to_char(offr.arrival_dep_time,'hh24:mi') = ? AND CURRENT_SEAT_AVAIL > 0 AND to_char(offsr.ride_date,'yyyy-mon-dd') = ?");
                
                crs.setString(1, isToUni);
                crs.setString(2, rideTime);
                crs.setString(3, rideDate.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd")).toLowerCase());

                crs.execute();
                
                while (crs.next()){
                    Driver currDriver = new Driver();
                    currDriver.setEmailID(crs.getString("driver_id"));
                    
                    oracle.sql.TIMESTAMP ts = (oracle.sql.TIMESTAMP)crs.getObject("arrival_dep_time");
                    String tsString = ts.timestampValue().toLocalDateTime().format(DateTimeFormatter.ofPattern("HH:mm"));
                    
                    ridesWithoutLocationFilter.add(new SingleRide(crs.getDate("ride_date").toLocalDate(),
                            crs.getInt("ride_id"),isToUni.equals("1"),
                            tsString,
                            new Location(crs.getString("start_location")), 
                            new Location(crs.getString("end_location")),
                            crs.getInt("current_seat_avail"),currDriver));        
                }
            } catch (SQLException ex) {
                Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //If weekly ride
        else {
            try {
                String sqlCommand = "select offr.driver_id as driver_id, offr.ride_id as ride_id, offr.is_to_uni as is_to_uni, offr.arrival_dep_time as arrival_dep_time, offr.start_location as start_location, offr.end_location as end_location, offr.current_seat_avail as current_seat_avail, offwr.day as day from offered_rides offr, offered_weekly_rides offwr where offr.ride_id = offwr.ride_id AND offr.is_to_uni = ? AND to_char(offr.arrival_dep_time,'hh24:mi') = ? AND CURRENT_SEAT_AVAIL > 0";
                if (rideDays.size() > 0){
                    sqlCommand += " AND (";
                    for (int i = 0; i < rideDays.size(); ++i) {
                        //Add the current day to query
                        sqlCommand += ("lower(offwr.day) = lower('" + rideDays.get(i) + "')");
                        //If not the last day
                        if (i != rideDays.size() - 1){
                            sqlCommand += " OR ";
                        }
                    }      
                    sqlCommand += ")";
                }
                crs.setCommand(sqlCommand);
                crs.setString(1, isToUni);
                crs.setString(2, rideTime);
                
                crs.execute();
                
                while (crs.next()) {
                    Driver currDriver = new Driver();
                    currDriver.setEmailID(crs.getString("driver_id"));

                    oracle.sql.TIMESTAMP ts = (oracle.sql.TIMESTAMP) crs.getObject("arrival_dep_time");
                    String tsString = ts.timestampValue().toLocalDateTime().format(DateTimeFormatter.ofPattern("HH:mm"));

                    ridesWithoutLocationFilter.add(new WeeklyRide(crs.getString("day"),
                            crs.getInt("ride_id"), isToUni.equals("1"),
                            tsString,
                            new Location(crs.getString("start_location")),
                            new Location(crs.getString("end_location")),
                            crs.getInt("current_seat_avail"), currDriver));
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Filter based on location, within 1 degree
        for (Ride r : ridesWithoutLocationFilter){
            if ((Math.abs(r.getStartingLocation().getLongitude() - pickupLocation.getLongitude()) < 1)
                    && (Math.abs(r.getStartingLocation().getLatitude()- pickupLocation.getLatitude()) < 1)
                    && (Math.abs(r.getEndingLocation().getLongitude() - dropoffLocation.getLongitude()) < 1)
                    && (Math.abs(r.getEndingLocation().getLatitude()- dropoffLocation.getLatitude()) < 1)) {
                foundRides.add(r);
            }
        }
        System.out.println("Found Rides: ");
        for (Ride r : foundRides){
            System.out.println(r.getRideId());
        }
        return  foundRides;
    }
    
    public ArrayList<SingleRide> viewSingleConfirmedRides(){
        ArrayList<SingleRide> singleRides = new ArrayList<>();
        CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
        try {
            crs.setCommand("select offr.driver_id as driver_id, offr.ride_id as ride_id, offr.is_to_uni as is_to_uni, offr.arrival_dep_time as arrival_dep_time, offr.start_location as start_location, offr.end_location as end_location, offr.current_seat_avail as current_seat_avail, offsr.ride_date as ride_date from offered_rides offr, offered_single_rides offsr, confirmed_rides cr where cr.ride_id = offr.ride_id AND offr.ride_id = offsr.ride_id AND cr.passenger_id = ?");
            crs.setString(1, this.getEmailID());
            crs.execute();
            while (crs.next()) {
                Driver currDriver = new Driver();
                currDriver.setEmailID(crs.getString("driver_id"));

                oracle.sql.TIMESTAMP ts = (oracle.sql.TIMESTAMP) crs.getObject("arrival_dep_time");
                String tsString = ts.timestampValue().toLocalDateTime().format(DateTimeFormatter.ofPattern("HH:mm"));

                singleRides.add(new SingleRide(crs.getDate("ride_date").toLocalDate(),
                        crs.getInt("ride_id"), crs.getString("is_to_uni").equals("1"),
                        tsString,
                        new Location(crs.getString("start_location")),
                        new Location(crs.getString("end_location")),
                        crs.getInt("current_seat_avail"), currDriver));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return singleRides;
    }
    
    public ArrayList<WeeklyRide> viewWeeklyConfirmedRides(){
        ArrayList<WeeklyRide> weeklyRides = new ArrayList<>();
        CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
        try {
            crs.setCommand("select offr.driver_id as driver_id, offr.ride_id as ride_id, offr.is_to_uni as is_to_uni, offr.arrival_dep_time as arrival_dep_time, offr.start_location as start_location, offr.end_location as end_location, offr.current_seat_avail as current_seat_avail, offwr.day as day from offered_rides offr, offered_weekly_rides offwr, confirmed_rides cr where offr.ride_id = offwr.ride_id and cr.ride_id = offr.ride_id and cr.passenger_id = ?");
            crs.setString(1, this.getEmailID());
            crs.execute();
            
            while (crs.next()) {
                Driver currDriver = new Driver();
                currDriver.setEmailID(crs.getString("driver_id"));

                oracle.sql.TIMESTAMP ts = (oracle.sql.TIMESTAMP) crs.getObject("arrival_dep_time");
                String tsString = ts.timestampValue().toLocalDateTime().format(DateTimeFormatter.ofPattern("HH:mm"));

                weeklyRides.add(new WeeklyRide(crs.getString("day"),
                        crs.getInt("ride_id"), crs.getString("is_to_uni").equals("1"),
                        tsString,
                        new Location(crs.getString("start_location")),
                        new Location(crs.getString("end_location")),
                        crs.getInt("current_seat_avail"), currDriver));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return weeklyRides;
    }
    
}
