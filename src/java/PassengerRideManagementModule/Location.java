/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PassengerRideManagementModule;

/**
 *
 * @author Tasli
 */
public class Location {

    private float longitude;
    private float latitude;

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }
    public Location(){
        
    }
    public Location(String location){
        String[] longlat = location.split(",");
        this.longitude = Float.parseFloat(longlat[0]);
        this.latitude = Float.parseFloat(longlat[1]);
    }

    @Override
    public String toString() {
        return "Location{" + "longitude=" + longitude + ", latitude=" + latitude + '}';
    }
    
}
