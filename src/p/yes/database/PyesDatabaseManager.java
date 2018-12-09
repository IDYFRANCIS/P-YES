/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.yes.Database;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import p.yes_Model.Applicant;
import p.yes_Model.AreaOfIntrest;
import p.yes_Model.CharacterAss;
import p.yes_Model.Document;
import p.yes_Model.Employment;
import p.yes_Model.Refree;
import p.yes_Model.dto.Biodata;
import p.yes_Model.dto.CharacterAssessment;
import p.yes_Model.dto.Contact;
import p.yes_Model.dto.Entrepreneurship;
import p.yes_Model.dto.File;
import p.yes_Model.dto.History;
import p.yes_Model.dto.LoginDto;
import p.yes_Model.dto.NextOfKin;
import p.yes_Model.dto.OfficerRegistration;
import p.yes_Model.dto.Referee;
import p.yes_Model.dto.SecondLevelBeneficiary;
import p.yes_Model.dto.UploadDto;
import p.yes_Model.User;

/**
 *
 * @author Aniwange.TA
 */
public class PyesDatabaseManager implements  PyesDatabaseManagerInterface{
     Connection con=null;
    public PyesDatabaseManager() {
        
    }
   

   //

    @Override
    public boolean createApplicantTable() {
        boolean status = false;
        System.err.println("working1");
        try {
            
           Statement statement = getConnection(con).createStatement();
             String sql = "CREATE TABLE IF NOT EXISTS applicant "
                    + "(applicationNumber CHAR(248) PRIMARY KEY , "
                    + "firstName CHAR(248) NOT NULL, "
                    + "middleName CHAR(248) NOT NULL, "
                    + "lastName CHAR(248) NOT NULL, "
                    + "gender CHAR(248) NOT NULL, "
                    + "maritalStatus CHAR(248) NOT NULL, "
                    + "stateOfOrigin CHAR(248) NOT NULL, "
                    + "localGovOrigin CHAR(248) NOT NULL, "
                    + "wardName CHAR(248) NOT NULL, "
                    + "formOfIdentification CHAR(248) NOT NULL, "
                    + "identificationNumber CHAR(248) NOT NULL, "
                    + "bankVerificationNumber CHAR(248) NOT NULL, "
                    + "bankName CHAR(248) NOT NULL, "
                    + "phoneNumber CHAR(248) NOT NULL, "
                    + "emailAddress CHAR(248) NOT NULL, "
                    + "status CHAR(248) NOT NULL, "
                    + "nokName CHAR(248) NOT NULL, "
                    + "nokPhoneNumber CHAR(248) NOT NULL, "
                    + "nokRelationship CHAR(248) NOT NULL, "
                    + "nokAddress CHAR(248) NOT NULL,"
                    + "stateOfResidence CHAR(248) NOT NULL, "
                    + "localGovOfRes CHAR(248) NOT NULL, "
                    + "dob CHAR(248) NOT NULL, "
                    + "residentialAddress CHAR(248) NOT NULL)";
            statement.execute(sql);
            statement.close();
            System.err.println("working");
            getConnection(con).close();
             return  true;
        } catch (Exception e) {
            errorMessage("createApplicantTable",e);
        }
        return status;
    }

   

    @Override
    public boolean createAreaOfIntrestTable() {
      boolean  status=false;
       System.err.println("working1");
      try{
           
            Statement statement = getConnection(con).createStatement();
           String sql = "CREATE TABLE IF NOT EXISTS areaOfIntrest "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "applicationNumber CHAR(248) NOT NULL, "
                    + "firstName CHAR(248) NOT NULL, "
                    + "middleName CHAR(248) NOT NULL, "
                    + "lastName CHAR(248) NOT NULL, "
                    + "gender CHAR(248) NOT NULL, "
                    + "maritalStatus CHAR(248) NOT NULL, "
                    + "phoneNumber CHAR(248) NOT NULL, "
                    + "empowerOthers CHAR(248) NOT NULL, "
                    + "areaOfIntrest CHAR(248) NOT NULL, "
                    + "email CHAR(248) NOT NULL, "
                    + "employmentStatus CHAR(248) NOT NULL, "
                    + "residentialAddress CHAR(248) NOT NULL,"
                    + "DOB_Beneficiary_Step4 CHAR(248) NOT NULL,"
                    + "idType CHAR(248) NOT NULL,"
                    + "idNumber CHAR(248) NOT NULL)";
            statement.execute(sql);
            statement.close();
            getConnection(con).close();
             System.err.println("working");
            return true;
      }catch(Exception e){
           errorMessage("createAreaOfIntrestTable",e); 
      }
      return status;
    }

    @Override
    public boolean createEmploymentTable() {
       boolean status=false;
      try{
           
            Statement statement = getConnection(con).createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS employment "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "applicationNumber CHAR(248) NOT NULL, "
                    + "academicQualification CHAR(248) NOT NULL, "
                    + "employmentStatus CHAR(248) NOT NULL, "
                    + "beneficiaryStatus CHAR(248) NOT NULL, "
                    + "existingBusiness CHAR(248) NOT NULL, "
                    + "businessDescription CHAR(248) NOT NULL, "
                    + "businessLocation CHAR(248) NOT NULL)";
            statement.execute(sql);
           statement.close();
           getConnection(con).close();
          return true;
      }catch(Exception e){
          errorMessage("createEmploymentTable", e);
      }
      return status;
    }

    @Override
    public boolean createRefreeTable() {
         boolean status=false;
      try{
          
            Statement statement = getConnection(con).createStatement();
           String sql = "CREATE TABLE IF NOT EXISTS refree "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "applicationNumber CHAR(248) NOT NULL, "
                    + "refName CHAR(248) NOT NULL, "
                    + "refAddress CHAR(248) NOT NULL, "
                    + "refPhoneNumber CHAR(248) NOT NULL, "
                    + "refRelationship CHAR(248) NOT NULL)";
           statement.execute(sql);
           statement.close();
          getConnection(con).close();
           return true;
      }catch(Exception e){
          errorMessage("createRefreeTable", e);
      }
      return status;
        
    }

      
     @Override
    public boolean createDocumentsTable() {
       boolean status = false;
       try{
             
            Statement statement = getConnection(con).createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS documents "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "applicationNumber CHAR(248) NOT NULL, "
                    + "base64File CHAR(248) NOT NULL, "
                    + "fileName CHAR(248) NOT NULL)"; 
           statement.execute(sql);
           statement.close();
           getConnection(con).close();
           return true;
      }catch(Exception e){
           errorMessage("createDocumentsTable", e);
      }
       return status;
    }

    @Override
    public boolean createCharacterAssTable() {
       try{
         
            
            Statement statement = getConnection(con).createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS characterAss "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "applicationNumber CHAR(248) NOT NULL, "
                    + "crimeConviction CHAR(248) NOT NULL, "
                    + "crimeDescription CHAR(248) NOT NULL, "
                    + "lawAbiding CHAR(248) NOT NULL)"; 
           statement.execute(sql);
           statement.close();
           getConnection(con).close();
           return true;
      }catch(Exception e){
           errorMessage("createCharacterAssTable", e);
      }
       return false;
    }
    
     @Override
    public boolean createLogin() {
        try{
            Statement statement = getConnection(con).createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS login "
                    + "(userId CHAR(248) PRIMARY KEY , "
                    + "email CHAR(248) NOT NULL, "
                    + "password CHAR(248) NOT NULL, "
                    + "role CHAR(248) NOT NULl)"; 
           statement.execute(sql);
           statement.close();
           getConnection(con).close();
           return true;
      }catch(Exception e){
           errorMessage("createLogin", e);
      }
       return false; 
    }

    ///
    
    
    
    
    
    @Override
    public Applicant insertApplicant(Applicant applicant) {
      try{
          getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(applicant.insertApplicantQuery());
           statement.close();
          getConnection(con).close();
          System.err.println("inserted applications");
          return applicant;
      }catch(Exception e){
          System.err.println("applicants"+e.getMessage());      
      }
      System.err.println("problem applications");
      return null;
    }

    @Override
    public AreaOfIntrest insertAreaOfIntrest(AreaOfIntrest areaOfIntrest) {
       try{
           getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(areaOfIntrest.insertAreaOfInterestQuery());
           statement.close();
           getConnection(con).close();
           return areaOfIntrest;   
      }catch(Exception e){
           System.err.println(e.getMessage());      
      }
         return null;   
    }

    @Override
    public Refree insertRefree(Refree refree) {
        try{
          getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(refree.insertRefreeQuery());
           statement.close();
           getConnection(con).close();
           return refree;   
      }catch(Exception e){
           System.err.println(e.getMessage());      
      }
         return null;       
    }

    @Override
    public Employment insertEmployment(Employment employment) {
        try{
            getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(employment.insertEmploymentQuery());
           statement.close();
           getConnection(con).close();
           return employment;   
      }catch(Exception e){
           System.err.println("insertEmployment :  "+e.getMessage());      
      }
         return null;       
    }
    
     @Override
    public Document insertDocument(Document doc) {
       try{
            getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(doc.insertDocumentQuery());
           statement.close();
           getConnection(con).close();
           return doc;   
      }catch(Exception e){
           System.err.println(e.getMessage());      
      }
         return null;  
    }
    
     @Override
    public CharacterAss insertCharterAss(CharacterAss ch) {
       try{
            getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(ch.insertCharacterAssQuery());
           statement.close();
           getConnection(con).close();
           return  ch;   
      }catch(Exception e){
           System.err.println(e.getMessage());      
      }
         return null;  
    }

    @Override
    public User insertLogin(User user) {
        try{
            getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(user.insertUserQuery());
           statement.close();
           getConnection(con).close();
           return user;   
      }catch(Exception e){
           System.err.println("insertLogin  : "+e.getMessage());      
      }
         return null;  
    }
  
     
    
    
    
    
 public void errorMessage(String methodName, Exception e) {
        System.err.println(e.getMessage()+" :  "+methodName+" : Something went wrong");
    }    

 
 /************************************************************
  *           Finder methods;
  * **********************************************************
  *           
  * ***********************************************************
  * @param id
  * @return 
  */
 
         @Override
    public List<Applicant> findAllApplicants() {
        List<Applicant> apllList=new ArrayList<>();
             try {
                 String sql="SELECT * FROM applicant";
                 Statement statement = getConnection(con).createStatement();
                 ResultSet rs=statement.executeQuery(sql);
                 Applicant ap = new Applicant();
                  while(rs.next()){
                     ap.setApplicationNumber(rs.getString("applicationNumber"));
                     //ap.setUserId(rs.getString("userId"));
                     ap.setFirstName(rs.getString("firstName"));
                     ap.setMiddleName(rs.getString("middleName"));
                     ap.setGender(rs.getString("gender"));
                     ap.setMaritalStatus(rs.getString("maritalStatus"));
                     ap.setStateOfOrigin(rs.getString("stateOfOrigin"));
                     ap.setWardName(rs.getString("wardName"));
                     ap.setFormOfIdentification(rs.getString("formOfIdentification"));
                     ap.setIdentificationNumber(rs.getString("identificationNumber"));
                     ap.setBankVerificationNumber(rs.getString("bankVerificationNumber"));
                     ap.setBankName(rs.getString("bankName"));
                     ap.setPhoneNumber(rs.getString("phoneNumber"));
                     ap.setEmailAddress(rs.getString("emailAddress"));
                     ap.setStateOfResidence(rs.getString("stateOfResidence"));
                     ap.setDob(rs.getString("dob"));
                     ap.setResidentialAddress(rs.getString("residentialAddress"));
                     ap.setStatus(rs.getString("status"));
                     apllList.add(ap);
                 }
                statement.close();
                getConnection(con).close(); 
                return apllList;
             } catch (Exception e) {
                 System.err.println(e.getMessage());
             }
     return  null;
    }
    
     public List<Applicant> findAllApplicantsNotUploaded() {
        List<Applicant> apllList=new ArrayList<>();
             try {
                 String sql="SELECT * FROM applicant WHERE status=" +"\'"+"NOT UPLOADED"+ "\'";
                 Statement statement = getConnection(con).createStatement();
                 ResultSet rs=statement.executeQuery(sql);
                 Applicant ap = new Applicant();
                  while(rs.next()){
                     ap.setApplicationNumber(rs.getString("applicationNumber"));
                     //ap.setUserId(rs.getString("userId"));
                     ap.setFirstName(rs.getString("firstName"));
                     ap.setMiddleName(rs.getString("middleName"));
                     ap.setGender(rs.getString("gender"));
                     ap.setMaritalStatus(rs.getString("maritalStatus"));
                     ap.setStateOfOrigin(rs.getString("stateOfOrigin"));
                     ap.setWardName(rs.getString("wardName"));
                     ap.setFormOfIdentification(rs.getString("formOfIdentification"));
                     ap.setIdentificationNumber(rs.getString("identificationNumber"));
                     ap.setBankVerificationNumber(rs.getString("bankVerificationNumber"));
                     ap.setBankName(rs.getString("bankName"));
                     ap.setPhoneNumber(rs.getString("phoneNumber"));
                     ap.setEmailAddress(rs.getString("emailAddress"));
                     ap.setStateOfResidence(rs.getString("stateOfResidence"));
                     ap.setDob(rs.getString("dob"));
                     ap.setResidentialAddress(rs.getString("residentialAddress"));
                     ap.setStatus(rs.getString("status"));
                     apllList.add(ap);
                 }
                statement.close();
                getConnection(con).close(); 
                return apllList;
             } catch (Exception e) {
                 System.err.println(e.getMessage());
             }
     return  null;
    }
     public List<Applicant> findAllApplicantsUploaded() {
        List<Applicant> apllList=new ArrayList<>();
             try {
                 String sql="SELECT * FROM applicant WHERE status=" +"\'"+"UPLOADED"+ "\'";
                 Statement statement = getConnection(con).createStatement();
                 ResultSet rs=statement.executeQuery(sql);
                 Applicant ap = new Applicant();
                  while(rs.next()){
                     ap.setApplicationNumber(rs.getString("applicationNumber"));
                     //ap.setUserId(rs.getString("userId"));
                     ap.setFirstName(rs.getString("firstName"));
                     ap.setMiddleName(rs.getString("middleName"));
                     ap.setGender(rs.getString("gender"));
                     ap.setMaritalStatus(rs.getString("maritalStatus"));
                     ap.setStateOfOrigin(rs.getString("stateOfOrigin"));
                     ap.setWardName(rs.getString("wardName"));
                     ap.setFormOfIdentification(rs.getString("formOfIdentification"));
                     ap.setIdentificationNumber(rs.getString("identificationNumber"));
                     ap.setBankVerificationNumber(rs.getString("bankVerificationNumber"));
                     ap.setBankName(rs.getString("bankName"));
                     ap.setPhoneNumber(rs.getString("phoneNumber"));
                     ap.setEmailAddress(rs.getString("emailAddress"));
                     ap.setStateOfResidence(rs.getString("stateOfResidence"));
                     ap.setDob(rs.getString("dob"));
                     ap.setResidentialAddress(rs.getString("residentialAddress"));
                     ap.setStatus(rs.getString("status"));
                     apllList.add(ap);
                 }
                statement.close();
                getConnection(con).close(); 
                return apllList;
             } catch (Exception e) {
                 System.err.println(e.getMessage());
             }
     return  null;
    }
    
    @Override
    public Applicant findByIdApplicant(String id) {
       try {
                 String sql="SELECT * FROM applicant WHERE applicationNumber="+"\'"+id+ "\'";
                 Statement statement = getConnection(con).createStatement();
                 ResultSet rs=statement.executeQuery(sql);
                 Applicant ap=new Applicant();
                 while(rs.next()){
                    
                     ap.setApplicationNumber(rs.getString("applicationNumber"));
                     //ap.setUserId(rs.getString("userId"));
                     ap.setFirstName(rs.getString("firstName"));
                     ap.setMiddleName(rs.getString("middleName"));
                     ap.setGender(rs.getString("gender"));
                     ap.setMaritalStatus(rs.getString("maritalStatus"));
                     ap.setStateOfOrigin(rs.getString("stateOfOrigin"));
                     ap.setWardName(rs.getString("wardName"));
                     ap.setFormOfIdentification(rs.getString("formOfIdentification"));
                     ap.setIdentificationNumber(rs.getString("identificationNumber"));
                     ap.setBankVerificationNumber(rs.getString("bankVerificationNumber"));
                     ap.setBankName(rs.getString("bankName"));
                     ap.setPhoneNumber(rs.getString("phoneNumber"));
                     ap.setEmailAddress(rs.getString("emailAddress"));
                     ap.setNokName(rs.getString("nokName"));
                     ap.setNokAddress(rs.getString("nokAddress"));
                     ap.setNokRelationship(rs.getString("nokRelationship"));
                     ap.setNokPhoneNumber("nokPhoneNumber");
                     ap.setStateOfResidence(rs.getString("stateOfResidence"));
                     ap.setDob(rs.getString("dob"));
                     ap.setStatus(rs.getString("status"));
                     ap.setResidentialAddress(rs.getString("residentialAddress"));
                 
                 }
                statement.close();
                getConnection(con).close();  
                 return  ap;
             } catch (Exception e) {
                 System.err.println(e.getMessage());
             }
      return  null;   
    }

    @Override
    public AreaOfIntrest findAreaOfIntrestTableByAppicantId(String appicantId) {
        try {
                 String sql="SELECT * FROM areaOfIntrest WHERE applicationNumber=" +"\'"+appicantId+ "\'";
                 Statement statement =getConnection(con).createStatement();
                 ResultSet rs=statement.executeQuery(sql);
                 AreaOfIntrest areaOfIntrest = new AreaOfIntrest();
                 while(rs.next()){
                     
                     areaOfIntrest.setApplicationNumber(rs.getString("applicationNumber"));
                     //areaOfIntrest.setUserId(rs.getString("userId"));
                     areaOfIntrest.setFirstName(rs.getString("firstName"));
                     areaOfIntrest.setMaritalStatus(rs.getString("middleName"));
                     areaOfIntrest.setGender(rs.getString("gender"));
                     areaOfIntrest.setMaritalStatus(rs.getString("maritalStatus"));
                     areaOfIntrest.setPhoneNumber(rs.getString("phoneNumber"));
                     areaOfIntrest.setAreaOfIntrest("areaOfIntrest");
                     areaOfIntrest.setResidentialAddress("residentialAddress");
                     areaOfIntrest.setEmploymentStatus("employmentStatus");
                     areaOfIntrest.setEmail("email");
                     areaOfIntrest.setIdType("idType");
                     areaOfIntrest.setIdNumber("idNumber");
                     areaOfIntrest.setEmpowerOthers("empowerOthers");
                                
                   
                 }
                statement.close();
                getConnection(con).close(); 
                return areaOfIntrest;
             } catch (Exception e) {
                 System.err.println(e.getMessage());
             }
      return  null;   
    }

    @Override
    public Employment findEmploymentByApplicationId(String appicantId) {
        try {
           
            String sql = "SELECT * FROM employment WHERE applicationNumber=" + "\'" +appicantId + "\'";
            Statement statement =getConnection(con).createStatement();
            ResultSet rs = statement.executeQuery(sql);
             Employment emp = new Employment();
            while (rs.next()) {
                emp.setApplicationNumber(rs.getString("applicationNumber"));
                emp.setBeneficiaryStatus(rs.getString("beneficiaryStatus"));
                emp.setAcademicQualification(rs.getString("academicQualification"));
                emp.setExistingBusiness(rs.getString("existingBusiness"));
                emp.setBusinessLocation(rs.getString("businessLocation"));
                emp.setEmploymentStatus(rs.getString("employmentStatus"));

              
            }
            statement.close();
            getConnection(con).close();
            return emp;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Refree> findRefreeByApplicationId(String applicationId) {
        try {
            List<Refree> rlist=new ArrayList<>();
            String sql = "SELECT * FROM refree WHERE applicationNumber=" + "\'" + applicationId+ "\'";
            Statement statement = getConnection(con).createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Refree refree = new Refree();

                refree.setApplicationNumber(rs.getString("applicationNumber"));
                //refree.setUserId(rs.getString("userId"));
                refree.setRefName(rs.getString("refName"));
                refree.setRefAddress(rs.getString("refAddress"));
                refree.setRefPhoneNumber(rs.getString("refPhoneNumber"));
                refree.setRefRelationship(rs.getString("refRelationship"));
                
                rlist.add(refree);
               
            }
            statement.close();
            getConnection(con).close();
            return rlist;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
 
  

    public boolean checkBusinessStatus(Employment employment) {
        boolean  isbusinessExisting=false;
        if(employment.getExistingBusiness().equalsIgnoreCase("yes")){
            isbusinessExisting=true;
        }
        return isbusinessExisting;
    }

    @Override
    public List<Document> getAllFile(String applicantId) {
        try{
           String sql = "SELECT * FROM document WHERE applicationNumber=" + "\'" + applicantId + "\'";
            Statement statement =getConnection(con).createStatement();
            ResultSet rs = statement.executeQuery(sql);
            List<Document> documents=new ArrayList<>();
            while (rs.next()) {
                Document document = new Document();
                document.setApplicationNumber(rs.getString("applicationNumber"));
                document.setBase64File(rs.getString("base64File"));
                document.setFileName("fileName");
                
                documents.add(document);  
            }
            statement.close();
            getConnection(con).close();
            return documents;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public CharacterAss getCharterAss(String applicantId) {
       try { 
            Statement statement = getConnection(con).createStatement();
            String sql = "SELECT * FROM characterAss WHERE applicationNumber=" + "\'" + applicantId + "\'";
            ResultSet rs = statement.executeQuery(sql);
            CharacterAss characterAss = new CharacterAss();
            while (rs.next()) {    
            characterAss.setApplicationNumber(rs.getString("applicationNumber"));
            characterAss.setCrimeConviction(rs.getString("crimeConviction"));
            characterAss.setCrimeDescription(rs.getString("crimeDescription"));
            characterAss.setLawAbiding(rs.getString("lawAbiding"));   
            }
            statement.close();
            getConnection(con).close();
            return characterAss;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    //
    
     @Override
    public Connection getConnection(Connection con) {
       try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:pyes.db");
           // con.setAutoCommit(false);
           return con;
        } catch (Exception e) {
           System.err.println("getConnection: "+ e.getMessage());
        }
        return null;
    }

   
  

   


    @Override
    public boolean isUserExist(User user) {
        System.out.println("api id : "+user.getUserid());
        try{
          String sql = "SELECT * FROM  login WHERE userId="+"\'"+user.getUserid() + "\'" + "AND password="+"\'"+user.getPassword()+"\'";
           Statement statement =getConnection(con).createStatement();
           ResultSet rs = statement.executeQuery(sql);
           String userIdLocal=" ";
            boolean status=false;
             while(rs.next()){
                  userIdLocal =rs.getString("userId");   
                  System.err.println("userIdLocal db :" + userIdLocal);
           if(user.getUserid().trim().equalsIgnoreCase(userIdLocal)){
               System.out.println("user found");
               return true;
            }
            }
          
          return status;
        }
        catch(Exception e){
                    
              System.err.println("error:"+ e.getMessage());      
         } 
    System.out.println(" not user found"); 
    return false;
    }

    @Override
    public boolean isAppicantNumberExist(String applicationNumber) {
         try{
          String sql = "SELECT * FROM  applicant WHERE applicationNumber=" + "\'" +applicationNumber+ "\'" ;
            Statement statement =getConnection(con).createStatement();
            ResultSet rs = statement.executeQuery(sql);
            String applicationNumberDb=" ";
             while(rs.next()){
                 applicationNumberDb =rs.getString("applicationNumber");
                   
             }
             if(applicationNumberDb.equals(applicationNumber) ){
                 System.out.println("applicant found"); 
                 return true;
             }
             
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
          
       System.out.println("applicant  not found"); 
        return false;
    }

    @Override
    public boolean isFormOfIdentificationExist(String formOfIdentification, String IdentificationNumber) {
        //selecting from applicants
         try{
          String sql = "SELECT * FROM  applicant WHERE identificationNumber=" + "\'" +IdentificationNumber+ "\'" + " AND formOfIdentification="+"\'"+formOfIdentification+"\'";
             Statement statement =getConnection(con).createStatement();
             ResultSet rs = statement.executeQuery(sql);
             String idNumberDb=null;
             String idTypeDb=null;
             while(rs.next()){
                  idNumberDb=rs.getString("identificationNumber");
                  System.out.println("ndm amos"+idNumberDb);
                  idTypeDb=rs.getString("formOfIdentification");  
             }
             if(idNumberDb.equals(IdentificationNumber) && idTypeDb.equalsIgnoreCase(formOfIdentification)){
                 System.out.println("applicant found"); 
                 return true;
             }
             
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
          
       System.out.println("applicant  not found"); 
        return false;
    }

    @Override
    public boolean isSecondLevelPhoneFormOfIdExist(String phone, String formOfIdentificatin) {
          //Selecting from areaofinterestable
          try{
          String sql = "SELECT * FROM areaOfIntrest WHERE phoneNumber=" + "\'" +phone+ "\'" + " AND idType="+"\'"+formOfIdentificatin+"\'";
             Statement statement =getConnection(con).createStatement();
             ResultSet rs = statement.executeQuery(sql);
             String phoneDb=null;
             String idTypeDb=null;
             while(rs.next()){
                  phoneDb=rs.getString("phoneNumber");
                  idTypeDb=rs.getString("idType");  
             }
             if(phoneDb.equals(phone) && idTypeDb.equalsIgnoreCase(formOfIdentificatin)){
                 System.out.println("beneficially already exist"); 
                 return true;
             }
             
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
          
       System.out.println("beneficially  not found"); 
        return false;
    }

   

   
    
     public UploadDto uploadApplicant(String applicantId){
         UploadDto uploadDto = new UploadDto();
       OfficerRegistration officerRegistration = new OfficerRegistration();
       List<OfficerRegistration> officers=new ArrayList<>();
       Biodata biodata = new Biodata();
       CharacterAssessment characterAssessment = new CharacterAssessment();
       Contact contact = new Contact();
       Entrepreneurship entrepreneurship = new Entrepreneurship();
       File file = new File();
       List<File> files=new ArrayList<>();
       History history = new History();
       NextOfKin nextOfKin = new NextOfKin();
       List<Referee> refrees = new  ArrayList<>();
       SecondLevelBeneficiary secondLevelBeneficiary = new SecondLevelBeneficiary();
       
        Applicant applicant=new Applicant();
        applicant=findByIdApplicant(applicantId);
       
     
       
            // populate biodata
           biodata.setBankName(applicant.getBankName());
           biodata.setBankVerificationNumber(applicant.getBankVerificationNumber());
         //  biodata.setDateOfBirth(Integer.valueOf(applicant.getDob()));
           biodata.setFirstName(applicant.getFirstName());
           biodata.setFormOfIdentification(applicant.getFormOfIdentification());
           biodata.setGender(applicant.getGender());
           biodata.setIdentificationNumber(applicant.getIdentificationNumber());
           biodata.setLastName(applicant.getLastName());
           biodata.setLocalGovOrigin(applicant.getLocalGovOrigin());
           biodata.setMaritalStatus(applicant.getMaritalStatus());
           biodata.setMiddleName(applicant.getMiddleName());
           biodata.setStateOfOrigin(applicant.getStateOfOrigin());
           biodata.setWardName(applicant.getWardName());
           
           //populate characterAssessment
           //not find yet
           CharacterAss characterAss=getCharterAss(applicant.getApplicationNumber());
           characterAssessment.setCrimeConvicted(characterAss.getCrimeDescription());
           boolean crimeStatus=false;
           if(characterAss.getCrimeConviction().equalsIgnoreCase("yes")){
               crimeStatus=true;
           }
           characterAssessment.setCriminalConvictionStatus(crimeStatus);
           characterAssessment.setLawAbiding(characterAss.getLawAbiding());
           
           
           //populate contact
           contact.setEmailAddress(applicant.getEmailAddress());
           contact.setLocalGovResidence(applicant.getLocalGovOrigin());
           contact.setPhoneNumber(applicant.getPhoneNumber());
           contact.setResidentialAddress(applicant.getResidentialAddress());
           contact.setStateOfResidence(applicant.getStateOfResidence());
          
           
          // populate  entrepreneurship
           AreaOfIntrest areaOfIntrest=findAreaOfIntrestTableByAppicantId(applicant.getApplicationNumber());
           
           Employment employment=findEmploymentByApplicationId(applicant.getApplicationNumber());
           System.out.println("empoyment Status:  "+ employment.getEmploymentStatus());
           entrepreneurship.setAreaOfInterest(areaOfIntrest.getAreaOfIntrest());
           entrepreneurship.setBusinesState(employment.getBusinessLocation());
           entrepreneurship.setBusinessLocation(employment.getBusinessLocation());
           entrepreneurship.setBusinessDescription(employment.getBusinessDescription());
           boolean  isbusinessExisting=checkBusinessStatus(employment);
           entrepreneurship.setExistingBusiness(isbusinessExisting);
    
           //populate file
          
           
           //not yet
           
//            List<Document> documents=getAllFile(applicant.getApplicationNumber());
//            List<File> files=new ArrayList<>();
//            
//            for(Document document:documents){
//                file.setBase64File(document.getBase64File());
//                file.setFileName(document.getBase64File());
//                files.add(file);
//            }
           
           //populate Refree
           List<Refree>  Listrf=findRefreeByApplicationId(applicant.getApplicationNumber());
           Referee referee=new Referee();
           for(Refree rf:Listrf){
           referee.setAddress(rf.getRefAddress());
           referee.setFullName(rf.getRefName());
           referee.setPhoneNumber(rf.getRefPhoneNumber());
           referee.setRelationship(rf.getRefRelationship());
           refrees.add(referee);
           }
           //populate history 
           history.setAcademicQualification(employment.getAcademicQualification());
           history.setApplicantProgramName("desktopTest");
           history.setBeneficiaryStatus(employment.getBeneficiaryStatus());
           history.setEmploymentStatus(employment.getEmploymentStatus());
           
           //populate nextOfKin
           Refree refereeLocal=Listrf.get(0);
           nextOfKin.setAddress(applicant.getNokAddress());
           nextOfKin.setFullName(applicant.getNokName());
           nextOfKin.setPhoneNumber(applicant.getNokPhoneNumber());
           nextOfKin.setRelationship(applicant.getNokRelationship());
           
           
           
           //populate SecondLevelBeneficiary
          
            secondLevelBeneficiary.setDateOfBirth(applicant.getDobBeneficiaryStep4());
            secondLevelBeneficiary.setEmailAddress(areaOfIntrest.getEmail());
            secondLevelBeneficiary.setEmploymentStatus(employment.getEmploymentStatus());
            secondLevelBeneficiary.setExistingBeneficiary(employment.getBeneficiaryStatus());
            secondLevelBeneficiary.setFirstName(areaOfIntrest.getFirstName());
            secondLevelBeneficiary.setFormOfIdentification(areaOfIntrest.getIdType());
            secondLevelBeneficiary.setGender(areaOfIntrest.getGender());
            secondLevelBeneficiary.setIndentificationNumber(areaOfIntrest.getIdNumber());
            secondLevelBeneficiary.setLastName(areaOfIntrest.getLastName());
            secondLevelBeneficiary.setMaritalStatus(areaOfIntrest.getMaritalStatus());
            secondLevelBeneficiary.setMiddleName(areaOfIntrest.getMiddleName());
            secondLevelBeneficiary.setPhoneNumber(areaOfIntrest.getPhoneNumber());
            secondLevelBeneficiary.setResidentialAddress(areaOfIntrest.getResidentialAddress());
            secondLevelBeneficiary.setSlbBeneficiaryStatus(employment.getBeneficiaryStatus());
            secondLevelBeneficiary.setSlbProgram(areaOfIntrest.getAreaOfIntrest());
            
           //pouplate the registration object
           
           officerRegistration.setApplicationNumber(applicant.getApplicationNumber());
           officerRegistration.setBiodata(biodata);
           officerRegistration.setCharacterAssessment(characterAssessment);
           officerRegistration.setContact(contact);
           officerRegistration.setFiles(files);
           officerRegistration.setEntrepreneurship(entrepreneurship);
           
           officerRegistration.setHistory(history);
           officerRegistration.setNextOfKin(nextOfKin);
           officerRegistration.setReferees(refrees);
           officerRegistration.setSecondLevelBeneficiary(secondLevelBeneficiary);
           String officerId=applicant.getApplicationNumber()+applicant.getBankVerificationNumber();
           String uerid=officerId+applicant.getBankVerificationNumber();
           officerRegistration.setOfficerID(officerId);
           officerRegistration.setUserId(uerid);
           officers.add(officerRegistration);
           
           
       
       uploadDto.setOfficerRegistration(officers);
       return uploadDto;
     }
     
      public UploadDto uploadApplicants(){
       UploadDto uploadDto = new UploadDto();
       OfficerRegistration officerRegistration = new OfficerRegistration();
       List<OfficerRegistration> officers=new ArrayList<>();
       Biodata biodata = new Biodata();
       CharacterAssessment characterAssessment = new CharacterAssessment();
       Contact contact = new Contact();
       Entrepreneurship entrepreneurship = new Entrepreneurship();
       File file = new File();
       History history = new History();
       NextOfKin nextOfKin = new NextOfKin();
       List<Referee> refrees = new  ArrayList<>();
       SecondLevelBeneficiary secondLevelBeneficiary = new SecondLevelBeneficiary();
       
       List<Applicant> applicatsList=new ArrayList<>();
       
      applicatsList.addAll(findAllApplicants());
       for(Applicant applicant:applicatsList){
            // populate biodata
           biodata.setBankName(applicant.getBankName());
           biodata.setBankVerificationNumber(applicant.getBankVerificationNumber());
         //  biodata.setDateOfBirth(Integer.valueOf(applicant.getDob()));
           biodata.setFirstName(applicant.getFirstName());
           biodata.setFormOfIdentification(applicant.getFormOfIdentification());
           biodata.setGender(applicant.getGender());
           biodata.setIdentificationNumber(applicant.getIdentificationNumber());
           biodata.setLastName(applicant.getLastName());
           biodata.setLocalGovOrigin(applicant.getLocalGovOrigin());
           biodata.setMaritalStatus(applicant.getMaritalStatus());
           biodata.setMiddleName(applicant.getMiddleName());
           biodata.setStateOfOrigin(applicant.getStateOfOrigin());
           biodata.setWardName(applicant.getWardName());
           
           //populate characterAssessment
           //not find yet
           CharacterAss characterAss=getCharterAss(applicant.getApplicationNumber());
           characterAssessment.setCrimeConvicted(characterAss.getCrimeDescription());
           boolean crimeStatus=false;
           if(characterAss.getCrimeConviction().equalsIgnoreCase("yes")){
               crimeStatus=true;
           }
           characterAssessment.setCriminalConvictionStatus(crimeStatus);
           characterAssessment.setLawAbiding(characterAss.getLawAbiding());
           
           
           //populate contact
           contact.setEmailAddress(applicant.getEmailAddress());
           contact.setLocalGovResidence(applicant.getLocalGovOrigin());
           contact.setPhoneNumber(applicant.getPhoneNumber());
           contact.setResidentialAddress(applicant.getResidentialAddress());
           contact.setStateOfResidence(applicant.getStateOfResidence());
          
           
          // populate  entrepreneurship
           AreaOfIntrest areaOfIntrest=findAreaOfIntrestTableByAppicantId(applicant.getApplicationNumber());
           Employment employment=findEmploymentByApplicationId(applicant.getApplicationNumber());
           entrepreneurship.setAreaOfInterest(areaOfIntrest.getAreaOfIntrest());
           entrepreneurship.setBusinesState(employment.getBusinessLocation());
           entrepreneurship.setBusinessLocation(employment.getBusinessLocation());
           entrepreneurship.setBusinessDescription(employment.getBusinessDescription());
           boolean  isbusinessExisting=checkBusinessStatus(employment);
           entrepreneurship.setExistingBusiness(isbusinessExisting);
    
           //populate file
          
           
           //not yet
           
            List<Document> documents=getAllFile(applicant.getApplicationNumber());
            List<File> files=new ArrayList<>();
            
            for(Document document:documents){
                file.setBase64File(document.getBase64File());
                file.setFileName(document.getBase64File());
                files.add(file);
            }
           
           //populate Refree
           List<Refree>  Listrf=findRefreeByApplicationId(applicant.getApplicationNumber());
           Referee referee=new Referee();
           for(Refree rf:Listrf){
           referee.setAddress(rf.getRefAddress());
           referee.setFullName(rf.getRefName());
           referee.setPhoneNumber(rf.getRefPhoneNumber());
           referee.setRelationship(rf.getRefRelationship());
           refrees.add(referee);
           }
           //populate history 
           history.setAcademicQualification(employment.getAcademicQualification());
           history.setApplicantProgramName("desktopTest");
           history.setBeneficiaryStatus(employment.getBeneficiaryStatus());
           history.setEmploymentStatus(employment.getEmploymentStatus());
           
           //populate nextOfKin
          // Refree refereeLocal=Listrf.get(0);
           nextOfKin.setAddress(applicant.getNokAddress());
           nextOfKin.setFullName(applicant.getNokName());
           nextOfKin.setPhoneNumber(applicant.getNokPhoneNumber());
           nextOfKin.setRelationship(applicant.getNokRelationship());
           
           
           
           //populate SecondLevelBeneficiary
          
            secondLevelBeneficiary.setDateOfBirth(applicant.getDobBeneficiaryStep4());
            secondLevelBeneficiary.setEmailAddress(areaOfIntrest.getEmail());
            secondLevelBeneficiary.setEmploymentStatus(areaOfIntrest.getEmploymentStatus());
            secondLevelBeneficiary.setExistingBeneficiary("");
            secondLevelBeneficiary.setFirstName(areaOfIntrest.getFirstName());
            secondLevelBeneficiary.setFormOfIdentification(areaOfIntrest.getIdType());
            secondLevelBeneficiary.setGender(areaOfIntrest.getGender());
            secondLevelBeneficiary.setIndentificationNumber(areaOfIntrest.getIdNumber());
            secondLevelBeneficiary.setLastName(areaOfIntrest.getLastName());
            secondLevelBeneficiary.setMaritalStatus(areaOfIntrest.getMaritalStatus());
            secondLevelBeneficiary.setMiddleName(areaOfIntrest.getMiddleName());
            secondLevelBeneficiary.setPhoneNumber(areaOfIntrest.getPhoneNumber());
            secondLevelBeneficiary.setResidentialAddress(areaOfIntrest.getResidentialAddress());
            secondLevelBeneficiary.setSlbBeneficiaryStatus(areaOfIntrest.getEmploymentStatus());
            secondLevelBeneficiary.setSlbProgram(areaOfIntrest.getAreaOfIntrest());
            
           //pouplate the registration object
           
           officerRegistration.setApplicationNumber(applicant.getApplicationNumber());
           officerRegistration.setBiodata(biodata);
           officerRegistration.setCharacterAssessment(characterAssessment);
           officerRegistration.setContact(contact);
           officerRegistration.setFiles(files);
           officerRegistration.setEntrepreneurship(entrepreneurship);
           
           officerRegistration.setHistory(history);
           officerRegistration.setNextOfKin(nextOfKin);
           officerRegistration.setReferees(refrees);
           officerRegistration.setSecondLevelBeneficiary(secondLevelBeneficiary);
           String officerId=applicant.getApplicationNumber()+applicant.getBankVerificationNumber();
           String uerid=officerId+applicant.getBankVerificationNumber();
           officerRegistration.setOfficerID(" RO1543839126404");
           officerRegistration.setUserId(uerid);
           officers.add(officerRegistration);
           
           
       }
       uploadDto.setOfficerRegistration(officers);
       return uploadDto;
    }

    @Override
    public boolean isUerExist(String userId) {
         try {
                 String sql="SELECT * FROM login WHERE userId="+"\'"+userId+ "\'";
                 Statement statement = getConnection(con).createStatement();
                 ResultSet rs=statement.executeQuery(sql);
                 while(rs.next()){
                   if(rs.getString("userId").equalsIgnoreCase(userId)) {
                        return true;
                    }
                 }
                 
           }catch(Exception e){
                    System.err.println("isUerExist  "+ e.getMessage());     
             return false;          
                        
           
           }
       return false;
        
    }

    @Override
    public String updateApplicant(Applicant applicant) {
         try{
           getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(applicant.updateQuery());
           statement.close();
           getConnection(con).close();
           return "successful";
      }catch(Exception e){
          System.err.println(e.getMessage());      
      }
      return null;
    }

    @Override
    public String updateAreaOfIntrest(AreaOfIntrest areaOfIntrest) {
       try{
           getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(areaOfIntrest.updateQuery());
           statement.close();
           getConnection(con).close();
           return "successful";
      }catch(Exception e){
          System.err.println(e.getMessage());      
      }
      return null;
    }

    @Override
    public String updateRefree(Refree refree) {
        try{
           getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(refree.updateQuery());
           statement.close();
           getConnection(con).close();
           return "successful";
      }catch(Exception e){
          System.err.println(e.getMessage());      
      }
      return null; 
    }

    @Override
    public String updateDocuments(Document doc) {
        try{
           getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(doc.updateQuery());
           statement.close();
           getConnection(con).close();
           return "successful";
      }catch(Exception e){
          System.err.println(e.getMessage());      
      }
      return null;
    }

    @Override
    public String updateEmployyment(Employment employment) {
        try{
           getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(employment.updateQuery());
           statement.close();
           getConnection(con).close();
           return "successful";
      }catch(Exception e){
          System.err.println(e.getMessage());      
      }
      return null;
    }

    @Override
    public String updateCharterAss(CharacterAss ch) {
        try{
           getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(ch.updateQuery());
           statement.close();
           getConnection(con).close();
           return "successful";
      }catch(Exception e){
          System.err.println(e.getMessage());      
      }
      return null;
    }

    @Override
    public String updateLogin(User user) {
        try{
           getConnection(con).setAutoCommit(false);
           Statement statement = getConnection(con).createStatement();
           statement.execute(user.updateQuery());
           statement.close();
           getConnection(con).close();
           return "successful";
      }catch(Exception e){
          System.err.println(e.getMessage());      
      }
      return null;
    }

   public  String encodeString(String todecode) {
        String encode = "";
        try {
            encode= Base64.getEncoder().encodeToString(todecode.getBytes("utf-8"));
             return encode;
        } catch (UnsupportedEncodingException ex) {
        }

        //System.out.println("decode");
        return null;
    }

    /**
     *
     * @param storePassword
     * @return
     */
    public String getDecode(String storePassword) {
        byte[] decodedPassword = Base64.getDecoder().decode(storePassword);
        String decodeStringPassword = new String(decodedPassword, StandardCharsets.UTF_8);
        return decodeStringPassword;
    }

    @Override
    public User LoginUser(LoginDto user) {
        //Selecting from areaofinterestable
          try{
          String sql = "SELECT * FROM login  WHERE email=" + "\'" +user.getEmail()+ "\'" ;
             Statement statement =getConnection(con).createStatement();
             ResultSet rs = statement.executeQuery(sql);
             User user1=new User();
             while(rs.next()){
                   user1.setEmail(rs.getString("email"));
                   user1.setPassword(rs.getString("password"));
                   user1.setRole(rs.getString("role"));
                   user1.setUserid(rs.getString("userId"));
             }
             return user1;
             
             
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
  public ArrayList getLga(String state) {
		String[][] lga = { { "Abia", "Aba North" }, { "Abia", "Aba South" }, { "Abia", "Arochukwu" },
				{ "Abia", "Bende" }, { "Abia", "Ikwuano" }, { "Abia", "Isiala-Ngwa North" },
				{ "Abia", "Isiala-Ngwa South" }, { "Abia", "Isuikwato" }, { "Abia", "Ngwa" }, { "Abia", "Obi Nwa" },
				{ "Abia", "Ohafia" }, { "Abia", "Osisioma" }, { "Abia", "Ukwa East" }, { "Abia", "Ukwa West" },
				{ "Abia", "Umuahia North" }, { "Abia", "Umuahia South" }, { "Abia", "Umu-Neochi" },
				{ "Abuja", "Abaji" }, { "Abuja", "Abuja Municipal" }, { "Abuja", "Bwari" }, { "Abuja", "Gwagwalada" },
				{ "Abuja", "Kuje" }, { "Abuja", "Kwali" }, { "Adamawa", "Demsa" }, { "Adamawa", "Fufore" },
				{ "Adamawa", "Ganaye" }, { "Adamawa", "Gireri" }, { "Adamawa", "Gombi" }, { "Adamawa", "Guyuk" },
				{ "Adamawa", "Hong" }, { "Adamawa", "Jada" }, { "Adamawa", "Lamurde" }, { "Adamawa", "Madagali" },
				{ "Adamawa", "Maiha" }, { "Adamawa", "Mayo-Belwa" }, { "Adamawa", "Michika" },
				{ "Adamawa", "Mubi North" }, { "Adamawa", "Mubi South" }, { "Adamawa", "Numan" },
				{ "Adamawa", "Shelleng" }, { "Adamawa", "Song" }, { "Adamawa", "Toungo" }, { "Adamawa", "Yola North" },
				{ "Adamawa", "Yola South" }, { "Akwaibom", "Abak" }, { "Akwaibom", "Eastern Obolo" },
				{ "Akwaibom", "Eket" }, { "Akwaibom", "Esit Eket" }, { "Akwaibom", "Essien Udim" },
				{ "Akwaibom", "Etim Ekpo" }, { "Akwaibom", "Etinan" }, { "Akwaibom", "Ibeno" },
				{ "Akwaibom", "Ibesikpo Asutan" }, { "Akwaibom", "Ibiono Ibom" }, { "Akwaibom", "Ikono" },
				{ "Akwaibom", "Ikot Abasi" }, { "Akwaibom", "Ikot Ekpene" }, { "Akwaibom", "Ini" },
				{ "Akwaibom", "Itu" }, { "Akwaibom", "Mbo" }, { "Akwaibom", "Mkpat Enin" }, { "Akwaibom", "Nsit Atai" },
				{ "Akwaibom", "Nsit Ibom" }, { "Akwaibom", "Nsit Ubium" }, { "Akwaibom", "Obot Akara" },
				{ "Akwaibom", "Okobo" }, { "Akwaibom", "Onna" }, { "Akwaibom", "Oron" }, { "Akwaibom", "Oruk Anam" },
				{ "Akwaibom", "Udung Uko" }, { "Akwaibom", "Ukanafun" }, { "Akwaibom", "Uruan" },
				{ "Akwaibom", "Urue-Offong/Oruko" }, { "Akwaibom", "Uyo" }, { "Anambra", "Aguata" },
				{ "Anambra", "Anambra East" }, { "Anambra", "Anambra West" }, { "Anambra", "Anaocha" },
				{ "Anambra", "Awka North" }, { "Anambra", "Awka South" }, { "Anambra", "Ayamelum" },
				{ "Anambra", "Dunukofia" }, { "Anambra", "Ekwusigo" }, { "Anambra", "Idemili North" },
				{ "Anambra", "Idemili south" }, { "Anambra", "Ihiala" }, { "Anambra", "Njikoka" },
				{ "Anambra", "Nnewi North" }, { "Anambra", "Nnewi South" }, { "Anambra", "Ogbaru" },
				{ "Anambra", "Onitsha North" }, { "Anambra", "Onitsha South" }, { "Anambra", "Orumba North" },
				{ "Anambra", "Orumba South" }, { "Anambra", "Oyi" }, { "Bauchi", "Alkaleri" }, { "Bauchi", "Bauchi" },
				{ "Bauchi", "Bogoro" }, { "Bauchi", "Damban" }, { "Bauchi", "Darazo" }, { "Bauchi", "Dass" },
				{ "Bauchi", "Ganjuwa" }, { "Bauchi", "Giade" }, { "Bauchi", "Itas/Gadau" }, { "Bauchi", "Jamaare" },
				{ "Bauchi", "Katagum" }, { "Bauchi", "Kirfi" }, { "Bauchi", "Misau" }, { "Bauchi", "Ningi" },
				{ "Bauchi", "Shira" }, { "Bauchi", "Tafawa-Balewa" }, { "Bauchi", "Toro" }, { "Bauchi", "Warji" },
				{ "Bauchi", "Zaki" }, { "Bayelsa", "Brass" }, { "Bayelsa", "Ekeremor" },
				{ "Bayelsa", "Kolokuma/Opokuma" }, { "Bayelsa", "Nembe" }, { "Bayelsa", "Ogbia" },
				{ "Bayelsa", "Sagbama" }, { "Bayelsa", "Southern Ijaw" }, { "Bayelsa", "Yenegoa" }, { "Benue", "Ado" },
				{ "Benue", "Agatu" }, { "Benue", "Apa" }, { "Benue", "Buruku" }, { "Benue", "Gboko" },
				{ "Benue", "Guma" }, { "Benue", "Gwer East" }, { "Benue", "Gwer West" }, { "Benue", "Katsina-Ala" },
				{ "Benue", "Konshisha" }, { "Benue", "Kwande" }, { "Benue", "Logo" }, { "Benue", "Makurdi" },
				{ "Benue", "Obi" }, { "Benue", "Ogbadibo" }, { "Benue", "Ohimini" }, { "Benue", "Oju" },
				{ "Benue", "Okpokwu" }, { "Benue", "Otukpo" }, { "Benue", "Tarka" }, { "Benue", "Ukum" },
				{ "Benue", "Ushongo" }, { "Benue", "Vandeikya" }, { "Borno", "Abadam" }, { "Borno", "Askira/Uba" },
				{ "Borno", "Bama" }, { "Borno", "Bayo" }, { "Borno", "Biu" }, { "Borno", "Chibok" },
				{ "Borno", "Damboa" }, { "Borno", "Dikwa" }, { "Borno", "Gubio" }, { "Borno", "Guzamala" },
				{ "Borno", "Gwoza" }, { "Borno", "Hawul" }, { "Borno", "Jere" }, { "Borno", "Kaga" },
				{ "Borno", "Kala/Balge" }, { "Borno", "Konduga" }, { "Borno", "Kukawa" }, { "Borno", "Mafa" },
				{ "Borno", "Magumeri" }, { "Borno", "Maiduguri" }, { "Borno", "Marte" }, { "Borno", "Mobbar" },
				{ "Borno", "Monguno" }, { "Borno", "Ngala" }, { "Borno", "Nganzai" }, { "Borno", "Shani" },
				{ "CrossRiver", "Abi" }, { "CrossRiver", "Akamkpa" }, { "CrossRiver", "Akpabuyo" },
				{ "CrossRiver", "Bakassi" }, { "CrossRiver", "Bekwara" }, { "CrossRiver", "Biase" },
				{ "CrossRiver", "Boki" }, { "CrossRiver", "Calabar Municipality" }, { "CrossRiver", "Calabar South" },
				{ "CrossRiver", "Etung" }, { "CrossRiver", "Ikom" }, { "CrossRiver", "Obanliku" },
				{ "CrossRiver", "Obudu" }, { "CrossRiver", "Odubra" }, { "CrossRiver", "Odukpani" },
				{ "CrossRiver", "Ogoja" }, { "CrossRiver", "Yala" }, { "CrossRiver", "Yarkur" },
				{ "Delta", "Aniocha South" }, { "Delta", "Aniocha" }, { "Delta", "Bomadi" }, { "Delta", "Burutu" },
				{ "Delta", "Ethiope East" }, { "Delta", "Ethiope West" }, { "Delta", "Ika North-East" },
				{ "Delta", "Ika South" }, { "Delta", "Isoko North" }, { "Delta", "Isoko south" },
				{ "Delta", "Ndokwa East" }, { "Delta", "Ndokwa West" }, { "Delta", "Okpe" },
				{ "Delta", "Oshimili North" }, { "Delta", "Oshimili" }, { "Delta", "Patani" }, { "Delta", "Sapele" },
				{ "Delta", "Udu" }, { "Delta", "Ughelli North" }, { "Delta", "Ughelli South" }, { "Delta", "Ukwani" },
				{ "Delta", "Uvwie" }, { "Delta", "Warri Central" }, { "Delta", "Warri North" },
				{ "Delta", "Warri South" }, { "Ebonyi", "Abakaliki" }, { "Ebonyi", "Afikpo North" },
				{ "Ebonyi", "Afikpo South" }, { "Ebonyi", "Ebonyi" }, { "Ebonyi", "Ezza South" }, { "Ebonyi", "Ezza" },
				{ "Ebonyi", "Ishielu" }, { "Ebonyi", "Ivo" }, { "Ebonyi", "lkwo" }, { "Ebonyi", "Ohaozara" },
				{ "Ebonyi", "Ohaukwu" }, { "Ebonyi", "Onicha" }, { "Edo", "Central" }, { "Edo", "Egor" },
				{ "Edo", "Esan Central" }, { "Edo", "Esan NorthEast" }, { "Edo", "Esan South-East" },
				{ "Edo", "Esan West" }, { "Edo", "Etsako Central" }, { "Edo", "Etsako East" }, { "Edo", "Igueben" },
				{ "Edo", "Oredo" }, { "Edo", "Orhionwon" }, { "Edo", "Ovia South-East" }, { "Edo", "Ovia SouthWest" },
				{ "Edo", "Uhunmwonde" }, { "Edo", "Ukpoba" }, { "Ekiti", "Ado" }, { "Ekiti", "Efon" },
				{ "Ekiti", "Ekiti SouthWest" }, { "Ekiti", "EkitiEast" }, { "Ekiti", "EkitiWest" },
				{ "Ekiti", "Emure/Ise/Orun" }, { "Ekiti", "Gbonyin" }, { "Ekiti", "Ido/Osi" }, { "Ekiti", "Ijero" },
				{ "Ekiti", "Ikare" }, { "Ekiti", "Ikole" }, { "Ekiti", "Ilejemeje" }, { "Ekiti", "Irepodun" },
				{ "Ekiti", "Ise/Orun" }, { "Ekiti", "Moba" }, { "Ekiti", "Oye" }, { "Enugu", "Aninri" },
				{ "Enugu", "Enugu East" }, { "Enugu", "Enugu North" }, { "Enugu", "Enugu South" },
				{ "Enugu", "Ezeagu" }, { "Enugu", "Igbo Ekiti" }, { "Enugu", "Igbo Eze South" },
				{ "Enugu", "IgboEze North" }, { "Enugu", "Isi Uzo" }, { "Enugu", "Nkanu East" }, { "Enugu", "Nkanu" },
				{ "Enugu", "Nsukka" }, { "Enugu", "Oji River" }, { "Enugu", "Udenu" }, { "Enugu", "Udi Agwu" },
				{ "Enugu", "Uzo Uwani" }, { "Gombe", "Akko" }, { "Gombe", "Balanga" }, { "Gombe", "Billiri" },
				{ "Gombe", "Dukku" }, { "Gombe", "Funakaye" }, { "Gombe", "Gombe" }, { "Gombe", "Kaltungo" },
				{ "Gombe", "Kwami" }, { "Gombe", "Nafada/Bajoga" }, { "Gombe", "Shomgom" },
				{ "Gombe", "Yamaltu/Delta" }, { "Imo", "Aboh Mbaise" }, { "Imo", "Ahiazu-Mbaise" },
				{ "Imo", "Ehime Mbano" }, { "Imo", "Ezinihitte" }, { "Imo", "Ideato North" }, { "Imo", "Ideato South" },
				{ "Imo", "Ihitte/Uboma" }, { "Imo", "Ikeduru" }, { "Imo", "Isiala Mbano" }, { "Imo", "Isu" },
				{ "Imo", "Mbaitoli" }, { "Imo", "Ngor Okpala" }, { "Imo", "Njaba" }, { "Imo", "Nkwerre" },
				{ "Imo", "Nwangele" }, { "Imo", "Obowo" }, { "Imo", "Oguta" }, { "Imo", "Ohaji/Egbema" },
				{ "Imo", "Okigwe" }, { "Imo", "Orlu" }, { "Imo", "Orsu" }, { "Imo", "Oru East" }, { "Imo", "Oru West" },
				{ "Imo", "Owerri Municipal" }, { "Imo", "Owerri North" }, { "Imo", "Owerri West" },
				{ "Jigawa", "Auyo" }, { "Jigawa", "Babura" }, { "Jigawa", "Biriniwa" }, { "Jigawa", "Birni Kudu" },
				{ "Jigawa", "Buji" }, { "Jigawa", "Dutse" }, { "Jigawa", "Gagarawa" }, { "Jigawa", "Garki" },
				{ "Jigawa", "Gumel" }, { "Jigawa", "Guri" }, { "Jigawa", "Gwaram" }, { "Jigawa", "Gwiwa" },
				{ "Jigawa", "Hadejia" }, { "Jigawa", "Jahun" }, { "Jigawa", "Kafin Hausa" },
				{ "Jigawa", "Kaugama Kazaure " }, { "Jigawa", "Kiri Kasamma" }, { "Jigawa", "Kiyawa" },
				{ "Jigawa", "Maigatari" }, { "Jigawa", "Malam Madori" }, { "Jigawa", "Miga" }, { "Jigawa", "Ringim" },
				{ "Jigawa", "Sule-Tankarkar" }, { "Jigawa", "Taura" }, { "Jigawa", "Yankwashi" },
				{ "Kaduna", "Birni-Gwari" }, { "Kaduna", "Chikun" }, { "Kaduna", "Giwa" }, { "Kaduna", "Igabi" },
				{ "Kaduna", "Ikara" }, { "Kaduna", "jaba" }, { "Kaduna", "Jemaa" }, { "Kaduna", "Kachia" },
				{ "Kaduna", "Kaduna North" }, { "Kaduna", "Kaduna South" }, { "Kaduna", "Kagarko" },
				{ "Kaduna", "Kajuru" }, { "Kaduna", "Kaura" }, { "Kaduna", "Kauru" }, { "Kaduna", "Kubau" },
				{ "Kaduna", "Kudan" }, { "Kaduna", "Lere" }, { "Kaduna", "Makarfi" }, { "Kaduna", "Sabon-Gari" },
				{ "Kaduna", "Sanga" }, { "Kaduna", "Soba" }, { "Kaduna", "Zango-Kataf" }, { "Kaduna", "Zaria" },
				{ "Kano", "Ajingi" }, { "Kano", "Albasu" }, { "Kano", "Bagwai" }, { "Kano", "Bebeji" },
				{ "Kano", "Bichi" }, { "Kano", "Bunkure" }, { "Kano", "Dala " }, { "Kano", "Dambatta" },
				{ "Kano", "Dawakin Kudu" }, { "Kano", "Dawakin Tofa" }, { "Kano", "Doguwa" }, { "Kano", "Fagge" },
				{ "Kano", "Gabasawa" }, { "Kano", "Garko" }, { "Kano", "Garum" }, { "Kano", "Gaya" },
				{ "Kano", "Gezawa" }, { "Kano", "Gwale" }, { "Kano", "Gwarzo" }, { "Kano", "Kabo" },
				{ "Kano", "Kano Municipal" }, { "Kano", "Karaye" }, { "Kano", "Kibiya" }, { "Kano", "Kiru" },
				{ "Kano", "kumbotso" }, { "Kano", "Kunchi" }, { "Kano", "Kura" }, { "Kano", "Madobi" },
				{ "Kano", "Makoda" }, { "Kano", "Mallam" }, { "Kano", "Minjibir" }, { "Kano", "Nasarawa" },
				{ "Kano", "Rano" }, { "Kano", "Rimin Gado" }, { "Kano", "Shanono" }, { "Kano", "Sumaila" },
				{ "Kano", "Takali" }, { "Kano", "Tofa" }, { "Kano", "Tsanyawa" }, { "Kano", "Tudun Wada" },
				{ "Kano", "Ungogo" }, { "Kano", "Warawa" }, { "Kano", "Wudil" }, { "Katsina", "Bakori" },
				{ "Katsina", "Bakori" }, { "Katsina", "Batagarawa" }, { "Katsina", "Batsari" }, { "Katsina", "Baure" },
				{ "Katsina", "Bindawa" }, { "Katsina", "Charanchi" }, { "Katsina", "Dan Musa" },
				{ "Katsina", "Dandume " }, { "Katsina", "Danja" }, { "Katsina", "Daura" }, { "Katsina", "Dutsi" },
				{ "Katsina", "Dutsin-Ma" }, { "Katsina", "Faskari" }, { "Katsina", "Funtua" }, { "Katsina", "Ingawa" },
				{ "Katsina", "Jibia" }, { "Katsina", "Kafur" }, { "Katsina", "Kankara" }, { "Katsina", "Kankia" },
				{ "Katsina", "Katsina" }, { "Katsina", "Kurfi" }, { "Katsina", "Kusada" }, { "Katsina", "Mai'Adua" },
				{ "Katsina", "Malumfashi" }, { "Katsina", "Mani" }, { "Katsina", "Mashi" }, { "Katsina", "Matazuu" },
				{ "Katsina", "Musawa" }, { "Katsina", "Rimi" }, { "Katsina", "Sabuwa" }, { "Katsina", "Safana" },
				{ "Katsina", "Sandamu" }, { "Katsina", "Zango" }, { "Kebbi", "Aleiro" }, { "Kebbi", "Arewa-Dandi" },
				{ "Kebbi", "Argungu" }, { "Kebbi", "Augie" }, { "Kebbi", "Bagudo" }, { "Kebbi", "Birnin Kebbi" },
				{ "Kebbi", "Bunza" }, { "Kebbi", "Dandi" }, { "Kebbi", "Fakai" }, { "Kebbi", "Gwandu" },
				{ "Kebbi", "Jega" }, { "Kebbi", "Kalgo" }, { "Kebbi", "Koko/Besse" }, { "Kebbi", "Maiyama " },
				{ "Kebbi", "Ngaski" }, { "Kebbi", "Sakaba " }, { "Kebbi", "Shanga" }, { "Kebbi", "Suru" },
				{ "Kebbi", "Wasagu/Danko" }, { "Kebbi", "Y Zuru" }, { "Kogi", "Adavi" }, { "Kogi", "Ajaokuta" },
				{ "Kogi", "Ankpa" }, { "Kogi", "Bassa" }, { "Kogi", "Dekina" }, { "Kogi", "Ibaji" }, { "Kogi", "Idah" },
				{ "Kogi", "Igalamela-Odolu" }, { "Kogi", "Ijumu" }, { "Kogi", "Kabba/Bunu" }, { "Kogi", "Kogi" },
				{ "Kogi", "Lokoja" }, { "Kogi", "Mopa-Muro" }, { "Kogi", "Ofu" }, { "Kogi", "Ogori/Mangongo" },
				{ "Kogi", "Okehi" }, { "Kogi", "Okene" }, { "Kogi", "Olamaboro" }, { "Kogi", "Omala" },
				{ "Kogi", "Yagba East" }, { "Kogi", "Yagba West" }, { "Kwara", "Asa" }, { "Kwara", "Baruten" },
				{ "Kwara", "Edu" }, { "Kwara", "Ekiti" }, { "Kwara", "Ifelodun" }, { "Kwara", "Ilorin East" },
				{ "Kwara", "Irepodun" }, { "Kwara", "Isin" }, { "Kwara", "Kaiama" }, { "Kwara", "Moro" },
				{ "Kwara", "Offa" }, { "Kwara", "Oke-Ero" }, { "Kwara", "Oyun" }, { "Kwara", "Pategi" },
				{ "Lagos", "Agege" }, { "Lagos", "Ajeromi-Ifelodun" }, { "Lagos", "Alimosho" },
				{ "Lagos", "Amuwo-Odofin" }, { "Lagos", "Apapa" }, { "Lagos", "Badagry" }, { "Lagos", "Epe" },
				{ "Lagos", "Eti-Osa" }, { "Lagos", "Ibeju/Lekki" }, { "Lagos", "Ifako-Ijaye" }, { "Lagos", "Ikeja" },
				{ "Lagos", "Ikorodu" }, { "Lagos", "Kosofe" }, { "Lagos", "Lagos Island" },
				{ "Lagos", "Lagos Mainland" }, { "Lagos", "Mushin" }, { "Lagos", "Ojo" }, { "Lagos", "Oshodi-Isolo" },
				{ "Lagos", "Shomolu" }, { "Lagos", "Surulere" }, { "Nasarawa", "Akwanga" }, { "Nasarawa", "Awe" },
				{ "Nasarawa", "Doma" }, { "Nasarawa", "Karu" }, { "Nasarawa", "Keana" }, { "Nasarawa", "Keffi" },
				{ "Nasarawa", "Kokona" }, { "Nasarawa", "Lafia" }, { "Nasarawa", "Nasarawa" },
				{ "Nasarawa", "Nasarawa-Eggon" }, { "Nasarawa", "Obi" }, { "Nasarawa", "Toto" },
				{ "Nasarawa", "Wamba" }, { "Niger", "Agaie" }, { "Niger", "Agwara" }, { "Niger", "Bida" },
				{ "Niger", "Borgu" }, { "Niger", "Bosso" }, { "Niger", "Chanchaga" }, { "Niger", "Edati" },
				{ "Niger", "Gbako" }, { "Niger", "Gurara" }, { "Niger", "Katcha" }, { "Niger", "Kontagora" },
				{ "Niger", "Lapai" }, { "Niger", "Lavun" }, { "Niger", "Magama" }, { "Niger", "Mariga" },
				{ "Niger", "Mashegu" }, { "Niger", "Mokwa" }, { "Niger", "Muya" }, { "Niger", "Pailoro" },
				{ "Niger", "Rafi" }, { "Niger", "Rijau" }, { "Niger", "Shiroro" }, { "Niger", "Suleja" },
				{ "Niger", "Tafa" }, { "Niger", "Wushishi" }, { "Ogun", "Abeokuta North" },
				{ "Ogun", "Abeokuta South" }, { "Ogun", "Ado-Odo/Ota" }, { "Ogun", "Egbado North" },
				{ "Ogun", "Egbado South" }, { "Ogun", "Ewekoro" }, { "Ogun", "Ifo" }, { "Ogun", "Ijebu East" },
				{ "Ogun", "Ijebu North East" }, { "Ogun", "Ijebu North" }, { "Ogun", "Ijebu Ode" },
				{ "Ogun", "Ikenne" }, { "Ogun", "Imeko-Afon" }, { "Ogun", "Ipokia" }, { "Ogun", "Obafemi-Owode" },
				{ "Ogun", "Odeda" }, { "Ogun", "Odogbolu" }, { "Ogun", "Ogun Waterside" }, { "Ogun", "Remo North" },
				{ "Ogun", "Shagamu" }, { "Ondo", "Akoko North East" }, { "Ondo", "Akoko North West" },
				{ "Ondo", "Akoko South Akure East" }, { "Ondo", "Akoko South West" }, { "Ondo", "Akure North" },
				{ "Ondo", "Akure South" }, { "Ondo", "Ese-Odo" }, { "Ondo", "Idanre" }, { "Ondo", "Ifedore" },
				{ "Ondo", "Ilaje" }, { "Ondo", "Ile-Oluji" }, { "Ondo", "Irele" }, { "Ondo", "Odigbo" },
				{ "Ondo", "Okeigbo" }, { "Ondo", "Okitipupa" }, { "Ondo", "Ondo East" }, { "Ondo", "Ondo West" },
				{ "Ondo", "Ose" }, { "Ondo", "Owo" }, { "Osun", "Aiyedade" }, { "Osun", "Aiyedire" },
				{ "Osun", "Atakumosa East" }, { "Osun", "Atakumosa West" }, { "Osun", "Atiba" },
				{ "Osun", "Boluwaduro" }, { "Osun", "Boripe" }, { "Osun", "Ede North" }, { "Osun", "Ede South" },
				{ "Osun", "Egbedore" }, { "Osun", "Ejigbo" }, { "Osun", "Ife Central" }, { "Osun", "Ife East" },
				{ "Osun", "Ife North" }, { "Osun", "Ife South" }, { "Osun", "Ifedayo" }, { "Osun", "Ifelodun" },
				{ "Osun", "Ila" }, { "Osun", "Ilesha East" }, { "Osun", "Ilesha West" }, { "Osun", "Irepodun" },
				{ "Osun", "Irewole" }, { "Osun", "Isokan" }, { "Osun", "Iwo" }, { "Osun", "Obokun" },
				{ "Osun", "Odo-Otin" }, { "Osun", "Ola-Oluwa" }, { "Osun", "Olorunda" }, { "Osun", "Oriade" },
				{ "Osun", "Orolu" }, { "Osun", "Osogbo" }, { "Oyo", "Afijio" }, { "Oyo", "Akinyele" },
				{ "Oyo", "Atiba" }, { "Oyo", "Atigbo" }, { "Oyo", "Egbeda" }, { "Oyo", "Ibadan North West" },
				{ "Oyo", "Ibadan North" }, { "Oyo", "Ibadan South East" }, { "Oyo", "Ibadan South West" },
				{ "Oyo", "IbadanCentral" }, { "Oyo", "Ibarapa  North" }, { "Oyo", "Ibarapa Central" },
				{ "Oyo", "Ibarapa East" }, { "Oyo", "Ido" }, { "Oyo", "Irepo" }, { "Oyo", "Iseyin" },
				{ "Oyo", "Itesiwaju" }, { "Oyo", "Iwajowa" }, { "Oyo", "Kajola" }, { "Oyo", "Lagelu Ogbomosho North" },
				{ "Oyo", "Ogbmosho South" }, { "Oyo", "Ogo Oluwa" }, { "Oyo", "Olorunsogo" }, { "Oyo", "Oluyole" },
				{ "Oyo", "Ona-Ara" }, { "Oyo", "Orelope" }, { "Oyo", "Ori Ire" }, { "Oyo", "Oyo East" },
				{ "Oyo", "Oyo West" }, { "Oyo", "Saki East" }, { "Oyo", "Saki West" }, { "Oyo", "Surulere" },
				{ "Plateau", "Barikin Ladi" }, { "Plateau", "Bassa" }, { "Plateau", "Bokkos" },
				{ "Plateau", "Jos East" }, { "Plateau", "Jos North" }, { "Plateau", "Jos South" },
				{ "Plateau", "Kanam" }, { "Plateau", "Kanke" }, { "Plateau", "Langtang North" },
				{ "Plateau", "Langtang South" }, { "Plateau", "Mangu" }, { "Plateau", "Mikang" },
				{ "Plateau", "Pankshin" }, { "Plateau", "Quaan Pan" }, { "Plateau", "Riyom" }, { "Plateau", "Shendam" },
				{ "Plateau", "Wase" }, { "Rivers", "Abua/Odual" }, { "Rivers", "Ahoada East" },
				{ "Rivers", "Ahoada West" }, { "Rivers", "Akuku Toru" }, { "Rivers", "Andoni" },
				{ "Rivers", "Asari-Toru" }, { "Rivers", "Bonny" }, { "Rivers", "Degema" }, { "Rivers", "Eleme" },
				{ "Rivers", "Emohua" }, { "Rivers", "Etche" }, { "Rivers", "Gokana" }, { "Rivers", "Ikwerre" },
				{ "Rivers", "Khana" }, { "Rivers", "Obia/Akpor" }, { "Sokoto", "Binji" }, { "Sokoto", "Bodinga" },
				{ "Sokoto", "Dange-shnsi" }, { "Sokoto", "Gada" }, { "Sokoto", "Gawabawa" }, { "Sokoto", "Goronyo" },
				{ "Sokoto", "Gudu" }, { "Sokoto", "Illela" }, { "Sokoto", "Isa" }, { "Sokoto", "Kebbe" },
				{ "Sokoto", "Kware" }, { "Sokoto", "Rabah" }, { "Sokoto", "Sabon birni" }, { "Sokoto", "Shagari" },
				{ "Sokoto", "Silame" }, { "Sokoto", "Sokoto North" }, { "Sokoto", "Sokoto South" },
				{ "Sokoto", "Tambuwal" }, { "Sokoto", "Tqngaza" }, { "Sokoto", "Tureta" }, { "Sokoto", "Wamako" },
				{ "Sokoto", "Wurno" }, { "Sokoto", "Yabo" }, { "Taraba", "Ardo-kola" }, { "Taraba", "Bali" },
				{ "Taraba", "Cassol" }, { "Taraba", "Donga" }, { "Taraba", "Gashaka" }, { "Taraba", "Ibi" },
				{ "Taraba", "Jalingo" }, { "Taraba", "Karin-Lamido" }, { "Taraba", "Kurmi" }, { "Taraba", "Lau" },
				{ "Taraba", "Sardauna" }, { "Taraba", "Ussa" }, { "Taraba", "Wukari" }, { "Taraba", "Yorro" },
				{ "Taraba", "Zing" }, { "Yobe", "Bade" }, { "Yobe", "Bursari" }, { "Yobe", "Damaturu" },
				{ "Yobe", "Fika" }, { "Yobe", "Fune" }, { "Yobe", "Geidam" }, { "Yobe", "Gujba" }, { "Yobe", "Gulani" },
				{ "Yobe", "Jakusko" }, { "Yobe", "Karasuwa" }, { "Yobe", "Karawa" }, { "Yobe", "Machina" },
				{ "Yobe", "Nangere" }, { "Yobe", "Nguru Potiskum" }, { "Yobe", "Tarmua" }, { "Yobe", "Yunusari" },
				{ "Zamfara", "Anka" }, { "Zamfara", "Bakura" }, { "Zamfara", "Birnin Magaji" },
				{ "Zamfara", "Bukkuyum" }, { "Zamfara", "Bungudu" }, { "Zamfara", "Gummi" }, { "Zamfara", "Gusau" },
				{ "Zamfara", "Kaura" }, { "Others", "Others" }, };
		ArrayList lgaa = new ArrayList();
		for (int k = 0; k < lga.length; k++) {
			String st = lga[k][0];
			String lg = lga[k][1];

			if (st.trim().equalsIgnoreCase(state)) {
				lgaa.add(lg);

			}
		}
		return lgaa;
	}

}
