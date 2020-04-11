/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverRideManagementModule;

/**
 *
 * @author Tasli
 */
public class Car {
    public Car(){
        
    }
    public Car(String carModel, Integer carCapacity) {
        this.carModel = carModel;
        this.carCapacity = carCapacity;
    }
    private String carModel;
    private Integer carCapacity;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(Integer carCapacity) {
        this.carCapacity = carCapacity;
    }

    @Override
    public String toString() {
        return "Car{" + "carModel=" + carModel + ", carCapacity=" + carCapacity + '}';
    }
}
