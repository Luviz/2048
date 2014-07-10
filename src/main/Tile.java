package main;

public class Tile {
	private int value;
	/*to know the pos or not to kown*/
	
	Tile(int value) {
		this.value = value;
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
	
}
