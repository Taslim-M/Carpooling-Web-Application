/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarpoolDatabase;

/**
 *
 * @author azada
 */
public class DbCredentialsSingleton {

    public static String getDbUrl() {
        return dbUrl;
    }

    public static void setDbUrl(String dbUrl) {
        DbCredentialsSingleton.dbUrl = dbUrl;
    }

    public static String getDbUsername() {
        return dbUsername;
    }

    public static void setDbUsername(String dbUsername) {
        DbCredentialsSingleton.dbUsername = dbUsername;
    }

    public static String getDbPassword() {
        return dbPassword;
    }

    public static void setDbPassword(String dbPassword) {
        DbCredentialsSingleton.dbPassword = dbPassword;
    }

    public DbCredentialsSingleton() {
        
    }
    
    private static String dbUrl = null;
    private static String dbUsername = null;
    private static String dbPassword = null;
    
}
