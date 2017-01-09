/*
 * 1) Kelly Hall
 * 2) October 23, 2016
 * 3) create a clicker game where a score increases and gets more difficult when image is clicked
 * 4) Input: User has the option to choose between 3 different images
 * 5) Output: outputting the interface, chosen image, and new/smaller image
 */

package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class DrawImage extends JPanel implements MouseListener
{		
	//create variables
	public JLabel score;
	
	JMenuBar menuBar;
	String chosenpic = "owl.jpg";
	int gamescore = 0;
	private int imgHeight = 256;
	private int imgWidth = 256;
	private double x = Math.random();
	private double y = Math.random();
	private int speed = 1000;
	Timer t;

	ImageIcon icon = new ImageIcon(chosenpic);
	Image img = icon.getImage();
	Image newimg;
	
	//set picture to what user chooses
	public void setPic(String chosenpic){
		ImageIcon icon = new ImageIcon(chosenpic);
		img = icon.getImage().getScaledInstance((int)(imgHeight), (int)(imgWidth), Image.SCALE_DEFAULT);
		this.chosenpic = chosenpic;
	}
	
	//get chosen picture
	public String getPic(){
		return this.chosenpic;
	}

	//get speed
	public int getSpeed(){
		return (int) speed;
	}
	
	//draw image
	DrawImage(JLabel score){	
		this.score = score;
		addMouseListener(this);
		
		//create timer and move image accordingly
		t = new Timer(getSpeed(), new ActionListener(){
			public void actionPerformed(ActionEvent e){			
				moveImage();				
			}			
		});

		t.start();

	}
	
	//make image appear randomly
	public void moveImage(){
		x = (600-img.getWidth(this)) * Math.random();
		y = (900-img.getHeight(this)*2) * Math.random();
		repaint();
	}
	
	//repaint (refresh) image when shrunken
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(img, (int) x, (int) y, this);

	}
	
	//when mouse is clicked, update the score
	@Override
	public void mouseClicked(MouseEvent e) {	
		if(((e.getX() > x) && (e.getX() < (x + imgWidth))) && ((e.getY() > y) && (e.getY() < (y + imgHeight))))
		{
			gamescore++;
			
			//when score is divisble by 5, make the image move faster
			score.setText("Score: " + gamescore);
			if (gamescore % 5 == 0 && gamescore != 0){
				t.setDelay(800);

			}
			
			//when score is divisible by 10, make image shrink
			if(gamescore % 10 == 0 && gamescore != 0){
				imgHeight /= 1.5;
				imgWidth /= 1.5;
				
				img = img.getScaledInstance((int)(imgHeight), (int)(imgWidth), Image.SCALE_DEFAULT);
			}		
		
		}
			
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}// end of DrawImage
