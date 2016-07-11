import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Gametwoplayerpanel extends JPanel{
	private GamePanel a= new GamePanel();
	private GamePanel b= new GamePanel();
	private Thread Fightingunit;
	private Thread watcher;
	private HeromovingUnit movingunit;
	private GameArena Frame;
	private String[] PlayeroneAttack = new String[4];
	private String[] Playeronedefend = new String[4];
	private String[] PlayertwoAttack = new String[4];
	private String[] Playertwodefend=new String[4];
	public void initialize() {
		setLayout(null);
		a.setBounds(0,0,0,0);
		a.setSize(670,700);
		a.setGameArena(Frame);
		b.setGameArena(Frame);
		a.setOpponent(b);
		a.setLanechangingkey("Alt");
		a.setPlayer(1);
		a.setattackkey(PlayeroneAttack);
		a.setdefendkey(Playeronedefend);
		a.initialize();
		//--------------
		b.setBounds(670,0,0,0);
		b.setSize(670,700);
		b.setOpponent(a);
		b.setLanechangingkey("Space");
		b.setPlayer(2);
		b.setattackkey(PlayertwoAttack);
		b.setdefendkey(Playertwodefend);
		b.initialize();
		movingunit = new HeromovingUnit();
		movingunit.initialize();
		a.setHeromovingUnit(movingunit);
		b.setHeromovingUnit(movingunit);
		movingunit.setBounds(200,0,940,200);
		Fightingunit = new Thread(movingunit);
		add(movingunit);
		add(a);
		add(b);
		ThreadManager program = new ThreadManager(a,b);
		watcher = new Thread(program);
		addFocusListener(new MyListener());
		setSize(1355,700);
		setVisible(true);

	}
	public void setGameArena(GameArena in){
		Frame = in;
	}
	public void setPlayeroneattackkey(String[] in){
		for (int i = 0 ; i < in.length ; i++){
			PlayeroneAttack[i] = in[i];
		}
	}
	public void setPlayeronedefendkey(String[] in){
		for (int i = 0 ; i < in.length ; i++){
			Playeronedefend[i] = in[i];
		}
	}
	public void setPlayertwoattackkey(String[] in){
		for (int i = 0 ; i < in.length ; i++){
			PlayertwoAttack[i] = in[i];
		}
	}
	public void setPlayertwodefendkey(String[] in){
		for (int i = 0 ; i < in.length ; i++){
			Playertwodefend[i] = in[i];
		}
	}
	public class MyListener implements FocusListener {
		public void focusGained(FocusEvent arg0) {
			if (!watcher.isAlive())watcher.start();
			if(!Fightingunit.isAlive())Fightingunit.start();
		}
		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	/*public class TheListener implements WindowListener {

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
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
			if (!watcher.isAlive())watcher.start();
			if(!Fightingunit.isAlive())Fightingunit.start();// TODO Auto-generated method stub
			
		}
		
	}*/
}
