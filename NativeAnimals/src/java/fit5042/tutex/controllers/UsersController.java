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

@Named(value = "usersController")
@RequestScoped
public class UsersController {
    private int userId;
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    private fit5042.nativeAnimals.repository.entities.Users users;
    
        public UsersController() {
        // Assign userId identifier via GET param 
        //this userId is the index, don't confuse with the Rescue Id
        userId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("userId"));
        // Assign Users based on the id provided 
        users = getUsers();
    }

    public fit5042.nativeAnimals.repository.entities.Users getUsers() {
        if (users == null) {
            // Get application context bean UsersApplication 
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            UsersApplication app
                    = (UsersApplication) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "usersApplication");
            // -1 to userId since we +1 in JSF (to always have positive userId id!) 
            return app.getUsers().get(--userId); //this userId is the index, don't confuse with the userId
        }
        return users;
    }
    
    
    
    
}
