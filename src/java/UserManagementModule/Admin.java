/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagementModule;

import DriverRideManagementModule.Car;
import DriverRideManagementModule.Driver;
import DriverRideManagementModule.SingleRide;
import PassengerRideManagementModule.Location;
import PassengerRideManagementModule.Passenger;
import UserManagementModule.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Tasli
 */
public class Admin extends User {

    public static boolean isAdmin(String emailID) throws SQLException {
        CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
        crs.setCommand("Select * from ADMINS WHERE ADM_EMAIL_ID = ? ");
        crs.setString(1, emailID);
        crs.execute();
        String usernameDB = "";
        //If there is a record
        if (crs.next()) {
            return true;
        } else {
            return false;
        }
    }
    //retrieveDriverRequests (then to display to user)
    //select driver call passenger class
        public ArrayList<Driver> retriveDriverRequests() throws SQLException{

        ArrayList<Driver> names = new ArrayList<>();
        CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
        try {
            //crs.setCommand("select first_name from b00075270.users where exists (select email_id from b00075270.driver_applications where b00075270.driver_applications.email_id = b00075270.users.email_id)");
            crs.setCommand("select * from users  Inner JOIN driver_applications  ON users.email_id = ?");
            crs.setString(1, this.getEmailID());
            
            crs.execute();
            while (crs.next()) {
                Driver currDriver = new Driver();
                currDriver.setEmailID(crs.getString("email_id"));
                currDriver.setFirstName(crs.getString("first_name"));
                currDriver.setMobileNumber(crs.getString("mobile_no"));
                Car c = new Car(crs.getString("car_model"),crs.getInt("car_capacity"));
                
                currDriver.setMyCar(c);
                

                names.add(currDriver);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
      
       // rs = statement.executeQuery("select * from b00075270.users  Inner JOIN b00075270.driver_applications  ON b00075270.users.email_id = b00075270.driver_applications.email_id;");
           
           return names;
    }
         
        
    }

