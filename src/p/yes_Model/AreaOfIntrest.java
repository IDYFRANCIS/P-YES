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
public class AreaOfIntrest implements Serializable{
    
    private String applicationNumber;
    private String userId;
    private String areaOfIntrest;
    private String empowerOthers;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String maritalStatus;
    private String phoneNumber;
    private String email;
    private String dob_Beneficiary_Step4;

    public String getDob_Beneficiary_Step4() {
        return dob_Beneficiary_Step4;
    }

    public void setdob_Beneficiary_Step4(String getDOB_Beneficiary_Step4) {
        this.dob_Beneficiary_Step4 = getDOB_Beneficiary_Step4;
    }
    private String employmentStatus;
    private String residentialAddress;
    private String idType;
    private String idNumber;

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

    public String getAreaOfIntrest() {
        return areaOfIntrest;
    }

    public void setAreaOfIntrest(String areaOfIntrest) {
        this.areaOfIntrest = areaOfIntrest;
    }

    public String getEmpowerOthers() {
        return empowerOthers;
    }

    public void setEmpowerOthers(String empowerOthers) {
        this.empowerOthers = empowerOthers;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String insertAreaOfInterestQuery(){
         String sql2 = "INSERT INTO areaOfIntrest "
                 + "( applicationNumber, firstName,"
                 + " middleName, lastName, gender,"
                 + " maritalStatus, phoneNumber, "
                 + "email, employmentStatus, "
                 + "residentialAddress, DOB_Beneficiary_Step4,"
                 + " idType, idNumber, areaOfIntrest,"
                 + " empowerOthers) "
                 + "VALUES " ;
        return sql2 + "(  " + "\'"
                + getApplicationNumber()+ "\',"+ "\'" 
                + getFirstName() + "\'," + "\'" 
                + getMiddleName() + "\'," + "\'" 
                + getLastName() + "\'," + "\'" 
                + getGender() + "\'," + "\'" 
                +getMaritalStatus() + "\'," + " \'" 
                + getPhoneNumber() + "\'," + " \'" 
                + getEmail() + "\'," + " \'" 
                +getEmploymentStatus() + "\'," + " \'" 
                +getResidentialAddress() + "\'," + " \'" 
                +getDob_Beneficiary_Step4() + "\'," + " \'" 
                + getIdType() + "\'," + " \'" 
                + getIdNumber() + "\'," + " \'" 
                +getAreaOfIntrest() + "\'," + " \'" 
                + getEmpowerOthers() + "\');";
    }
     public String updateQuery(){
         return " UPDATE areaOfIntrest SET firstName = "+getFirstName()+","
                 + " middleName = \'" +getMiddleName() + "\', "
                 + " lastName = \'" +getLastName() + "\', "
                 + " gender = \'" +getGender() + "\', "
                 + " employmentStatus = \'" +getEmploymentStatus() + "\', "
                 + " idType = \'" +getIdType() + "\', "
                 + " idNumber = \'" +getIdNumber() + "\', "
                 + " areaOfIntrest = \'" +getAreaOfIntrest() + "\', "
                 + " empowerOthers = \'" +getEmpowerOthers() + "\', "
                 + " phoneNumber = \'" +getPhoneNumber() + "\', "
                 + " email = \'" +getEmail() + "\', "
                 + " applicationNumber = \'" +getApplicationNumber() + "\', "
                 + " DOB_Beneficiary_Step4 = \'" +getDob_Beneficiary_Step4() + "\', "
                 + " residentialAddress = \'" +getResidentialAddress() + "\', "
                 + " maritalStatus = \'" +getMaritalStatus()+ "\', "
                 + " where applicationNumber = \'" +getApplicationNumber()+ "\';";
    }
}