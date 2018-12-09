/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.yes_Model;

import java.io.Serializable;

/**
 *
 * @author owner
 */
public class Refree implements Serializable {
    
    private String applicationNumber;
    private String userId;
    private String refName;
    private String refAddress;
    private String refPhoneNumber;
    private String refRelationship;
  

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public String getRefAddress() {
        return refAddress;
    }

    public void setRefAddress(String refAddress) {
        this.refAddress = refAddress;
    }

    public String getRefPhoneNumber() {
        return refPhoneNumber;
    }

    public void setRefPhoneNumber(String refPhoneNumber) {
        this.refPhoneNumber = refPhoneNumber;
    }

    public String getRefRelationship() {
        return refRelationship;
    }

    public void setRefRelationship(String refRelationship) {
        this.refRelationship = refRelationship;
    }

 
 
   public String insertRefreeQuery(){
        String sql2 = "INSERT INTO refree "
                + "( applicationNumber, "
                + "refName, refAddress, "
                + "refPhoneNumber, "
                + "refRelationship) "
                + "VALUES ";
       return sql2+ "(  " + "\'" 
               + getApplicationNumber()+ "\'," + "\'" 
               + getRefName() + "\'," + "\'" 
               + getRefAddress() + "\'," + "\'" 
               + getRefPhoneNumber() + "\'," + "\'" 
               + getRefRelationship() + "\' );";

   } 
   public String updateQuery(){
    return " UPDATE refree SET applicationNumber = "+getApplicationNumber()+","
                 + " refName = \'" +getRefName() + "\', "
                 + " refAddress = \'" +getRefAddress() + "\', "
                 + " refPhoneNumber = \'" +getRefPhoneNumber() + "\', "
                 + " nokRelationship = \'" +getRefRelationship() + "\',"
                 + " where applicationNumber = \'"+getApplicationNumber()+ "\';";
    }
}
    

   