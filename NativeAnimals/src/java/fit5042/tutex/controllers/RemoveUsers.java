/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;

import fit5042.nativeAnimals.repository.entities.Users;
import fit5042.tutex.mbeans.UsersManagedBean;
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
@Named("removeUsers")
public class RemoveUsers {
    
    @ManagedProperty(value = "#{usersManagedBean}")
    UsersManagedBean usersManagedBean;

    private boolean showForm = true;

    //private final ArrayList<fit5042.nativeAnimals.repository.entities.Users> users;
    private Users users;

    UsersApplication app;
    
    public void setUsers(Users users) {
       this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public RemoveUsers() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (UsersApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "usersApplication");

        app.updateUsersList();

        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        usersManagedBean = (UsersManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "usersManagedBean");
    }

    /**
     * @param userId Id
     */
    public void removeUsers(int userId) {
        try {
            //remove this user from db via EJB
            usersManagedBean.removeUsers(userId);

            //refresh the list in UsersApplication bean
             app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User has been deleted succesfully"));
        } catch (Exception ex) {

        }
        showForm = true;

    }
    
}
