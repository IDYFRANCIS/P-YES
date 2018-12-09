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
public class Applicant implements Serializable {
    private String applicationNumber;
    private String userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String maritalStatus;
    private String stateOfOrigin;
    private String wardName;
    private String formOfIdentification;
    private String identificationNumber;
    private String bankVerificationNumber;
    private String bankName;
    private String phoneNumber;
    private String emailAddress;
    private String stateOfResidence;
    private String residentialAddress;
    private String dob;
    private String localGovOrigin;
    private  String dobBeneficiaryStep4;
    private String status;
    private String localGovOfRes;
    private String nokName;
    private String nokAddress;
    private String nokPhoneNumber;
    private String nokRelationship;

    public String getLocalGovOfRes() {
        return localGovOfRes;
    }

    public void setLocalGovOfRes(String localGovOfRes) {
        this.localGovOfRes = localGovOfRes;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDobBeneficiaryStep4() {
        return dobBeneficiaryStep4;
    }

    public void setDobBeneficiaryStep4(String dobBeneficiaryStep4) {
        this.dobBeneficiaryStep4 = dobBeneficiaryStep4;
    }
    public String getLocalGovOrigin() {
        return localGovOrigin;
    }

    public void setLocalGovOrigin(String localGovOrigin) {
        this.localGovOrigin = localGovOrigin;
    }

   

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

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getStateOfOrigin() {
        return stateOfOrigin;
    }

    public void setStateOfOrigin(String stateOfOrigin) {
        this.stateOfOrigin = stateOfOrigin;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getFormOfIdentification() {
        return formOfIdentification;
    }

    public void setFormOfIdentification(String formOfIdentification) {
        this.formOfIdentification = formOfIdentification;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getBankVerificationNumber() {
        return bankVerificationNumber;
    }

    public void setBankVerificationNumber(String bankVerificationNumber) {
        this.bankVerificationNumber = bankVerificationNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStateOfResidence() {
        return stateOfResidence;
    }

    public void setStateOfResidence(String stateOfResidence) {
        this.stateOfResidence = stateOfResidence;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }
   public String getNokName() {
        return nokName;
    }

    public void setNokName(String nokName) {
        this.nokName = nokName;
    }

    public String getNokAddress() {
        return nokAddress;
    }

    public void setNokAddress(String nokAddress) {
        this.nokAddress = nokAddress;
    }

    public String getNokPhoneNumber() {
        return nokPhoneNumber;
    }

    public void setNokPhoneNumber(String nokPhoneNumber) {
        this.nokPhoneNumber = nokPhoneNumber;
    }

    public String getNokRelationship() {
        return nokRelationship;
    }

    public void setNokRelationship(String nokRelationship) {
        this.nokRelationship = nokRelationship;
    }
   
    public String insertApplicantQuery(){
       String sql=  "INSERT INTO applicant "
               + "( applicationNumber, firstName,"
               + " middleName, lastName, gender, "
               + "maritalStatus,"
               + " stateOfOrigin, "
               + " localGovOrigin, "
               + "wardName, formOfIdentification,"
               + " identificationNumber,"
               + " bankVerificationNumber,"
               + " bankName, phoneNumber, "
               + "emailAddress,"
               + " nokName, nokPhoneNumber, "
               + "nokAddress, "
               + "nokRelationship,"
               + "stateOfResidence, "
               + "localGovOfRes, "
               + "dob, status,"
               + "residentialAddress) "
               + "VALUES ";
        return sql+ "(  " + "\'" + getApplicationNumber() + "\'," + "\'"
                + getFirstName() + "\'," + "\'"
                + getMiddleName() + "\'," + "\'"
                + getLastName() + "\'," + "\'"
                + getGender() + "\'," + "\'"
                + getMaritalStatus() + "\'," + " \'"
                + getStateOfOrigin() + "\'," + " \'"
                + getLocalGovOrigin() + "\'," + " \'"
                + getWardName() + "\'," + " \'"
                + getFormOfIdentification() + "\'," + " \'"
                + getIdentificationNumber() + "\'," + " \'"
                + getBankVerificationNumber() + "\'," + " \'"
                + getBankName() + "\'," + " \'"
                + getPhoneNumber() + "\'," + " \'"
                + getEmailAddress() + "\'," + " \'"
                + getNokName() + "\'," + " \'" 
                + getNokPhoneNumber() + "\'," + " \'" 
                + getNokAddress() + "\'," + " \'" 
                + getNokRelationship() + "\',"+ " \'" 
                + getStateOfResidence() + "\'," + " \'"
                + getLocalGovOfRes()+ "\'," + " \'"
                + getDob() + "\'," + " \'"
                + getStatus() + "\'," + " \'"
                + getResidentialAddress() + "\');";
    }
    public String updateQuery(){
         return " UPDATE applicant SET firstName = "+getFirstName()+","
                 + " middleName = \'" +getMiddleName() + "\', "
                 + " lastName = \'" +getLastName() + "\', "
                 + " gender = \'" +getGender() + "\', "
                 + " formOfIdentification = \'" +getFormOfIdentification() + "\', "
                 + " identificationNumber = \'" +getIdentificationNumber() + "\', "
                 + " bankVerificationNumber = \'" +getBankVerificationNumber() + "\', "
                 + " bankName = \'" +getBankName() + "\', "
                 + " phoneNumber = \'" +getPhoneNumber() + "\', "
                 + " emailAddress = \'" +getEmailAddress() + "\', "
                 + " nokName = \'" +getNokName() + "\', "
                 + " nokPhoneNumber = \'" +getNokPhoneNumber() + "\', "
                 + " nokAddress = \'" +getNokAddress()+ "\', "
                 + " stateOfResidence = \'" +getStateOfResidence() + "\', "
                 + "dob = \'" +getDob() + "\', "
                 + "status =\'" +getStatus() + "\', "
                 + " residentialAddress = \'" +getResidentialAddress() + "\', "
                 + " maritalStatus = \'" +getMaritalStatus()+ "\', "
                 + "stateOfOrigin = " + getStateOfOrigin()+ ","
                 + " wardName = \'" + getWardName() + "\' "
                 + " where applicationNumber = \'" + getApplicationNumber()+ "\';";
    }
}
