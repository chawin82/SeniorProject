import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class CreditFrame extends JFrame{
	private JLabel Background;
	public void initialize() {
		ImageIcon template = new ImageIcon("Frame Exit.jpg");
		Background = new JLabel(template);
		Container n = getContentPane();
		n.setLayout(null);
		Background.setBounds(0,0,700,700);
		n.add(Background);
		addWindowListener(new CloseListener());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700,700);
	}
	public class CloseListener implements WindowListener{

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			System.exit(-1);// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			System.exit(-1);// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
	}

}
