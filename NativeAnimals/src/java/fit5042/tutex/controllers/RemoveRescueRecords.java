/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;

import fit5042.nativeAnimals.repository.entities.RescueRecords;
import fit5042.tutex.mbeans.RescueRecordsManagedBean;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author csz
 */

@RequestScoped
@Named("removeRescueRecords")
public class RemoveRescueRecords {
    
    @ManagedProperty(value = "#{rescueRecordsManagedBean}")
    RescueRecordsManagedBean rescueRecordsManagedBean;

    private boolean showForm = true;

    //private final ArrayList<fit5042.nativeAnimals.repository.entities.RescueRecords> rescueRecords;
    private RescueRecords rescueRecords;

    RescueRecordsApplication app;
    
    public void setRescueRecords(RescueRecords rescueRecords) {
       this.rescueRecords = rescueRecords;
    }

    public RescueRecords getRescueRecords() {
        return rescueRecords;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public RemoveRescueRecords() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (RescueRecordsApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "rescueRecordsApplication");

        app.updateRescueRecordsList();

        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        rescueRecordsManagedBean = (RescueRecordsManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "rescueRecordsManagedBean");
    }

    /**
     * @param rescueId Id
     */
    public void removeRescueRecords(int rescueId) {
        try {
            //remove this rescueRecords from db via EJB
            rescueRecordsManagedBean.removeRescueRecords(rescueId);

            //refresh the list in RescueRecordsApplication bean
             app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("RescueRecords has been deleted succesfully"));
        } catch (Exception ex) {

        }
        showForm = true;

    }
    
    
}
