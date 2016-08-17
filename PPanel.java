package OneBallOneThread;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PPanel extends JPanel implements MouseListener
{
	public PPanel()
	{	
		setLayout(null);
		addMouseListener(this);
	}	
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		add( new PBall( e.getPoint()) );
	}

	@Override
	public void mouseClicked(MouseEvent e){}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
