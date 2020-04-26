/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagementModule;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tasli
 */
public class AccountTest {

    Platform platform;
    Account account;
    String testEmail;
    String testPassword;
    String testFname;
    String testLname;
    String testGender;
    String testMobile;
    String testFakePassword;
    public AccountTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        platform = new Platform();
        account = new Account();
        testEmail = "unitTest@aus.edu";
        testPassword = "abc";
        testFname = "Tester";
        testLname = "LastName";
        testGender = "M";
        testMobile = "0501234567";
        testFakePassword = "Fake";
        platform.submitRegistrationFormDetails(testEmail, testPassword, testFname, testLname, testGender, testMobile);
        account.setEmailID(testEmail);
        account.setPassword(testPassword);
    }

    @Test
    public void testlogin() throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        assertTrue(account.login());
        account.setPassword(testFakePassword);
        assertFalse(account.login());
    }

    @After
    public void tearDown() throws SQLException {
        
         //Clean Up Added Record
        CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
        crs.setCommand("Delete from ACCOUNTS where USERNAME = ?");
        crs.setString(1, testEmail);
        crs.execute();
        crs.setCommand("Delete from USERS where EMAIL_ID = ?");
        crs.setString(1, testEmail);
        crs.execute();

        platform = null;
        account = null;
        testEmail = null;
        testPassword = null;
        testFname = null;
        testLname = null;
        testGender = null;
        testMobile = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
