package com.sample;

import java.util.ArrayList;
import java.util.List;


public class Orbital {
	private  int n;
	private  int l;
	private  int ml;
	//private  double ms;
	private boolean marked = false;
	private boolean filled = false;

	
	public static final int s = 0;
	public static final int p = 1;
	public static final int d = 2;
	public static final int f = 3;

	//private static final double spinUp = 0.5;
	//private static final double spinDown = -0.5;

	public Orbital() {

	}

	public Orbital(int n, int l, int ml) {
		this.n = n;
		this.l = l;
		this.ml = ml;
		//this.ms = ms;
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

	/**
	 * @return the ml (Angular Quantum Number ==> position in subShell)
	 */
	public int getMl() {
		return ml;
	}

	/**
	 * @param ml
	 *            the ml (Angular Quantum Number ==> position in subShell) to
	 *            set
	 */
	public void setMl(int ml) {
		this.ml = ml;
	}

	

	public int Elv() {
		return n + l;
	}

	@Override
	public String toString() {

		return n + "," + l + "," + ml;

	}

	public String getFilled() {

		if (filled == true) {
			return this.toString();
		}
		else {
			return null;
		}
		
	}

	/**
	 * @return the filled
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * @param filled
	 *            the filled to set
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	
	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	
	

}
