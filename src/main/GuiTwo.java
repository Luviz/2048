package main;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiTwo extends JFrame{
	private JPanel container;
	
	private JPanel	uPanel;
	private JPanel panel;
	
	private ImageIcon test;
	private JLabel gridBg;
	
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
				System.out.println(getSize());
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
		container = new JPanel(null);
		//container.setLayout(new GridBagConstraints());
		
		
		uPanel = new JPanel(null);
		uPanel.setBackground(Color.BLUE);
		uPanel.setSize(100, 100);
		uPanel.setLocation(50, 50);
		
		addKeyListener(new kL());
		
		panel = new JPanel(null);
		//panel.setSize(400, 400);
		panel.setLocation(10, 100);
		panel.setBackground(Color.black);
		
		g = new ArrayList<>();
		g.add(new Point(10, 10));
		g.add(new Point(90, 90));
		g.add(new Point(180, 180));
		
		grid = new Grid();
		
		test = new ImageIcon("two.png");
		
		gridBg = new JLabel(new ImageIcon("gridbg.png"));
	
		gridBg.setSize(new ImageIcon("gridbg.png").getIconHeight(),new ImageIcon("gridbg.png").getIconHeight());
		gridBg.setLocation(panel.getLocation());
		
		
		
		//vGrid;
		vGrid = new ArrayList<>(4);
		for (int i =0; i <  4 ; i++){
			vGrid.add(new ArrayList<JLabel>());
			for (int j = 0; j < 4; j++) {
				vGrid.get(i).add(new JLabel(new ImageIcon("null.png")));
				vGrid.get(i).get(j).setLocation(panel.getLocation().x+10+j*90, panel.getLocation().y+10+i*90);
				vGrid.get(i).get(j).setSize(80, 80);
				panel.add(vGrid.get(i).get(j));
			}
		}
		panel.add(gridBg);
		System.out.println("maxsize"+vGrid.get(3).get(3).getLocation().toString());
		
	}
	
	private void setting() {
		setSize(gridBg.getLocation().x + gridBg.getSize().width +25	, gridBg.getLocation().y + gridBg.getSize().height +60) ;

	}
	
	private void render(){
		//panel.add(jlTest);
		update();
		add(uPanel);
		add(panel);
	}
	
	public void update(){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (grid.getTile(j, i) != null) {
					vGrid.get(i).get(j).setIcon(new ImageIcon(new Integer(grid.getTile(j, i).getValue()).toString()+ ".png"));
				}else{
					vGrid.get(i).get(j).setIcon(new ImageIcon("null1.png"));
				}
				
			}
		}
		grid.dprint(); 	//DEBUG
	}
	
	

	
	
}
