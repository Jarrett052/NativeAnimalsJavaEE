/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;

import fit5042.nativeAnimals.repository.entities.Users;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author csz
 */

@RequestScoped
@Named("searchUsers")
public class SearchUsers {
    
    private boolean showForm = true;

    private Users users;

    UsersApplication app;
   
    private int searchByUserId;

    public UsersApplication getApp() {
        return app;
    }

    public void setApp(UsersApplication app) {
        this.app = app;
    }

    public int getSearchByUserId() {
        return searchByUserId;
    }

    public void setSearchByUserId(int searchByUserId) {
        this.searchByUserId = searchByUserId;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public SearchUsers() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (UsersApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "usersApplication");

        app.updateUsersList();
    }

    /**
     * @param user Id
     */


    public void searchUsersByUserId(int userId) {
        try {
            //search all properties by contact person from db via EJB 
            app.searchUsersByUserId(userId);
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
