package flightPath;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Cell extends JButton {
	private boolean isWall, isBorder, visited;
	private int coorX, coorY;
	private Cell neighborUp;
	private Cell neighborUpLeft;
	private Cell neighborUpRight;
	private Cell neighborDown;
	private Cell neighborDownLeft;
	private Cell neighborDownRight;
	private Cell neighborLeft;
	private Cell neighborRight;
	private Color wall = Color.black;
	private Color wasVisited = Color.blue;
	private static int width = 50;
	private static int height = 50;
	private static Color backgroundColor = Color.white;

	private void changeColor(Color c) {
		// using JButton code to set the change color method
		setBackground(c);
		repaint();
	}

	// Constructor for the cells
	public Cell(int coorX, int coorY) {

		// To use to find where node is on layout
		this.setCoorX(coorX);
		this.setCoorY(coorY);
		this.isBorder = false;
		this.visited = false;
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		changeColor(backgroundColor);

	}

	// used to draw the cells black that will be a wall
	public void drawWall() {
		changeColor(wall);
	}

	public void drawStart() {
		changeColor(Color.green);
	}

	public void drawEnd() {
		changeColor(Color.RED);
	}

	// Get the neighboring cells

	public Cell getNeighborUp() {
		return neighborUp;
	}

	public void setNeighborUp(Cell neighborUp) {
		this.neighborUp = new Cell(coorX, coorY - 1);

	}

	public Cell getNeighborUpLeft() {
		return neighborUpLeft;
	}

	public void setNeighborUpLeft(Cell neighborUpLeft) {
		this.neighborUpLeft = new Cell(coorX - 1, coorY - 1);

	}

	public Cell getNeighborUpRight() {
		return neighborUpRight;
	}

	public void setNeighborUpRight(Cell neighborUpRight) {

		this.neighborUpRight = new Cell(coorX + 1, coorY - 1);

	}

	public Cell getNeighborDown() {
		return neighborDown;
	}

	public void setNeighborDown(Cell neighborDown) {

		this.neighborDown = new Cell(coorX, coorY + 1);

	}

	public Cell getNeighborDownLeft() {
		return neighborDownLeft;
	}

	public void setNeighborDownLeft(Cell neighborDownLeft) {

		this.neighborDownLeft = new Cell(coorX - 1, coorY + 1);

	}

	public Cell getNeighborDownRight() {
		return neighborDownRight;
	}

	public void setNeighborDownRight(Cell neighborDownRight) {

		this.neighborDownRight = new Cell(coorX + 1, coorY + 1);

	}

	public Cell getNeighborLeft() {
		return neighborLeft;
	}

	public void setNeighborLeft(Cell neighborLeft) {

		this.neighborLeft = new Cell(coorX - 1, coorY);

	}

	public Cell getNeighborRight() {
		return neighborRight;
	}

	public void setNeighborRight(Cell neighborRight) {

		this.neighborRight = new Cell(coorX + 1, coorY);
	}

	public int getCoorX() {
		return coorX;
	}

	public void setCoorX(int coorX) {
		this.coorX = coorX;
	}

	public int getCoorY() {
		return coorY;
	}

	public void setCoorY(int coorY) {
		this.coorY = coorY;
	}

	public boolean isWall() {
		return isWall;
	}

	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}

	public void setBorder(boolean isBorder) {
		this.isBorder = isBorder;
	}

	public boolean getIsBorder() {
		return isBorder;
	}

	public String toString() {
		return "(" + coorX + ", " + coorY + ")";
	}

	
	public boolean equals(Cell one, Cell two) {
		if (one.getCoorX() == two.getCoorX() && one.getCoorY() == two.getCoorY()) {
			return true;
		} else {
			return false;
		}
	}

	public void setVisited(boolean visited) {
		this.visited = true;
	}
	
	
	
}