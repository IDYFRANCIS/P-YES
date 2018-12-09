/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.yes_Model.dto;

import java.io.Serializable;

/**
 *
 * @author Aniwange.TA
 */
public class LoginResponseData implements Serializable{
private Boolean status;
private String message;
private UserLoginResponseDto data;

public Boolean getStatus() {
return status;
}

public void setStatus(Boolean status) {
this.status = status;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public UserLoginResponseDto getData() {
return data;
}

public void setData(UserLoginResponseDto data) {
this.data = data;
}

}
    
    

