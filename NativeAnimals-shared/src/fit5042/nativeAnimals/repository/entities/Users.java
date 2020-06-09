/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.nativeAnimals.repository.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author csz
 */

@Entity
@NamedQueries({
    @NamedQuery(name = Users.GET_ALL_QUERY_NAME, query = "SELECT u FROM Users u order by u.userId desc")})

public class Users implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "Users.getAll";
    
    private int userId;
    private String userType;
    private String userName;
    private Address userAddress;
    private String userPhone;
    public Users(){
    
    
    }
    
    public Users(int userId,String userType,String userName,Address userAddress,String userPhone){
        this.userId = userId;
        this.userType = userType;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
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
    
    @Embedded
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
    
//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE})
    
    
    @Override
    public String toString() {
        return "Users{" + "userId=" + userId + ", userType=" + userType + ", userName=" + userName + ", userAddress=" + userAddress + ", userPhone=" + userPhone + '}'; 
    }
    
    
}
