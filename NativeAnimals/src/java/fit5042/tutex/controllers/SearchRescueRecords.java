/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;

import fit5042.nativeAnimals.repository.entities.RescueRecords;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author csz
 */

@RequestScoped
@Named("searchRescueRecords")
public class SearchRescueRecords {
    
    private boolean showForm = true;

    private RescueRecords rescueRecords;

    RescueRecordsApplication app;

    private int searchByRescueId;
   
    private int searchByUserId;
    
    private String searchByDesc;
    
    private String searchByType;

    public RescueRecordsApplication getApp() {
        return app;
    }

    public void setApp(RescueRecordsApplication app) {
        this.app = app;
    }

    public int getSearchByRescueId() {
        return searchByRescueId;
    }

    public void setSearchByRescueId(int searchByRescueId) {
        this.searchByRescueId = searchByRescueId;
    }

    public int getSearchByUserId() {
        return searchByUserId;
    }

    public void setSearchByUserId(int searchByUserId) {
        this.searchByUserId = searchByUserId;
    }
    
    public String getSearchByDesc() {
        return searchByDesc;
    }

    public void setSearchByDesc(String searchByDesc) {
        this.searchByDesc = searchByDesc;
    }
    
    public String getSearchByType() {
        return searchByType;
    }

    public void setSearchByType(String searchByType) {
        this.searchByType = searchByType;
    }
    

    public void setRescueRecords(RescueRecords rescueRecords) {
        this.rescueRecords = rescueRecords;
    }

    public RescueRecords getRescueRecords() {
        return rescueRecords;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public SearchRescueRecords() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (RescueRecordsApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "rescueRecordsApplication");

        app.updateRescueRecordsList();
    }

    /**
     * @param rescue Id
     */
    public void searchRescueRecordsByRescueId(int rescueId) {
        try {
            //search this RescueRecord then refresh the list in RescueRecordsApplication bean
            app.searchRescueRecordsByRescueId(rescueId);
        } catch (Exception ex) {

        }
        showForm = true;

    }

    public void searchRescueRecordsByUserId(int userId) {
        try {
            //search all properties by contact person from db via EJB 
            app.searchRescueRecordsByUserId(userId);
        } catch (Exception ex) {

        }
        showForm = true;
    }
    
    public void searchRescueRecordsByTypeAndDesc(String animalType, String description) {
        try {
            //search all properties by contact person from db via EJB 
            app.searchRescueRecordsByTypeAndDesc(animalType,description);
        } catch (Exception ex) {

        }
        showForm = true;
    }

    public void searchAll() {
        try {
            //return all properties from db via EJB
            app.searchAll();
        } catch (Exception ex) {

        }
        showForm = true;
    }
     
}
