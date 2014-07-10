package main;

class Lunch {
	public static void main(String [] args) {
		System.out.println("hello");
		
		Grid g = new Grid();
		
		g.dprint();
		boolean run = true;
		
		System.out.println("While Start!");
		while (run) {
			run = false;
			System.out.println("RRRRRRRRRRR");
			System.out.println("sRight");
			System.out.println("RRRRRRRRRRR");
			while (g.sRight()) {

				System.out.println("sRight > end");
				g.dprint();
				run = true;
			}
			//g.dprint();
			System.out.println("LLLLLLLLL");
			System.out.println("sLeft");
			System.out.println("LLLLLLLLL");
			while (g.sLeft()) {

				System.out.println("sLeft > end");
				g.dprint();
				run = true;
			}
			System.out.println("END!");
		}
		System.out.println("While END");
		
		System.out.println("The END!");
	}
	
}