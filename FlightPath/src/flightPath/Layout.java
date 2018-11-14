package flightPath;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Layout extends JFrame {
	private Cell[] cellBoard = new Cell[81];

	public static void main(String[] args) {

		new Layout();
	}

	private JPanel p = new JPanel();

	public Layout() {
		setTitle("Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);
		setResizable(false);

		Container c = getContentPane();
		p.setLayout(new GridLayout(9, 9));

		// Chooses the color to make each cell

		for (int x = 0; x < 81; x++) {
			Cell nextCell;

			// Creates the new cell after finally figuring out the background color
			nextCell = new Cell();

			cellBoard[x] = nextCell;
			p.add(cellBoard[x]);
			// adds the cell to the game board itself
			c.add(p);

			setVisible(true);
		}
	}
}
