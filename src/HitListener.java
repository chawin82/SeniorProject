import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class HitListener implements KeyListener{
	private String changebutton = "";
	private ThePipeline monitor ;
	private TheData a ;
	private GamePanel g;
	public HitListener (ThePipeline m,TheData b,GamePanel z){// Define object that we want this listener to monitor
		monitor = m;
		a=b;
		g=z;
	}

	public void keyPressed(KeyEvent in) {
		String temp = String.valueOf(in.getKeyChar());
		temp = temp.trim();
		if (KeyEvent.getKeyText(in.getKeyCode()).equals(changebutton)
			) {
			monitor.focus(false);
			monitor.release();
			g.changemonitor();
		}
		else {
			a.setText(temp);
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	public void setchangingkey(String in){
		changebutton = in.trim();
	}
}
