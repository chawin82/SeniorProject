import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;


public class GameArena extends JFrame{
	private MainPanel main = new MainPanel();
	private PlayerselectPanel playerselect = new PlayerselectPanel();
	private HighScorePanel highscorepanel = new HighScorePanel();
	private Playernameget playernameget = new Playernameget();
	private ButtonConfigPanel buttonconfig = new ButtonConfigPanel();
	private Gametwoplayerpanel p= new Gametwoplayerpanel();
	private String Playeronename;
	private String Playertwoname;
	private String[] Playeroneattackkey = new String[4];
	private String[] Playeronedefendkey = new String[4];
	private String[] Playertwoattackkey = new String[4];
	private String[] Playertwodefendkey = new String[4];
	private GamePanel Playerone = new GamePanel();
	private Audioo Soundmain = new Audioo("2003GreatBattle.mid");
	private Audioo SoundHighScore = new Audioo("BattleEnd2.mid");
	private Audioo SoundExit = new Audioo("Ending1.mid");
	private Audioo SoundConfig1 = new Audioo("Vehicle1.mid");
	private Audioo SoundConfig2 = new Audioo("Vehicle2.mid");
	private Audioo SoundPlayerselect = new Audioo("Boss1.mid");
	private Audioo Playeronenamegetsound = new Audioo("Battle1.mid");
	private Audioo Playertwonamegetsound = new Audioo("Battle2.mid");
	private Audioo Gamestartsound = new Audioo("FourHorsemen.mid");
	private int Scoreplayerone = -5555;
	private int Scoreplayertwo = -5555;
	private int playeramount;
	private int leveldiff = -55;
	public void initialize() {
		this.setVisible(true);
		this.setSize(1350,720);
		main.initialize();
		main.setArena(this);
		add(main);
		main.setVisible(true);
		playerselect.initialize();
		playerselect.setArena(this);
		add(playerselect);
		highscorepanel.initialize();
		highscorepanel.setArena(this);
		add(highscorepanel);
		playerselect.setVisible(false);
		highscorepanel.setVisible(false);
		buttonconfig.setVisible(false);
		Playerone.setVisible(false);
		setSize(1350,720);
		setVisible(true);
		Soundmain.toPlay();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void playerselect() {
		Soundmain.toStop();
		SoundConfig1.toStop();
		SoundConfig2.toStop();
		SoundPlayerselect.toPlay();
		main.setVisible(false);
		highscorepanel.setVisible(false);
		playernameget.setVisible(false);
		buttonconfig.setVisible(false);
		playerselect.setVisible(true);
		p.setVisible(false);
		Playerone.setVisible(false);
	}
	public void toMain() {
		Soundmain.toPlay();
		SoundHighScore.toStop();
		Gamestartsound.toStop();
		SoundPlayerselect.toStop();
		Playeronenamegetsound.toStop();
		Playertwonamegetsound.toStop();
		main.setVisible(true);
		playerselect.setVisible(false);
		highscorepanel.setVisible(false);
		playernameget.setVisible(false);
		buttonconfig.setVisible(false);
		p.setVisible(false);
		Playerone.setVisible(false);
	}
	public void Buttonconfig() {
		Playeronenamegetsound.toStop();
		Playertwonamegetsound.toStop();
		main.setVisible(false);
		Playerone.setVisible(false);
		playerselect.setVisible(false);
		highscorepanel.setVisible(false);
		playernameget.setVisible(false);
		p.setVisible(false);
		buttonconfig = new ButtonConfigPanel();
		buttonconfig.setGameArena(this);
		if (playeramount == 1) {
			buttonconfig.initialize(0);
			SoundConfig1.toPlay();
		}
		else if (playeramount == 2) {
			buttonconfig.initialize(1);
			SoundConfig2.toPlay();
		}
		add(buttonconfig);
		buttonconfig.setVisible(true);
	}
	public void HighScoreBoard() throws FileNotFoundException {
		Soundmain.toStop();
		Gamestartsound.toStop();
		SoundHighScore.toPlay();
		main.setVisible(false);
		Playerone.setVisible(false);
		playerselect.setVisible(false);
		playernameget.setVisible(false);
		buttonconfig.setVisible(false);
		p.setVisible(false);
		highscorepanel = new HighScorePanel();
		highscorepanel.initialize();
		highscorepanel.setArena(this);
		add(highscorepanel);
		highscorepanel.setVisible(true);
	}
	public void gamestart() {
		Gamestartsound.toPlay();
		SoundConfig1.toStop();
		SoundConfig2.toStop();
		main.setVisible(false);
		playerselect.setVisible(false);
		buttonconfig.setVisible(false);
		highscorepanel.setVisible(false);
		playernameget.setVisible(false);
		if (playeramount == 2){
			p = new Gametwoplayerpanel();
			p.setGameArena(this);
			p.setPlayeroneattackkey(Playeroneattackkey);
			p.setPlayertwoattackkey(Playertwoattackkey);
			p.setPlayeronedefendkey(Playeronedefendkey);
			p.setPlayertwodefendkey(Playertwodefendkey);
			p.initialize();
			add(p);
			p.requestFocus();
			p.setVisible(true);
		}
		else {
			Playerone.setBounds(0,0,0,0);
			Playerone.setSize(1340,700);
			Playerone.setLanechangingkey("Alt");
			Playerone.setPlayer(1);
			Playerone.settrainingmode(true);
			Playerone.setattackkey(Playeroneattackkey);
			Playerone.setdefendkey(Playeronedefendkey);
			Playerone.initialize();
			Playerone.setGameArena(this);
			add(Playerone);
			Playerone.setVisible(true);
			Playerone.requestFocus();
		}
	}
	public void playernameget(int n) {
		SoundPlayerselect.toStop();
		if (n== 0){
			Playeronenamegetsound.toPlay();
		}
		if (n==1){
			Playertwonamegetsound.toPlay();
		}
		main.setVisible(false);
		playerselect.setVisible(false);
		highscorepanel.setVisible(false);
		p.setVisible(false);
		Playerone.setVisible(false);
		buttonconfig.setVisible(false);
		playernameget = new Playernameget();
		playernameget.initialize(n);
		playernameget.setArena(this);
		add(playernameget);
		playeramount = n + 1;
		playernameget.setVisible(true);
	}
	public void keepdata(String in,int score,int level){
		try {
			highscorepanel.datasave(in, score, level);
		} catch (FileNotFoundException e) {		}
	}
	public void setNamePlayerone(String in){
		Playeronename = in;
	}
	public void setNamePlayertwo(String in){
		Playertwoname = in;
	}
	public void exit() {
		Soundmain.toStop();
		SoundExit.toPlay();
		this.setVisible(false);
		CreditFrame a = new CreditFrame();
		a.initialize();
	}
	public void end() {
		if (Scoreplayerone >= Scoreplayertwo){
			keepdata (Playeronename,Scoreplayerone - Scoreplayertwo,leveldiff);
			Scoreplayerone = -5555;
			Scoreplayertwo = -5555;
			leveldiff = -55;
		}
		else {
			keepdata(Playertwoname,Scoreplayertwo - Scoreplayerone,leveldiff);
			Scoreplayerone = -5555;
			Scoreplayertwo = -5555;
			leveldiff = -55;
		}
		try {
			HighScoreBoard();
		} catch (FileNotFoundException e) {		}
	}
	public synchronized void setLeveldiff(int in){
		leveldiff = in;
		if (Scoreplayerone > -5555 && leveldiff > -55 && Scoreplayertwo > -5555){
			end();
		}
	}
	public synchronized void setscoreplayerone(int in){
		Scoreplayerone = in;
		if (Scoreplayerone > -5555 && leveldiff > -55 && Scoreplayertwo > -5555){
			end();
		}
	}
	public synchronized void setscoreplayertwo(int in){
		Scoreplayertwo = in;
		if (Scoreplayerone > -5555 && leveldiff > -55 && Scoreplayertwo > -5555){
			end();
		}
	}
	public void SetPlayeronekey(String[] attackkey,String[] defendkey){
		for (int i = 0 ; i < Playeroneattackkey.length ; i++){
			Playeroneattackkey[i] = attackkey[i].toLowerCase();
		}
		for (int i = 0 ; i < Playeronedefendkey.length ; i++){
			Playeronedefendkey[i] = defendkey[i].toLowerCase();
		}
	}
	public void SetPlayertwokey(String[] attackkey,String[] defendkey){
		Playertwodefendkey = new String[4];
		for (int i = 0 ; i < Playertwoattackkey.length ; i++){
			Playertwoattackkey[i] = attackkey[i].toLowerCase();
		}
		for (int i = 0 ; i < Playertwodefendkey.length ; i++){
			Playertwodefendkey[i] = defendkey[i].toLowerCase();
		}
	}
	public static void main(String[] args){
		GameArena a = new GameArena() ;
		a.initialize();
	}
}
