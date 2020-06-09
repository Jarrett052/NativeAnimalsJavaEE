/*
 * To change this license header, choose License Headers in Project RescueRecords.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.mbeans;

import fit5042.nativeAnimals.repository.RescueRecordsRepository;
import fit5042.nativeAnimals.repository.entities.Address;
import fit5042.nativeAnimals.repository.entities.RescueRecords;
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

@ManagedBean(name = "rescueRecordsManagedBean", eager = true)
@SessionScoped

public class RescueRecordsManagedBean implements Serializable {
    
    @EJB
    private RescueRecordsRepository rescueRecordsRepository;
    
    public RescueRecordsManagedBean() {
        
    }
    
    public List<RescueRecords> getAllRescueRecords() {
        try {
            List<RescueRecords> rescueRecordsList = rescueRecordsRepository.getAllRescueRecords();
            return rescueRecordsList;
        } catch (Exception ex) {
            Logger.getLogger(RescueRecordsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addRescueRecords(RescueRecords rescueRecords) 
    {
        try {
             rescueRecordsRepository.addRescueRecords(rescueRecords);
        } catch (Exception ex) {
            Logger.getLogger(RescueRecordsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     /**
     * Search a rescueRecord by Id
     */
    
    public RescueRecords searchRescueRecordsByRescueId(int id) {
        
        try {
            return rescueRecordsRepository.searchRescueRecordsByRescueId(id);
        } catch (Exception ex) {
            Logger.getLogger(RescueRecordsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public List<RescueRecords> searchRescueRecordsByUserId(int UserId) {
        try {
            //retrieve user by id
            for (Users users : rescueRecordsRepository.getAllUsers()) {
                if (users.getUserId()== UserId) {
                    return rescueRecordsRepository.searchRescueRecordsByUserId(UserId);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(RescueRecordsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
        public List<RescueRecords> searchRescueRecordsByTypeAndDesc(String animalType, String description) {
        try {
            //retrieve rescueRecords by animalType and description
            return rescueRecordsRepository.searchRescueRecordsByTypeAndDesc(animalType,description);
        } catch (Exception ex) {
            Logger.getLogger(RescueRecordsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    

    public void removeRescueRecords(int rescueId) {
        try {
            rescueRecordsRepository.removeRescueRecords(rescueId);
        } catch (Exception ex) {
            Logger.getLogger(RescueRecordsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editRescueRecords(RescueRecords rescueRecords) {
        try {
            String s = rescueRecords.getRescueAddress().getStreetNumber();
            Address address = rescueRecords.getRescueAddress();
            address.setStreetNumber(s);
            rescueRecords.setRescueAddress(address);

            rescueRecordsRepository.editRescueRecords(rescueRecords);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rescue Record has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(RescueRecordsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addRescueRecords(fit5042.tutex.controllers.RescueRecords localRescueRecords) {
        //convert this newRescueRecords which is the local rescueRecords to entity rescueRecords
        RescueRecords rescueRecords = convertRescueRecordsToEntity(localRescueRecords);

        try {
            rescueRecordsRepository.addRescueRecords(rescueRecords);
        } catch (Exception ex) {
            Logger.getLogger(RescueRecordsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private RescueRecords convertRescueRecordsToEntity(fit5042.tutex.controllers.RescueRecords localRescueRecords) {
        try
        {
            RescueRecords rescueRecords = new RescueRecords(); //entity
            String rescueStreetNumber = localRescueRecords.getRescueStreetNumber();
            String rescueStreetAddress = localRescueRecords.getRescueStreetAddress();
            String rescueSuburb = localRescueRecords.getRescueSuburb();
            String rescuePostcode = localRescueRecords.getRescuePostcode();
            String rescueState = localRescueRecords.getRescueState();
            Address rescueAddress = new Address(rescueStreetNumber, rescueStreetAddress, rescueSuburb, rescuePostcode, rescueState);
            rescueRecords.setRescueAddress(rescueAddress);
            rescueRecords.setRescueDate(localRescueRecords.getRescueDate());
            rescueRecords.setAnimalType(localRescueRecords.getAnimalType());
            rescueRecords.setAnimalId(localRescueRecords.getAnimalId());
            rescueRecords.setAnimalName(localRescueRecords.getAnimalName());
            int userId = localRescueRecords.getUserId();
            String userType = localRescueRecords.getUserType();
            String userName = localRescueRecords.getUserName();
            String userPhone = localRescueRecords.getUserPhone();
            String userStreetNumber = localRescueRecords.getUserStreetNumber();
            String userStreetAddress = localRescueRecords.getUserStreetAddress();
            String userSuburb = localRescueRecords.getUserSuburb();
            String userPostcode = localRescueRecords.getUserPostcode();
            String userState = localRescueRecords.getUserState();
            Address userAddress = new Address(userStreetNumber, userStreetAddress, userSuburb, userPostcode, userState);
            Users rescuer = new Users(userId,userType,userName,userAddress,userPhone); 
            rescueRecords.setRescuer(rescuer);
            rescueRecords.setDescription(localRescueRecords.getDescription());
            return rescueRecords;
        }
        catch (Exception ex)
        {
            
        }
        return null;
    }

}
