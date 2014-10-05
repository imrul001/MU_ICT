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
	  * Validate Input String
	  * 
	  **/
	 public static String checkStringInput(){
		 String str = null;
		 Scanner scanner = new Scanner(System.in);
		 for(int i=0;;i++){
			 try{
				 str = scanner.nextLine().toLowerCase();
				 if(isCorrectString(str)){
					 break; 
				 }else{
					 System.out.println("Incorrect Input. Input should be Y/YES or N/NO. Try Again..");
					 continue;
				 }
			 }catch(InputMismatchException exception){
				 System.out.println("Incorrect Input. Try Again..");
			 }
		 }
		 return str;
	 }
	 /**
	  * Validate Message 
	  * 
	  **/
	 public static boolean isCorrectString(String str){
		 if(str.equalsIgnoreCase("y") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("n")  || str.equalsIgnoreCase("no")){
			 return true;
		 }else{
			 return false;
		 }
	 }

}
