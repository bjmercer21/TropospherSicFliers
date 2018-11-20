package flightPath;

import java.awt.Container;
import java.awt.GridLayout;
import java.lang.Math;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class Layout extends JFrame {

	// this will be variable by the end, 10 is just a test number
	static int numOfNodes = 25;
	boolean foundWall;
	private Cell[][] cellBoard = new Cell[numOfNodes][numOfNodes];
	ArrayList<Cell> wallList = new ArrayList<>();
	Cell startCell = new Cell(0, 0);
	Cell endCell = new Cell(numOfNodes - 1, numOfNodes - 1);
	Cell nullCell = null;
	
//	Algorithms testAlg = new Algorighms();

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

		p.setLayout(new GridLayout(numOfNodes, numOfNodes));

		createWallList();
		System.out.println(wallList);

		for (int x = 0; x < numOfNodes; x++) {
			for (int y = 0; y < numOfNodes; y++) {
				Cell nextCell = new Cell(x, y);
				if(nextCell.equals(nextCell,startCell)) {
					nextCell.drawStart();
				}
				if(nextCell.equals(nextCell, endCell)) {
					nextCell.drawEnd();
				}

				
				nextCell.setNeighborUp(nextCell);
				if(nextCell.getNeighborUp().getCoorY() == -1) {
					nextCell.setBorder(true);
				}
				nextCell.setNeighborDown(nextCell);
				nextCell.setNeighborLeft(nextCell);
				nextCell.setNeighborRight(nextCell);
				nextCell.setNeighborUpLeft(nextCell);
				nextCell.setNeighborUpRight(nextCell);
				nextCell.setNeighborDownLeft(nextCell);
				nextCell.setNeighborDownRight(nextCell);

				for (int z = 0; z < wallList.size(); z++) {
					if (nextCell.equals(nextCell, wallList.get(z))) {
						nextCell.setWall(true);
						nextCell.drawWall();
					}

				}

				cellBoard[x][y] = nextCell;
				p.add(cellBoard[x][y]);
		
				// adds the cell to the flight layout
				c.add(p);

			}

		}
		
		

		System.out.println(cellBoard[0][0].getNeighborUp());
		System.out.println(cellBoard[0][0].getIsBorder());
		System.out.println(cellBoard[0][0].getNeighborUpLeft());
		System.out.println(cellBoard[0][0].getNeighborUpRight());
		System.out.println(cellBoard[0][0].getNeighborDown());
		System.out.println(cellBoard[0][0].getNeighborDownLeft());
		System.out.println(cellBoard[0][0].getNeighborDownRight());
		System.out.println(cellBoard[0][0].getNeighborLeft());
		System.out.println(cellBoard[0][0].getNeighborRight());
		

		setVisible(true);

	}

	// Used to create a list of locations that will be walls
	private void createWallList() {
		Random rand = new Random();

		int percentage = (int) (Math.pow(numOfNodes, 2) * (float) .3);

		for (int x = 0; x < percentage; x++) {
			Cell wallCell = new Cell(rand.nextInt(numOfNodes), rand.nextInt(numOfNodes));
			while (wallList.contains(wallCell) || wallCell.equals(wallCell, startCell)
					|| wallCell.equals(wallCell, endCell)) {
				wallCell = new Cell(rand.nextInt(numOfNodes), rand.nextInt(numOfNodes));
			}
			wallList.add(wallCell);

		}
	}

	public static int getNumOfNodes() {
		return numOfNodes;
	}
}
