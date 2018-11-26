package flightPath;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Cell extends JButton {

	public int x, y;
	public Cell parent;
	public int hValue;
	public int fValue;
	public boolean solution;
	private Color defaultColor = Color.white;
	private boolean isWall;

	public void changeColor(Color c) {
		setBackground(c);
		repaint();
	}

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		setBorder(BorderFactory.createLineBorder(Color.black, 2));
		changeColor(defaultColor);
		setWall(false);
		setPreferredSize(new Dimension(50, 50));
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
}
