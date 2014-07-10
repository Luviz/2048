package main;

import java.util.ArrayList;
import java.util.Random;

public class Rand {
	private ArrayList<Integer> x;
	private ArrayList<Integer> y;
	
	private Random r;

	Rand() {
		r = new Random();
	}
	
	/**
	 * 
	 * @param range ....
	 *  
	 * @return - ArraList {Tile t, int a}
	 */
	public ArrayList<Object> newTile(int range){
		ArrayList<Object> ret = new ArrayList<>(2);
		int a, b;
		if (range > 0){
			a = r.nextInt(range);		// 	get item for Arraylist getnull()
			b = r.nextInt(10);			//	gen tile 2 or 4 10% chance of 4
			if (b != 9){
				ret.add(new Tile(2));
				ret.add(a);
			}else{
				ret.add(new Tile(4));
				ret.add(a);
			}
			return ret;
		}
			
		return null;
	}

	public ArrayList<Integer> getX() {
		return x;
	}

	public void setX(ArrayList<Integer> x) {
		this.x = x;
	}

	public ArrayList<Integer> getY() {
		return y;
	}

	public void setY(ArrayList<Integer> y) {
		this.y = y;
	}

	
	/*
	 * just incase!
	 */
	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}
	
	
	
	
	
}
