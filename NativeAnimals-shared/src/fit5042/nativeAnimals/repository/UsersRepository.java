/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.nativeAnimals.repository;

import fit5042.nativeAnimals.repository.entities.Users;
import java.util.List;
import javax.ejb.Remote;


/**
 *
 * @author csz
 */

@Remote
public interface UsersRepository {
    
     /**
     * Add the users being passed as parameter into the repository
     *
     * @param users - the users to add
     */
    
    public void addUsers(Users users) throws Exception;

    /**
     * Search for a user by its user ID
     *
     * @param id - the userId of the users to search for
     * @return the user found
     */
    public Users searchUsersByUserId(int id) throws Exception;
    

    /**
     * Return all the Users in the repository
     *
     * @return all the Users in the repository
     */
    public List<Users> getAllUsers() throws Exception;

   
    /**
     * Remove the users, whose users ID matches the one being passed as
     * parameter, from the repository
     *
     * @param userId - the ID of the users to remove
     */
    public void removeUsers(int userId) throws Exception;

    /**
     * Update a user in the repository
     *
     * @param users - the updated information regarding a users
     */
    public void editUsers(Users users) throws Exception;

}
