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
public class Employment implements Serializable {
    private String applicationNumber;
    private String userId;
    private String academicQualification;
    private String employmentStatus;
    private String beneficiaryStatus;
    private String existingBusiness;
    private String businessDescription;
    private String businessLocation;

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

    public String getAcademicQualification() {
        return academicQualification;
    }

    public void setAcademicQualification(String academicQualification) {
        this.academicQualification = academicQualification;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getBeneficiaryStatus() {
        return beneficiaryStatus;
    }

    public void setBeneficiaryStatus(String beneficiaryStatus) {
        this.beneficiaryStatus = beneficiaryStatus;
    }

    public String getExistingBusiness() {
        return existingBusiness;
    }

    public void setExistingBusiness(String existingBusiness) {
        this.existingBusiness = existingBusiness;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public String getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(String businessLocation) {
        this.businessLocation = businessLocation;
    }

public String insertEmploymentQuery(){
     String sql2 = "INSERT INTO employment "
             + "(applicationNumber, "
             + "academicQualification, "
             + "employmentStatus, "
             +"beneficiaryStatus, "
             +"existingBusiness,"
             + " businessDescription,"
             + " businessLocation) "
             + "VALUES ";
     
    return  sql2 + "(" + "\'" 
            + getApplicationNumber()+ "\'," + "\'" 
            + getAcademicQualification()+ "\'," + "\'"
            + getEmploymentStatus() + "\'," + "\'" 
            + getBeneficiaryStatus() + "\'," + "\'" 
            + getExistingBusiness() + "\'," + "\'" 
            + getBusinessDescription() + "\'," + " \'" 
            + getBusinessLocation() + "\');";
}
public String updateQuery(){
    return " UPDATE employment SET applicationNumber = "+getApplicationNumber()+","
                 + " academicQualification = \'" +getAcademicQualification() + "\', "
                 + " employmentStatus = \'" +getEmploymentStatus() + "\', "
                 + " beneficiaryStatus = \'" +getBeneficiaryStatus() + "\', "
                 + " existingBusiness = \'" +getExistingBusiness() + "\', "
                 + " businessDescription = \'" +getBusinessDescription() + "\', "
                 + " businessLocation = \'" +getBusinessLocation()+ "\', "
                 + " where applicationNumber = \'" +getApplicationNumber()+ "\';";
    }
    
}


   