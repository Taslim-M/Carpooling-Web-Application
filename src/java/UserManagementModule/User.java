/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagementModule;

/**
 *
 * @author azada
 */
public abstract class User {

    public User(String firstName, String lastName, String gender, String mobileNumber, String emailID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.emailID = emailID;
    }

    private String firstName;
    private String lastName;
    private String gender;
    private String mobileNumber;
    private String emailID;

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User() {
        
    }

}
