package utilityPackage;

import java.util.Random;

public class utility {
	
	 /**
	  * method that generates random number from 1 to 10
	  * 
	  **/
	 public static int generateRandom(int maxValue){
		 int randomNumber = 0;
		 Random random = new Random();
		 randomNumber = random.nextInt(maxValue) + 1;
		 return randomNumber;
	 }
	 
	 /**
	  * Method to print Status
	  * 
	  **/
	 public static int printStatus(int scope, int totalCoin){
		 int coinRest = totalCoin - scope;
		 printStatusString(coinRest);
		 return coinRest;
	 }
	 
	 public static void printStatusString(int coinRemaining){
		 System.out.println("Number of remaining coins = "+coinRemaining);
		 System.out.println("Take 1 or 2 or 3 coins");
	 }
	 /**
	  * Generate safe steps for agent 
	  * 
	  **/
	 public static int generateStepByScope(int coinRemaining){
		 int step = 0;
		 if(coinRemaining <= 20 && coinRemaining >= 18){
			 step = coinRemaining - 17;
		 }
		 if(coinRemaining <= 16 && coinRemaining >= 14){
			 step = coinRemaining - 13;
		 }
		 if(coinRemaining <= 12 && coinRemaining >= 10){
			 step = coinRemaining - 9;
		 }
		 if(coinRemaining <= 8 && coinRemaining >= 6){
			 step = coinRemaining - 5;
		 }
		 if(coinRemaining < 5){
			 step = coinRemaining - 1;
		 }
		 return step;
		 
	 }
	 
	 /**
	  * Method to print result
	  * 
	  **/
	 public static void printResult(boolean isAgentsTurn){
		 System.out.println();
		 if(isAgentsTurn){
			 System.out.println("Congrats!!! You Won");
		 }else{
			 System.out.println("Computer WINS");
		 }
		 System.out.println("Game Over");
	 }
	 
	 /**
	  * Move of agent with printing status
	  * 
	  **/
	 public static int moveOfAgent(int coinRemaining){
		 System.out.println();
		 int step = utility.generateStepByScope(coinRemaining);
		 return step;
	 }
	 
	 /**
	  * Method to print Agents Move
	  * 
	  **/
	 public static void printAgentsMove(int step){
		 System.out.println("Computer's move is = "+step);
	 }

}
