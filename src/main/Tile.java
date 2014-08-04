package main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tile extends JLabel{
	private int value;
	private Coord coord;
	/*to know the pos or not to kown*/
	
	Tile(int value) {
		this.value = value;
		
		if (value > 0){
			this.setSize(80, 80);
			setIcon(new ImageIcon(new Integer(value).toString()+".png"));
		}else{
			setSize(0, 0);
		}
	}
	
	Tile(int value , Coord coord) {
		this.coord = coord;
		this.value = value;
				
		if (value > 0){
			setIcon(new ImageIcon(new Integer(value).toString()+".png"));
			this.setSize(80, 80);
		}else{
			this.setSize(0, 0);
		}
	}
	
	public void setLoc(){
		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void addValue (int value){
		this.value += value;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	
	
	
}
