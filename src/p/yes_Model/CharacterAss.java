/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.yes_Model;

/**
 *
 * @author Aniwange.TA
 */
public class CharacterAss {
    String id;
    String applicationNumber;
    String crimeConviction;
    String CrimeDescription;

    public String getCrimeDescription() {
        return CrimeDescription;
    }

    public void setCrimeDescription(String CrimeDescription) {
        this.CrimeDescription = CrimeDescription;
    }
    String lawAbiding;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getCrimeConviction() {
        return crimeConviction;
    }

    public void setCrimeConviction(String crimeConviction) {
        this.crimeConviction = crimeConviction;
    }

    public String getLawAbiding() {
        return lawAbiding;
    }

    public void setLawAbiding(String lawAbiding) {
        this.lawAbiding = lawAbiding;
    }
    
    public  String insertCharacterAssQuery(){
        String sq1="INSERT INTO characterAss ( applicationNumber, crimeConviction, crimeDescription, lawAbiding) "
                    + "VALUES ";
        return sq1+ "(  " + "\'"
                + getApplicationNumber()+ "\',"+ "\'" 
                + getCrimeConviction()+ "\'," + "\'" 
                + getCrimeDescription()+ "\'," + "\'" 
                + getLawAbiding()+ "\');";
    }
  public String updateQuery(){
    return " UPDATE characterAss SET applicationNumber = "+getApplicationNumber()+","
                 + " crimeConviction = \'" +getCrimeConviction() + "\', "
                 + " crimeDescription = \'" +getCrimeDescription() + "\', "
                 + " lawAbiding = \'" +getLawAbiding()+ "\', "
                 + " where applicationNumber = \'" +getApplicationNumber()+ "\';";
    }
}
