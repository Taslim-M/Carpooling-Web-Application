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
public abstract class Request {
    private Location pickupLocation;
    private Location dropoffLocation;
    private Ride ride;
    private boolean isConfirmed;
}
