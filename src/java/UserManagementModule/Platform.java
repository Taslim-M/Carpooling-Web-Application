/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagementModule;

import PassengerRideManagementModule.Passenger;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Tasli
 */
public class Platform {

    private String universityName;

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public boolean submitRegistrationFormDetails(String email, String password, String fname, String lname, String gender, String mobileNo) {
        if (doesIDExist(email)) {
            return false;
        }

        Passenger p = new Passenger();
        p.setEmailID(email);
        p.setFirstName(fname);
        p.setLastName(lname);
        p.setMobileNumber(mobileNo);
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("INSERT INTO ACCOUNTS (USERNAME, PASSWORD) VALUES (?,?) ");
            crs.setString(1, email);
            crs.setString(2, password);
            crs.execute();
            
            crs.setCommand("INSERT INTO USERS (EMAIL_ID, FIRST_NAME, LAST_NAME, GENDER, MOBILE_NO) VALUES (?,?) ");
            crs.setString(1, email);
            crs.setString(2, fname);
            crs.setString(3, lname);
            crs.setString(4, gender);
            crs.setString(5, mobileNo);
            crs.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean doesIDExist(String emailID) {
        try {
            CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
            crs.setCommand("Select USERNAME from ACCOUNTS WHERE USERNAME = ? ");
            crs.setString(1, emailID);
            crs.execute();
            if (crs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
