package p.yes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
public class PyesDataBase {

    Connection c = null;
    Statement stmt = null;
    String APPLICANT_TABLE = "applicant";
    String AreaOfIntrest_TABLE = "areaOfIntrest";
    String Refree_TABLE = "refree";
    String Employment_TABLE = "employment";
    String Documents_TABLE = "documents";
    String CharacterAss_TABLE = "characterAss";

    public boolean droptable(String tablename) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            stmt = c.createStatement();
            String sql = "DROP TABLE IF EXISTS " + tablename + ";";
            stmt.execute(sql);
            stmt.close();
            c.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    /**
     * ****************************************************************************************************************
     * CREATING METHODS
     *
     * @return
     * ****************************************************************************************************************
     */
    public boolean createApplicantTable() {

        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("Start creating Applicant DB");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            stmt = c.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS applicant "
                    + "(applicationNumber CHAR(248) , "
                    + "firstName CHAR(248) NOT NULL, "
                    + "middleName CHAR(248) NOT NULL, "
                    + "lastName CHAR(248) NOT NULL, "
                    + "gender CHAR(248) NOT NULL, "
                    + "maritalStatus CHAR(248) NOT NULL, "
                    + "stateOfOrigin CHAR(248) NOT NULL, "
                    + "wardName CHAR(248) NOT NULL, "
                    + "formOfIdentification CHAR(248) NOT NULL, "
                    + "identificationNumber CHAR(248) NOT NULL, "
                    + "bankVerificationNumber CHAR(248) NOT NULL, "
                    + "bankName CHAR(248) NOT NULL, "
                    + "phoneNumber CHAR(248) NOT NULL, "
                    + "emailAddress CHAR(248) NOT NULL, "
                    + "status CHAR(248) NOT NULL, "
                    + "stateOfResidence CHAR(248) NOT NULL, "
                    + "dob CHAR(248) NOT NULL, "
                    + "residentialAddress CHAR(248) NOT NULL)";

            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            c.close();

            System.out.println("Done creating Applicant DB");
            return true;
        } catch (Exception e) {
            System.err.println("Error" + e.getClass().getName() + ": " + e.getMessage());
            return false;
        }

    }

    public boolean createAreaOfIntrestTable() {

        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("Start creating Area Of Intrest DB");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            stmt = c.createStatement();

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
                    + "dob_Beneficiary CHAR(248) NOT NULL,"
                    + "idType CHAR(248) NOT NULL,"
                    + "idNumber CHAR(248) NOT NULL)";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            c.close();

            System.out.println("Done creating Area Of Intrest DB");
            return true;
        } catch (Exception e) {
            System.err.println("Error" + e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    public boolean createEmploymentTable() {

        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("Start creating Employment DB");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            stmt = c.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS employment "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "applicationNumber CHAR(248) NOT NULL, "
                    + "academicQualification CHAR(248) NOT NULL, "
                    + "employmentStatus CHAR(248) NOT NULL, "
                    + "beneficiaryStatus CHAR(248) NOT NULL, "
                    + "existingBusiness CHAR(248) NOT NULL, "
                    + "businessDescription CHAR(248) NOT NULL, "
                    + "businessLocation CHAR(248) NOT NULL)";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            c.close();

            System.out.println("Done creating Employment Table DB");
            return true;
        } catch (Exception e) {
            System.err.println("Error" + e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    public boolean createRefreeTable() {

        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("Start creating Refree DB");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            stmt = c.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS refree "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "applicationNumber CHAR(248) NOT NULL, "
                    + "refName CHAR(248) NOT NULL, "
                    + "refAddress CHAR(248) NOT NULL, "
                    + "refPhoneNumber CHAR(248) NOT NULL, "
                    + "refRelationship CHAR(248) NOT NULL, "
                    + "nokName CHAR(248) NOT NULL, "
                    + "nokPhoneNumber CHAR(248) NOT NULL, "
                    + "nokRelationship CHAR(248) NOT NULL, "
                    + "nokAddress CHAR(248) NOT NULL)";
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            c.close();

            System.out.println("Done creating Refree Table DB");
            return true;
        } catch (Exception e) {
            System.err.println("Error" + e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }
    
    
     public boolean createDocumentsTable() {

        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("Start creating Documents DB");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            stmt = c.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS documents "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "applicationNumber CHAR(248) NOT NULL, "
                    + "base64File CHAR(248) NOT NULL, "
                    + "fileName CHAR(248) NOT NULL)"; 
                   
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            c.close();

            System.out.println("Done creating Document Table DB");
            return true;
        } catch (Exception e) {
            System.err.println("Error" + e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }
     
     
      public boolean createCharacterAssTable() {

        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("Start creating CharacterAss DB");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            stmt = c.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS characterAss "
                    + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "applicationNumber CHAR(248) NOT NULL, "
                    + "crimeConviction CHAR(248) NOT NULL, "
                    + "crimeDescription CHAR(248) NOT NULL, "
                    + "lawAbiding CHAR(248) NOT NULL)"; 
                   
            System.out.println(sql);
            stmt.execute(sql);
            stmt.close();
            c.close();

            System.out.println("Done creating CharacterAss Table DB");
            return true;
        } catch (Exception e) {
            System.err.println("Error" + e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

      
     



    /**
     * ************************************************************************************************
     * INSERTING METHODS
     * ************************************************************************************************
     */
    public boolean insertApplicant(Applicant applicant) {
        Connection c = null;
        Statement stmt = null;

        try {
            System.out.println("Start inserting into Applicant");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String val = "( " + "\'" + applicant.getApplicationNumber() 
                    + "\'," + "\'" + applicant.getFirstName()
                    + "\'," + "\'" + applicant.getMiddleName()
                    + "\'," + "\'" + applicant.getLastName()
                    + "\'," + "\'" + applicant.getGender()
                    + "\'," + "\'" + applicant.getMaritalStatus()
                    + "\'," + "\'" + applicant.getStateOfOrigin()
                    + "\'," + "\'" + applicant.getWardName()
                    + "\'," + "\'" + applicant.getFormOfIdentification()
                    + "\'," + "\'" + applicant.getIdentificationNumber()
                    + "\'," + "\'" + applicant.getBankVerificationNumber()
                    + "\'," + "\'" + applicant.getBankName()
                    + "\'," + "\'" + applicant.getPhoneNumber()
                    + "\'," + "\'" + applicant.getEmailAddress()
                    + "\'," + "\'" + applicant.getStateOfResidence()
                    + "\'," + "\'" + applicant.getDob()
                    + "\'," + "\'" + applicant.getStatus()
                    + "\'," + "\'" + applicant.getResidentialAddress()
                    + "\');";
            String val2 = "(  " + "\'" + applicant.getApplicationNumber() + "\',"
                    + "\'" + applicant.getFirstName() + "\'," + "\'" + applicant.getMiddleName() + "\'," + "\'" + applicant.getLastName() + "\'," + "\'" + applicant.getGender() + "\'," + "\'" + applicant.getMaritalStatus() + "\'," + " \'" + applicant.getStateOfOrigin() + "\'," + " \'" + applicant.getWardName() + "\'," + " \'" + applicant.getFormOfIdentification() + "\'," + " \'" + applicant.getIdentificationNumber() + "\'," + " \'" + applicant.getBankVerificationNumber() + "\'," + " \'" + applicant.getBankName() + "\'," + " \'" + applicant.getPhoneNumber() + "\',"
                    + " \'" + applicant.getEmailAddress() + "\'," + " \'" + applicant.getStateOfResidence() + "\'," + " \'" + applicant.getDob() + "\'," + " \'" + applicant.getStatus()+ "\'," + " \'" + applicant.getResidentialAddress() + "\');";
            String sql2 = "INSERT INTO applicant ( applicationNumber, firstName, middleName, lastName, gender, maritalStatus, stateOfOrigin, wardName, formOfIdentification, identificationNumber, bankVerificationNumber, bankName, phoneNumber, emailAddress, stateOfResidence, dob, status, residentialAddress) "
                    + "VALUES " + val2;
            stmt.executeUpdate(sql2);
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Done inserting into Applicant");
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Null value to DB");
        return false;
    }

    public boolean insertAreaOfIntrest(AreaOfIntrest areaOfIntrest) {
        Connection c = null;
        Statement stmt = null;

        try {
            System.out.println("Start inserting into Area of Intrest Table");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String val = "( " + "\'" + areaOfIntrest.getApplicationNumber()
                    + "\'," + "\'" + areaOfIntrest.getFirstName()
                    + "\'," + "\'" + areaOfIntrest.getMiddleName()
                    + "\'," + "\'" + areaOfIntrest.getLastName()
                    + "\'," + "\'" + areaOfIntrest.getGender()
                    + "\'," + "\'" + areaOfIntrest.getMaritalStatus()
                    + "\'," + "\'" + areaOfIntrest.getPhoneNumber()
                    + "\'," + "\'" + areaOfIntrest.getEmail()
                    + "\'," + "\'" + areaOfIntrest.getEmploymentStatus()
                    + "\'," + "\'" + areaOfIntrest.getResidentialAddress()
                   // + "\'," + "\'" + areaOfIntrest.getDob_Beneficiary()
                    + "\'," + "\'" + areaOfIntrest.getIdType()
                    + "\'," + "\'" + areaOfIntrest.getIdNumber()
                    + "\'," + "\'" + areaOfIntrest.getAreaOfIntrest()
                    + "\'," + "\'" + areaOfIntrest.getEmpowerOthers()
                    + "\');";

          //  String val2 = "(  " + "\'" + areaOfIntrest.getApplicationNumber()+ "\',"
               //     + "\'" + areaOfIntrest.getFirstName() + "\'," + "\'" + areaOfIntrest.getMiddleName() + "\'," + "\'" + areaOfIntrest.getLastName() + "\'," + "\'" + areaOfIntrest.getGender() + "\'," + "\'" + areaOfIntrest.getMaritalStatus() + "\'," + " \'" + areaOfIntrest.getPhoneNumber() + "\'," + " \'" + areaOfIntrest.getEmail() + "\'," + " \'" + areaOfIntrest.getEmploymentStatus() + "\'," + " \'" + areaOfIntrest.getResidentialAddress() + "\'," + " \'" + areaOfIntrest.getDob_Beneficiary() + "\'," + " \'" + areaOfIntrest.getIdType() + "\'," + " \'" + areaOfIntrest.getIdNumber() + "\'," + " \'" + areaOfIntrest.getAreaOfIntrest() + "\'," + " \'" + areaOfIntrest.getEmpowerOthers() + "\');";

            String sql2 = "INSERT INTO areaOfIntrest ( applicationNumber, firstName, middleName, lastName, gender, maritalStatus, phoneNumber, email, employmentStatus, residentialAddress, dob_Beneficiary, idType, idNumber, areaOfIntrest, empowerOthers) "
                    + "VALUES " + val;
            stmt.executeUpdate(sql2);
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Done inserting into Area of Intrest");
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Null value to DB");
        return false;
    }

    public boolean insertRefree(Refree refree) {
//        Connection c = null;
//        Statement stmt = null;
//
//        try {
//            System.out.println("Start inserting into Refree Table");
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
//            c.setAutoCommit(false);
//            stmt = c.createStatement();
//
//
//         //   String val2 = "(  " + "\'" + refree.getApplicationNumber()+ "\',"
//                    + "\'" + refree.getRefName() + "\'," + "\'" + refree.getRefAddress() + "\'," + "\'" + refree.getRefPhoneNumber() + "\'," + "\'" + refree.getRefRelationship() + "\'," + "\'" + refree.getNokName() + "\'," + " \'" + refree.getNokPhoneNumber() + "\'," + " \'" + refree.getNokAddress() + "\'," + " \'" + refree.getNokRelationship() + "\');";
//
//            String sql2 = "INSERT INTO refree ( applicationNumber, refName, refAddress, refPhoneNumber, refRelationship, nokName, nokPhoneNumber, nokAddress, nokRelationship) "
//                    + "VALUES " + val2;
//            stmt.executeUpdate(sql2);
//            stmt.close();
//            c.commit();
//            c.close();
//            System.out.println("Done inserting into Refree");
//            return true;
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        }
//        System.out.println("Null value to DB");
//        return false;
//    }
//
//    public boolean insertEmployment(Employment employment) {
//        Connection c = null;
//        Statement stmt = null;
//
//        try {
//            System.out.println("Start inserting into Employment Table");
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
//            c.setAutoCommit(false);
//            stmt = c.createStatement();
//
//            String val = "( " + "\'" + employment.getApplicationNumber()
//                    + "\'," + "\'" + employment.getAcademicQualification()
//                    + "\'," + "\'" + employment.getEmploymentStatus()
//                    + "\'," + "\'" + employment.getBeneficiaryStatus()
//                    + "\'," + "\'" + employment.getExistingBusiness()
//                    + "\'," + "\'" + employment.getBusinessDescription()
//                    + "\'," + "\'" + employment.getBusinessLocation()
//                    + "\');";
//
//            String val2 = "(  " + "\'" + employment.getApplicationNumber()+ "\',"
//                    + "\'" + employment.getAcademicQualification()+ "\'," + "\'" + employment.getEmploymentStatus() + "\'," + "\'" + employment.getBeneficiaryStatus() + "\'," + "\'" + employment.getExistingBusiness() + "\'," + "\'" + employment.getBusinessDescription() + "\'," + " \'" + employment.getBusinessLocation() + "\');";
//
//            String sql2 = "INSERT INTO employment ( applicationNumber, academicQualification, employmentStatus, beneficiaryStatus, existingBusiness, businessDescription, businessLocation) "
//                    + "VALUES " + val2;
//            stmt.executeUpdate(sql2);
//            stmt.close();
//            c.commit();
//            c.close();
//            System.out.println("Done inserting into employment");
//            return true;
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        }
//        System.out.println("Null value to DB");
        return false;
    }
    
    
     public boolean insertDocuments(Document documents) {
        Connection c = null;
        Statement stmt = null;

        try {
            System.out.println("Start inserting into Documents Table");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String val2 = "(  " + "\'" + documents.getApplicationNumber()+ "\',"
                    + "\'" + documents.getBase64File()+ "\'," + "\'" + documents.getFileName() + "\');";

            String sql2 = "INSERT INTO documents ( applicationNumber, base64File, fileName) "
                    + "VALUES " + val2;
            stmt.executeUpdate(sql2);
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Done inserting into Documents");
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Null value to DB");
        return false;
    }
    
     
      public boolean insertCharacterAss(CharacterAss characterAss) {
        Connection c = null;
        Statement stmt = null;

        try {
            System.out.println("Start inserting into CharacterAss Table");
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String val2 = "(  " + "\'" + 
                    characterAss.getApplicationNumber()+ "\'," + "\'" + 
                    characterAss.getCrimeConviction()+ "\'," + "\'" +
                    characterAss.getCrimeDescription()+ "\'," + "\'" +
                    characterAss.getLawAbiding()+ "\');";

            String sql2 = "INSERT INTO characterAss (applicationNumber, crimeConviction, crimeDescription, lawAbiding) "
                    + "VALUES " + val2;
            
             System.err.println("Inserting... " + sql2);
             
            stmt.executeUpdate(sql2);
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Done inserting into characterAss");
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Null value to DB");
        return false;
    }

      

    /**
     * *****************************************************************************************************************
     * GET METHOD QUERY
     * ****************************************************************************************************************
     */
    
     public Applicant getApplicant(ResultSet rs){
        Applicant applicant = new Applicant();
        try {
            applicant.setFirstName(rs.getString("firstName"));
            applicant.setLastName(rs.getString("lastName"));
            applicant.setGender(rs.getString("gender"));
            applicant.setStateOfOrigin(rs.getString("stateOfOrigin"));
            applicant.setEmailAddress(rs.getString("emailAddress"));
            applicant.setFormOfIdentification(rs.getString("formOfIdentification"));
            applicant.setStatus(rs.getString("status"));
        } catch (Exception e) {
        }
        return applicant;
    }
    
   
    
    
     public List<Applicant> getAllApplicant() {
        Connection c = null;
        Statement stmt = null;
        
        List<Applicant> applicant = new ArrayList<>();
        String sql = "SELECT * FROM applicant WHERE status = 'UPLOADED'";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Start getting applicants  " +rs.getString("firstName") + rs.getFetchSize());
            
            while (rs.next()) {
                applicant.add(getApplicant(rs));
                System.out.println("getApplicant " + getApplicant(rs).toString());
            }
            rs.close();
            stmt.close();
            c.close();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Successful");
        return applicant;
    }
     
     
       public List<Applicant> getAllApplicantStatus() { 
        Connection c = null;
        Statement stmt = null;
        
        System.out.println("Start getting applicants here " );
        List<Applicant> applicant = new ArrayList<>();
        String sql = "SELECT * FROM applicant WHERE status = 'NOT UPLOADED'";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:pyes.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Start getting applicants  " +rs.getString("firstName") + rs.getFetchSize());
            
            while (rs.next()) {
                applicant.add(getApplicant(rs));
                System.out.println("getApplicant " + getApplicant(rs).toString());
            }
            rs.close();
            stmt.close();
            c.close();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Successful");
        return applicant;
    }     
    
}
