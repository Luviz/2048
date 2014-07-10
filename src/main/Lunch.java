package main;

class Lunch {
	public static void main(String [] args) {
		System.out.println("hello");
		
		Grid g = new Grid();
		
		g.dprint();
		System.out.println("sLeft");
		g.sLeft();
		System.out.println("sLeft > end");
		g.dprint();
		System.out.println("END!");
		
	}
	
}