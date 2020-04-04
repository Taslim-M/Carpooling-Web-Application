/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PassengerRideManagementModule;

import DriverRideManagementModule.Ride;

/**
 *
 * @author Tasli
 */
public class Request {
    
    private String requested_ride_id;
    private String passengerid;
    private Location pickupLocation;
    private Location dropoffLocation;
    private String confirmationbutton;


    public void setRequested_ride_id(String requested_ride_id) {
        this.requested_ride_id = requested_ride_id;
    }
    
    public void setPassengerid(String passengerid)
    {
        this.passengerid = passengerid;
    }
    
    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDropoffLocation(Location dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }


    public void setConfirmationbutton(String confirmationbutton) {
        this.confirmationbutton = confirmationbutton;
    }




    public String getRequested_ride_id() {
        return requested_ride_id;
    }
    
    public String getPassengerid()
    {
        return passengerid;
    }
    
    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDropoffLocation() {
        return dropoffLocation;
    }


    public String getConfirmationbutton() {
        return confirmationbutton;
    }
    
}
