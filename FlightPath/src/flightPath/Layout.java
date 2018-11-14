package flightPath;

import java.awt.Container;
import java.awt.GridLayout;
import java.lang.Math;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@SuppressWarnings("serial")
public class Layout extends JFrame {

	// this will be variable by the end, 10 is just a test number
	int numOfNodes = 25;
	boolean foundWall;
	private Cell[] cellBoard = new Cell[(int) Math.pow(numOfNodes, 2)];
	ArrayList<Integer> masterNodeLocations = new ArrayList<>();
	ArrayList<Integer> wallList = new ArrayList<>();

	public static void main(String[] args) {

		new Layout();
	}

	private JPanel p = new JPanel();

	public Layout() {
		setTitle("Flight Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);
		setResizable(false);

		Container c = getContentPane();

		// Adds numbers to a list to be used to determine walls
		for (int x = 0; x < (int) (Math.pow(numOfNodes, 2)); x++) {
			masterNodeLocations.add(x);
		}

		p.setLayout(new GridLayout(numOfNodes, numOfNodes));
		masterWallList();
		

		for (int x = 0; x < (int) Math.pow(numOfNodes, 2); x++) {
			Cell nextCell = new Cell(x);

			if (wallList.contains(x)) {
				nextCell.drawWall();
			}
			

			cellBoard[x] = nextCell;
			p.add(cellBoard[x]);

			// adds the cell to the flight layout
			c.add(p);
		}
		setVisible(true);
	}

	// Used to create a list of locations that will be walls
	private void masterWallList() {
		Random rand = new Random();
		int percentage = (int) (masterNodeLocations.size() * (float) .25);
		ArrayList<Integer> temp = masterNodeLocations;

		for (int x = 0; x < percentage; x++) {
			int wallNum = rand.nextInt(temp.size());
			while (wallList.contains(wallNum) || wallNum == 0 || wallNum == temp.size()-1) {
				wallNum = rand.nextInt(temp.size());
			}
			wallList.add(wallNum);
		}
		Collections.sort(wallList);
	}
}
