package p.yes;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import p.yes.utils.Config;
import p.yes.Database.Api.PyesApiManager;
import p.yes.Database.PyesDatabaseManager;
import p.yes_Model.User;
import p.yes_Model.dto.LoginDto;
import p.yes_Model.dto.LoginResponseData;
import p.yes_Model.dto.ResponseDto;
import p.yes_Model.dto.UserLoginResponseDto;

/**
 * FXML Controller class
 *
 * @author IDONGESIT FRANCIS
 */
public class FXML_PYES_LOGIN_PAGEController implements Initializable {
      PyesDatabaseManager pdm=new  PyesDatabaseManager();

    @FXML
    private JFXTextField emailField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Label loginError;
    
    @FXML
    private ImageView login_image;

   

    @FXML
    String loadForms(ActionEvent event) {
        
         loginBtn.setDisable(true);
        String email = emailField.getText().trim();
        String pass = passwordField.getText().trim();
        if(email.isEmpty()){
             loginBtn.setDisable(false);
             loginError.setText("email is empty");
             return null; 
        }
       if(pass.isEmpty()){
            loginBtn.setDisable(false);
            loginError.setText("email is empty");
            return null;
        }
        
        LoginDto request = new LoginDto(email, pass);
        User user=new User();
        user.setEmail(email);
        String encodePass=pdm.encodeString(pass);
        user.setPassword(encodePass);
       User userLocal=pdm.LoginUser(request);
       if(userLocal.getEmail()!=null){
         String newpass=pdm.getDecode(userLocal.getPassword());
          if(pass.equalsIgnoreCase(newpass) && email.equalsIgnoreCase(userLocal.getEmail())){
             Parent root = null;
                try {
                    Stage stage = new Stage();
                    root = FXMLLoader.load(getClass().getResource("FXMLP-YES.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setMaximized(true);
                    stage.getIcons().add(new Image(getClass().getResourceAsStream("pyes-alone.png")));
                    stage.setTitle("PRESIDENTIAL YOUTH EMPOWERMENT SCHEME");
                    stage.show();
                    ((Node) event.getSource()).getScene().getWindow().hide();
                    return "ok";
                } catch (IOException ex) {
                    Logger.getLogger(FXML_PYES_LOGIN_PAGEController.class.getName()).log(Level.SEVERE, null, ex);
                }
          return "yes";
        }
       if(!(pass.equalsIgnoreCase(pdm.encodeString(userLocal.getPassword())) && email.equalsIgnoreCase(userLocal.getEmail()))){
           loginBtn.setDisable(false);
           loginError.setText("Wrong password or email");
           return "ok";
       }
       
      }
      if(userLocal.getEmail()==null){
          System.err.println("Iam here2");
          ResponseDto response = PyesApiManager.httpRequestHelper(Config.BASE_URL + "admin/login", "POST", request, null);
          System.err.println(": "+response.getData().toString());
          if(response.getData()!=null) {
                loginBtn.setDisable(true);
                 System.err.println("Iam here3");
                Gson gson =new Gson();
                System.err.println("data: "+ response.getData().toString());
                LoginResponseData userLoginRes=gson.fromJson(response.getData().toString(), LoginResponseData.class);
                
               //userLoginRes
              UserLoginResponseDto userLoginResponseDto=userLoginRes.getData();
              System.err.println(" role:"+userLoginResponseDto.getRole());
              user.setRole(userLoginResponseDto.getRole());
              user.setUserid(userLoginResponseDto.getUserId());
              System.err.print(":userid "+ userLoginResponseDto.getUserId());
              System.err.println("Iam here3");
             if(pdm.isUerExist(user.getUserid())){
                  pdm.updateLogin(user);
                  System.err.println("Iam amos amos");
             }
           if(!(pdm.isUerExist(user.getUserid()))){
                 System.err.println("Iam amos2 ");
                 pdm.insertLogin(user);
             } 
               Parent root = null;
                try {
                    Stage stage = new Stage();
                    root = FXMLLoader.load(getClass().getResource("FXMLP-YES.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setMaximized(true);
                    stage.getIcons().add(new Image(getClass().getResourceAsStream("pyes-alone.png")));
                    stage.setTitle("PRESIDENTIAL YOUTH EMPOWERMENT SCHEME");
                    stage.show();
                    ((Node) event.getSource()).getScene().getWindow().hide();
                    return "yes";
                } catch (IOException ex) {
                    Logger.getLogger(FXML_PYES_LOGIN_PAGEController.class.getName()).log(Level.SEVERE, null, ex);
                }
          
            
        }
            else {
                loginBtn.setDisable(false);
                loginError.setText(response.getMessage());
                return "no";
            }
        
    }
     loginBtn.setDisable(false);
     loginError.setText("Something went wrong");
       return null;
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pdm.createApplicantTable();
        pdm.createAreaOfIntrestTable();
        pdm.createCharacterAssTable();
        pdm.createDocumentsTable();
        pdm.createEmploymentTable();
        pdm.createLogin();
        pdm.createRefreeTable();
       
    }

}
