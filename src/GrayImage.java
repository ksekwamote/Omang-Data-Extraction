import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs; 
import org.opencv.imgproc.Imgproc;

public class GrayImage {
   public static void main( String[] args ) {
   
      try{

         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
         Mat source = Imgcodecs.imread(OmangInfo.filepath,  0);
         Mat destination = new Mat();
         //Imgproc.medianBlur(source, destination, 0);
         //destination = source;
         //Imgproc.adaptiveThreshold(source,destination,127,255,Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C);
         //Imgproc.adaptiveThreshold(source, destination, 200,Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY, 9, 11);
        Imgproc.threshold(source,destination,100,255,Imgproc.THRESH_BINARY);
         Imgcodecs.imwrite(OmangInfo.filepath, destination);
         System.out.println("Succesful thresholding of Image!");
         
      } catch (Exception e) {
         System.out.println("error: " + e.getMessage());
      }
   }
}