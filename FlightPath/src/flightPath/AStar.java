
package flightPath;

import java.awt.Color;
import java.util.ArrayList;




public class AStar{


//A* algorithm starts here
    protected ArrayList<Cell> open = new ArrayList<>();
    protected ArrayList<Cell> closed = new ArrayList<>();  
    private Layout board;

    public static final int DIAGONAL_COST = 14;
    public static final int VERTICAL_COST = 10;



    public  AStar(Layout board){

        this.board = board;
        Cell startCell = board.getCell(0, 0);
        Cell endCell = board.getCell(board.getSizeOfBoard()-1, board.getSizeOfBoard()-1);
        Cell current;
        ArrayList<Cell> totalPath = new ArrayList<>();

        

        //add cell to open queue
        open.add(startCell);

        while(!open.isEmpty()){
            current = open.get(0);
            for(int x=0; x<open.size(); x++){
                if(current.fValue < open.get(x).fValue){
                    current = open.get(x);                    
                }
            }

            Cell tempCell = current;
                totalPath.add(tempCell);
                while(tempCell.parent != null){
                    totalPath.add(tempCell.parent);
                    tempCell = tempCell.parent;
                }

            if(current.equals(endCell)){
                System.out.println("Done");
                break;
                }

            int indexToRemove = open.indexOf(current);
            open.remove(indexToRemove);
            closed.add(current);
            
            //Creates a variable to check all the neighbors
            ArrayList<Cell> neighbors = current.getNeighbors();

            
            for(int i = 0; i < neighbors.size();i++){
                Cell neighborCell = neighbors.get(i);
                if(!closed.contains(neighborCell) && !neighborCell.isWall()){
                    int tempG = current.gValue + VERTICAL_COST;

                    if(open.contains(neighborCell)){
                        if(tempG < neighborCell.gValue){
                            neighborCell.gValue = tempG;
                        }
                    } else {
                        neighborCell.gValue = tempG;
                        open.add(neighborCell);
                    }

                    neighborCell.hValue = Math.abs(neighborCell.x - endCell.x) + Math.abs(neighborCell.y - endCell.y);
                    neighborCell.fValue = neighborCell.gValue + neighborCell.hValue;
                    neighborCell.parent = current;

                }
            }

            closed.add(current);

            for(int i = 0; i < open.size(); i++){
                if(!open.get(i).equals(startCell)){
                    if(!open.get(i).equals(endCell)){
                        open.get(i).changeColor(Color.magenta);
                    }
                }
                 
            }
    
            for(int i = 0; i < closed.size(); i++){
                if(!closed.get(i).equals(startCell)){
                    if(!closed.get(i).equals(endCell)){
                        closed.get(i).changeColor(Color.pink);
                    }    
                }
            }
            for(int i = 0; i < totalPath.size(); i++){
                if(!totalPath.get(i).equals(startCell)){
                    if(!totalPath.get(i).equals(endCell)){
                        totalPath.get(i).changeColor(Color.BLUE);
                    }
                }
                   
            }
        }

        
        System.out.println(totalPath);

    }

   


}