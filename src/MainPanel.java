import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.lang.ClassLoader;


public class MainPanel extends JPanel{
	class TheMouseListener implements MouseListener {
		private int destination = 0;
		public TheMouseListener(int n){
			destination = n;
		}
		public void mouseClicked(MouseEvent arg0) {		
			if (destination == 3){
				Frame.exit();
			}
			if (destination == 2){
				try {
					Frame.HighScoreBoard();
				} catch (FileNotFoundException e) {		}
			}
			if (destination == 1){
				Frame.playerselect();
			}
		}
		public void mouseEntered(MouseEvent arg0) {
			tostate(destination);
		}
		public void mouseExited(MouseEvent arg0) {
			tostate(0);
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent arg0) {
			//
			
		}
		
	}
	private GameArena Frame;
	private ImageIcon folder[] = new ImageIcon[4];
	private JLabel background[] = new JLabel[4];
	private int width=1340;
	private int height = 700;
	public synchronized void initialize() {
		folder[0] = new ImageIcon("main.jpg");
		folder[1] = new ImageIcon("New Game.jpg");
		folder[2] = new ImageIcon("High Score.jpg");
		folder[3] = new ImageIcon("Exit.jpg");
		setSize(width,height);
		setLayout(null);
		for (int i = 0 ; i < background.length ; i++){ 
			background[i] = new JLabel(folder[i]);
			background[i].setBounds(10,0,0,0);
			background[i].setSize(width,height);
			add(background[i]);
			background[i].setVisible(false);
		}
		JLabel Newgame = new JLabel();
		Newgame.setBounds(36,322,242,242);
		Newgame.addMouseListener(new TheMouseListener(1));
		JLabel HighScore = new JLabel();
		HighScore.setBounds(280,335,270,273);
		HighScore.addMouseListener(new TheMouseListener(2));
		add(HighScore);
		add(Newgame);
		JLabel Exit = new JLabel();
		Exit.setBounds(573,372,234,211);
		Exit.addMouseListener(new TheMouseListener(3));
		add(Exit);
		tostate(0);
	}
	public void tostate(int n){
		for (int i = 0 ; i < background.length ; i++){
			background[i].setVisible(false);
		}
			background[n].setVisible(true);
	}
	public void setArena(GameArena t){
		Frame = t;
	}
}
