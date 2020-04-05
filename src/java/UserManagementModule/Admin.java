/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagementModule;

import UserManagementModule.User;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

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
}
