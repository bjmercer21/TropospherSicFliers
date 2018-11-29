
package flightPath;

import java.awt.Color;
import java.util.ArrayList;




public class AStar{


//A* algorithm starts here
  
    private Layout board;
    Cell endCell;
    Cell startCell;
    Cell current;
    ArrayList<Cell> open = new ArrayList<>();
    ArrayList<Cell> closed = new ArrayList<>();
    ArrayList<Cell> totalPath = new ArrayList<>();

   
    public static final int VERTICAL_COST = 1;
    public boolean solution;



    public  AStar(Layout board){

        this.board = board;
        startCell = board.getCell(0, 0);
        endCell = board.getCell(board.getSizeOfBoard()-1, board.getSizeOfBoard()-1);
        
        //Calculate and set hValue to each cell
        for(int i = 0; i < board.getSizeOfBoard(); i++){
            for (int j = 0; j < board.getSizeOfBoard(); j++ ){
                Cell thisCell = board.getCell(i, j); 
                thisCell.hValue = Math.abs(thisCell.x - endCell.x) + Math.abs(thisCell.y - endCell.y);
            }
        }

        open.add(startCell);
        

        //Starts the A* Algorithm
        while(!open.isEmpty()){
        
        current = open.get(0);

         //Find cell with lowest F cost and store in current
        for(int x=0; x<open.size(); x++){
                if(open.get(x).fValue< current.fValue || open.get(x).fValue == current.fValue && open.get(x).hValue < current.hValue){
                    current = open.get(x);
                }
            }

        //Used later to remove current cell from open list
        int indexToRemove = open.indexOf(current);

        
        //end condition of found path 
        if(current.equals(endCell)){
            System.out.println("Done");
            solution = true;
            break;
        }


        
           
            
        //Creates an arraylist with all the neighbors for ease of 
        //checking and updating all neighbors
        ArrayList<Cell> neighbors = current.getNeighbors();
        
            
        for(int i = 0; i < neighbors.size();i++){
            Cell neighborCell = neighbors.get(i);

            //check to see if this cell is already been visited, or is a wall
            //if not, then we calculate its gValue
            if(!closed.contains(neighborCell) && !neighborCell.isWall()){

                //Set this gValue in a temp because it may not be
                //the lowest gValue
                int tempG = current.gValue + VERTICAL_COST;

                //if cell is in open set, and already has a gValue,
                //Check to see if tempG is lower.
                if(open.contains(neighborCell)){

                    //if TempG is lower we update the gValue and the Parent
                    if(tempG < neighborCell.gValue){
                        neighborCell.gValue = tempG;
                        neighborCell.parent = current;

                       
                    }
                // if this neighbor is not in open set, we assign a gValue
                //set its parent to our current cell, calc fValue, and add to open list
                } else {
                    neighborCell.gValue = tempG;
                    neighborCell.parent = current;

                    
                    open.add(neighborCell);

                }
                    
            }
                
        }

        // Update both open and closed lists.
        open.remove(indexToRemove);
        closed.add(current);
        
        

        //end condition of no solution
        if(!current.equals(endCell)&& open.isEmpty()){
            System.out.println("No Solution");
            solution = false;
            break;
        }


            // Painting the Cells
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

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        
        reconstructPath();

        for(int i = 0; i < totalPath.size(); i++){
                    if(!totalPath.get(i).equals(startCell)){
                        if(!totalPath.get(i).equals(endCell)){
                            totalPath.get(i).changeColor(Color.BLUE);
                        }
                    }
                       
                }
        

    }

    private ArrayList<Cell> reconstructPath(){
        Cell temp;
        if(solution){
            temp = endCell;
            while(temp.parent != null){
                totalPath.add(temp);
                temp = temp.parent;
            }
        }
        
        if(!solution){
            temp = current;
            while(temp.parent != null){
                totalPath.add(temp);
                temp = temp.parent;
            }
        }
        
        return totalPath;
    }

   


}