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
public class Document {
    private String applicationNumber;
    private String base64File;
    private String fileName;

    public String getBase64File() {
        return base64File;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public void setBase64File(String base64File) {
        this.base64File = base64File;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

   public String insertDocumentQuery(){
       String sql1 = "INSERT INTO documents (applicationNumber, base64File, fileName) "
                    + "VALUES ";
      return sql1 + "(  " + "\'" 
              + getApplicationNumber()+ "\',"+ "\'"
              + getBase64File()+ "\'," + "\'" 
              + getFileName() + "\');";
   }
 public String updateQuery(){
  return " UPDATE documents SET applicationNumber = "+getApplicationNumber()+","
                 + " base64File = \'" +getBase64File() + "\', "
                 + " fileName = \'" +getFileName()+ "\', "
                 + " where applicationNumber = \'" +getApplicationNumber()+ "\';";
    }  
}
