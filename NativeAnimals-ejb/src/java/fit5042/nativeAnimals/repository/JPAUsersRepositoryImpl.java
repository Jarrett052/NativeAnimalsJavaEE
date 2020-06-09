/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.nativeAnimals.repository;

import fit5042.nativeAnimals.repository.entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author csz
 */

@Stateless
public class JPAUsersRepositoryImpl implements UsersRepository {

    @PersistenceContext(unitName = "NativeAnimals-ejbPU")
    private EntityManager entityManager;
    
    @Override
    public void addUsers(Users users) throws Exception {
        List<Users> usersList = entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();
        if(usersList != null){
            users.setUserId(usersList.get(0).getUserId() + 1);
        }else{
            users.setUserId(3001);
        }
        entityManager.persist(users);    
    }

    @Override
    public Users searchUsersByUserId(int id) throws Exception {
        Users users = entityManager.find(Users.class, id);
        return users;    
    }

    @Override
    public List<Users> getAllUsers() throws Exception {
        return entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();    
    }

    @Override
    public void removeUsers(int userId) throws Exception {
        Users users = searchUsersByUserId(userId);
        entityManager.remove(users);    
    }

    @Override
    public void editUsers(Users users) throws Exception {
        try {
            entityManager.merge(users);
        } catch (Exception ex) {
            
        }

    }
    
}
