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
public class User {
    String userid;
    String password;
    String role;
    String email;
 public User(){
        
    }
 public User(String userid, String password, String role, String email) {
        this.userid = userid;
        this.password = password;
        this.role = role;
        this.email = email;
    }
    
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String insertUserQuery() {
       String sql="INSERT INTO login ( userId, email,password,role) "
                    + "VALUES ";
       return sql + "(  " + "\'" + getUserid()+ "\',"+ "\'" 
                + getEmail()+ "\'," + "\'" 
                + getPassword()+ "\',"+"\'"  
                + getRole()+ "\');";

   } 
    
 @Override
    public String toString() {
        return "User : {" + "userid=" + userid + ", password=" + password + ", role=" + role + ", email=" + email + '}';
    }
   
  public String updateQuery(){
  return " UPDATE login SET email = "+getUserid()+","
                 + " role = \'" +getEmail() + "\', "
                 + " password = \'" +getPassword()+ "\', "
                 + " where userId = \'" +getUserid()+ "\';";
    }
}
