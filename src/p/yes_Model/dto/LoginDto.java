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
public class LoginDto {
    String email;
    String password;
    
    
    
 public LoginDto(String email, String pass) {
        this.email = email;
        this.password = pass;
       
    }
 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
    }

   

   
    
}
