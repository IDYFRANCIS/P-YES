package p.yes.utils;

import com.google.gson.Gson;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.zip.Deflater;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import p.yes_Model.dto.ResponseDto;
import sun.misc.BASE64Encoder;

/**
 *
 * @author IDONGESIT FRANCIS
 */
public class Const {

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

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String output;
                while ((output = br.readLine()) != null) {

                    conn.disconnect();
                    System.out.println("OkHttp" + output);
                    response.setData(output);
                    response.isStatus();
                    return response;

                }

            } else if (conn.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST) {

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
                String output;
                while ((output = br.readLine()) != null) {

                    System.out.println("OkHttp" + output);
                    conn.disconnect();
                    response.setData(output);
                    response.setStatus(false);
                    return response;

                }
            } else if (conn.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
                String output;
                while ((output = br.readLine()) != null) {

                    System.out.println("OkHttp" + output);
                    conn.disconnect();
                    response.setData(output);
                    response.setStatus(false);
                    return response;

                }
            } else {

                System.out.println("OkHttp" + " else");

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
                String output;
                while ((output = br.readLine()) != null) {

                    System.out.println("OkHttp" + output);
                    conn.disconnect();
                    response.setData(output);
                    response.setStatus(false);
                    return response;

                }

            }

        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;

    }
    
    
      public static String encodeFileToBase64Binary(File file){
            String encodedfile = null;
            try {
                
                BufferedImage imagem = ImageIO.read(file);
                
                ImageOutputStream  ios =  ImageIO.createImageOutputStream(file);

            //  List of ImageWritre's for jpeg format 
            Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpeg");

            //  Capture the first ImageWriter
            ImageWriter writer = iter.next();

            //  define the o outPut file to the write
            writer.setOutput(ios);

            //  Here you define the changes you wanna make to the image
            ImageWriteParam iwParam = writer.getDefaultWriteParam();
            iwParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            iwParam.setCompressionQuality(.90f);

            //  Compression, etc... being made
            writer.write(null, new IIOImage(imagem, null, null), iwParam);

            writer.dispose();

            //  Write to altered image in memory to the final file
            ImageIO.write(imagem, "jpg", ios);
                
                FileInputStream fileInputStreamReader = new FileInputStream(file);
                byte[] bytes = new byte[(int)file.length()];
                
                fileInputStreamReader.read(bytes);
                
                BASE64Encoder encoder = new BASE64Encoder();
                encodedfile = encoder.encode(bytes);
                
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return encodedfile;
        }

      
     public static byte[] compress(byte[] data) throws IOException {  
        Deflater deflater = new Deflater();  
        deflater.setInput(data);  
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);   
        deflater.finish();  
        byte[] buffer = new byte[1024];   
        while (!deflater.finished()) {  
         int count = deflater.deflate(buffer); // returns the generated code... index  
         outputStream.write(buffer, 0, count);   
        }  
        outputStream.close();  
        byte[] output = outputStream.toByteArray();  
       // System.out.println("Original: " + data.length / 1024 + " Kb");  
        //System.out.println("Compressed: " + output.length / 1024 + " Kb");  
        return output;  
  }  
}
