package sourcePackage;

import playerPackage.playerClass;
import utilityPackage.utility;
import validationPackage.validate;

/**
 * TODO
 * 
 * 1. Validation in input is required(Done)
 * 2. Implement Random user(Done)
 * 3. Further validations for players are required(Done).
 * 4. String input validation should be done.
 *   
 **/
public class nim {
	private boolean isComputersTurn = false;
	private int maxValue = 2;
	private int maxNumOfActions = 3;
	
 public static void main(String[] args){
//	 Scanner scanner = new Scanner(System.in);
	 nim n = new nim();
	 String msg = playerClass.selectRandomPlayerToStart(n);
	 System.out.println(msg);
	 int scope = 0;
	 int numberOfCoins = 21;
	 
	 for(int i=0;;i++){
		 if(i == 0){
			 scope = 0;
			 numberOfCoins = 21;
			 numberOfCoins = utility.printStatus(scope, numberOfCoins);
		 }else{
			 
			if(!n.isComputersTurn){
				//Human Player's move
				 System.out.println("Your Move :");				 
				 //take integer input and validate
				 scope = validate.isCorrectInput(scope);
				 //scope = scanner.nextInt();
				 
				 //Force the player
				 scope = playerClass.askAgain(scope, numberOfCoins);
				 numberOfCoins = utility.printStatus(scope, numberOfCoins);
				 n.setComputersTurn(true);
				 if(numberOfCoins == 1){
					 break;
				 }
			}else{
				//Computer's move
				 scope = utility.moveOfAgent(numberOfCoins);
				 if(scope == 0){
					 //Random(Unsafe) move for computer
					 scope = utility.generateRandom(n.maxNumOfActions);
					 utility.printAgentsMove(scope);
					 numberOfCoins = utility.printStatus(scope, numberOfCoins);
				 }else{
					 //Safe move of Computer
					 utility.printAgentsMove(scope);
					 numberOfCoins = utility.printStatus(scope, numberOfCoins);
				 }
				 n.setComputersTurn(false);				 
				 if(numberOfCoins == 1){
					 break;
				 }
			}
		 }
		 System.out.println();
	 }
	 utility.printResult(n.isComputersTurn);
 }
 
 public void setComputersTurn(boolean bol){
	 this.isComputersTurn = bol;
 }
 
 public boolean getComputersTurn(){
	 return isComputersTurn;
 }
 
 public int getMaxValue(){
	 return maxValue;
 }
}

