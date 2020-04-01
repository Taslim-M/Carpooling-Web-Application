/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagementModule;

import CarpoolDatabase.DbRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tasli
 */
public class Account {

    private String emailID = null;
    private String password = null;
    private DbRepo dbCon = null;

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(String un, String pw) {
        this.emailID = un;
        this.password = pw;
        this.dbCon = new DbRepo();
    }

    public Account() {
        this.dbCon = new DbRepo();
    }

    public boolean login() throws SQLException {
        ResultSet rs = dbCon.executeSelectionQuery("Select * from ACCOUNTS WHERE USERNAME = '" + this.emailID + "'");
        String usernameDB = "";
        String pwdDB = "";
        if (rs != null) {
            while (rs.next()) {
                usernameDB = rs.getString("USERNAME");
                pwdDB = rs.getString("PASSWORD");
                if (this.emailID.equals(usernameDB) && this.password.equals(pwdDB)) {
                    return true;
                }
            }
        }
        return false;
    }
}
