/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;



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
@Named("addUsers")
public class AddUsers {
    
    @ManagedProperty(value = "#{usersManagedBean}")
    UsersManagedBean usersManagedBean;

    private boolean showForm = true;

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

    public AddUsers() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (UsersApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "usersApplication");

        //instantiate usersManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        usersManagedBean = (UsersManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "usersManagedBean");
    }

    public void addUsers(Users localUsers) {
        //this is the local users, not the entity
        try {
            //add this users to db via EJB
            usersManagedBean.addUsers(localUsers);

            //refresh the list in usersApplication bean
            app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Users has been added succesfully"));
            //refresh the users list in usersApplication bean
        } catch (Exception ex) {

        }
        showForm = true;
    }
    
}
