package flightPath;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	
	private int V;   // No. of vertices 
	private Layout board;
    
	public BFS(Layout board) {
		V = board.getSizeOfBoard();
		this.board = board;
		Cell startCell = board.getCell(0, 0);
		Cell endCell = board.getCell(board.getSizeOfBoard()-1, board.getSizeOfBoard()-1);
		BFS(startCell, endCell);
	} 


	
	void BFS(Cell cellStart, Cell endCell) {
		//Create an Array of Unvisited
		//Everytime you check a neighbor 
		cellStart.setVisited(true);
		ArrayList<Cell> unvisited = new ArrayList<>();
		ArrayList<Cell> visited = new ArrayList<>();
		unvisited.add(cellStart);
		
		while(unvisited.size() > 0) {
			Cell cell = unvisited.remove(0);
			if(cell == endCell) {
				Cell v = endCell;
				while(v != cellStart) {
					v.setBackground(Color.blue);
					v = v.parent;
				}
				return;
			}
			visited.add(cell);
			Collections.shuffle(cell.getNeighbors());
			for(Cell neighbor: cell.getNeighbors()){
				if (!visited.contains(neighbor) && !unvisited.contains(neighbor)) {
					if (!neighbor.isWall()) {
						neighbor.parent = cell;
					unvisited.add(neighbor);
					neighbor.setBackground(Color.red);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				}
				
			}
			
		}
		
		
	}
}
