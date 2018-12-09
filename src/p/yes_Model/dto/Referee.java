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
public class Referee {
    private String address;
private String fullName;
private String phoneNumber;
private String relationship;

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getFullName() {
return fullName;
}

public void setFullName(String fullName) {
this.fullName = fullName;
}

public String getPhoneNumber() {
return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

public String getRelationship() {
return relationship;
}

public void setRelationship(String relationship) {
this.relationship = relationship;
}
}
