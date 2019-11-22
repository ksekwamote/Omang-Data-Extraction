// Java program to covert a color image to gray scale 
import org.opencv.core.Core; 
import org.opencv.core.Mat; 
import org.opencv.imgcodecs.Imgcodecs; 
import org.opencv.imgproc.Imgproc; 

public class grayscale { 
	public static void main(String args)  
	{ 
                try{
		// To load OpenCV core library 
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
		String input=OmangInfo.filepath; 

		// To Read the image 
		Mat source = Imgcodecs.imread(input); 

		// Creating the empty destination matrix 
		Mat destination = new Mat(); 

		// Converting the image to gray scale and 
		// saving it in the dst matrix 
		//Imgproc.cvtColor(source, destination, Imgproc.COLOR_RGB2GRAY); 
                //Imgproc.adaptiveThreshold(source, destination, 255,  Imgproc.ADAPTIVE_THRESH_MEAN_C , Imgproc.THRESH_BINARY, 15, 40);
		// Writing the image 
                Imgproc.cvtColor(source , destination, Imgproc.COLOR_RGB2GRAY);
		Imgcodecs.imwrite(OmangInfo.filepath, destination); 
		System.out.println("The image is successfully to Grayscale"); 
                }
                catch(Exception e){
                
                        System.out.println("No Way Dude!");
                }
	} 
} 
