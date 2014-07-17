package main;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiOne extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9143511061950868095L;

	ArrayList<ArrayList<JTextArea>> grid;
	JPanel panel;

	GuiOne() {
		inti();
		setting();
	}

	private void inti() {
		panel = new JPanel(null);

		grid = new ArrayList<>(4);

		JTextArea tmp = new JTextArea("0000");
		tmp.setSize(tmp.getPreferredSize());
		tmp.setBackground(Color.WHITE);
		for (int i = 0; i < 4; i++)
			grid.add(new ArrayList<JTextArea>());
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				grid.get(i).add(new JTextArea());
				// setSize
				grid.get(i).get(j).setSize(tmp.getSize());
				// setting location
				grid.get(i).get(j).setLocation(j * (tmp.getSize().width+10) + 20,i * (tmp.getSize().height+10) + 20);
				// ADDING To Panel
				panel.add(grid.get(i).get(j));
			}
		}
	}

	private void setting() {
		setSize(600, 800);
		add(panel);
	}

}
