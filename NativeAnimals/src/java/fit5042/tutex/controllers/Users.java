/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;

import fit5042.nativeAnimals.repository.entities.Address;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author csz
 */


@RequestScoped
@Named(value = "users")
public class Users implements Serializable {
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
    
    public Users(){
    
    }
    
    public Users(int userId,String userType,String userName,Address userAddress,String userPhone){
        this.userId = userId;
        this.userType = userType;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userPhone = userPhone;        
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
    
    @Override
    public String toString() {
        return "Users{" + "userId=" + userId + ", userType=" + userType + ", userName=" + userName + ", userAddress=" + userAddress + ", userPhone=" + userPhone + '}'; 
    }
        
    
}
