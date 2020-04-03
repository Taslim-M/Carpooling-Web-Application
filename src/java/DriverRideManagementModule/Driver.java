/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverRideManagementModule;

import PassengerRideManagementModule.Location;
import PassengerRideManagementModule.Passenger;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Tasli
 */
public class Driver extends Passenger {

    private Image registrationImg;
    private Image licenseImg;
    private Image EIDImg;
    private Car myCar;

    public Image getRegistrationImg() {
        return registrationImg;
    }

    public void setRegistrationImg(Image registrationImg) {
        this.registrationImg = registrationImg;
    }

    public Image getLicenseImg() {
        return licenseImg;
    }

    public void setLicenseImg(Image licenseImg) {
        this.licenseImg = licenseImg;
    }

    public Image getEIDImg() {
        return EIDImg;
    }

    public void setEIDImg(Image EIDImg) {
        this.EIDImg = EIDImg;
    }

    public Car getMyCar() {
        return myCar;
    }

    public void setMyCar(Car myCar) {
        this.myCar = myCar;
    }

    public ArrayList<SingleRide> viewSingleConfirmedRides() {
        ArrayList<SingleRide> rides = new ArrayList<SingleRide>();
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("Select * from offered_rides where driver_id = ? AND ride_id in (select ride_id from confirmed_rides)");
            crs.setString(1, this.getEmailID());
            crs.execute();
            while (crs.next()) {
                SingleRide r = new SingleRide();
                r.setRideId(crs.getInt("ride_id"));
                r.setIsToUni((crs.getInt("is_to_uni")==1) ? true : false );
                r.setArrivalDepartureTime(crs.getString("arrival_dep_time"));
                r.setStartingLocation(new Location(crs.getString("start_location")));
                r.setEndingLocation(new Location(crs.getString("end_location")));
                r.setSeatAvailability(crs.getInt("current_seat_avail"));
                rides.add(r);
                       
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rides;
    }

    public ArrayList<Passenger> viewConfirmedPassengers() {
        ArrayList<Passenger> Passengers = new ArrayList<Passenger>();
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("Select * from users where email_id in (select passenger_id from confirmed_rides)");
            crs.execute();
            while (crs.next()) {
                Passenger p = new Passenger();
                p.setEmailID(crs.getString("email_id"));
                p.setFirstName(crs.getString("first_name"));
                p.setLastName(crs.getString("last_name"));
                p.setGender(crs.getString("Gender"));
                p.setMobileNumber(crs.getString("mobile_no"));
                
                Passengers.add(p);
                       
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Passengers;
    }

    private String getRideId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
