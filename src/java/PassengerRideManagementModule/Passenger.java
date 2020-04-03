/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PassengerRideManagementModule;

import DriverRideManagementModule.Ride;
import UserManagementModule.User;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Tasli
 */
public class Passenger extends User {
    
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
    
    //INCOMPLETE
    public ArrayList<Ride> searchRides(boolean isSingle, String isToUni, LocalDate rideDate, ArrayList<String> rideDays, Location rideLocation, String rideTime){
        ArrayList<Ride> foundRides = new ArrayList<>();
        CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
        Location lowerBoundLoc = new Location(rideLocation.getLongitude() - 1, rideLocation.getLatitude() - 1);
        Location upperBoundLoc = new Location(rideLocation.getLongitude() + 1, rideLocation.getLatitude() + 1);
        
        if (isSingle){
        }
        return  foundRides;
    }
}
