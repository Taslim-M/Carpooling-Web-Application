/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverRideManagementModule;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author azada
 */
public class RideTest {
    
    public RideTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testIsValid() {
        assertTrue(Ride.isValid("10:15"));
        assertTrue(Ride.isValid("21:15"));
        assertTrue(Ride.isValid("03:15"));
        assertFalse(Ride.isValid("abc"));
        assertFalse(Ride.isValid("23:15"));
        assertFalse(Ride.isValid("22:15"));
        assertFalse(Ride.isValid("02:15"));
    }
}
