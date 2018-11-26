package flightPath;

import java.util.ArrayList;
import java.util.PriorityQueue;



public class Algorithms {

	static int testNum = 25;

	public static Layout board = new Layout(testNum,testNum);


	public static void main(String[] args) {
		System.out.print(board);
	}


	//A* algorithm starts here
	static PriorityQueue<Cell> open;
	static boolean closed[][];
	static ArrayList<Cell> aStarPath;

	public class AStar{
	
		public static final int DIAGONAL_COST = 14;
		public static final int VERTICAL_COST = 10;

		public void checkAndUpdateCost(Cell current, Cell temp, int cost){
			if(temp == null || closed[temp.x][temp.y])
				return;
			
			int tempFinalCost = temp.hValue + cost;

			boolean inOpen = open.contains(temp);
			if(!inOpen || tempFinalCost < temp.fValue){
				temp.fValue = tempFinalCost;
				temp.parent = current;
				if(!inOpen) open.add(temp);
			}
		}

		public  AStar(){
			Cell startCell =(Cell) board.getComponentAt(0,0);
			Cell endCell = (Cell) board.getComponentAt(testNum - 1, testNum - 1);
			Cell current;



			//add cell to open queue
			open.add(startCell);

			//starts looping through until it finds the end
			while(true){
				current = open.poll();
				if(current == null)
					break;
				closed[current.x][current.y] = true;

				if(current.equals(endCell)){
					return;
				}

				Cell temp;

				if(current.x-1 >= 0){
					temp = (Cell) board.getComponentAt(current.x - 1, current.y);
					checkAndUpdateCost(current, temp, current.fValue+VERTICAL_COST);
				
					if(current.y-1 >= 0){
						temp = (Cell) board.getComponentAt(current.x - 1, current.y-1);
						checkAndUpdateCost(current, temp, current.fValue+DIAGONAL_COST);
					}

					if(current.y+1 <= testNum){
						temp = (Cell) board.getComponentAt(current.x - 1, current.y+1);
						checkAndUpdateCost(current, temp, current.fValue+DIAGONAL_COST);
					}
				
				}

				if(current.y-1>=0){
					temp = (Cell) board.getComponentAt(current.x, current.y-1);
					checkAndUpdateCost(current, temp, current.fValue+VERTICAL_COST);
				}
				
				if(current.y+1 <= testNum){
					temp = (Cell) board.getComponentAt(current.x, current.y+1);
					checkAndUpdateCost(current, temp, current.fValue+VERTICAL_COST);
				}

				if(current.x+1 <= testNum){
					temp = (Cell) board.getComponentAt(current.x+1, current.y);
					checkAndUpdateCost(current, temp, current.fValue+VERTICAL_COST);
				}

				if(current.y-1 >=0){
					temp = (Cell) board.getComponentAt(current.x+1, current.y-1);
					checkAndUpdateCost(current, temp, current.fValue+DIAGONAL_COST);
				}

				if(current.y+1 <= testNum){
					temp = (Cell) board.getComponentAt(current.x+1, current.y+1);
					checkAndUpdateCost(current, temp, current.fValue+DIAGONAL_COST);
				}
			}

		}
	}



}