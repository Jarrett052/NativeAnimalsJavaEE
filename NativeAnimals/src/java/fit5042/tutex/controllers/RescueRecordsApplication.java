package fit5042.tutex.controllers;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import fit5042.tutex.mbeans.RescueRecordsManagedBean;
import javax.inject.Named;
import fit5042.nativeAnimals.repository.entities.RescueRecords;
import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 * The class is a demonstration of how the application scope works. You can
 * change this scope.
 *
 * @author csz
 */

@Named(value = "rescueRecordsApplication")
@ApplicationScoped

public class RescueRecordsApplication {

    //dependency injection of managed bean here so that we can use its methods
    @ManagedProperty(value = "#{rescueRecordsManagedBean}")
    RescueRecordsManagedBean rescueRecordsManagedBean;
    
//    private ArrayList<RescueRecords> rescueRecords;
    private static final ArrayList<RescueRecords> rescueRecordsList = new ArrayList<>();

    private boolean showForm = true;

    public boolean isShowForm() {
        return showForm;
    }

    // Add some rescueRecords data from db to app 
    public RescueRecordsApplication() throws Exception {
//        rescueRecords = new ArrayList<>();
        
        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        rescueRecordsManagedBean = (RescueRecordsManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "rescueRecordsManagedBean");
        
        if (rescueRecordsList != null && rescueRecordsList.size() > 0)
        {
            
        } else {
            //get rescueRecords from db 
            updateRescueRecordsList();
        }
    }
    
    public ArrayList<RescueRecords> getRescueRecords() {
        return rescueRecordsList;
    }

    private void setRescueRecords(ArrayList<RescueRecords> newRescueRecords) {
//        this.rescueRecords = newRescueRecords;
    }

    //when loading, the property list needs to be populated if rescueRecords not present 
    public void updateRescueRecordsList() {
        if (rescueRecordsList != null && rescueRecordsList.size() > 0)
        {
            
        }
        else
        {
            rescueRecordsList.clear();

            for (fit5042.nativeAnimals.repository.entities.RescueRecords rescueRecord : rescueRecordsManagedBean.getAllRescueRecords()) {
                rescueRecordsList.add(rescueRecord);
            }

            setRescueRecords(rescueRecordsList);
        }
    }

    public void searchRescueRecordsByRescueId(int rescueId) {
        rescueRecordsList.clear();
        
        rescueRecordsList.add(rescueRecordsManagedBean.searchRescueRecordsByRescueId(rescueId));
    }

    public void searchRescueRecordsByUserId(int userId) {
        rescueRecordsList.clear();

        for (fit5042.nativeAnimals.repository.entities.RescueRecords rescueRecord : rescueRecordsManagedBean.searchRescueRecordsByUserId(userId)) {
            rescueRecordsList.add(rescueRecord);
        }

        setRescueRecords(rescueRecordsList);
    }

    public void searchRescueRecordsByTypeAndDesc(String animalType, String description) {
        rescueRecordsList.clear();

        for (fit5042.nativeAnimals.repository.entities.RescueRecords rescueRecord : rescueRecordsManagedBean.searchRescueRecordsByTypeAndDesc(animalType,description)) {
            rescueRecordsList.add(rescueRecord);
        }

        setRescueRecords(rescueRecordsList);
    }        

    
    public void searchAll()
    {
        rescueRecordsList.clear();

        for (fit5042.nativeAnimals.repository.entities.RescueRecords rescueRecord : rescueRecordsManagedBean.getAllRescueRecords()) {
            rescueRecordsList.add(rescueRecord);
        }

        setRescueRecords(rescueRecordsList);
    }
    
}
