import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab1 {

	/**
	 * Main Method will scan in a file, if it exists.
	 * Reads file token-by-token and counts the number
	 * of tokens that are valid numbers, as well tokens
	 * that are not valid numbers. Adds the tokens that 
	 * were a number to a sum. Lastly, it will output 
	 * the count of tokens that were a number, count of 
	 * those that were not, and the sum of tokens that
	 * were a number.
	 * @param args
	 */
	public static void main(String[] args) {
		//counter variables and sum variable
		int nonNumbers = 0, count = 0; 
		double numbers = 0, numSum = 0; 
		Scanner in; //declare Scanner object
		try {
		    in = new Scanner(new File("data.txt"));  //open the file for scanner obj. to read
			while(in.hasNext()){				
					String s = in.next(); //read next string
					numbers = convertToDouble(s); //convertToDouble checks if s is a double
					if(numbers != -1){  //s is a valid double
						count++; //increment numbers
						numSum += numbers; //add the double to numSum
					}else //s was not a double
						nonNumbers++; //increment
			}
			System.out.printf("%d, %d, %.1f", count, nonNumbers,numSum); //display results
			in.close(); //close the file
		} catch (FileNotFoundException e) { //the file could not be opened
			System.out.println("File Not Found");
			e.printStackTrace();
		}

	}
	
	/**
	 * Checks if the string passed to the function  
	 * can be converted to a double. If it is return
	 * its value as a double. If not return an invalid
	 * value.
	 * @param s
	 * @return
	 */
	
	public static double convertToDouble(String s){
		Scanner data = new Scanner(s); //create new scanner object to read s
		if(data.hasNextDouble()){ //data is a double
			data.close();	//close data scanner	
			return Double.parseDouble(s); //convert s to a double and return its value
		}else{  //s was not a double
			data.close();
			return -1;
		}
	}
}
