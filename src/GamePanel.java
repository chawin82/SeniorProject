import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class GamePanel extends JPanel{
	private JSlider Speed = new JSlider(0,7);
	private JTextArea Score = new JTextArea("2000");
	private String[] defendkey = new String[4];
	private String[] attackkey = new String[4];
	private String lanechangekey;
	private AttackUnit attack1 = new AttackUnit();
	private AttackUnit attack2 = new AttackUnit();
	private DefendingUnit defend = new DefendingUnit();
	private StatusPanel[] AllStatusBoard = new StatusPanel[3];
	private JTextArea Scoreforoneplayer = new JTextArea("0");
	private int status = 0;
	private int score = 2000;
	private int scoreforoneplayer = 0;
	private GamePanel Opponent;
	private GameArena Frame;
	private String playername;
	private int player;
	private HeromovingUnit HeroPanel;
	private HeromovingUnit HeroPanelforonePlayer;
	private StatusPanel s= new StatusPanel();
	private boolean istrainingmode = false;
	//----------------Constructor---------------------------------
	public GamePanel() { // Create GamePanel with default score=100
		
	}
	public GamePanel(int n){// Create GamePanel with default score = n;
		setscore(n);
	}
	public GamePanel(int n ,GamePanel g){
		Opponent = g;
		setscore(n);
	}
	public GamePanel(GamePanel g){
		Opponent = g;
	}
	//---------------------------------------------------------------
	//--------------------name--------------------------------------
	public synchronized void setName(String in) {
		playername = in;
	}
	public synchronized String getName() {
		return playername;
	}
	//---------------------Dealing with Score-----------------------
	public synchronized void setscore(int n){//SetScore to start 
		if (n > 100) score = n;
	}
	public synchronized int getscore(){
		return score;
	}
	public synchronized int getLevel() {
		return Speed.getValue()+1;
	}
	public synchronized void minusscore (int n){//Score minus
		if (istrainingmode) return;
		if (n <= 0) return;
		score = score - n;
		Score.setText("" + score);
		if (score <= 0){
			end();
			if (!istrainingmode) {
				Opponent.end();
				HeroPanel.setdie(player);
			}
		}
	}
	public synchronized void minusscoreforoneplayer(int n){
		if (istrainingmode) {
			score = score - n;
			Score.setText("" + score);
			if (score <= 0) {
				end();
				HeroPanelforonePlayer.setdie(1);
			}
			else {
				HeroPanelforonePlayer.gotattacked(1, 200);
			}
		}
	}
	public void end() {
		attack1.endgame();
		attack2.endgame();
		if (istrainingmode){
			Frame.toMain();
			return;
		}
		if (!istrainingmode) defend.endgame();
		if (player == 1){
			Frame.setscoreplayerone(score);
			Frame.setLeveldiff(Math.abs(Opponent.getLevel()-getLevel()));
		}
		else {
			Frame.setscoreplayertwo(score);
		}
	}
	//-------------Dealing with Hero moving Unit--------------
	public void setHeromovingUnit(HeromovingUnit in){
		HeroPanel = in;
	}
	public synchronized void cannotdefend(){
		if (!istrainingmode) HeroPanel.cannotdefend(player);
	}
	public synchronized void attacksignal(int n){
		if (istrainingmode) return;
		if (player == 1)HeroPanel.attack(2,n);
		if (player == 2)HeroPanel.attack(1,n);
	}
	//--------------------------------------------------------
	//-----------For One Player Mode--------------------------
	public void setHeroslide(int sc){
		if (!istrainingmode) return;
		else {
			if (sc==20) {
				s.setstatus(1);
				//HeroPanelforonePlayer.attack(1,20);
			}
			else if (sc==50) {
				s.setstatus(2);
				//HeroPanelforonePlayer.attack(1,50);
			}
			else if (sc==100){
				s.setstatus(3);
				//HeroPanelforonePlayer.attack(1,100);
			}
			else if (sc==200){
				s.setstatus(4);
				//HeroPanelforonePlayer.attack(1,200);
			}
			else if (sc==500){
				s.setstatus(5);
				//HeroPanelforonePlayer.attack(1,500);
			}
		}
	}
	//------------Dealing with Pattern------------------------
	public synchronized void sendPattern(String[] in,int sc){
		if (!istrainingmode){
		int[] Pattern = new int[in.length];
		for (int i = 0 ; i < in.length ; i++){
			if (keycode(in[i]) >= 0){
				Pattern[i] = keycode(in[i]);
			}
		}
		Opponent.ReceivePattern(Pattern, sc);
		}
		else if (istrainingmode) {
			scoreforoneplayer = scoreforoneplayer + sc;
			Scoreforoneplayer.setText("" + scoreforoneplayer);
			if (sc==20) {
				HeroPanelforonePlayer.attack(1,20);
			}
			else if (sc==50) {
				HeroPanelforonePlayer.attack(1,50);
			}
			else if (sc==100){
				HeroPanelforonePlayer.attack(1,100);
			}
			else if (sc==200){
				HeroPanelforonePlayer.attack(1,200);
			}
			else if (sc==500){
				HeroPanelforonePlayer.attack(1,500);
			}
		}
	}
	public synchronized void ReceivePattern(int[] in,int score){
		if (!istrainingmode){
		String[] Pattern = new String[in.length];
		for (int i = 0 ; i < in.length ; i++){
			Pattern[i] = decrypted(in[i]);
		}
		defend.receivepattern(Pattern,score);
		}
	}
	private String decrypted(int n){
		if (n>=0 && n < defendkey.length){
			return defendkey[n];
		}
		else return "";
	}
	private int keycode(String in){
		for (int i = 0 ; i < attackkey.length ; i++){
			if (in.equals(attackkey[i])) return i;
		}
		return -10;
	}
	//-------------------------------------------------------
	//-----------------Lane Changing------------------------
	public void changemonitor() {
		status = status + 1;
		if (istrainingmode) status = status % 2;
		else status = status%3;
		if (status == 0) {
			attack1.requestFocus();
			attack1.setmonitorstatus(true);
			attack2.setmonitorstatus(false);
			defend.setmonitorstatus(false);
		}
		else if (status == 1) {
			attack2.requestFocus();
			attack2.setmonitorstatus(true);
			attack1.setmonitorstatus(false);
			defend.setmonitorstatus(false);
		}
		else if (status==2){
			defend.requestFocus();
			attack1.setmonitorstatus(false);
			attack2.setmonitorstatus(false);
			defend.setmonitorstatus(true);
		}
	}
	//-------------------------------------------------------
	public void initialize(){
		if (!istrainingmode){
		if (player == 1) {
		setSize(670,700);
		setLayout(null);
		ImageIcon lanepicture=new ImageIcon("RIAL MAIN SCORE.png");
		JLabel left = new JLabel (lanepicture);
		left.setBounds(0,0,200,700);
		ImageIcon rightpicture=new ImageIcon("Middle.png");
		JLabel right = new JLabel (rightpicture);
		right.setBounds(650,0,20,700);
		HitListener a1 = new HitListener(attack1,attack1.getDatabase(),this);
		a1.setchangingkey(lanechangekey);
		HitListener a2 = new HitListener(attack2,attack2.getDatabase(),this);
		a2.setchangingkey(lanechangekey);
		HitListener d = new HitListener(defend,defend.getDatabase(),this);
		d.setchangingkey(lanechangekey);
		attack1.addKeyListener(a1);
		attack2.addKeyListener(a2);
		defend.addKeyListener(d);
		attack1.setkey(attackkey);
		attack2.setkey(attackkey);
		defend.setkey(defendkey);
		attack1.setGamePanel(this);
		attack2.setGamePanel(this);
		defend.setGamePanel(this);
		attack1.setJSlider(Speed);
		attack2.setJSlider(Speed);
		defend.setJSlider(Speed);
		attack1.setlanenumber(1);
		attack2.setlanenumber(2);
		
			for (int i = 0 ; i < AllStatusBoard.length ; i++){
				AllStatusBoard[i] = new StatusPanel();
			}
		attack1.setStatusPanel(AllStatusBoard[0]);
		attack2.setStatusPanel(AllStatusBoard[1]);		
		defend.setStatusPanel(AllStatusBoard[2]);	
		attack1.setmonitorstatus(true);
		attack2.setmonitorstatus(false);
		defend.setmonitorstatus(false);
		add(defend);
		add(attack1);
		add(attack2);
		AllStatusBoard[0].setBounds(25,25,145,105);
		AllStatusBoard[1].setBounds(25,160,145,105);
		AllStatusBoard[2].setBounds(25,305,146,105);
		add(AllStatusBoard[0]);
		add(AllStatusBoard[1]);
		add(AllStatusBoard[2]);
		addFocusListener(new MyListener2());
		defend.setVisible(true);
		attack1.setBounds(200,200,150,500);
		attack2.setBounds(350,200,150,500);
		defend.setBounds(500,200,150,500);
		Thread lane1 =new Thread(attack1);
		Thread lane2 = new Thread(attack2);
		Thread lane3 = new Thread(defend);
		lane1.start();
		lane2.start();
		lane3.start();
		Score.setBounds(35,585,125,80);
		Score.setEditable(false);
		Font f = new Font("Arial Black",Font.BOLD,45);
		Score.setFont(f);
		Score.setBackground(new Color(255,255,255));
		Score.setText("" + score);
		add(Score);
		Speed.setBounds(40,420,125,80);
		Speed.setOpaque(false);
		Speed.addChangeListener(new JSliderListener());
		add(Speed);
		add(left);
		add(right);
		}
		else {
			setSize(670,700);
			setLayout(null);
			ImageIcon lanepicture=new ImageIcon("RIAL MAIN SCORE02.png");
			JLabel left = new JLabel (lanepicture);
			left.setBounds(470,0,200,700);
			ImageIcon rightpicture=new ImageIcon("Middle.png");
			JLabel right = new JLabel (rightpicture);
			right.setBounds(0,0,20,700);
			HitListener a1 = new HitListener(attack1,attack1.getDatabase(),this);
			a1.setchangingkey(lanechangekey);
			HitListener a2 = new HitListener(attack2,attack2.getDatabase(),this);
			a2.setchangingkey(lanechangekey);
			HitListener d = new HitListener(defend,defend.getDatabase(),this);
			d.setchangingkey(lanechangekey);
			attack1.addKeyListener(a1);
			attack2.addKeyListener(a2);
			defend.addKeyListener(d);
			attack1.setkey(attackkey);
			attack2.setkey(attackkey);
			defend.setkey(defendkey);
			attack1.setGamePanel(this);
			attack2.setGamePanel(this);
			defend.setGamePanel(this);
			attack1.setJSlider(Speed);
			attack2.setJSlider(Speed);
			defend.setJSlider(Speed);
			attack1.setlanenumber(1);
			attack2.setlanenumber(2);
				for (int i = 0 ; i < AllStatusBoard.length ; i++){
					AllStatusBoard[i] = new StatusPanel();
				}
			attack1.setStatusPanel(AllStatusBoard[0]);
			attack2.setStatusPanel(AllStatusBoard[1]);		
			defend.setStatusPanel(AllStatusBoard[2]);	
			attack1.setmonitorstatus(true);
			attack2.setmonitorstatus(false);
			defend.setmonitorstatus(false);
			add(defend);
			add(attack1);
			add(attack2);
			AllStatusBoard[0].setBounds(670 - 25-145,25,145,105);
			AllStatusBoard[1].setBounds(670 - 25-145,160,145,105);
			AllStatusBoard[2].setBounds(670 - 25-145,305,146,105);
			add(AllStatusBoard[0]);
			add(AllStatusBoard[1]);
			add(AllStatusBoard[2]);
			addFocusListener(new MyListener2());
			defend.setVisible(true);
			attack1.setBounds(20,200,150,500);
			attack2.setBounds(170,200,150,500);
			defend.setBounds(320,200,150,500);
			Thread lane1 =new Thread(attack1);
			Thread lane2 = new Thread(attack2);
			Thread lane3 = new Thread(defend);
			lane1.start();
			lane2.start();
			lane3.start();
			Score.setBounds(670 - 35-125,585,125,80);
			Score.setEditable(false);
			Font f = new Font("Arial Black",Font.BOLD,45);
			Score.setFont(f);
			Score.setBackground(new Color(255,255,255));
			Score.setText("" + score);
			add(Score);
			Speed.setBounds(670 - 40-125,420,125,80);
			Speed.setOpaque(false);
			Speed.addChangeListener(new JSliderListener());
			add(Speed);
			add(left);
			add(right);	
		}
		}
		else {// One Player mode
			setSize(1340,700);
			setLayout(null);
			addFocusListener(new MyListener2());
			ImageIcon lanepicture=new ImageIcon("RIAL MAIN SCORE for one player.png");
			JLabel left = new JLabel (lanepicture);
			left.setBounds(0,0,200,700);
			ImageIcon rightpicture=new ImageIcon("Middle.png");
			JLabel right = new JLabel (rightpicture);
			right.setBounds(500,200,40,700);
			HitListener a1 = new HitListener(attack1,attack1.getDatabase(),this);
			a1.setchangingkey("Alt");
			HitListener a2 = new HitListener(attack2,attack2.getDatabase(),this);
			a2.setchangingkey("Alt");
			attack1.addKeyListener(a1);
			attack2.addKeyListener(a2);
			attack1.setkey(attackkey);
			attack2.setkey(defendkey);
			attack1.setGamePanel(this);
			attack2.setGamePanel(this);
			attack1.setJSlider(Speed);
			attack2.setJSlider(Speed);
			attack1.setlanenumber(4);
			attack2.setlanenumber(5);
			AllStatusBoard = new StatusPanel[2];
				for (int i = 0 ; i < AllStatusBoard.length ; i++){
					AllStatusBoard[i] = new StatusPanel();
				}
			attack1.setStatusPanel(AllStatusBoard[0]);
			attack2.setStatusPanel(AllStatusBoard[1]);		
			attack1.setmonitorstatus(true);
			attack2.setmonitorstatus(false);
			add(attack1);
			add(attack2);
			HeroPanelforonePlayer = new HeromovingUnit();
			HeroPanelforonePlayer.initialize2();
			HeroPanelforonePlayer.setBounds(200,0,340,200);
			add(HeroPanelforonePlayer);
			AllStatusBoard[0].setBounds(25,25,145,105);
			AllStatusBoard[1].setBounds(25,170,145,105);
			add(AllStatusBoard[0]);
			add(AllStatusBoard[1]);
			addFocusListener(new MyListener2());
			attack1.setBounds(200,200,150,700);
			attack2.setBounds(350,200,150,700);
			s.initialize2();
			s.setBounds(540,0,1340-540,700);
			add(s);
			Thread lane1 =new Thread(attack1);
			Thread lane2 = new Thread(attack2);
			lane1.start();
			lane2.start();
			Score.setBounds(27,395,145,95);
			Score.setEditable(false);
			Font f = new Font("Arial Black",Font.BOLD,45);
			Score.setFont(f);
			Score.setBackground(new Color(255,255,255));
			Scoreforoneplayer.setBounds(35,585,125,80);
			Scoreforoneplayer.setBackground(new Color(255,255,255));
			Scoreforoneplayer.setEditable(false);
			Scoreforoneplayer.setFont(f);
			add(Scoreforoneplayer);
			add(Score);
			Speed.setBounds(40,420,125,80);
			Speed.setOpaque(false);
			Speed.addChangeListener(new JSliderListener());
			add(Speed);
			add(left);
			add(right);
		}
	}
	//-----------Set Key For control-----------------------
	public synchronized void setdefendKey(String[] Key,String Modi){
		for (int i = 0 ; i < defendkey.length ; i++){
			defendkey[i] = Key[i];
		}
	}
	public synchronized void setLanechangingkey(String Modi){
		lanechangekey = Modi;
	}
	public synchronized void setattackkey(String[] Key){
		for (int i = 0 ; i < defendkey.length ; i++){
			attackkey[i] = Key[i];
		}
	}
	public synchronized void setdefendkey(String[] Key){
		for (int i = 0 ; i < defendkey.length ; i++){
			defendkey[i] = Key[i];
		}		
	}
	//-------------------------------------------------------
	//-----------Set Player----------------------------------
	public void setPlayer(int n){
		player = n;
	}
	//-------------------------------------------------------
	public void setOpponent (GamePanel p){
		Opponent = p;
	}
	public void setGameArena(GameArena a){
		Frame = a;
	}
	public void settrainingmode(boolean in){
		istrainingmode = in;
	}
	public class MyListener2 implements FocusListener {
		public void focusGained(FocusEvent arg0) {
			if (status == 0)attack1.requestFocus(true);
			else if (status == 1)attack2.requestFocus(true);
			else if (status == 2)defend.requestFocus(true);
		}
		public void focusLost(FocusEvent arg0) {
			
		}
	}
	public class JSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {
			if (istrainingmode){
				attack1.setWaittime(15-Speed.getValue());
				attack2.setWaittime(15-Speed.getValue());
			}
			else {
				attack1.setWaittime(15-Speed.getValue());
				attack2.setWaittime(15-Speed.getValue());
				defend.setwaittime(15-Speed.getValue());
			}
		}
			
	}
}
