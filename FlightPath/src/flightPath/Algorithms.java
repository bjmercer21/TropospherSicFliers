package flightPath;


public class Algorithms {

	static int testNum = 50;

	public static Layout board = new Layout(testNum,testNum);



	public static void main(String[] args) {
		//new AStar(board);	
		
		new DepthFirst(board);
	}


}