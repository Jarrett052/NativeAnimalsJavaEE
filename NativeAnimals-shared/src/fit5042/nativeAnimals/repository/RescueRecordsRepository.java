/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.nativeAnimals.repository;

import fit5042.nativeAnimals.repository.entities.RescueRecords;
import fit5042.nativeAnimals.repository.entities.Users;
import java.util.List;
import javax.ejb.Remote;


/**
 *
 * @author csz
 */

@Remote
public interface RescueRecordsRepository {
    
     /**
     * Add the rescueRecord being passed as parameter into the repository
     *
     * @param rescueRecords - the rescueRecord to add
     */
    
    public void addRescueRecords(RescueRecords rescueRecords) throws Exception;

    /**
     * Search for a RescueRecord by its rescueRecord ID
     *
     * @param id - the rescueId of the rescueRecords to search for
     * @return the rescueRecords found
     */
    public RescueRecords searchRescueRecordsByRescueId(int id) throws Exception;
    
        /**
     * Search for a RescueRecord by  User ID
     *
     * @param userId - the rescueId of the rescueRecords to search for
     * @return the rescueRecords found
     */
    public List<RescueRecords> searchRescueRecordsByUserId(int userId) throws Exception;
    
    /**
     * Search for a RescueRecord by  animal type and description
     *
     * @param animalType 
     * @param description 
     * - the animalType and description of the rescueRecords to search for
     * @return the rescueRecords found
     */
    public List<RescueRecords> searchRescueRecordsByTypeAndDesc(String animalType, String description) throws Exception;
    
    
    
    /**
     * Return all the RescueRecords in the repository
     *
     * @return all the RescueRecords in the repository
     */
    public List<RescueRecords> getAllRescueRecords() throws Exception;

    /**
     * Return all the rescuers in the repository
     *
     * @return all the rescuers in the repository
     */
    public List<Users> getAllUsers() throws Exception;

    /**
     * Remove the rescueRecords, whose rescueRecords ID matches the one being passed as
     * parameter, from the repository
     *
     * @param rescueId - the ID of the rescueRecords to remove
     */
    public void removeRescueRecords(int rescueId) throws Exception;

    /**
     * Update a rescueRecords in the repository
     *
     * @param rescueRecords - the updated information regarding a rescueRecords
     */
    public void editRescueRecords(RescueRecords rescueRecords) throws Exception;


}
