package main;

import java.io.IOException;

class Lunch {
	public static void main(String [] args) {
		System.out.println("hello");
		
		Grid g = new Grid();
		
		g.dprint();
		boolean run = true;

		while (run){
			System.out.println("w,a,s,d and 0 to exit");
			try {
				char in =(char) System.in.read();
				switch (in) {
				case '0':
					run = false;
					break;
				case 'w':
					g.sUp();
					break;
				case 'a':
					g.sLeft();
					break;
				case 's':
					g.sDown();
					//System.out.println("not impelamented yet");
					break;
				case 'd':
					g.sRight();
					break;
				default:
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("lunch> while");
			g.dprint();
		}
		
		/*
		while (run){
			boolean tmp = true;
			while (tmp) {
				tmp = g.sUp();
				//System.out.println("up");
				//g.dprint();
				tmp = g.sLeft();
				//System.out.println("left");
				//g.dprint();
			}
			run = g.sRight();
			run = g.sUp();
			run = g.sLeft();
			g.dprint();
		}
		
//*/
		
		
		
		/*
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
		//*/
		System.out.println("The END!");
	}
	
}