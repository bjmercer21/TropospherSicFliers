package flightPath;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Cell extends JButton {

	public int x, y;
	public Cell parent;
	public int hValue;
	public int gValue;
	public int fValue;
	private boolean isVisited = false;
	public boolean solution;
	private Color defaultColor = Color.white;
	private boolean isWall;
	private ArrayList<Cell> neighbors = new ArrayList<>();

	public void changeColor(Color c) {
		setBackground(c);
		repaint();
	}

	/**
	 * @return the isVisited
	 */
	public boolean isVisited() {
		return isVisited;
	}

	/**
	 * @param isVisited the isVisited to set
	 */
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		setBorder(BorderFactory.createLineBorder(Color.black, 2));
		changeColor(defaultColor);
		setWall(false);
		setPreferredSize(new Dimension(50, 50));
		fValue = hValue + gValue;
		
	}

	/**
	 * @return the isWall
	 */
	public boolean isWall() {
		return isWall;
	}

	/**
	 * @param isWall
	 *            the isWall to set
	 */
	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}

	public void setNeighbors(ArrayList<Cell> neighbors){
		this.neighbors = neighbors;
	}

	public ArrayList<Cell> getNeighbors(){
		return neighbors;
	}


}
