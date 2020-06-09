/*
 * To change this license header, choose License Headers in Project RescueRecords.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.nativeAnimals.repository;

import fit5042.nativeAnimals.repository.entities.RescueRecords;
import fit5042.nativeAnimals.repository.entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author csz
 */

@Stateless
public class JPARescueRecordsRepositoryImpl implements RescueRecordsRepository {
    
    @PersistenceContext(unitName = "NativeAnimals-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addRescueRecords(RescueRecords rescueRecords) throws Exception {
        List<RescueRecords> rescueRecordsList = entityManager.createNamedQuery(RescueRecords.GET_ALL_QUERY_NAME).getResultList();
        if(rescueRecordsList != null){
            rescueRecords.setRescueId(rescueRecordsList.get(0).getRescueId() + 1);
        }else{
            rescueRecords.setRescueId(1001);
        }
        entityManager.persist(rescueRecords);
    }

    @Override
    public RescueRecords searchRescueRecordsByRescueId(int id) throws Exception {
//        RescueRecords rescueRecords = entityManager.createQuery("SELECT r from RescueRecords r WHERE r.rescueId = :rescueId", RescueRecords.class).
//        setParameter("rescueId", id).getSingleResult();
        RescueRecords rescueRecords = entityManager.find(RescueRecords.class, id);
        return rescueRecords;
    }
        

    @Override
    public List<RescueRecords> getAllRescueRecords() throws Exception {
        return entityManager.createNamedQuery(RescueRecords.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public List<Users> getAllUsers() throws Exception {
       return entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeRescueRecords(int rescueId) throws Exception {
        RescueRecords rescueRecords = searchRescueRecordsByRescueId(rescueId);
        entityManager.remove(rescueRecords);
    }

    @Override
    public void editRescueRecords(RescueRecords rescueRecords) throws Exception {
        try {
            entityManager.merge(rescueRecords);
        } catch (Exception ex) {
            
        }
        
    }
    
    @Override
    public List<RescueRecords> searchRescueRecordsByUserId(int userId) throws Exception {
        //complete this method using Criteria API
        CriteriaBuilder cbr = entityManager.getCriteriaBuilder();
        CriteriaQuery<RescueRecords> cq = cbr.createQuery(RescueRecords.class);
        Root<RescueRecords> root = cq.from(RescueRecords.class);
        Join<RescueRecords, Users> pj = root.join("rescuer");
        cq.where(cbr.equal(pj.get("userId"), userId));
        TypedQuery<RescueRecords> tq = entityManager.createQuery(cq);
        List<RescueRecords> result = tq.getResultList();
        return result;
    }
    
    @Override
    public List<RescueRecords> searchRescueRecordsByTypeAndDesc(String animalType, String description) throws Exception {
        //complete this method using Criteria API
        CriteriaBuilder cbr = entityManager.getCriteriaBuilder();
        CriteriaQuery<RescueRecords> cq = cbr.createQuery(RescueRecords.class);
        Root<RescueRecords> root = cq.from(RescueRecords.class);
//        cq.where((cbr.equal(root.get("animalType"), animalType)),(cbr.equal(root.get("description"), description)));
        Predicate animalTypeCondition = cbr.equal(root.get("animalType"), animalType);
        Predicate descriptionCondition = cbr.equal(root.get("description"), description);
        Predicate condition = cbr.and(animalTypeCondition,descriptionCondition);
//        cq.where(animalTypeCondition,descriptionCondition);
        cq.select(root).where(condition);
        TypedQuery<RescueRecords> tq = entityManager.createQuery(cq);
        List<RescueRecords> result = tq.getResultList();
        return result;
    }
    
}
