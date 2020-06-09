/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author csz
 */

@RequestScoped
@Named("logoutController")
public class LogoutController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    //private static final long serialVersionUID = 5443351151396868724L;


   public String logout() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    session.invalidate();
    return "/login.xhtml?faces-redirect=true";
    }
      
}

