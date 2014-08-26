package sourcePackage;

import java.util.Scanner;

import playerPackage.playerClass;

import utilityPackage.utility;

/**
 * TODO
 * 
 * 1. Validation in input is required
 * 2. Implement Random user(Only computer works now)
 * 3. Further validations for players are required.
 *   
 **/
public class nim {
	private boolean isComputersTurn = false;
	private int maxValue = 2; 
	
 public static void main(String[] args){
	 Scanner scanner = new Scanner(System.in);
	 nim n = new nim();
	 int flag = playerClass.selectRandomPlayerToStart(n);
	 System.out.println("flag ="+flag);
	 int scope;
	 int numberOfCoins = 21;
	 
	 for(int i=0;;i++){
		 if(i == 0){
			 scope = 0;
			 numberOfCoins = 21;
			 numberOfCoins = utility.printStatus(scope, numberOfCoins);
		 }else{
			 
			if(!n.isComputersTurn){
				//Human Player's move
				 scope = scanner.nextInt();
				 numberOfCoins = utility.printStatus(scope, numberOfCoins);
				 n.isComputersTurn = true;
				 if(numberOfCoins == 1){
					 break;
				 }
			}else{
				//computer's move
				 scope = utility.moveOfAgent(numberOfCoins);
				 numberOfCoins = utility.printStatus(scope, numberOfCoins);
				 n.isComputersTurn = false;
				 
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

