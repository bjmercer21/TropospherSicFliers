package flightPath;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


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
        endCell = board.getCell(board.getSizeOfBoard()-1, board.getSizeOfBoard()-1);
        
        open.add(startCell);
        current = open.get(0);
        
        
        for(int i = 0; i < board.getSizeOfBoard(); i++){
            for (int j = 0; j < board.getSizeOfBoard(); j++ ){
                tmp = board.getCell(i, j);
                if (!tmp.isWall())
                {
                    
                }
            }
        }
    }
    
    public static boolean searchPath (Layout board, List<Integer> path)
    {
        
        return false;
    }
}