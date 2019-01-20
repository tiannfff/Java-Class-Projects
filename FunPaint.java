package java_hw;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JComponent;

@SuppressWarnings("serial")

public class FunPaint
{  
	/**
	 * Draws colored circles on a n*n grid size of a user choice
	 * @param g graphics to draw
	 */
	public static void draw(Graphics g)
	{  
		Scanner in = new Scanner(System.in);
		// ask user to enter a dimension number
		System.out.println("Enter Grid Dimension (an even number):");
		int GridDimension = 6; // initialize GridDimension
		int input = in.nextInt(); // user input of dimension
		
		// ask the user to reenter an even number until his input is valid
		while (input%2 != 0) {
			System.out.println("Enter Grid Dimension as EVEN number:");
			input = in.nextInt();
		}
		GridDimension = input;
	    
		// every grid will be drawn a graphics, so go through
		// each grid in the input dimension
		for (int row = 0;row<GridDimension;row++)
		{
			for (int column = 0;column<GridDimension;column++)
		    {
				// upper left of grids will be colored green
				if (row<GridDimension/2 && column<GridDimension/2) {
					g.setColor(Color.GREEN);
					// draw circle on the grid
					g.fillOval(row*60 + 50,column*60 + 50, 50,50);
				}
				// lower right of grids will be colored red
				else if(row>=GridDimension/2 && column>=GridDimension/2) {
					g.setColor(Color.RED);
					// draw circle on the grid
					g.fillOval(row*60 + 50,column*60 + 50, 50,50);
				}
				else {
					// other grids will be colored black
				    g.setColor(Color.BLACK);
				    // draw circle on the grid
				    g.fillOval(row*60 + 50,column*60 + 50, 50,50);	
				}
		    }
		}
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 800;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent component = new JComponent()
		{
			public void paintComponent(Graphics graph)
			{
				draw(graph);
			}
		};     
		frame.add(component);
		frame.setVisible(true);
   }   
}


