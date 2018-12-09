package p.yes;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
import p.yes.Database.PyesDatabaseManager;
import p.yes_Model.Applicant;

/**
 * FXML Controller class
 *
 * @author IDONGESIT FRANCIS
 */
public class FXMLVIEW_ALLController implements Initializable {

    @FXML
    private MenuItem newRegView_Btn;

    @FXML
    private MenuItem uploadView_Btn;

    @FXML
    private MenuItem closeView;
    
    private PyesDataBase dataBase;
    
    @FXML
    private MenuBar myMenuBarViewAll;

    @FXML
    private JFXTreeTableView<ApplicantObservableModel> treeTabelViewAll_Applicants;

    @FXML
    void loadNewRegistrationPane(ActionEvent event) throws IOException {
        if (event.getTarget()== newRegView_Btn) {
           Stage stage = (Stage) myMenuBarViewAll.getScene().getWindow();
            Parent root = null;

            root = FXMLLoader.load(getClass().getResource("FXMLP-YES.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setMaximized(false);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("pyes-alone.png")));
            stage.setTitle("PRESIDENTIAL YOUTH EMPOWERMENT SCHEME");
            stage.show();
        }
    }

    @FXML
    void loadUploadedApplicants(ActionEvent event) {
        if (event.getTarget()== uploadView_Btn) {
          Stage stage = (Stage) myMenuBarViewAll.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("FXMLSYNC-ALL.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setMaximized(false);
                stage.getIcons().add(new Image(getClass().getResourceAsStream("pyes-alone.png")));
                stage.setTitle("ALL APPLICANTS TO BE UPLOADED");
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(FXMLPYESController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    void exitApp(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayApplicants();   
        
    }

   
    
    public void displayApplicants() {
        //dataBase = new PyesDataBase();
        
        
        JFXTreeTableColumn<FXMLVIEW_ALLController.ApplicantObservableModel, String> firstName = new JFXTreeTableColumn<>("FIRSTNAME");
        firstName.setPrefWidth(200);
        firstName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String> param) {
                firstName.setStyle("-fx-alignment: CENTER");
                return param.getValue().getValue().FirstName;

            }
        });
        
        
        JFXTreeTableColumn<FXMLVIEW_ALLController.ApplicantObservableModel, String> lastName = new JFXTreeTableColumn<>("LASTNAME");
        lastName.setPrefWidth(200);
        lastName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String> param) {
                lastName.setStyle("-fx-alignment: CENTER");
                return param.getValue().getValue().LastName;

            }
        });
        
        JFXTreeTableColumn<FXMLVIEW_ALLController.ApplicantObservableModel, String> gender = new JFXTreeTableColumn<>("GENDER");
        gender.setPrefWidth(140);
        gender.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String> param) {
                gender.setStyle("-fx-alignment: CENTER");
                return param.getValue().getValue().Gender;

            }
        });
        
        JFXTreeTableColumn<FXMLVIEW_ALLController.ApplicantObservableModel, String> state = new JFXTreeTableColumn<>("STATE");
        state.setPrefWidth(180);
        state.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String> param) {
                state.setStyle("-fx-alignment: CENTER");
                return param.getValue().getValue().State;

            }
        });
        
        JFXTreeTableColumn<FXMLVIEW_ALLController.ApplicantObservableModel, String> email = new JFXTreeTableColumn<>("EMAIL");
        email.setPrefWidth(230);
        email.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String> param) {
                email.setStyle("-fx-alignment: CENTER");
                return param.getValue().getValue().Email;

            }
        });
        
        JFXTreeTableColumn<FXMLVIEW_ALLController.ApplicantObservableModel, String> formOfIdentification = new JFXTreeTableColumn<>("FORM OF ID");
        formOfIdentification.setPrefWidth(190);
        formOfIdentification.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String> param) {
                formOfIdentification.setStyle("-fx-alignment: CENTER");
                return param.getValue().getValue().FormOfIdentification;

            }
        });
        
        JFXTreeTableColumn<FXMLVIEW_ALLController.ApplicantObservableModel, String> status = new JFXTreeTableColumn<>("STATUS");
        status.setPrefWidth(150);
        status.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<FXMLVIEW_ALLController.ApplicantObservableModel, String> param) {
                status.setStyle("-fx-alignment: CENTER");
                return param.getValue().getValue().Status;

            }
        });
        
        
        
        
        ObservableList<ApplicantObservableModel> applicant = FXCollections.observableArrayList();
        PyesDatabaseManager pdm=new PyesDatabaseManager();
        
        List<Applicant> applicants = pdm.findAllApplicants();
        
        
        if (applicants != null) {
            
            for(Applicant app : applicants){
                
                applicant.add(new ApplicantObservableModel(app.getFirstName(), app.getLastName(),
                        app.getGender(), app.getStateOfOrigin(), app.getEmailAddress(), 
                        app.getFormOfIdentification(), app.getStatus()));
            }
        }
        
        
        final TreeItem<FXMLVIEW_ALLController.ApplicantObservableModel> root = new RecursiveTreeItem<>(applicant, RecursiveTreeObject::getChildren);
        treeTabelViewAll_Applicants.getColumns().setAll(firstName, lastName, gender, state, email, formOfIdentification, status);
        treeTabelViewAll_Applicants.setRoot(root);
        treeTabelViewAll_Applicants.setShowRoot(false);
    }
    
     class ApplicantObservableModel extends RecursiveTreeObject<ApplicantObservableModel>{
        StringProperty FirstName;
        StringProperty LastName;
        StringProperty Gender;
        StringProperty State;
        StringProperty Email;
        StringProperty FormOfIdentification;
        StringProperty Status;
        public ApplicantObservableModel(String FirstName, String LastName, String Gender, String State, String Email, String FormOfIdentification, String Status) {
            this.FirstName = new SimpleStringProperty(FirstName);
            this.LastName = new SimpleStringProperty(LastName);
            this.Gender = new SimpleStringProperty(Gender);
            this.State = new SimpleStringProperty(State);
            this.Email = new SimpleStringProperty(Email);
            this.FormOfIdentification = new SimpleStringProperty(FormOfIdentification);
            this.Status = new SimpleStringProperty(Status);
        }
    }
}


