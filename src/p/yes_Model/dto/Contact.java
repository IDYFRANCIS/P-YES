/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.yes_Model.dto;

/**
 *
 * @author Aniwange.TA
 */
public class Contact {
    
private String emailAddress;
private String localGovResidence;
private String phoneNumber;
private String residentialAddress;
private String stateOfResidence;

public String getEmailAddress() {
return emailAddress;
}

public void setEmailAddress(String emailAddress) {
this.emailAddress = emailAddress;
}

public String getLocalGovResidence() {
return localGovResidence;
}

public void setLocalGovResidence(String localGovResidence) {
this.localGovResidence = localGovResidence;
}

public String getPhoneNumber() {
return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

public String getResidentialAddress() {
return residentialAddress;
}

public void setResidentialAddress(String residentialAddress) {
this.residentialAddress = residentialAddress;
}

public String getStateOfResidence() {
return stateOfResidence;
}

public void setStateOfResidence(String stateOfResidence) {
this.stateOfResidence = stateOfResidence;
}
}
