package playerPackage;


import sourcePackage.nim;
import utilityPackage.utility;
import validationPackage.validate;

public class playerClass {
	
	private String gameStarter = null;
	 /**
	  * Select Random Player to start
	  *
	  **/
	 public static String selectRandomPlayerToStart(nim n1){
		 playerClass class1 = new playerClass();
		 if(utility.generateRandom(n1.getMaxValue()) == 1){
			 n1.setComputersTurn(false);
			 class1.gameStarter = "You should Start the Game";
		 }else{
			 n1.setComputersTurn(true);
			 class1.gameStarter = "Computer Starts the Game";
		 }
		 return class1.gameStarter;
	 }
	 
	 /**
	  * Method to check safe state for the agent
	  * 
	  **/
	 public static boolean isSafeForAgent(int scope, int coinRemaining){
		 int state = coinRemaining - scope;
		 if(state == 5)
			 return false;
		 else
			 return true;
	 }
	 
	 /**
	  * Confirm the Agent's safe state by asking again
	  * 
	  ***/
	 public static int askAgain(int scope, int coinRemaining){
		 if(isSafeForAgent(scope, coinRemaining)){
			 return scope;
		 }else{
			 for(int j=0;;j++){
				 System.out.println("Are you sure??? [Y/N].");
				 //take string input and validate
				 String str = validate.checkStringInput();
				 //String str = scanner.nextLine().toLowerCase();
				 
				 if(str.equalsIgnoreCase("Y") || str.equalsIgnoreCase("yes")){
					 if(!isSafeForAgent(scope, coinRemaining)){
						 continue;
					 }else{
						 break;
					 }
				 }
				 else if(str.equalsIgnoreCase("N") || str.equalsIgnoreCase("no")){
					 utility.printStatusString(coinRemaining);
					 System.out.println("Your Move Again :");
					//take integer input and validate
					 scope = validate.isCorrectInput(scope);
					 //scope = scanner.nextInt();
					 if(!isSafeForAgent(scope, coinRemaining)){
						 continue;
					 }else{
						 break;
					 }
				 }
				 else {
					 System.out.println("Incorrect Data");
				 }
			 }
		 }
		 return scope;
	 }

}
