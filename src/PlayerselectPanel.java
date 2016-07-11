import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerselectPanel extends JPanel{
	class TheMouseListener implements MouseListener {
		private int destination = 0;
		public TheMouseListener(int n){
			destination = n;
		}
		public void mouseClicked(MouseEvent arg0) {		
			if (destination == 2){
				Frame.toMain();
			}
			if (destination == 1){
				Frame.playernameget(1);
			}
			if (destination == 0){
				Frame.playernameget(0);
			}
		}
		public void mouseEntered(MouseEvent arg0) {
			tostate(destination);
			if (destination==2){
				Back.playSound();
			}
		}
		public void mouseExited(MouseEvent arg0) {
			if (destination < 2)
			background[destination].requestFocus();
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent arg0) {
			//
			
		}
	}
	class TheKeyListener implements KeyListener{
		private int status = 0;
		public TheKeyListener (int n){
			if (n==0 || n==1 || n==2){
				status = n;
			}
		}
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
					if (getStatus() == 0 || getStatus() == 1){
						Frame.playernameget(status);
					}
					else {
						Frame.toMain();
					}
				}
				if (arg0.getKeyCode() == KeyEvent.VK_DOWN){
					tostate(status + 1);
				}
				else if (arg0.getKeyCode() == KeyEvent.VK_UP){
					tostate(status - 1);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			} 
			
		}

	private GameArena Frame;
	private ImageIcon folder[] = new ImageIcon[2];
	private JLabel background[] = new JLabel[2];
	private int width=1340;
	private int height = 700;
	private int status = 0;
	private AudioWav Back = new AudioWav("Cancel2.wav");
	public synchronized int getStatus() {
		return status;
	}
	public synchronized void initialize() {
		folder[0] = new ImageIcon("One Player Select.jpg");
		folder[1] = new ImageIcon("Two Player Select.jpg");
		setSize(width,height);
		setLayout(null);
		for (int i = 0 ; i < background.length ; i++){ 
			background[i] = new JLabel(folder[i]);
			background[i].setBounds(10,0,0,0);
			background[i].setSize(width,height);
			add(background[i]);
			background[i].addKeyListener(new TheKeyListener(i));
			background[i].setVisible(false);
		}
		JLabel one = new JLabel();
		one.setBounds(118,228,370,100);
		one.addMouseListener(new TheMouseListener(0));
		JLabel two = new JLabel();
		two.setBounds(113,407,372,95);
		two.addMouseListener(new TheMouseListener(1));
		JLabel Back = new JLabel();
		Back.setBounds(0,510,210,170);
		Back.addMouseListener(new TheMouseListener(2));
		add(Back);
		add(one);
		add(two);
		tostate(0);
	}
	public synchronized void tostate(int n){
		if (n >= 1) status = 1;
		else if ( n <= 0)status = 0;
		else status = n;
		for (int i = 0 ; i < background.length ; i++){
			background[i].setVisible(false);
		}
			background[status].setVisible(true);
			background[status].requestFocus();
	}
	public void setArena(GameArena t){
		Frame = t;
	}
}