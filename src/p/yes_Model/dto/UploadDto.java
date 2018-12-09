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
public class UploadDto {
private List<OfficerRegistration> officerRegistration = null;
public List<OfficerRegistration> getOfficerRegistration() {
return officerRegistration;
}
public void setOfficerRegistration(List<OfficerRegistration> officerRegistration) {
this.officerRegistration = officerRegistration;
} 

    @Override
    public String toString() {
        return "{" + "officerRegistration: " + officerRegistration + '}';
    }

}
