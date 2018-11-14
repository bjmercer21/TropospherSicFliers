package flightPath;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Cell extends JButton {
	private boolean isWall=false;
	private int location;
	private Color wall = Color.black;
	private static int width = 50;
	private static int height = 50;
	private static Color backgroundColor = Color.white;

	private void changeColor(Color c) {
		// using JButton code to set the change color method
		setBackground(c);
		paintImmediately(0, 0, width, height);}
		
	//Constructor for the cells
	public Cell(int location) {
		//To use to find where node is on layout
		this.location = location;
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		changeColor(backgroundColor);
		
	}
	
	//used to draw the cells black that will be a wall
	public void drawWall() {
		changeColor(wall);
	}
}