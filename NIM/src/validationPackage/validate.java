package validationPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class validate {
	
	/**
	 * Validate Integer Input
	 * 
	 **/
	public static int isCorrectInput(int scope){
		 for(int j=0;;j++){
			 try{
				 Scanner scanner = new Scanner(System.in);
				 scope = scanner.nextInt();
				 if(isInputInLimit(scope)){
					 break;				 
				 }else{
					 System.out.println("Incorrect Input. Input should be 1 or 2 or 3. Try Again");
					 continue;
				 }
			 }catch(InputMismatchException exception){
				 System.out.println("Incorrect Input. Try Again");
			 }
		 }
		 return scope;
	 }
	
	/**
	 * Validate Input Limit
	 * 
	 **/
	 public static boolean isInputInLimit(int scope){
		 if(scope >= 1 && scope <= 3){
			 return true;
		 }else{
			 return false;
		 }
	 }
	 
	 /**
	  *
	  * 
	  **/

}
