/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;

import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



/**
 *
 * @author csz
 */

@Named(value = "stateNameBean")
@SessionScoped
public class StateNameBean implements Serializable {
    
    private ArrayList<String> stateNameList;
    private static final String BASE_URL = "http://localhost:26232/StateName/webresources/";
    private String testResult;
    
    public ArrayList<String> getStateNameList(){
        return this.stateNameList;
    }
     
    public void setStateNameList(ArrayList<String> stateNameList){
        this.stateNameList.equals(stateNameList);
    }
    
    public String getTestResult(){
        return this.testResult;
    }
    
    public void setTestResult(){
        this.testResult = findAllStateName();
    }
    
    
    public static String findAllStateName() {
        final String methodPath = "statename.statename/";
        //initialise
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        //Making HTTP request
        try {
            url = new URL(BASE_URL + methodPath);
            //open the connection
            conn = (HttpURLConnection) url.openConnection();
            // set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            // set the connection method to GET
            conn.setRequestMethod("GET");
            // add http headers to set your response type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
            // read the input steream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }
    
//    public ArrayList<String> testTheResult(){
//        String temResult = findAllStateName();
//        String[] storeText = temResult.split("\"},{\"");
//        int Listlength = storeText.length;
//        ArrayList<String> stateList = new ArrayList<String>();
//        String StateName;
//        
//        for(int i=0;i<Listlength;i++){
//          String[] StateNameFinal = storeText[i].split("statename\":\"");
//          StateName = StateNameFinal[1];
//          stateList.add(StateName);
//        }
//        return stateList;   
//    }
    
        public ArrayList<String> testTheResult(){
        String temResult = findAllStateName();
        int stringLength = temResult.length() - 3;
        String temResult1 = temResult.substring(2,stringLength);
        ArrayList<String> stateNameList = new ArrayList<String>();
        String[] storeText = temResult1.split("\"\\},\\{\"");
        int Listlength = storeText.length;
        String StateName;
        for(int i=0;i<Listlength;i++){
          String[] StateNameFinal = storeText[i].split("statename\":\"");
          StateName = StateNameFinal[1];
          stateNameList.add(StateName);
        }
        return stateNameList;   
    }

//    static class SetStateNameWebService {  
//    private WebTarget webTarget;
//    private Client client;  
//    private static final String BASE_URI = "http://localhost:45073/Week8Webservices/webresources";  
//    
//    public SetStateNameWebService() {  
//        client = javax.ws.rs.client.ClientBuilder.newClient();
//        webTarget = client.target(BASE_URI).path("greeting");
//    }
//    
//    public void setPostName() throws ClientErrorException {
//        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).post(null);
//    }    
//    
//    public void setPostName2(String name) throws ClientErrorException {  
//        //create a form and add to this form information of a user  
//       Form form = new Form();
//       form.param("name", name);
//       webTarget.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE));        
//    }
//
//
//    public String getXml() throws ClientErrorException {
//            WebTarget resource = webTarget;
//            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
//        }
//
//        public void putXml(Object requestEntity) throws ClientErrorException {
//            webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
//        }
//
//        public void close() {
//            client.close();
//        }
//    }    
//    
    
}
