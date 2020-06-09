/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;



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
@Named("addRescueRecords")
public class AddRescueRecords {
    
    @ManagedProperty(value = "#{rescueRecordsManagedBean}")
    RescueRecordsManagedBean rescueRecordsManagedBean;

    private boolean showForm = true;

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

    public AddRescueRecords() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (RescueRecordsApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "rescueRecordsApplication");

        //instantiate rescueRecordsManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        rescueRecordsManagedBean = (RescueRecordsManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "rescueRecordsManagedBean");
    }

    public void addRescueRecords(RescueRecords localRescueRecords) {
        //this is the local rescueRecords, not the entity
        try {
            //add this rescueRecords to db via EJB
            rescueRecordsManagedBean.addRescueRecords(localRescueRecords);

            //refresh the list in rescueRecordsApplication bean
            app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("RescueRecords has been added succesfully"));
            //refresh the rescueRecords list in rescueRecordsApplication bean
        } catch (Exception ex) {

        }
        showForm = true;
    }
    
}
