package OneBallOneThread;

import javax.swing.JFrame;

public class PFrame extends JFrame
{
	public PFrame()
	{
		setTitle("Balls");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 100, 800, 500);		
		add( new PPanel() );		
		setVisible(true);
	}
}
