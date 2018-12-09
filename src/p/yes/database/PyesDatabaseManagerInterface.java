/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.yes.Database;

import java.sql.Connection;
import java.util.List;
import p.yes_Model.Applicant;
import p.yes_Model.AreaOfIntrest;
import p.yes_Model.CharacterAss;
import p.yes_Model.Document;
import p.yes_Model.Employment;
import p.yes_Model.Refree;
import p.yes_Model.dto.LoginDto;
import p.yes_Model.User;

/**
 *
 * @author Aniwange.TA
 */
public interface PyesDatabaseManagerInterface {
    Connection getConnection(Connection con);
    //create methods
    boolean  createApplicantTable();
    boolean createAreaOfIntrestTable();
    boolean createEmploymentTable();
    boolean createRefreeTable();
    boolean createDocumentsTable();
    boolean createCharacterAssTable();
    boolean createLogin();
    //insert methods
   
    Applicant  insertApplicant(Applicant applicant);
    AreaOfIntrest insertAreaOfIntrest(AreaOfIntrest areaOfIntrest);
    Refree insertRefree(Refree refree);
    Employment insertEmployment(Employment employment);
    Document  insertDocument(Document doc);
    CharacterAss insertCharterAss(CharacterAss  ch);
    User insertLogin(User user);
    
    
    //Updates
     
     String updateApplicant(Applicant applicant);
     String updateAreaOfIntrest(AreaOfIntrest areaOfIntrest);
     String updateRefree(Refree refree);
     String updateDocuments(Document doc);
     String updateEmployyment(Employment employment);
     String updateCharterAss(CharacterAss  ch);
     String updateLogin(User user);
     
    //finder methods
     List<Applicant> findAllApplicants();
     Applicant     findByIdApplicant(String id);
     CharacterAss getCharterAss(String applicatId);
     AreaOfIntrest findAreaOfIntrestTableByAppicantId(String appicantId);
     Employment findEmploymentByApplicationId(String appicantId);
     List<Refree>   findRefreeByApplicationId(String applicatId);
     List<Document> getAllFile(String applicatId);
     User LoginUser(LoginDto user);
     
     
    
    //checkers
   boolean isUserExist(User user);
   boolean isAppicantNumberExist(String applicationNumber);
   boolean isFormOfIdentificationExist(String formOfIdentification,String IdentificationNumber);
   boolean isSecondLevelPhoneFormOfIdExist(String phone, String formOfIdentificatin);
   boolean isUerExist(String userId);
    
   
}
