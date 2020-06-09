/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.nativeAnimals.repository.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/**
 *
 * @author csz
 */

@Entity
@NamedQueries({
    @NamedQuery(name = RescueRecords.GET_ALL_QUERY_NAME, query = "SELECT r FROM RescueRecords r order by r.rescueId desc")})

public class RescueRecords implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "RescueRecords.getAll";
    
    private int rescueId;
    private Date rescueDate;
    private String animalType;
    private int animalId;
    private String animalName;
    private Address rescueAddress;
    private Users rescuer;
    private String description;
    
    public RescueRecords(){
    
    
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
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "rescueId")
    public int getRescueId() {
        return rescueId;
    }

    public void setRescueId(int rescueId) {
        this.rescueId = rescueId;
    }
    
    @Temporal(TemporalType.DATE)
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
    @NotNull
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

    @Embedded
    public Address getRescueAddress() {
        return rescueAddress;
    }

    public void setRescueAddress(Address rescueAddress) {
        this.rescueAddress = rescueAddress;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "rescued_by", nullable = false)
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
