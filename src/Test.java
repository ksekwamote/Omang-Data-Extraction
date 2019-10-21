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
  
import net.sourceforge.tess4j.Tesseract; 
import net.sourceforge.tess4j.TesseractException; 
import java.awt.image.*;
import javax.imageio.ImageIO;

  
public class Test { 
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
    
    public static void main(String[] args) 
    { 
       
        Tesseract tesseract = new Tesseract(); 
        try { 
  
            tesseract.setDatapath("C:\\Users\\vkapuisire\\Desktop\\Tess4J\\tessdata"); 
            File imageFile  = new File("C:\\Users\\vkapuisire\\Pictures\\image.png");
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            BufferedImage buff =cropImage(bufferedImage,100,100,170,180);
            String text = tesseract.doOCR(buff); 
            // path of your image file 
            System.out.print(text); 
        } 
        catch (TesseractException | IOException e) { 
            e.printStackTrace(); 
            System.out.println("Heela tlherra!");
        } 
    } 
}

