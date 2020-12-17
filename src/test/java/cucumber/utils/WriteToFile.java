package cucumber.utils;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile {
	
	
		static String filePath = "D:\\L&T Technology Services\\EclipseWorkspace\\EatonFadrApplication\\src\\test\\resources\\FileReadWrite\\";
	  //static String filePath = "D:\\Eclipse Work space\\Java\\LoginPageSerinity01\\src\\test\\resources\\JsonFiles\\";
	  
	  public void writeToFile(String fileName, String readText) { //Read Text gets the text from the string that is read in another class
	    try {
	      FileWriter myWriter = new FileWriter(filePath+fileName,false); //Clears the file before it writes to it
	      myWriter.write(readText);
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    
	   
	  }
}

