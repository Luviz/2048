package main;

import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("unused")
class Lunch {
	public static void main(String [] args) throws IOException {
		System.out.println("hello");
		
		GuiTwo go = new GuiTwo();
		go.setVisible(true);
		go.setDefaultCloseOperation(go.EXIT_ON_CLOSE);
		
		for (int i =0 ; i < 10 ; i++){
			System.in.read();
			go.move(i);
		}
		
		//cmd interface
		/*
		Grid g = new Grid();
		g.dprint();
		boolean run = true;
		Scanner s = new Scanner(System.in);
		while (run){
			System.out.println("w,a,s,d and 0 to exit");
			char in = new String(s.nextLine()).charAt(0);
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
			
			//System.out.println("lunch> while");
			g.dprint();
		}
		s.close();
		//*/
	
		System.out.println("The END!");
	}
	
}