package com.sample;

import java.util.ArrayList;
import java.util.List;



public class Atom {
	private int initialElectron;
	private int electronLeft;
	//private List<Orbital> listOfOrbital;
	private int currentElv = 1;
	private int currentN = 1;
	public Atom() {
		
	}
	
	public Atom(int electronLeft){
		this.initialElectron = electronLeft;
		this.electronLeft = electronLeft;
	}
	
	public int getElectronLeft() {
		return electronLeft;
	}

	public void setElectronLeft(int electronLeft) {
		this.electronLeft = electronLeft;
	}

	public int getCurrentElv() {
		return currentElv;
	}

	public void setCurrentElv(int currentElv) {
		this.currentElv = currentElv;
	}

	public int getCurrentN() {
		return currentN;
	}

	public void setCurrentN(int currentN) {
		this.currentN = currentN;
	}
	
	public void setLowestN_forElv(int Elv) {
		this.currentN = getMin_n_forElv(Elv);
	}
	
	public int getMax_l_forElv(int Elv) {
		List<Integer> allL = new ArrayList<Integer>();
		for (int i = Elv; i > 0; i--) {
			if (Elv-i < i ) {
				allL.add(Elv-i);
			}
		}
//		allL.sort(null);
		return allL.get(allL.size()-1);
	}
	
	public int getMin_n_forElv(int Elv){
		return Elv - getMax_l_forElv(Elv);
	}
	
	public void nextSub() {
		if (currentN+1 > currentElv) {
			this.setCurrentElv(currentElv+1);
			this.setCurrentN(getMin_n_forElv(currentElv));
		}else{
			this.setCurrentN(currentN+1);
		}
	}
	
	public int getCurrentL() {
		return currentElv- currentN;
	}
	
	public int getMaxElectron(){
		int l = getCurrentL();
		return (4*l)+2;
	}

	public int getInitialElectron() {
		return initialElectron;
	}

	public void setInitialElectron(int initialElectron) {
		this.initialElectron = initialElectron;
	}
}
