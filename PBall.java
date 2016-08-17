package OneBallOneThread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;

public class PBall extends JPanel
{
	int dx;
	int dy;
	Color color;
	
	public PBall(Point p)
	{
		setLocation(p);
		setSize(30, 30);
		Random r = new Random();
		dx = r.nextInt(15) - 7;
		dy = r.nextInt(15) - 7;
		color = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
		repaint();
		
		new PanelThread();
	}
	
	@Override
	public void paint(Graphics g) 
	{
		//super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		gg.setColor(color);
		gg.fillOval(2, 2, 26, 26);
	}
	
	public void move()
	{
		Point p = getLocation();
		JPanel par = (JPanel) getParent();
		
		if( p.x < 0 || p.x + 30 > par.getWidth() )
			dx = -dx;
		if( p.y < 0 || p.y + 30 > par.getHeight() )
			dy = -dy;
		
		p.translate(dx, dy);
		setLocation(p);
	}	
	
	class PanelThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				move();
				
				try
				{
					sleep( 50 );
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}				
				
				repaint();
			}		
		}
		
		PanelThread()
		{
			start();
		}
	}
}
