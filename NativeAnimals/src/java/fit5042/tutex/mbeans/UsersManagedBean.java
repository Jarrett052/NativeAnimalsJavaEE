/*
 * To change this license header, choose License Headers in Project RescueRecords.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.mbeans;

import fit5042.nativeAnimals.repository.UsersRepository;
import fit5042.nativeAnimals.repository.entities.Address;
import fit5042.nativeAnimals.repository.entities.Users;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author csz
 */

@ManagedBean(name = "usersManagedBean", eager = true)
@SessionScoped

public class UsersManagedBean implements Serializable {
    
    @EJB
    private UsersRepository usersRepository;
    
    public UsersManagedBean() {
        
    }
    
    public List<Users> getAllUsers() {
        try {
            List<Users> usersList = usersRepository.getAllUsers();
            return usersList;
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addUsers(Users users) 
    {
        try {
             usersRepository.addUsers(users);
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     /**
     * Search a user by Id
     */
    
    public Users searchUsersByUserId(int id) {
        
        try {
            return usersRepository.searchUsersByUserId(id);
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
    public void removeUsers(int userId) {
        try {
            usersRepository.removeUsers(userId);
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editUsers(Users users) {
        try {
            String s = users.getUserAddress().getStreetNumber();
            Address address = users.getUserAddress();
            address.setStreetNumber(s);
            users.setUserAddress(address);

            usersRepository.editUsers(users);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addUsers(fit5042.tutex.controllers.Users localUsers) {
        //convert this newUsers which is the local users to entity users
        Users users = convertUsersToEntity(localUsers);

        try {
            usersRepository.addUsers(users);
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Users convertUsersToEntity(fit5042.tutex.controllers.Users localUsers) {
        try
        {
            Users users = new Users(); //entity
            int userId = localUsers.getUserId();
            String userType = localUsers.getUserType();
            String userName = localUsers.getUserName();
            String userPhone = localUsers.getUserPhone();
            String userStreetNumber = localUsers.getUserStreetNumber();
            String userStreetAddress = localUsers.getUserStreetAddress();
            String userSuburb = localUsers.getUserSuburb();
            String userPostcode = localUsers.getUserPostcode();
            String userState = localUsers.getUserState();
            Address userAddress = new Address(userStreetNumber, userStreetAddress, userSuburb, userPostcode, userState);
            users.setUserId(userId);
            users.setUserType(userType);
            users.setUserName(userName);
            users.setUserAddress(userAddress);
            users.setUserPhone(userPhone);
            return users;
        }
        catch (Exception ex)
        {
            
        }
        return null;
    }

}
