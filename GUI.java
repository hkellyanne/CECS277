/*
 * 1) Kelly Hall
 * 2) October 23, 2016
 * 3) create a clicker game where a score increases and gets more difficult when image is clicked
 * 4) Input: User has the option to choose between 3 different images
 * 5) Output: outputting the interface, chosen image, and new/smaller image
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;


public class GUI extends JFrame{
	//create variables
	public JLabel image;
	Image img;
	private JLabel score = new JLabel("Score: 0");
	public int gamescore = 0;
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 900;
	public static String chosenpic = "owl.jpg";
	DrawImage newscore = new DrawImage(score);

	public GUI(){
		
		//set JFrame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		createComponents();
		add(newscore);
		
		//create menu
		JMenuBar menuBar;
		JMenu chooseImage;
		
				menuBar = new JMenuBar();	
				chooseImage = new JMenu("Choose your image");
				menuBar.add(chooseImage);
				
				//create menu option #1
				JMenuItem option1 = new JMenuItem("Owl");
			    option1.addActionListener(new ActionListener() {
			        @Override
			    	public void actionPerformed(ActionEvent arg0) {
						chosenpic = "owl.jpg";
						newscore.setPic(chosenpic);
			        }

			    });
				chooseImage.add(option1);
				chooseImage.addSeparator();
				
				//create menu option #2
				JMenuItem option2 = new JMenuItem("Frog");
			    option2.addActionListener(new ActionListener() {
				@Override
			        public void actionPerformed(ActionEvent arg0) {
						chosenpic = "frog.jpg";
						newscore.setPic(chosenpic);
			        }
			    });
				chooseImage.add(option2);
				chooseImage.addSeparator();
				
				
				//create menu option #3
				JMenuItem option3 = new JMenuItem("Plankton");
			    option3.addActionListener(new ActionListener() {
			        @Override
			    	public void actionPerformed(ActionEvent arg0) {
						chosenpic = "plankton.jpg";
						newscore.setPic(chosenpic);
			        }
			    });
				chooseImage.add(option3);				
				chooseImage.addSeparator();
	
				setJMenuBar(menuBar);
				
		
		
		
	}//end of GUI constructor
	
	//create components of the frame
	private void createComponents(){
				
				score.setHorizontalAlignment(SwingConstants.CENTER); 
				add(score, BorderLayout.NORTH);

	}//end of createComponents

}//end of GUI
