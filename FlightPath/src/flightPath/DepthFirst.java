package flightPath;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;


public class DepthFirst
{
    private Layout board;
    
    public DepthFirst (Layout board)
    {
        this.board = board;
	Cell startCell = board.getCell(0, 0);
	Cell endCell = board.getCell(board.getSizeOfBoard()-1, board.getSizeOfBoard()-1);
	DFS(startCell, endCell);
    }
    
    void DFS(Cell startCell, Cell endCell)
    {
        startCell.setVisited(true);
        ArrayList<Cell> unvisited = new ArrayList<>();
	ArrayList<Cell> visited = new ArrayList<>();
	unvisited.add(startCell);
        
        while(unvisited.size() > 0)
        {
            Cell cell = unvisited.remove(0);
            if(cell == endCell)
            {
                Cell v = endCell;
                while(v != startCell)
                {
                    v.setBackground(Color.yellow);
                    v = v.parent;
                }
                return;
            }
            
            if (cell.getNeighbors() == null)
            {
                visited.remove(cell);
            }
            else
            {
                visited.add(cell);
                Collections.shuffle(cell.getNeighbors());
                for(Cell neighbor: cell.getNeighbors())
                {
                    if (!visited.contains(neighbor) && !unvisited.contains(neighbor)) 
                    {
                        if (!neighbor.isWall())
                        {
                            neighbor.parent = cell;
                            unvisited.add(neighbor);
                            neighbor.setBackground(Color.pink);
                            try
                            {
                                Thread.sleep(50);
                            }
                            catch (InterruptedException e)
                            {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }	
    }
}