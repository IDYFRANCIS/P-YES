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
public class UserLoginResponseDto {
private String userId;
private String accessToken;
private String role;

public String getUserId() {
return userId;
}

public void setUserId(String userId) {
this.userId = userId;
}

public String getAccessToken() {
return accessToken;
}

public void setAccessToken(String accessToken) {
this.accessToken = accessToken;
}

public String getRole() {
return role;
}

public void setRole(String role) {
this.role = role;
}

  @Override
    public String toString() {
        return "UserLoginInfo : " + "userId=" + userId + ", accessToken=" + accessToken + ", role=" + role ;
    }
    
}
