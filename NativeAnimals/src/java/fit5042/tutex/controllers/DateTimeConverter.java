/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author csz
 */

@FacesConverter("DateTimeConverter")
public class DateTimeConverter implements Converter{
    
    public Date formatDate; 
    
//    DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
//    String DateLength = "Fri Oct 11 00:00:00 AEDT 2019";
    
    DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
    String DateLength = "11 Oct 2019";
    
    @Override
    public Date getAsObject(FacesContext context, UIComponent component, String value) {
//        int change;
        if(value.length()!= DateLength.length()){
            FacesMessage msg = new FacesMessage("Date Conversion error, Correct Date format: 01 Oct 2019.", "Invalid Date format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }else{
           
            try {
                formatDate =  dateFormat.parse(value);
            } catch (ParseException ex) {
                Logger.getLogger(DateTimeConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return formatDate;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String formatedDate;
        formatedDate = dateFormat.format(value);
        return formatedDate;
//        return value.toString();	
    }	
   

}
