package flightPath;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Layout extends JFrame {

	private int x, y;
	Container c = getContentPane();
	private int numOfNodes;
	public ArrayList<Cell> wallList = new ArrayList<>();

	public Layout(int x, int y) {
		this.x = x;
		this.y = y;
		numOfNodes = x;

		setTitle("Flight Path");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setSize(500, 500);

		createWallList();

		
		c.setLayout(new GridLayout(x, y));

		Cell newCell;

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {

				newCell = new Cell(i,j);

				for (int z = 0; z < wallList.size(); z++) {
					Cell testCell = wallList.get(z);
					if (i == testCell.x && j == testCell.y) {
						newCell.setWall(true);
						newCell.changeColor(Color.black);
						break;
					}
				}

				if (newCell.x == 0 && newCell.y == 0) {
					newCell.setWall(false);
					newCell.changeColor(Color.green);
				}
				if (newCell.x == x - 1 && newCell.y == y - 1) {
					newCell.setWall(false);
					newCell.changeColor(Color.red);
				}
				c.add(newCell);
			}
			
			
			
		}

		//Sets up the neighbors
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				ArrayList<Cell> neighbors = new ArrayList<>();
					if(getCell(i, j).x+1 < numOfNodes){
						neighbors.add(getCell(i+1,j));
					}
					if(getCell(i, j).x-1 >= 0){
						neighbors.add(getCell(i-1, j));
					}
					if(getCell(i, j).y+1 < numOfNodes){
						neighbors.add(getCell(i, j+1));
					}
					if(getCell(i, j).y-1 >= 0){
						neighbors.add(getCell(i, j-1));
					}

					//Start Diagonals
					// if(getCell(i, j).x+1 < numOfNodes && getCell(i, j).y+1 < numOfNodes){
					// 	neighbors.add(getCell(i+1,j+1));
					// }
					// if(getCell(i, j).x-1 >= 0 && getCell(i, j).y+1  >= 0){
					// 	neighbors.add(getCell(i-1, j+1));
					// }
					// if(getCell(i, j).x+1 < numOfNodes && getCell(i, j).y-1 < numOfNodes){
					// 	neighbors.add(getCell(i+1, j-1));
					// }
					// if(getCell(i, j).x-1 >= 0 && getCell(i, j).y-1 >= 0){
					// 	neighbors.add(getCell(i-1, j-1));
					// }
					getCell(i, j).setNeighbors(neighbors);
			}
		}

		setVisible(true);
	}

	private void createWallList() {
		Random rand = new Random();

		int percentage = (int) (Math.pow(numOfNodes, 2) * (float) .3);

		for (int x = 0; x < percentage; x++) {
			Cell wallCell = new Cell(rand.nextInt(numOfNodes), rand.nextInt(numOfNodes));
			while (wallList.contains(wallCell)) {
				wallCell = new Cell(rand.nextInt(numOfNodes), rand.nextInt(numOfNodes));
			}
			wallList.add(wallCell);

		}
	}

	public int getX(int x){
		return this.x = x;
	}

	public int getY(int y){
		return this.y = y;
	}

	public Cell getCell(int x, int y){
		Cell thisCell = (Cell) c.getComponent((x*numOfNodes)+y);
		return thisCell;
	}

	public int getSizeOfBoard(){
		return numOfNodes;
	}

	

}