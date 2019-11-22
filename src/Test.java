/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vkapuisire
 */
//PRE-PROCESSING 


import java.io.File; 
import java.io.IOException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import net.sourceforge.tess4j.Tesseract; 
import net.sourceforge.tess4j.TesseractException; 
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.util.*;


public class Test { 
    
    public static String idNumber ="";  
    public static String surname="";
    public static String firstnames="";
    public static String dob="";
    public static String pob="";
    public static File files;
    
    public Test(){
    
    
    }
    
    public static BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int width, int height){
        try{
            BufferedImage croppedImage = bufferedImage.getSubimage(x, y, width, height);
            return croppedImage;
        }
       catch (Exception e) {
           e.printStackTrace();
           return null;
    }
   
}
    
    public static void setFile(File file){
        files=file;
    
    }
    
    public static File getFile(){
    
      return files;
    }
    
    public static void main(String[] args) 
    { 
       
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        Tesseract tesseract = new Tesseract(); 
        try { 
  
            tesseract.setDatapath("C:\\Users\\vkapuisire\\Desktop\\Tess4J\\tessdata"); 
            //File imageFile  = new File("C:\\Users\\vkapuisire\\Pictures\\omang.png");
            BufferedImage bufferedImage = ImageIO.read(getFile());
            BufferedImage buff =cropImage(bufferedImage,100,100,170,180);
            String text = tesseract.doOCR(buff); 
            // path of your image file 
            String[] info = text.split("\n");
            idNumber= info[0];
            surname = info[1];
            firstnames= info[2];
            dob = info[3];
            pob= info[4];
            
            System.out.print(pob); 
        } 
        catch (TesseractException | IOException e) { 
            e.printStackTrace(); 
            System.out.println("Heela tlherra!");
        } 
    } 
}

