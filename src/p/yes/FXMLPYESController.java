package p.yes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
;
import p.yes.utils.Const;
import p.yes.Database.PyesDatabaseManager;
import p.yes_Model.Applicant;
import p.yes_Model.AreaOfIntrest;
import p.yes_Model.CharacterAss;
import p.yes_Model.Document;
import p.yes_Model.Employment;
import p.yes_Model.Refree;

/**
 *
 * @author IDONGESIT FRANCIS
 */


public class FXMLPYESController implements Initializable {

    PyesDatabaseManager pdm = new PyesDatabaseManager();
    List<Document> documents = new ArrayList<>();
    List<Refree> refereesList = new ArrayList<>();
    ObservableList<String> localOfOriginList = FXCollections.observableArrayList();
    ObservableList<String> localOfResList = FXCollections.observableArrayList();
     ObservableList<String> localOfBusinessList = FXCollections.observableArrayList();
    ObservableList<String> localOfBeneficList = FXCollections.observableArrayList();

    @FXML
    private Pane step1_Pane; //BIO DATA AND CONTACT DETAILS
    
  
    

    @FXML
    private Pane step2_Pane; //EMPLOYMENT,BUSINESS & PROGRAM HISTORY

    @FXML
    private Label appmessage;

    @FXML
    private Pane step3_Pane; //REFEREES AND NEXT OF KIN

    @FXML
    private Pane step4_Pane; //AREA OF INTREST AND NEXT LEVEL BENEFICIARY

    @FXML
    private Pane step5_Pane; //DOCUMENTATION,ATTESTATION & SUBMISSION

    /**
     * ****************************************************************************************************************
     * COMBO-BOXES, BUTTONS AND TEXT FIELDS IN STEP 1
     * ****************************************************************************************************************
     */
    @FXML
    private JFXTextField firstName_Step1;

    @FXML
    private JFXTextField middleName_Step1;

    @FXML
    private JFXTextField lastName_Step1, bvn_Step1, idCardNo_Step1, bankName_Step1,
            phoneNo_Step1, wardName_Step1, email_Step1, residentialAddress_Step1;

    @FXML
    private JFXComboBox<String> cboxGender, cboxMaritalStatus, cboxStates, cboxIDType, cboxStates_ContactDetails;
     @FXML
    private JFXComboBox<String> cboxLGA;

    @FXML
    private JFXComboBox<String> cboxLGA_2;

    @FXML
    private JFXDatePicker DOB_Step1;

    @FXML
    private JFXButton nextBtn_Step1;
    /**
     * ****************************************************************************************************************
     * COMBO-BOXES, BUTTONS AND TEXT FIELDS IN STEP 2
     * ****************************************************************************************************************
     */
   

    @FXML
    private JFXComboBox<String> cboxQualification_Step2;

    @FXML
    private JFXComboBox<String> cboxEmploymentStatus_Step2;

    @FXML
    private JFXComboBox<String> cboxAlreadyBeneficiary_Step2;

    @FXML
    private JFXComboBox<String> cboxOwnBusiness_Step2;

    @FXML
    private JFXComboBox<String> cboxBusStates_Step2, localGovBusiness;

    @FXML
    private JFXTextField busDescription_Step2;

    @FXML
    private JFXButton nextBtn_Step2;

    @FXML
    private JFXButton previousBtn_Step2;

    private PyesDataBase dataBase;

    /**
     * ****************************************************************************************************************
     * COMBO BOXES, BUTTONS AND TEXT FIELDS IN STEP 3
     * ****************************************************************************************************************
     */
    @FXML
    private JFXTextField refName_Step3, refAddress_Step3, refPhoneNo_Step3, refRelationship_Step3,
            nokName_Step3, nokAddress_Step3, nokPhoneNo_Step3, nokRelationship_Step3;
     @FXML
    private JFXTreeTableView<Refree2> reTreeview;

    @FXML
    private Pane displayRefPane_Step3;

    @FXML
    private JFXButton nextBtn_Step3;

    @FXML
    private JFXButton previousBtn_Step3;

    @FXML
    private JFXButton btnAddReference_Step3;

    /**
     * ****************************************************************************************************************
     * COMBO BOXES, BUTTONS AND TEXT FIELDS IN STEP 4
     * ****************************************************************************************************************
     */
    @FXML
    private JFXComboBox<String> cboxEmpowerOthers_Step4, cboxIDType_BeneficiaryStep4, cboxAreaOfIntrest_Step4,
            cboxEmpStatOfBen_Step4, cboxGender_Step4, cboxMaritalStatus_Step4;

    @FXML
    private JFXTextField idNumber_Step4, lastName_Step4, email_Step4, firstName_Step4, phoneNo_Step4,
            middleName_Step4, residentialAddress_Step4;

    @FXML
    private JFXButton nextBtn_Step4;

    @FXML
    private JFXButton previousBtn_Step4;

    @FXML
    private JFXDatePicker DOB_Beneficiary_Step4;

    /**
     * *****************************************************************************************************************
     * COMBO BOXES, BUTTONS AND TEXT FIELDS IN STEP 5
     * *****************************************************************************************************************
     */
    @FXML
    private Label errorLabel_Step1, errorLabel_Step2, errorLabel_Step3, errorLabel_Step4, errorLabel_Step5;
    
    @FXML
    private JFXButton progress_Step1, progress_Step2, progress_Step3, progress_Step4, progress_Step5;

    @FXML
    private JFXButton btn_SaveDetails;

    @FXML
    private JFXButton previousBtn_Step5;

    @FXML
    private JFXTextField crimeDescription_Step5;

    @FXML
    private JFXComboBox<String> cboxConvicted_Step5, cboxLawAbiding_Step5;

    /**
     * *****************************************************************************************************************
     * MENU BAR ACTIONS AND CONTROLS
     * *****************************************************************************************************************
     */
    @FXML
    private MenuItem closeBtn, newReg_Btn, viewApplicant_Btn, syncAll_Btn;

    @FXML
    private AnchorPane anchorBoard;
@FXML
    private MenuBar myMenuBar;

    @FXML
    void closeApp(ActionEvent event) {
        Platform.exit();
    }

    private File selectedIDCard, selectedPassport, selectedLGForm;

    @FXML
    void onStateOfOriginClick(ActionEvent event) {
        String stateSelected = cboxStates.getSelectionModel().getSelectedItem();
        System.err.println("state: " + stateSelected);
        localOfOriginList.clear();
        ArrayList localGovs = pdm.getLga(stateSelected);
        localOfOriginList.addAll(localGovs);
        cboxLGA.setItems(localOfOriginList);

    }

    @FXML
    void onStateOfResClick(ActionEvent event) {
        System.err.println("State of res , hello world");
        String stateSelected = cboxStates_ContactDetails.getSelectionModel().getSelectedItem();
        System.err.println("state: " + stateSelected);
        localOfResList.clear();
        ArrayList localGovs = pdm.getLga(stateSelected);
        localOfResList.addAll(localGovs);
        cboxLGA_2.setItems(localOfResList);
    }
     @FXML
    void onStateOfBussineClick(ActionEvent event) {
        System.err.println("State of res , hello world");
        String stateSelected = cboxBusStates_Step2.getSelectionModel().getSelectedItem();
        System.err.println("state: " + stateSelected);
        localOfBusinessList.clear();
        ArrayList localGovs = pdm.getLga(stateSelected);
        localOfBusinessList.addAll(localGovs);
        localGovBusiness.setItems(localOfBusinessList);
    }
    
//     @FXML
//    void onStateOfBenificClick(ActionEvent event) {
//        System.err.println("State of res , hello world");
//        String stateSelected = cboxStates_ContactDetails.getSelectionModel().getSelectedItem();
//        System.err.println("state: " + stateSelected);
//        localOfBeneficList.clear();
//        ArrayList localGovs = pdm.getLga(stateSelected);
//        localOfBeneficList.addAll(localGovs);
//        cboxLGA_2.setItems(localOfResList);
//    }
//    

    @FXML
    void loadRegistrationPane(ActionEvent event) {
        if (event.getSource() == newReg_Btn) {

            step1_Pane.toFront();
            progress_Step1.setDisable(false);
            progress_Step2.setDisable(true);
            progress_Step3.setDisable(true);
            progress_Step4.setDisable(true);
            progress_Step5.setDisable(true);
        }
    }

    @FXML
    void loadViewAll_ApplicantsPage(ActionEvent event) {
        if (event.getTarget() == viewApplicant_Btn) {
            Stage stage = (Stage) myMenuBar.getScene().getWindow();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("FXMLVIEW-ALL.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setMaximized(false);
                stage.setTitle("ALL REGISTERED APPLICANTS");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLPYESController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    void uploadAll_Applicants(ActionEvent event) {
        if (event.getTarget() == syncAll_Btn) {
            Stage stage = (Stage) myMenuBar.getScene().getWindow();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("FXMLSYNC-ALL.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setMaximized(false);
                stage.setTitle("YET TO BE UPLOADED APPLICANTS");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLPYESController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * ***********************************************************************************************************
     * CONTROL METHODS TO SWITCH SCENES
     * ***********************************************************************************************************
     */
    //ACTION TO LOAD STEP TWO FORM 
    @FXML
    void load_Step2(ActionEvent event) {
        if (event.getSource() == nextBtn_Step1) {

            if (firstName_Step1.getText().isEmpty()) {
                errorLabel_Step1.setText("PLEASE INSERT FIRST NAME");
            } else if (middleName_Step1.getText().isEmpty()) {
                errorLabel_Step1.setText("PLEASE INSERT MIDDLE NAME");
            } else if (lastName_Step1.getText().isEmpty()) {
                errorLabel_Step1.setText("PLEASE INSERT LAST NAME");
            } else if (idCardNo_Step1.getText().isEmpty()) {
                errorLabel_Step1.setText("PLEASE INSERT ID CARD NO");
            } else if (bvn_Step1.getText().isEmpty()) {
                errorLabel_Step1.setText("PLEASE INSERT ACCOUNT BVN");
            } else if (bankName_Step1.getText().isEmpty()) {
                errorLabel_Step1.setText("PLEASE INSERT BANK NAME");
            } else if (phoneNo_Step1.getText().isEmpty()) {
                errorLabel_Step1.setText("PLEASE INSERT PHONE NUMBER");
            } else if (email_Step1.getText().isEmpty()) {
                errorLabel_Step1.setText("PLEASE INSERT EMAIL ADDRESS");
            } else if (residentialAddress_Step1.getText().isEmpty()) {
                errorLabel_Step1.setText("PLEASE INSERT RESIDENTIAL ADDRESS");
            } else if (wardName_Step1.getText().isEmpty()) {
                errorLabel_Step1.setText("PLEASE INSERT WARD NAME");
            } else if (cboxMaritalStatus.getSelectionModel().isEmpty()) {
                errorLabel_Step1.setText("PLEASE SELECT MARITAL STATUS");
            } else if (cboxGender.getSelectionModel().isEmpty()) {
                errorLabel_Step1.setText("PLEASE SELECT GENDER");
            } else if (DOB_Step1.getValue() == null) {
                errorLabel_Step1.setText("PLEASE SELECT DATE OF BIRTH");
            } else if (cboxStates.getSelectionModel().isEmpty()) {
                errorLabel_Step1.setText("PLEASE SELECT STATE");
            } else if (cboxIDType.getSelectionModel().isEmpty()) {
                errorLabel_Step1.setText("PLEASE SELECT TYPE OF ID");
            } else if (cboxStates_ContactDetails.getSelectionModel().isEmpty()) {
                errorLabel_Step1.setText("PLEASE SELECT STATE OF RESIDENCE");
            } else {

                step2_Pane.toFront();
                progress_Step2.setDisable(false);
                progress_Step1.setDisable(true);
                progress_Step3.setDisable(true);
                progress_Step4.setDisable(true);
                progress_Step5.setDisable(true);
                errorLabel_Step1.setVisible(false);
            }
        }

    }

    //ACTION TO GO BACK TO STEP ONE FORM
    @FXML
    void returnTo_Step1(ActionEvent event) {
        if (event.getSource() == previousBtn_Step2) {
            System.err.println("hello");
            step1_Pane.toFront();
            progress_Step1.setDisable(false);
            progress_Step2.setDisable(true);
            progress_Step3.setDisable(true);
            progress_Step4.setDisable(true);
            progress_Step5.setDisable(true);
        }
    }

    //ACTION TO LOAD STEP THREE FORM 
    @FXML
    void load_Step3(ActionEvent event) {
        if (event.getSource() == nextBtn_Step2) {

        
                
         
           System.out.print("amos step2");
        
            if (cboxEmploymentStatus_Step2.getSelectionModel().isEmpty()) {
                errorLabel_Step2.setText("PLEASE SELECT EMPLOYMENT STATUS");
            }else if (cboxBusStates_Step2.getSelectionModel().isEmpty()) {
                          errorLabel_Step2.setText("PLEASE SELECT BUSINESS STATE");
              } 
            else if (cboxOwnBusiness_Step2.getSelectionModel().isEmpty()) {
                errorLabel_Step2.setText("PLEASE SELECT BUSINESS OWNERSHIP OPTION");
            } else if (cboxAlreadyBeneficiary_Step2.getSelectionModel().isEmpty()) {
                errorLabel_Step2.setText("PLEASE SELECT BENEFICIARY STATUS");
            } else if (cboxQualification_Step2.getSelectionModel().isEmpty()) {
                errorLabel_Step2.setText("PLEASE SELECT ACADEMIC QUALIFICATION");
            } else if (busDescription_Step2.getText().isEmpty()) {
                            errorLabel_Step2.setText("PLEASE DESCRIBE BUSINESS");
           
                      }
            else {
                step3_Pane.toFront();
                progress_Step3.setDisable(false);
                progress_Step1.setDisable(true);
                progress_Step2.setDisable(true);
                progress_Step4.setDisable(true);
                progress_Step5.setDisable(true);
                errorLabel_Step2.setVisible(false);
            }
         }
       
    }
    //ACTION TO GO BACK TO STEP TWO FORM  
    @FXML
    void returnTo_Step2(ActionEvent event) {
        if (event.getSource() == previousBtn_Step3) {
            step2_Pane.toFront();
            progress_Step2.setDisable(false);
            progress_Step1.setDisable(true);
            progress_Step3.setDisable(true);
            progress_Step4.setDisable(true);
            progress_Step5.setDisable(true);
        }
    }

    //ACTION TO LOAD STEP FOUR FORM
    @FXML
    void load_Step4(ActionEvent event) {
        if (event.getSource() == nextBtn_Step3) {

            if (refName_Step3.getText().isEmpty()) {
                errorLabel_Step3.setText("PLEASE INSERT REFREE NAME");
            } else if (refAddress_Step3.getText().isEmpty()) {
                errorLabel_Step3.setText("PLEASE INSERT REFREE ADDRESS");
            } else if (refPhoneNo_Step3.getText().isEmpty()) {
                errorLabel_Step3.setText("PLEASE INSERT REFREE PHONE NUNMBER");
            } else if (refRelationship_Step3.getText().isEmpty()) {
                errorLabel_Step3.setText("INSERT REFREE RELATIONSHIP");
            } else if (nokName_Step3.getText().isEmpty()) {
                errorLabel_Step3.setText("INSERT NOK NAME");
            } else if (nokAddress_Step3.getText().isEmpty()) {
                errorLabel_Step3.setText("INSERT NOK ADDRESS");
            } else if (nokPhoneNo_Step3.getText().isEmpty()) {
                errorLabel_Step3.setText("INSERT NOK PHONE NUMBER");
            } else if (nokRelationship_Step3.getText().isEmpty()) {
                errorLabel_Step3.setText("INSERT NOK RELATIONSHIP");
            } else {
                step4_Pane.toFront();
                progress_Step4.setDisable(false);
                progress_Step1.setDisable(true);
                progress_Step2.setDisable(true);
                progress_Step3.setDisable(true);
                progress_Step5.setDisable(true);
                errorLabel_Step3.setVisible(false);

            }
        }
    }

    @FXML
    void addRefree(ActionEvent event) {
        Refree refree = new Refree();
        refree.setRefAddress(refAddress_Step3.getText());
        refree.setRefName(refName_Step3.getText());
        refree.setRefPhoneNumber(refPhoneNo_Step3.getText());
        refree.setRefRelationship(refRelationship_Step3.getText());
        if(refereesList.size()>=2){
            
           errorLabel_Step3.setText("You have reached the maximum Number of Refrees"); 
       
        }else{
         refereesList.add(refree);
         table2();
        }
        errorLabel_Step3.setText("Refree added successfully");

    }

    //ACTION TO GO BACK TO STEP THREE FORM  
    @FXML
    void returnTo_Step3(ActionEvent event) {
        if (event.getSource() == previousBtn_Step4) {
            step3_Pane.toFront();
            progress_Step3.setDisable(false);
            progress_Step1.setDisable(true);
            progress_Step2.setDisable(true);
            progress_Step4.setDisable(true);
            progress_Step5.setDisable(true);
        }
    }

    //ACTION TO LOAD STEP FIVE FORM
    @FXML
    void load_Step5(ActionEvent event) {
        if (event.getSource() == nextBtn_Step4) {
            

                if (cboxGender_Step4.getSelectionModel().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE SELECT GENDER");
                } else if (cboxEmpowerOthers_Step4.getSelectionModel().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE CHOOSE EMPOWERMENT OPTION");
                } else if (cboxAreaOfIntrest_Step4.getSelectionModel().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE SELECT AREA OF INTREST");
                } else if (cboxMaritalStatus_Step4.getSelectionModel().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE SELECT MARITAL STATUS");
                } else if (cboxEmpStatOfBen_Step4.getSelectionModel().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE SELECT EMPLOYMENT STATUS");
                } else if (cboxIDType_BeneficiaryStep4.getSelectionModel().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE SELECT ID TYPE");
                } else if (idNumber_Step4.getText().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE INSERT ID NUMBER");
                } else if (lastName_Step4.getText().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE INSERT LAST NAME");
                } else if (email_Step4.getText().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE INSERT EMAIL");
                } else if (firstName_Step4.getText().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE INSERT FIRST NAME");
                } else if (phoneNo_Step4.getText().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE INSERT PHONE NUMBER");
                } else if (residentialAddress_Step4.getText().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE INSERT RESDENTIAL ADDRESS");
                } else if (DOB_Beneficiary_Step4.getValue() == null) {
                    errorLabel_Step4.setText("PLEASE CHOOSE DOB OF BENEFICIARY");
                } else if (middleName_Step4.getText().isEmpty()) {
                    errorLabel_Step4.setText("PLEASE INSERT MIDDLE NAME");
                } else {
                    step5_Pane.toFront();
                    progress_Step5.setDisable(false);
                    progress_Step1.setDisable(true);
                    progress_Step2.setDisable(true);
                    progress_Step3.setDisable(true);
                    progress_Step4.setDisable(true);
                    errorLabel_Step4.setVisible(false);
                }
            }
        
    }

    //ACTION TO GO BACK TO STEP FOUR FORM
    @FXML
    void returnTo_Step4(ActionEvent event) {
        if (event.getSource() == previousBtn_Step5) {
            step4_Pane.toFront();
            progress_Step4.setDisable(false);
            progress_Step1.setDisable(true);
            progress_Step2.setDisable(true);
            progress_Step3.setDisable(true);
            progress_Step5.setDisable(true);
        }
    }

    /**
     * ******************************************************************************************************************
     * STEP FIVE UPLOAD DOCUMENT OPTIONS
     * *****************************************************************************************************************
     */
    @FXML
    private JFXButton btn_UploadPassport, btn_Upload_LGForm, btn_Upload_IDCard;


    private String passportImage, lgImage, idCardImage;

    @FXML
    private ImageView passport_Image, idCard_Image, lgForm_Image;

    @FXML
    void upload_IDCard(ActionEvent event) {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        selectedIDCard = fc.showOpenDialog(null);
        if (selectedIDCard != null) {

            double bytes = selectedIDCard.length();
            double kilobytes = (bytes / 1024);
            idCardImage = Const.encodeFileToBase64Binary(selectedIDCard);
           // System.out.println(idCardImage);
            Image image = new Image(selectedIDCard.toURI().toString());
            idCard_Image.setImage(image);
            Document document = new Document();
            //documents.setApplicationNumber("Ap00"+(bvn_Step1.getText().trim()+phoneNo_Step1.getText().trim()));
            document.setBase64File(idCardImage);
            document.setFileName("IDCARD");
            documents.add(document);

        } else {
            errorLabel_Step5.setText("PLEASE CHOOSE A VALID ID CARD");
        }
    }

    @FXML
    void upload_LGForm(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        selectedLGForm = fc.showOpenDialog(null);

        if (selectedLGForm != null) {

            double bytes = selectedLGForm.length();
            double kilobytes = (bytes);
            lgImage = Const.encodeFileToBase64Binary(selectedLGForm);
            System.out.println(lgImage);
            Image image = new Image(selectedLGForm.toURI().toString());
            lgForm_Image.setImage(image);
            Document document = new Document();
            //documents.setApplicationNumber("Ap00"+(bvn_Step1.getText().trim()+phoneNo_Step1.getText().trim()));
            document.setBase64File(lgImage);
            document.setFileName("LOCAL GOVERNMENT ORIGIN");
            documents.add(document);
        } else {
            errorLabel_Step5.setText("PLEASE UPLOAD A VALID ID L.G FORM");
        }
    }

    @FXML
    void upload_Passport(ActionEvent event) {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        selectedPassport = fc.showOpenDialog(null);
        if (selectedPassport != null) {

            double bytes = selectedPassport.length();
            double kilobytes = (bytes / 1024);

            passportImage = Const.encodeFileToBase64Binary(selectedPassport);
            System.out.println(passportImage);
            Image image = new Image(selectedPassport.toURI().toString());
            passport_Image.setImage(image);
            Document document = new Document();
            //documents.setApplicationNumber("Ap00"+(bvn_Step1.getText().trim()+phoneNo_Step1.getText().trim()));
            document.setBase64File(passportImage);
            document.setFileName("PASSPORT");
            documents.add(document);

        } else {
            errorLabel_Step5.setText("PLEASE UPLOAD A VALID ID PASSPORT");
        }
    }
    ;
    
    
    
    /**
     * ******************************************************************************************************************
     * DECLEARING CONTENTS OF COMBO-BOX
     * ***************************************************************************************************************
     */
    ObservableList<String> gender = FXCollections.observableArrayList("Male", "Female");

    ObservableList<String> crimeConviction = FXCollections.observableArrayList("YES", "NO");

    ObservableList<String> lawAbiding = FXCollections.observableArrayList("YES", "NO");

    ObservableList<String> empowerOthers = FXCollections.observableArrayList("YES", "NO");

    ObservableList<String> alreadyABeneficiary = FXCollections.observableArrayList("YES", "NO");

    ObservableList<String> statusOfEmployment = FXCollections.observableArrayList("Employed", "Unemployed");

    ObservableList<String> cboxEmploymentStatusOfBeneficiary = FXCollections.observableArrayList("Employed", "Unemployed");

    ObservableList<String> alreadyExistingBussiness = FXCollections.observableArrayList("YES", "NO");

    ObservableList<String> areaOfIntrest = FXCollections.observableArrayList("Fast Foods", "Mobile Fast Foods", "Smoothie", "Fabrics Sale", "Confectionary", "Photography",
            "Business Center", "Farmer's Shop", "Photo Shop", "Female Mobile Photo Shop", "ICT", "Barbing Salon",
            "Tailoring/Fabrics", "Poultry", "Fish Farming", "Mobile Butchery", "Rice Mill", "Tractor Assembly",
            "Car Wash", "Mobile Sugarcane Juicing", "Tea/Noddles", "Mobile Milk Dispenser(Fura/Nono)", "Fresh Egg Delivery",
            "Mobile Fumigation", "Mobile Barbers", "Airtime Vending", "Irrigation", "Car Service Bay/Vulcanizing", "Shoe Making",
            "Welding/Metal Fabricating", "Tractor Mechanic");

    ObservableList<String> idType = FXCollections.observableArrayList("National Drivers Licence", "International Passport", "Voters Card", "National ID Card");

    ObservableList<String> beneficiaryIdType = FXCollections.observableArrayList("National Drivers Licence", "International Passport", "Voters Card", "National ID Card");

    ObservableList<String> qualification = FXCollections.observableArrayList("Masters Degree", "Bachelor Of Science(Bsc)", "Senior School Certificate", "Primary School Certificate");

    ObservableList<String> maritalStatus = FXCollections.observableArrayList("Single", "Married", "Divorced", "Widowed");

    ObservableList<String> states = FXCollections.observableArrayList("Abia", "Adamawa",
            "Akwa Ibom", "Anambra", "Bauchi", "Bayelsa", "Benue", "Borno", "Cross River", "Delta", "Ebonyi", "Edo", "Ekiti", "Enugu", "FCT",
            "Gombe", "Imo", "Jigawa", "Kaduna", "Kano", "Katsina", "Kebbi", "Kogi", "Kwara", "Lagos", "Nasarawa", "Niger",
            "Ogun", "Ondo", "Osun", "Oyo", "Plateau", "Rivers", "Sokoto", "Taraba", "Yobe", "Zamfara");

// ACTION TO SAVE DATA TO DATABASE     
    @FXML
    void saveToDataBase(ActionEvent event) {

        Applicant applicant = new Applicant();
        applicant.setBankName(bankName_Step1.getText().trim());
        applicant.setBankVerificationNumber(bvn_Step1.getText().trim());
        applicant.setEmailAddress(email_Step1.getText().trim());
        applicant.setApplicationNumber("Ap00" + (bvn_Step1.getText().trim() + phoneNo_Step1.getText().trim()));
        applicant.setStatus("NOT UPLOADED");
        applicant.setFirstName(firstName_Step1.getText().trim());
        applicant.setNokName(nokName_Step3.getText().trim());
        applicant.setNokAddress(nokAddress_Step3.getText().trim());
        applicant.setNokPhoneNumber(nokPhoneNo_Step3.getText().trim());
        applicant.setNokRelationship(nokRelationship_Step3.getText().trim());
        applicant.setMiddleName(middleName_Step1.getText().trim());
        applicant.setWardName(wardName_Step1.getText().trim());
        applicant.setLastName(lastName_Step1.getText().trim());
        applicant.setFormOfIdentification(cboxIDType.getSelectionModel().getSelectedItem());
        applicant.setGender(cboxGender.getSelectionModel().getSelectedItem());
        applicant.setIdentificationNumber(idCardNo_Step1.getText().trim());
        applicant.setMaritalStatus(cboxMaritalStatus.getSelectionModel().getSelectedItem());
        applicant.setPhoneNumber(phoneNo_Step1.getText().trim());
        applicant.setResidentialAddress(residentialAddress_Step1.getText().trim());
        applicant.setLocalGovOfRes(cboxLGA_2.getValue());
        applicant.setStateOfOrigin(cboxStates.getSelectionModel().getSelectedItem());
        applicant.setLocalGovOrigin(cboxLGA.getSelectionModel().getSelectedItem());
        applicant.setDob(DOB_Step1.getValue().toString());
        applicant.setStateOfResidence(cboxStates_ContactDetails.getSelectionModel().getSelectedItem());

        // dataBase.insertApplicant(applicant);
        AreaOfIntrest areaOfIntrest = new AreaOfIntrest();
        areaOfIntrest.setAreaOfIntrest(cboxAreaOfIntrest_Step4.getSelectionModel().getSelectedItem());
        areaOfIntrest.setEmpowerOthers(cboxEmpowerOthers_Step4.getSelectionModel().getSelectedItem());
        areaOfIntrest.setFirstName(firstName_Step4.getText().trim());
        areaOfIntrest.setApplicationNumber(applicant.getApplicationNumber());
        areaOfIntrest.setMiddleName(middleName_Step4.getText().trim());
        areaOfIntrest.setLastName(lastName_Step4.getText().trim());
        areaOfIntrest.setGender(cboxGender_Step4.getSelectionModel().getSelectedItem());
        areaOfIntrest.setMaritalStatus(cboxMaritalStatus_Step4.getSelectionModel().getSelectedItem());
        areaOfIntrest.setPhoneNumber(phoneNo_Step4.getText().trim());
        areaOfIntrest.setEmail(email_Step4.getText().trim());
        areaOfIntrest.setEmploymentStatus(cboxEmpStatOfBen_Step4.getSelectionModel().getSelectedItem());
        areaOfIntrest.setResidentialAddress(residentialAddress_Step4.getText().trim());
        areaOfIntrest.setdob_Beneficiary_Step4(DOB_Beneficiary_Step4.getValue().toString());
        areaOfIntrest.setIdType(cboxIDType_BeneficiaryStep4.getSelectionModel().getSelectedItem());
        areaOfIntrest.setIdNumber(idNumber_Step4.getText().trim());

        Employment employment = new Employment();
        employment.setAcademicQualification(cboxQualification_Step2.getSelectionModel().getSelectedItem());
        employment.setEmploymentStatus(cboxEmploymentStatus_Step2.getSelectionModel().getSelectedItem());
        employment.setBeneficiaryStatus(cboxAlreadyBeneficiary_Step2.getSelectionModel().getSelectedItem());
        employment.setExistingBusiness(cboxOwnBusiness_Step2.getSelectionModel().getSelectedItem());
        employment.setBusinessDescription(busDescription_Step2.getText().trim());
        employment.setApplicationNumber(applicant.getApplicationNumber());
        employment.setBusinessLocation(localGovBusiness.getValue()+ "  "+cboxBusStates_Step2.getSelectionModel().getSelectedItem());
        // dataBase.insertEmployment(employment);

//        Refree refree = new Refree();
//        refree.setRefName(refName_Step3.getText().trim());
//        refree.setRefAddress(refAddress_Step3.getText().trim());
//        refree.setRefPhoneNumber(refPhoneNo_Step3.getText().trim());
//        refree.setRefRelationship(refRelationship_Step3.getText().trim());
//        refree.setApplicationNumber(applicant.getApplicationNumber());
        CharacterAss characterAss = new CharacterAss();
        characterAss.setApplicationNumber(applicant.getApplicationNumber());
        characterAss.setCrimeConviction(cboxConvicted_Step5.getSelectionModel().getSelectedItem());
        characterAss.setCrimeDescription(crimeDescription_Step5.getText().trim());
        characterAss.setLawAbiding(cboxLawAbiding_Step5.getSelectionModel().getSelectedItem());

        String message = insertApplication(applicant, areaOfIntrest, employment, refereesList, characterAss, documents);
        System.out.println(message);
        appmessage.setText(message);

    }

    public void InsertFiles(Applicant applicant) {
        for (Document document : documents) {
            document.setApplicationNumber(applicant.getApplicationNumber());
            pdm.insertDocument(document);
        }
    }

    public void InsertFiles2(Applicant applicant) {
        for (Document document : documents) {
            document.setApplicationNumber(applicant.getApplicationNumber());
            pdm.updateDocuments(document);
        }
    }
     public void InsertRefree1(Applicant applicant) {
        for (Refree refereenow : refereesList) {
            refereenow.setApplicationNumber(applicant.getApplicationNumber());
            pdm.insertRefree(refereenow);
        }
    }

    public void InsertRefree2(Applicant applicant) {
        for (Refree refereenow : refereesList) {
            refereenow.setApplicationNumber(applicant.getApplicationNumber());
            pdm.updateRefree(refereenow);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //INITIALIZING COMBO-BOXES
        documents.clear();
        refereesList.clear();
        cboxIDType.setItems(idType);
        cboxConvicted_Step5.setItems(crimeConviction);
        cboxLawAbiding_Step5.setItems(lawAbiding);
        cboxGender.setItems(gender);
        cboxMaritalStatus.setItems(maritalStatus);
        cboxStates.setItems(states);
        cboxStates_ContactDetails.setItems(states);
        cboxIDType_BeneficiaryStep4.setItems(idType);
        cboxEmpowerOthers_Step4.setItems(empowerOthers);
        cboxGender_Step4.setItems(gender);
        cboxMaritalStatus_Step4.setItems(maritalStatus);
        cboxQualification_Step2.setItems(qualification);
        cboxOwnBusiness_Step2.setItems(alreadyExistingBussiness);
        cboxAlreadyBeneficiary_Step2.setItems(alreadyABeneficiary);
        cboxEmploymentStatus_Step2.setItems(statusOfEmployment);
        cboxEmpStatOfBen_Step4.setItems(cboxEmploymentStatusOfBeneficiary);
        cboxIDType_BeneficiaryStep4.setItems(beneficiaryIdType);
        cboxBusStates_Step2.setItems(states);
        cboxAreaOfIntrest_Step4.setItems(areaOfIntrest);

        dataBase = new PyesDataBase();
        progress_Step1.setDisable(false);
        progress_Step2.setDisable(true);
        progress_Step3.setDisable(true);
        progress_Step4.setDisable(true);
        progress_Step5.setDisable(true);

    }

    public String insertApplication(Applicant applicant, AreaOfIntrest areaOfIntrest,
            Employment employment, List<Refree> refrees, CharacterAss characterAss, List<Document> documents) {
        if (!pdm.isAppicantNumberExist(applicant.getApplicationNumber())) {
            //insert
            pdm.insertApplicant(applicant);
            pdm.insertAreaOfIntrest(areaOfIntrest);
            pdm.insertEmployment(employment);
            pdm.insertCharterAss(characterAss);
            InsertRefree1(applicant);
            InsertFiles(applicant);
           return "application was successful";
        }
        if (pdm.isAppicantNumberExist(applicant.getApplicationNumber())) {
            // update
            pdm.updateApplicant(applicant);
            pdm.updateAreaOfIntrest(areaOfIntrest);
            pdm.updateCharterAss(characterAss);
            pdm.updateEmployyment(employment);
            InsertFiles2(applicant);
            InsertRefree2(applicant);
               
            
            
        }

        return "something went wrong!!";
    }
    
    
     
      public void table2()
    {
        JFXTreeTableColumn<Refree2, String> name = new JFXTreeTableColumn<>("NAME");
        name.setPrefWidth(200);
        name.setCellValueFactory((TreeTableColumn.CellDataFeatures<Refree2, String> param) -> param.getValue().getValue().name);
        name.setStyle( "-fx-alignment: CENTER;");
        
        JFXTreeTableColumn<Refree2, String> phone = new JFXTreeTableColumn<>("PHONE NUMBER");
        phone.setPrefWidth(150);
        phone.setCellValueFactory((TreeTableColumn.CellDataFeatures<Refree2, String> param) -> param.getValue().getValue().phone);
        phone.setStyle( "-fx-alignment: CENTER;");
        
//        JFXTreeTableColumn<User2, String> quantity = new JFXTreeTableColumn<>("QUANTITY");
//        quantity.setPrefWidth(100);
//        quantity.setCellValueFactory((TreeTableColumn.CellDataFeatures<User2, String> param) -> param.getValue().getValue().QUANTITY);
//        quantity.setStyle( "-fx-alignment: CENTER;");
        
        ObservableList<Refree2> refrees2 = FXCollections.observableArrayList();
        refrees2.clear();
        for(Refree refree10:refereesList){
            refrees2.add(new Refree2(refree10.getRefName(),refree10.getRefPhoneNumber()));
        }
        
        final TreeItem<Refree2> root = new RecursiveTreeItem<>(refrees2, RecursiveTreeObject::getChildren);
        reTreeview.getColumns().setAll(name, phone);
        reTreeview.setRoot(root);
        reTreeview.setShowRoot(false);
    }

    @FXML
    private void onEmpStateClicked(ActionEvent event) {
    }

 class Refree2 extends RecursiveTreeObject<Refree2>{
        StringProperty name;
        StringProperty phone;
        public Refree2(String name, String phone) {
            this.name = new SimpleStringProperty(name);
            this.phone = new SimpleStringProperty(phone);
        }
    }           

}
