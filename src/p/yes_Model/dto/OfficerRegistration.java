/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.yes_Model.dto;

import java.util.List;

/**
 *
 * @author Aniwange.TA
 */
public class OfficerRegistration {
private String applicationNumber;
private Biodata biodata;
private CharacterAssessment characterAssessment;
private Contact contact;
private Entrepreneurship entrepreneurship;
private List<File> files = null;
private History history;
private NextOfKin nextOfKin;
private String officerID;
private List<Referee> referees = null;
private SecondLevelBeneficiary secondLevelBeneficiary;
private String userId;

public OfficerRegistration(){
    
}
public String getApplicationNumber() {
return applicationNumber;
}

public void setApplicationNumber(String applicationNumber) {
this.applicationNumber = applicationNumber;
}

public Biodata getBiodata() {
return biodata;
}

public void setBiodata(Biodata biodata) {
this.biodata = biodata;
}

public CharacterAssessment getCharacterAssessment() {
return characterAssessment;
}

public void setCharacterAssessment(CharacterAssessment characterAssessment) {
this.characterAssessment = characterAssessment;
}

public Contact getContact() {
return contact;
}

public void setContact(Contact contact) {
this.contact = contact;
}

public Entrepreneurship getEntrepreneurship() {
return entrepreneurship;
}

public void setEntrepreneurship(Entrepreneurship entrepreneurship) {
this.entrepreneurship = entrepreneurship;
}

public List<File> getFiles() {
return files;
}

public void setFiles(List<File> files) {
this.files = files;
}

public History getHistory() {
return history;
}

public void setHistory(History history) {
this.history = history;
}

public NextOfKin getNextOfKin() {
return nextOfKin;
}

public void setNextOfKin(NextOfKin nextOfKin) {
this.nextOfKin = nextOfKin;
}

public String getOfficerID() {
return officerID;
}

public void setOfficerID(String officerID) {
this.officerID = officerID;
}

public List<Referee> getReferees() {
return referees;
}

public void setReferees(List<Referee> referees) {
this.referees = referees;
}

public SecondLevelBeneficiary getSecondLevelBeneficiary() {
return secondLevelBeneficiary;
}

public void setSecondLevelBeneficiary(SecondLevelBeneficiary secondLevelBeneficiary) {
this.secondLevelBeneficiary = secondLevelBeneficiary;
}

public String getUserId() {
return userId;
}

public void setUserId(String userId) {
this.userId = userId;
}

 @Override
   public String toString() {
   return  "{" + "applicationNumber=" + applicationNumber + ","
           + " biodata=" + biodata + ","
           + " characterAssessment=" + characterAssessment + ","
           + " contact=" + contact + ","
           + " entrepreneurship=" + entrepreneurship + ", "
           + "files=" + files + ","
           + " history=" + history + ","
           + " nextOfKin=" + nextOfKin + ","
           + " officerID=" + officerID + ","
           + " referees=" + referees + ","
           + " secondLevelBeneficiary=" + secondLevelBeneficiary + ", "
           + "userId=" + userId 
           + '}';
    }
    
}
