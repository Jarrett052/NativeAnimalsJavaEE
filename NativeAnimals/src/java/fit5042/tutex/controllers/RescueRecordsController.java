/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author csz
 */

@Named(value = "rescueRecordsController")
@RequestScoped
public class RescueRecordsController {
    private int rescueId;
    
    public int getRescueId() {
        return rescueId;
    }

    public void setRescueId(int rescueId) {
        this.rescueId = rescueId;
    }
    
    private fit5042.nativeAnimals.repository.entities.RescueRecords rescueRecords;
    
        public RescueRecordsController() {
        // Assign rescueId identifier via GET param 
        //this rescueId is the index, don't confuse with the Rescue Id
        rescueId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("rescueId"));
        // Assign RescueRecords based on the id provided 
        rescueRecords = getRescueRecords();
    }

    public fit5042.nativeAnimals.repository.entities.RescueRecords getRescueRecords() {
        if (rescueRecords == null) {
            // Get application context bean RescueRecordsApplication 
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            RescueRecordsApplication app
                    = (RescueRecordsApplication) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "rescueRecordsApplication");
            // -1 to rescueId since we +1 in JSF (to always have positive rescueId id!) 
            return app.getRescueRecords().get(--rescueId); //this rescueId is the index, don't confuse with the rescueId
        }
        return rescueRecords;
    }
    
    
    
    
}
