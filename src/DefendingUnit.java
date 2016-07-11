import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class DefendingUnit extends JPanel implements ThePipeline,Runnable{
	private GamePanel g;
	private JSlider speed;
	private Patterndraw Output = new Patterndraw();
	private StatusPanel Status;
	private TheData Input;
	private String[] template;
	private String[] Pattern;
	private HitListener keylistener;
	private int attackedscore;
	private int player;
	private int waittime;
	private boolean ismonitoring = false;
	public DefendingUnit() {
		Input = new TheData();
		Pattern = new String[4];
	}
	public DefendingUnit (GamePanel p,HitListener l){
		Output = new Patterndraw();
		g = p;
		keylistener = l;
		addKeyListener(keylistener);
		Input = new TheData();
		Pattern = new String[4];
	}
	public synchronized void setmonitorstatus(boolean in){
		ismonitoring = in;
		Output.setmonitorstatus(in);
	}
	public void setJSlider(JSlider a){
		speed = a;
	}
	public void setwaittime(int n){
		waittime = n;
		Output.setwaittime(n);
	}
	public void receivepattern(String[] in,int score){
		Pattern = new String[in.length];
		for (int i = 0 ; i < Pattern.length ; i++){
			Pattern[i] = in[i];
		}
		Output.addPattern(Pattern);
		attackedscore = score;
		if (attackedscore==20)Status.setstatus(5);
		else if (attackedscore==50) Status.setstatus(6);
		else if (attackedscore==100) Status.setstatus(7);
		else if (attackedscore==200)Status.setstatus(8);
		else if (attackedscore==500)Status.setstatus(9);
	}
	public void setStatusPanel(StatusPanel p){
		Status = p;
	}
	public TheData getDatabase() {
		return Input;
	}
	public void setkey(String[] in) {
		template = new String[in.length];
		for (int i = 0 ; i < template.length ; i++){
			template[i] = in[i];
		}	
	}
	public void focus(boolean n){
		super.requestFocus(n);
	}
	public void release() {
		Input.setText("");
		Output.setstatus(0);
	}
	public void actionperform() {
		g.minusscore(attackedscore);
	}
	public void cannotdefend(){
		g.cannotdefend();
	}
	public void attacksignal() {
		g.attacksignal(attackedscore);
	}
	public void reset() {
		Status.setstatus(-1);
	}
	public void run() {
		Output.setPipeline(this);
		Output.settemplate(3);
		Output.setDatabase(Input);
		reset();
		Output.initialize();
		Status.initialize();
		add(Output);
		setLayout(null);
		Output.setBounds(0,0,0,0);
		Output.setSize(150,500);
		Thread t = new Thread(Output);
		t.start();
	}
	public void setGamePanel(GamePanel gamePanel) {
		g=gamePanel;
	}
	public void setKeyListener(HitListener l){
		addKeyListener(l);
	}
	public void endgame() {
		Output.endgame();
	}
}



