package playerPackage;

import sourcePackage.nim;
import utilityPackage.utility;

public class playerClass {
	/**
	  * Select Random Player to start
	  *
	  **/
	 public static int selectRandomPlayerToStart(nim n1){
		 int check = 0;
		 if(utility.generateRandom(n1.getMaxValue()) == 1){
			 n1.setComputersTurn(false);
			 check = 1;
		 }else{
			 n1.setComputersTurn(true);
			 check = 2;
		 }
		 return check;
	 }

}
