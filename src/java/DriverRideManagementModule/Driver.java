/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverRideManagementModule;

import PassengerRideManagementModule.Location;
import PassengerRideManagementModule.Passenger;
import PassengerRideManagementModule.Request;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
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

    public ArrayList<SingleRide> viewSingleOfferedRides() {
        ArrayList<SingleRide> rides = new ArrayList<SingleRide>();
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("Select * from offered_rides where driver_id = ? AND ride_id NOT IN (select ride_id from offered_weekly_rides)");
            crs.setString(1, this.getEmailID());
            crs.execute();
            while (crs.next()) {

                SingleRide r = new SingleRide();
                r.setRideId(crs.getInt("ride_id"));
                r.setIsToUni((crs.getInt("is_to_uni") == 1) ? true : false);
                oracle.sql.TIMESTAMP ts = (oracle.sql.TIMESTAMP)crs.getObject("arrival_dep_time");
                String tsString = ts.timestampValue().toLocalDateTime().format(DateTimeFormatter.ofPattern("HH:mm"));
                r.setArrivalDepartureTime(tsString);
                r.setStartingLocation(new Location(crs.getString("start_location")));
                r.setEndingLocation(new Location(crs.getString("end_location")));
                r.setSeatAvailability(crs.getInt("current_seat_avail"));
                try
                {
                    CachedRowSet crs2 = CarpoolDatabase.DbRepo.getConfiguredConnection();
                        crs2.setCommand("Select * from offered_single_rides where ride_id = " + crs.getInt("ride_id"));
                        crs2.execute();
                        while (crs2.next()) {
                        r.setDate(LocalDate.parse(crs2.getDate("ride_date").toString()));
                        }
                        } catch (SQLException ex) {
                        Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                rides.add(r);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rides;
    }

    public ArrayList<WeeklyRide> viewWeeklyOfferedRides() {
        ArrayList<WeeklyRide> rides = new ArrayList<WeeklyRide>();
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("Select * from offered_rides where driver_id = ? AND ride_id NOT IN (select ride_id from offered_single_rides)");
            crs.setString(1, this.getEmailID());
            crs.execute();
            while (crs.next()) {

                WeeklyRide r = new WeeklyRide();
                r.setRideId(crs.getInt("ride_id"));
                r.setIsToUni((crs.getInt("is_to_uni") == 1) ? true : false);
                oracle.sql.TIMESTAMP ts = (oracle.sql.TIMESTAMP)crs.getObject("arrival_dep_time");
                String tsString = ts.timestampValue().toLocalDateTime().format(DateTimeFormatter.ofPattern("HH:mm"));
                r.setArrivalDepartureTime(tsString);
                r.setStartingLocation(new Location(crs.getString("start_location")));
                r.setEndingLocation(new Location(crs.getString("end_location")));
                r.setSeatAvailability(crs.getInt("current_seat_avail"));
                try
                {
                    CachedRowSet crs2 = CarpoolDatabase.DbRepo.getConfiguredConnection();
                        crs2.setCommand("Select * from offered_weekly_rides where ride_id = " + crs.getInt("ride_id"));
                        crs2.execute();
                        while (crs2.next()) {
                        r.setDay(crs2.getString("day"));
                        }
                        } catch (SQLException ex) {
                        Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
                        }
                rides.add(r);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rides;
    }

     public ArrayList<Request> viewPassengerRequests(String Ride_ID) {
        ArrayList<Request> Requests = new ArrayList<Request>();
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("Select * from ride_requests where ride_id = " + Ride_ID);
            crs.execute();
            while (crs.next()) {
                Request r = new Request();
                r.setRequested_ride_id(crs.getString("ride_id"));
                r.setPassengerid(crs.getString("passenger_id"));
                r.setPickupLocation(new Location(crs.getString("pickup_location")));
                r.setDropoffLocation(new Location(crs.getString("dropoff_location")));

                CachedRowSet crs2 = CarpoolDatabase.DbRepo.getConfiguredConnection();
                crs2.setCommand("Select * from ride_requests where passenger_id = '" + crs.getString("passenger_id") + "' AND ride_id = "+ Ride_ID +" AND passenger_id in(select passenger_id from confirmed_rides where Ride_ID = " +Ride_ID+ ")");
                crs2.execute();
  
                if (crs2.next() == false)
                {
                    r.setConfirmationbutton("Confirm/Remove");
             
                }  else
                {
                    r.setConfirmationbutton("Remove");
                }
                
                
                Requests.add(r);
                       
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Requests;
    }       
        
    public ArrayList<Passenger> viewPassengerInfo(String Passenger_ID) {
        ArrayList<Passenger> Passengers = new ArrayList<Passenger>();
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("Select * from users where email_id = '" + Passenger_ID +"'");
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
    
  public void CancelRide(String Ride_ID) {
   
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("Select * from offered_single_rides where ride_id =" + Ride_ID);
            crs.execute();
            if (crs.next() == false) {       
                CachedRowSet crs2 = CarpoolDatabase.DbRepo.getConfiguredConnection();
                crs2.setCommand("Delete offered_weekly_rides where ride_id =" + Ride_ID);
                crs2.execute();
                crs2.setCommand("Delete confirmed_rides where ride_id =" + Ride_ID);
                crs2.execute();
                crs2.setCommand("Delete ride_requests where ride_id =" + Ride_ID);
                crs2.execute();
                crs2.setCommand("Delete offered_rides where ride_id =" + Ride_ID);
                crs2.execute();

            }else
                {
                    
                CachedRowSet crs2 = CarpoolDatabase.DbRepo.getConfiguredConnection();
                crs2.setCommand("Delete offered_single_rides where ride_id =" + Ride_ID);
                crs2.execute();
                crs2.setCommand("Delete confirmed_rides where ride_id =" + Ride_ID);
                crs2.execute();
                crs2.setCommand("Delete ride_requests where ride_id =" + Ride_ID);
                crs2.execute();
                crs2.setCommand("Delete offered_rides where ride_id =" + Ride_ID);
                crs2.execute();
                
                }
                
             
            }
         catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  
 
  
    public String ConfirmPassengerRequest(String Ride_ID, String Passenger_ID) {
   
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("select * from offered_rides where ride_id = " + Ride_ID);
            crs.execute();
            while (crs.next()) {

            if(crs.getInt("current_seat_avail") == 0)
            {
                return "No Seats";

            }
            else
            {
                CachedRowSet crs2 = CarpoolDatabase.DbRepo.getConfiguredConnection();
                crs2.setCommand("insert into confirmed_rides values( " + Ride_ID + ",'" + Passenger_ID + "')");
                crs2.execute();
                crs2.setCommand("Update offered_rides set current_seat_avail = current_seat_avail - 1 where ride_id = " + Ride_ID);
                crs2.execute();
                return "Confirmed";
            }

        }
            
        }
         catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
    public void RemovePassenger(String Ride_ID, String Passenger_ID) {
   
        
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("Select * from confirmed_rides where ride_id =" + Ride_ID + "AND passenger_id = '" + Passenger_ID + "'");
            crs.execute();
            if (crs.next() == false) { 
                CachedRowSet crs2 = CarpoolDatabase.DbRepo.getConfiguredConnection();
                crs2.setCommand("Delete ride_requests where ride_id =" + Ride_ID + " AND passenger_id = '" + Passenger_ID + "'");
                crs2.execute();
            }
            else
            {
                CachedRowSet crs2 = CarpoolDatabase.DbRepo.getConfiguredConnection();
                crs2.setCommand("Delete confirmed_rides where ride_id = "+ Ride_ID+" AND passenger_id = '"+Passenger_ID +"'");
                crs2.execute();
                crs2.setCommand("Delete ride_requests where ride_id = "+ Ride_ID+" AND passenger_id = '"+Passenger_ID +"'");
                crs2.execute();
                crs2.setCommand("Update offered_rides set current_seat_avail = current_seat_avail + 1 where ride_id =" + Ride_ID);
                crs2.execute();

                
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
  
  
  


    private String getRideId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean updateDriverProfile(String email, String carModel, Integer capacity, Part eid, Part license, Part carReg) {
        try {

            InputStream eidIS = eid.getInputStream();
            InputStream licenseIS = license.getInputStream();
            InputStream carIS = carReg.getInputStream();

            if (eidIS != null && licenseIS != null && carIS != null) {

                CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
                //THE AUS DB DOES NOT ALLOW US TO INSERT BLOB for IMAGES
//                crs.setCommand("INSERT INTO DRIVER_APPLICATIONS (EMAIL_ID, LICENSE_IMAGE, CAR_REGIS_IMAGE, CAR_MODEL, EMIRATES_ID_IMAGE, CAR_CAPACITY) VALUES (?,?,?,?,?,?)");
//                crs.setString(1, email);
//                System.out.println("Set EMAIL");
//                crs.setBlob(2, licenseIS);
//                System.out.println("Set Liecense blob");
//                crs.setBlob(3, carIS);
//                crs.setString(4, carModel);
//                crs.setBlob(5, eidIS);
//                crs.setInt(6, capacity);
//                System.out.println("Set All PPTs");

                crs.setCommand("INSERT INTO DRIVER_APPLICATIONS (EMAIL_ID,CAR_MODEL,CAR_CAPACITY) VALUES (?,?,?)");
                crs.setString(1, email);
                crs.setString(2, carModel);
                crs.setInt(3, capacity);
                crs.execute();

            } else {
                return false;
            }
        } catch (IOException ex) {
            System.out.println(" SOMETHING IN DRIVER ER:" + ex);
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            System.out.println(" SOMETHING IN DRIVER SQL ER:" + ex);
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
