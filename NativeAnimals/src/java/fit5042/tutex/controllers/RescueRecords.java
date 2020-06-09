/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;

import fit5042.nativeAnimals.repository.entities.Address;
import fit5042.nativeAnimals.repository.entities.Users;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author csz
 */

@RequestScoped
@Named(value = "rescueRecords")
public class RescueRecords implements Serializable {
    private int rescueId;
    private Date rescueDate;
    private String animalType;
    private int animalId;
    private String animalName;
    private Address rescueAddress;
    private Users rescuer;
    private String description;
    
    
    private String rescueStreetNumber;
    private String rescueStreetAddress;
    private String rescueSuburb;
    private String rescuePostcode;
    private String rescueState;
    
    private int userId;
    private String userType;
    private String userName;
    private Address userAddress;
    private String userPhone;
    
    private String userStreetNumber;
    private String userStreetAddress;
    private String userSuburb;
    private String userPostcode;
    private String userState;
    
    public RescueRecords() {

    }
    
    public RescueRecords(int rescueId,Date rescueDate,String animalType,int animalId,String animalName,Address rescueAddress,Users rescuer,String description){
         this.rescueId = rescueId;
         this.rescueDate = rescueDate;
         this.animalType = animalType;
         this.animalId = animalId;
         this.animalName = animalName;
         this.rescueAddress = rescueAddress;
         this.rescuer = rescuer;
         this.description = description;
    }
    
    public int getRescueId() {
        return rescueId;
    }

    public void setRescueId(int rescueId) {
        this.rescueId = rescueId;
    }
    
    public Date getRescueDate() {
        return rescueDate;
    }

    public void setRescueDate(Date rescueDate) {
        this.rescueDate = rescueDate;
    }
    
    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    
    
    
    public Address getRescueAddress() {
        return rescueAddress;
    }

    public void setRescueAddress(Address rescueAddress) {
        this.rescueAddress = rescueAddress;
    }
    
    public String getRescueStreetNumber() {
        return rescueStreetNumber;
    }

    public void setRescueStreetNumber(String rescueStreetNumber) {
        this.rescueStreetNumber = rescueStreetNumber;
    }

    public String getRescueStreetAddress() {
        return rescueStreetAddress;
    }

    public void setRescueStreetAddress(String rescueStreetAddress) {
        this.rescueStreetAddress = rescueStreetAddress;
    }

    public String getRescueSuburb() {
        return rescueSuburb;
    }

    public void setRescueSuburb(String rescueSuburb) {
        this.rescueSuburb = rescueSuburb;
    }

    public String getRescuePostcode() {
        return rescuePostcode;
    }

    public void setRescuePostcode(String rescuePostcode) {
        this.rescuePostcode = rescuePostcode;
    }

    public String getRescueState() {
        return rescueState;
    }

    public void setRescueState(String rescueState) {
        this.rescueState = rescueState;
    }
    
     public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }
    
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    
    public String getUserStreetNumber() {
        return userStreetNumber;
    }

    public void setUserStreetNumber(String userStreetNumber) {
        this.userStreetNumber = userStreetNumber;
    }

    public String getUserStreetAddress() {
        return userStreetAddress;
    }

    public void setUserStreetAddress(String userStreetAddress) {
        this.userStreetAddress = userStreetAddress;
    }

    public String getUserSuburb() {
        return userSuburb;
    }

    public void setUserSuburb(String userSuburb) {
        this.userSuburb = userSuburb;
    }

    public String getUserPostcode() {
        return userPostcode;
    }

    public void setUserPostcode(String userPostcode) {
        this.userPostcode = userPostcode;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }
    
    public Users getRescuer() {
        return rescuer;
    }

    public void setRescuer(Users rescuer) {
        this.rescuer = rescuer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "RescueRecords{" + "rescueId=" + rescueId + ", rescueDate=" + rescueDate + ", animalType=" + animalType + ", animalId=" + animalId + ", animalName=" + animalName + ", rescueAddress=" + rescueAddress + ", rescuer=" + rescuer + ", description=" + description + '}'; 
    }
    
}
