package fit5042.tutex.controllers;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import fit5042.nativeAnimals.repository.entities.Users;
import fit5042.tutex.mbeans.UsersManagedBean;
import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 * The class is a demonstration of how the application scope works. You can
 * change this scope.
 *
 * @author csz
 */

@Named(value = "usersApplication")
@ApplicationScoped

public class UsersApplication {

    //dependency injection of managed bean here so that we can use its methods
    @ManagedProperty(value = "#{usersManagedBean}")
    UsersManagedBean usersManagedBean;
    
//    private ArrayList<RescueRecords> rescueRecords;
    private static final ArrayList<Users> usersList = new ArrayList<>();

    private boolean showForm = true;

    public boolean isShowForm() {
        return showForm;
    }

    // Add some user data from db to app 
    public UsersApplication() throws Exception {
//        usersList = new ArrayList<>();
        
        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        usersManagedBean = (UsersManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "usersManagedBean");
        
        if (usersList != null && usersList.size() > 0)
        {
            
        } else {
            //get users from db 
            updateUsersList();
        }
    }
    
    public ArrayList<Users> getUsers() {
        return usersList;
    }

    private void setUsers(ArrayList<Users> newUsers) {
//        this.usersList = newUsers;
    }

    //when loading, the property list needs to be populated if rescueRecords not present 
    public void updateUsersList() {
        if (usersList != null && usersList.size() > 0)
        {
            
        }
        else
        {
            usersList.clear();

            for (fit5042.nativeAnimals.repository.entities.Users users : usersManagedBean.getAllUsers()) {
                usersList.add(users);
            }

            setUsers(usersList);
        }
    }

    public void searchUsersByUserId(int userId) {
        usersList.clear();
        
        usersList.add(usersManagedBean.searchUsersByUserId(userId));
    }

  
    
    public void searchAll()
    {
        usersList.clear();

        for (fit5042.nativeAnimals.repository.entities.Users users : usersManagedBean.getAllUsers()) {
            usersList.add(users);
        }

        setUsers(usersList);
    }
    
}
