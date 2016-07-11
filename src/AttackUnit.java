import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class AttackUnit extends JPanel implements ThePipeline,Runnable{
	private GamePanel g;
	private JSlider speed;
	private Patterndraw Output = new Patterndraw();
	private StatusPanel Status;
	private TheData Input ;
	private String[] template;
	private String[] Pattern;
	private HitListener keylistener;
	private int[] ScorePattern = new int[5];
	private int scoretoattack;
	private boolean wait = false;
	private boolean ismonitoring = false;
	public synchronized void setmonitorstatus(boolean in){
		ismonitoring = in;
		Output.setmonitorstatus(in);
	}
	public AttackUnit() {
		Input = new TheData();
		Pattern = new String[4];
		ScorePattern[0] = 20;
		ScorePattern[1] = 50;
		ScorePattern[2] = 100;
		ScorePattern[3] = 200;
		ScorePattern[4] = 500;
	}
	public AttackUnit (GamePanel p,HitListener l){
		Output = new Patterndraw();
		g = p;
		keylistener = l;
		addKeyListener(keylistener);
		Input = new TheData();
		Pattern = new String[4];
		ScorePattern[0] = 20;
		ScorePattern[1] = 50;
		ScorePattern[2] = 100;
		ScorePattern[3] = 200;
		ScorePattern[4] = 500;
	}
	public void setlanenumber(int in){
		Output.settemplate(in);
	}
	public int getWaittime() {
		return speed.getValue() + 2;
	}
	public void setJSlider(JSlider a){
		speed = a;
	}
	public void setWaittime(int n){
		Output.setwaittime(n);
	}
	public void patterngen() {
		for (int i=0 ; i<Pattern.length ; i++){
			Pattern[i] = template[(int)(Math.random()*template.length)];
		}
		int temp =(int)(ScorePattern.length*Math.random());
		scoretoattack = ScorePattern[temp];
		if (ismonitoring) g.setHeroslide(scoretoattack);
		Status.setstatus(temp);
	}
	public void changestatus() {
		wait = !wait;
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
	public void setGamePanel(GamePanel p){
		g= p;
	}
	public void setStatusPanel(StatusPanel p){
		Status = p;
	}
	public void focus(boolean n){
		super.requestFocus(n);
	}
	public void release() {
		Input.setText("");
		Output.setstatus(0);
	}
	public void actionperform() {
		g.sendPattern(Pattern, scoretoattack);
	}
	public synchronized void reset() {
		patterngen();
		Output.addPattern(Pattern);
	}
	public void run() {
		Output.setPipeline(this);
		Output.setDatabase(Input);
		reset();
		Output.initialize();
		Status.initialize();
		if (scoretoattack==20){
		Status.setstatus(0);
		}
		else if (scoretoattack==50){
			Status.setstatus(0);
		}
		else if (scoretoattack==100){
			Status.setstatus(1);
		}
		else if (scoretoattack==200){
			Status.setstatus(2);
		}
		else if (scoretoattack==500){
			Status.setstatus(3);
		}
		add(Output);
		setLayout(null);
		Output.setBounds(0,0,0,0);
		Output.setSize(150,500);
		Thread t = new Thread(Output);
		t.start();
	}
	public void endgame() {
		Output.endgame();
	}
	public void cannotdefend() {
	
		
	}
	public void attacksignal() {
		g.minusscoreforoneplayer(scoretoattack);
	}
}
