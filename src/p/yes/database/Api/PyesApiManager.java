/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.yes.Database.Api;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import p.yes.utils.Config;
import p.yes_Model.dto.LoginResponseData;
import p.yes_Model.dto.ResponseDto;
import p.yes_Model.dto.UserLoginResponseDto;

/**
 *
 * @author Aniwange.TA
 */
public class PyesApiManager {
    
      public static boolean netIsAvailable() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }
      
   public static ResponseDto syncApplicants(String json)
    {
         HttpURLConnection connection = null;
        try {
           
            String targetURL = Config.BASE_URL+"officer/register/user";
            URL url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
           // System.err.println("accss: "+ PYES.access_token);
           // connection.setRequestProperty("Authorization", "Bearer " + PYES.access_token);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("platform", "web");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            //Send request
            DataOutputStream wr = new DataOutputStream (
            connection.getOutputStream());
            wr.writeBytes(json);
            wr.close();
           // int code = connection.getResponseCode();
            //System.err.println("code  amos : "+ code );
        
            if(connection.getResponseCode()==200)
            {
             return displaySuccessResponse(connection);
            }
            if(connection.getResponseCode()== HttpURLConnection.HTTP_BAD_REQUEST){
              return displayError(connection);
            }
        } catch (IOException ex) {
            Logger.getLogger(PyesApiManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
       
       
 
   public static ResponseDto httpRequestHelper(String urlPath, String requestMethod, Object request, String authorization) {
        try {

            ResponseDto response = new ResponseDto();
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("Content-Type", "application/json");

            if (authorization != null) {
                conn.setRequestProperty("Authorization", authorization);
            }

            Gson gson = new Gson();

            String input = gson.toJson(request);
            System.out.println("OkHttp " + input);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            System.out.println("OkHttp" + " here");
            if (conn.getResponseCode() == 200) {
           return displaySuccessResponse(conn);
                }
        if (conn.getResponseCode() ==400) {
                return displayError(conn);

               }

        } catch (MalformedURLException e) {

            e.printStackTrace();
            
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;

    }
      
      
      
       public static LoginResponseData displayError1(HttpURLConnection connection) {
        Gson gson=new Gson();
        try{
        InputStream is = connection.getErrorStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = rd.readLine())!= null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        LoginResponseData res = gson.fromJson(response.toString(), LoginResponseData.class);
        System.out.println(res.getMessage());
        return res; 
        }
        catch(Exception e){
            
        }
       return null; 
    }
       
    public static LoginResponseData displaySuccessResponse2(HttpURLConnection connection) throws IOException {
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        Gson gson=new Gson();
        LoginResponseData dto=new LoginResponseData ();
        while ((line = rd.readLine())!=null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();  
        UserLoginResponseDto res = gson.fromJson(response.toString(), UserLoginResponseDto.class);
        dto.setData(res);
        dto.setStatus(true);
        dto.setMessage("success");
        
        return dto;
    }
    
        public static ResponseDto displayError(HttpURLConnection connection) {
        Gson gson=new Gson();
        try{
        InputStream is = connection.getErrorStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = rd.readLine())!= null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        ResponseDto res = gson.fromJson(response.toString(), ResponseDto.class);
        System.out.println(res.getMessage());
        return res; 
        }
        catch(Exception e){
            
        }
       return null; 
    }
       
    public static ResponseDto displaySuccessResponse(HttpURLConnection connection) throws IOException {
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        ResponseDto dto=new ResponseDto ();
        while ((line = rd.readLine())!=null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();  
        dto.setData(response.toString());
        dto.setStatus(false);
        dto.setMessage("success");
        
        return dto;
    }

}
