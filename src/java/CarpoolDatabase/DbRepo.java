/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarpoolDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author azada
 */
public class DbRepo {
   

    public static CachedRowSet getConfiguredConnection() {
        CachedRowSet crs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl(DbCredentialsSingleton.getDbUrl());
            crs.setUsername(DbCredentialsSingleton.getDbUsername());
            crs.setPassword(DbCredentialsSingleton.getDbPassword());
        } catch (SQLException ex) {
            Logger.getLogger(DbRepo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return crs;
    }
}