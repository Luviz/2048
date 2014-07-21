package main;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiTwo extends JFrame{
	private JPanel panel;
	private ImageIcon test;
	private JLabel jlTest;
	
	private ArrayList<ArrayList<JLabel>>vGrid;
	
	private Grid grid;
	
	private ArrayList<Point> g;
	
	private class kL implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				//System.out.println("l");
				grid.sLeft();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				grid.sRight();
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				grid.sUp();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN){
				grid.sDown();
			}
			update();
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	GuiTwo(){
		init();
		setting();
		render();
	}
	
	private void init(){
		addKeyListener(new kL());
		
		panel = new JPanel(null);
		
		g = new ArrayList<>();
		g.add(new Point(10, 10));
		g.add(new Point(90, 90));
		g.add(new Point(180, 180));
		
		grid = new Grid();
		
		test = new ImageIcon("two.png");
		jlTest = new JLabel(new ImageIcon("4.png"));
		jlTest.setLocation(10, 10);
		jlTest.setSize(80,80);
		
		//vGrid;
		vGrid = new ArrayList<>(4);
		for (int i =0; i <  4 ; i++){
			vGrid.add(new ArrayList<JLabel>());
			for (int j = 0; j < 4; j++) {
				vGrid.get(i).add(new JLabel(new ImageIcon("null.png")));
				vGrid.get(i).get(j).setLocation(10+j*90, 10+i*90);
				vGrid.get(i).get(j).setSize(80, 80);
				panel.add(vGrid.get(i).get(j));
			}
		}
		
	}
	
	private void setting() {
		setSize(480, 480);
	}
	
	private void render(){
		//panel.add(jlTest);
		update();
		add(panel);
	}
	
	public void update(){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (grid.getTile(j, i) != null) {
					vGrid.get(i).get(j).setIcon(new ImageIcon(new Integer(grid.getTile(j, i).getValue()).toString()+ ".png"));
				}else{
					vGrid.get(i).get(j).setIcon(new ImageIcon("null.png"));
				}
				
			}
		}
		grid.dprint(); 	//DEBUG
	}
	
	public void move(int i){
		if (g.size() > i){
			jlTest.setLocation(g.get(i));
			render();
		}
	}

	
	
}
