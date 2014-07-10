package main; 

import java.util.ArrayList;

class Grid {
	
	/**grid.get(y).get(x)**/
	ArrayList<ArrayList<Tile>>grid;
	Rand rand = new Rand();
	
	Grid (){
		//gen 4x4
		grid = new ArrayList<>(4);
		
		//gen y then x
		for (int i = 0; i < 4; i++) {
			grid.add(new ArrayList<Tile>());
			for (int j =0 ; j < 4; j++){
				grid.get(i).add(null);
			}
		}
		for (int i = 0; i < 2; i++) {
			if(!genTile()){
				System.err.println("Grid: ctor> Grid full or could not gen any Tiles");
			}
		}
	}
	
	private boolean genTile(int x, int y, Tile newTile){
		boolean ret = false;
		if (grid.get(y).get(x) == null){
			grid.get(y).set(x, newTile);
			ret = true;
		}else{
			System.err.println("genTile: tile"+ x +" : "+ y +" is occupied!");
			ret = false;
		}
		return ret;
	}
	
	private boolean genTile(){
		ArrayList<Coord> cTmp = getNull();		//tempoeral Coord array	
		ArrayList<Object> rtmp = rand.newTile(cTmp.size());
		return genTile(cTmp.get((int) rtmp.get(1)).x, cTmp.get((int) rtmp.get(1)).y, (Tile)rtmp.get(0));
		
	}

	private ArrayList<Coord> getNull(){
		ArrayList<Coord> ret = new ArrayList<>();
	//	boolean full;				//humm I'm not sure about this one
		for (int i =0 ; i < 4; i ++){
			for (int j = 0; j < 4 ; j++) {
				if (grid.get(i).get(j) == null){
					ret.add(new Coord(j, i));
				}
			}
		}
		return ret;
	}
	
	
	public boolean sLeft(){
		boolean change = false;
		
		//i -> y | j -> x
		for (int i = 0 ; i < 4 ; i ++){
			for (int j = 0; j < 4 ; j++) {
				boolean tmp = mLeft(j, i);
				if (tmp == true)
					change = true;
			}
			aLeft(i);
		}
		if (change){
			//System.out.println(change);			//debug
			genTile();
		}
		return change;
	}
	
	/**
	 * MoveLeft 
	 * moving tile left
	 * (R)
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean mLeft(int x, int y){
		boolean ret = false; 		// basd on chenges
		
		//we r checking for x-1
		if (x > 0){
			//System.out.println("mLeft > x: "+ x+ " y: " + y);			//debug
			if (grid.get(y).get(x-1) == null && grid.get(y).get(x) != null){
				//moving
				grid.get(y).set(x-1 , grid.get(y).get(x));
				//setting x to null;
				grid.get(y).set(x , null);
				//System.out.println("mLeft > innerIf:");		//debug
				//dprint();										//debug
				mLeft(x-1, y);
				ret = true;
			}
		}
		
		return ret;
	}
	/**
	 * adds left wards
	 * if any chaenges it runs move to refitt
	 * @param y
	 * @return
	 */
	private boolean aLeft(int y){
		boolean ret = false;
		for (int i = 0; i < 3 ; i++) {
			if (grid.get(y).get(i) != null) {
				if (grid.get(y).get(i) != null && grid.get(y).get(i+1) != null) {
					if (grid.get(y).get(i).getValue() == grid.get(y).get(i + 1).getValue()) {
						grid.get(y).get(i).addValue(grid.get(y).get(i + 1).getValue());
						//nulling i+1
						grid.get(y).set(i+1, null);
						ret = true;
					}
				}
			}
		}
		//reswiping
		if (ret){
			System.out.println("aLeft");
			dprint();			//debug
			for (int i = 0; i < 4; i++) {
				mLeft(i, y);
			}
			dprint(); 			//debug
		}
		return ret;
	}
	
	/**
	 * debug print
	 */
	public void dprint(){
		System.out.println("-------");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int v = 0;
				if (grid.get(i).get(j) != null)
					v = grid.get(i).get(j).getValue();
				System.out.print(v+ " ");
				
			}
			System.out.println();
		}
		System.out.println("-------");
	}
	
}