package com.sample;

public class SimpleOrbital implements Comparable<SimpleOrbital> {
	private int n;
	private int l;
	// private int ml;
	// private double ms;
	private int electron ;
	// private boolean filled = false;

	public static final int s = 0;
	public static final int p = 1;
	public static final int d = 2;
	public static final int f = 3;

	// private static final double spinUp = 0.5;
	// private static final double spinDown = -0.5;

	public SimpleOrbital() {

	}

	public SimpleOrbital(int n, int l) {
		this.n = n;
		this.l = l;
		// this.ml = ml;
		// this.ms = ms;
	}

	/**
	 * @return the n First Quantum Number ==> Shell
	 */
	public int getN() {
		return n;
	}

	/**
	 * @param n
	 *            the n (First Quantum Number ==> Shell) to set
	 */
	public void setN(int n) {
		this.n = n;
	}

	/**
	 * @return the l (Second Quantum Number ==> subShell)
	 */
	public int getL() {
		return l;
	}

	/**
	 * @param l
	 *            the l (Second Quantum Number ==> subShell) to set
	 */
	public void setL(int l) {
		this.l = l;
	}
	
	public int Elv() {
		return n + l;
	}

	@Override
	public String toString() {
		String s = String.format("%s%s%s", n, getSubShell(), electron);
		return s;
	}

	public String getSubShell(){
		String subShell = "";
		switch (l) {
		case 0:
			subShell = "s";
			break;
		case 1:
			subShell = "p";
			break;
		case 2:
			subShell = "d";
			break;
		case 3:
			subShell = "f";
			break;
		}
		return subShell;
	}
	

	public int getElectron() {
		return electron;
	}

	public void setElectron(int electron) {
		this.electron = electron;
	}
	
	public void setHalf() {
		electron = (2*l)+1;
	}

	public void setFull() {
		electron = (4*l) +2;
	}
	
	public int compareTo(SimpleOrbital orb){
		int comparedElv = orb.Elv();
		int comparedN = orb.n;
		
		if(this.Elv() > comparedElv){
			return 1;
		}else if (this.Elv() == comparedElv ) {
			if ( this.n > comparedN) {
				return 1;
			}else if(this.n==comparedN){
				return 0;
			}else {
				return -1;
			}
		}else{
			return -1;
		}
		
	}
}
