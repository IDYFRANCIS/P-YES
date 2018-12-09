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
public class CharacterAssessment {    
private String crimeConvicted;
private Boolean criminalConvictionStatus;
private String lawAbiding;

public String getCrimeConvicted() {
return crimeConvicted;
}

public void setCrimeConvicted(String crimeConvicted) {
this.crimeConvicted = crimeConvicted;
}

public Boolean getCriminalConvictionStatus() {
return criminalConvictionStatus;
}

public void setCriminalConvictionStatus(Boolean criminalConvictionStatus) {
this.criminalConvictionStatus = criminalConvictionStatus;
}

public String getLawAbiding() {
return lawAbiding;
}

public void setLawAbiding(String lawAbiding) {
this.lawAbiding = lawAbiding;
}
    
}
