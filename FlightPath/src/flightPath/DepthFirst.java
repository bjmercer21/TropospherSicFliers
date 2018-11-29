package flightPath;

import java.awt.Color;
import java.util.ArrayList;


public class DepthFirst
{
    private Layout board;
    Cell endCell;
    Cell startCell;
    Cell current;
    Cell tmp;
    ArrayList<Cell> open = new ArrayList<>();
    ArrayList<Cell> closed = new ArrayList<>();
    ArrayList<Cell> totalPath = new ArrayList<>();
    
    public DepthFirst (Layout board)
    {
        this.board = board;
        startCell = board.getCell(0, 0);
        //endCell = board.getCell(board.getSizeOfBoard()-1, board.getSizeOfBoard()-1);
        
        open.add(startCell);
        current = open.get(0);
        
        searchPath(board, current, open);
    } 
    
    public boolean searchPath(Layout board, Cell cell, ArrayList<Cell> path)
    {
        if (cell == board.getCell(board.getSizeOfBoard() - 1, board.getSizeOfBoard() - 1))
        {
            path.add(cell);
            return true;
        }
        
        if (!cell.isWall())
        {
            cell.changeColor(Color.BLUE);
            
            int dx = -1;
            int dy = 0;
            if (searchPath(board, board.getCell(cell.getX() + dx, cell.getY() + dy), path))
            {
                path.add(board.getCell(cell.getX() + dx, cell.getY() + dy));
                return true;
            }
            
            dx = 1;
            dy = 0;
            if (searchPath(board, board.getCell(cell.getX() + dx, cell.getY() + dy), path))
            {
                path.add(board.getCell(cell.getX() + dx, cell.getY() + dy));
                return true;
            }
            
            dx = 0;
            dy = -1;
            if (searchPath(board, board.getCell(cell.getX() + dx, cell.getY() + dy), path))
            {
                path.add(board.getCell(cell.getX() + dx, cell.getY() + dy));
                return true;
            }
            
            dx = 1;
            dy = 1;
            if (searchPath(board, board.getCell(cell.getX() + dx, cell.getY() + dy), path))
            {
                path.add(board.getCell(cell.getX() + dx, cell.getY() + dy));
                return true;
            }
        }
        return false;
    }
}