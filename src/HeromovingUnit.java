import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class HeromovingUnit extends JPanel implements Runnable{
	private boolean continuing = true;
	private HeroImage Hero1 = new HeroImage();
	private HeroImage Hero2= new HeroImage();
	private HeroImage Bullet1= new HeroImage();
	private HeroImage Bullet2= new HeroImage();
	private Image Background;
	private int xPositionforBullet1;
	private int xPositionforBullet2;
	private boolean bullet1drawable = false;
	private boolean bullet2drawable = false;
	private boolean Hero1candefend = true;
	private boolean Hero2candefend = true;
	private int xHero1 = 100;
	private int xHero2 = 100;
	private int yHero = 60;
	private int yBullet = 70;
	private int ySpecial = 10;
	private boolean insecondmode= false;
	private AudioWav Hero1a20 = new AudioWav("Water2.wav");
	private AudioWav Hero1a50 = new AudioWav("Ocean1.wav");
	private AudioWav Hero1a100 = new AudioWav("Wind8.wav");
	private AudioWav Hero1a200 = new AudioWav("Darkness5.wav");
	private AudioWav Hero1a500 = new AudioWav("Thunder9.wav");
	private AudioWav Hero2a20 = new AudioWav("Shot1.wav");
	private AudioWav Hero2a50 = new AudioWav("Fire2.wav");
	private AudioWav Hero2a100 = new AudioWav("Fire6.wav");
	private AudioWav Hero2a200 = new AudioWav("Fire1.wav");
	private AudioWav Hero2a500 = new AudioWav("Fire3.wav");
	private AudioWav Defsound20 = new AudioWav("Recover1.wav");
	private AudioWav Defsound50 = new AudioWav("Recover2.wav");
	private AudioWav Defsound100 = new AudioWav("Recover3.wav");
	private AudioWav Defsound200 = new AudioWav("Recover4.wav");
	private AudioWav Defsound500 = new AudioWav("Recover5.wav");
	public void initialize() {
		//setPicture template for all hero
		//0=Normal
		//1=attacked 20 , 2 = attacked 50, 3= attacked 100
		//4=attacked 200,5=attacked 500
		//6=attack 200
		//7=attack 500
		//8 = can defend 20,50,100
		//9 = can defend 200,500
		//10 = attack 20,50,100
		//11 = die
		ImageIcon bg = new ImageIcon("bg.png");
		Background = (bg.getImage().getScaledInstance(bg.getIconWidth(), bg.getIconHeight(), Image.SCALE_DEFAULT));
		ImageIcon[] in1 = new ImageIcon[12];
		in1[0] = new ImageIcon("Hero1 Normal.png");
		in1[1] = new ImageIcon("20ed.png");
		in1[2] = new ImageIcon("50ed.png");
		in1[3] = new ImageIcon("100ed.png");
		in1[4] = new ImageIcon("200ed.png");
		in1[5] = new ImageIcon("500ed.png");
		in1[6] = new ImageIcon("Hero1 Att200.png");
		in1[7] = new ImageIcon("Hero1 Att500.png");
		in1[8] = new ImageIcon("Hero1 Defence01.png");
		in1[9] = new ImageIcon("Hero1Defence02.png");
		in1[10] = new ImageIcon("Hero1 to fire.png");
		in1[11] = new ImageIcon("Hero1 die.png");
		ImageIcon[] in2 = new ImageIcon[12];
		in2[0] = new ImageIcon("Hero02.png");
		in2[1] = new ImageIcon("20ed02.png");
		in2[2] = new ImageIcon("50ed02.png");
		in2[3] = new ImageIcon("100ed02.png");
		in2[4] = new ImageIcon("200ed02.png");
		in2[5] = new ImageIcon("500ed02.png");
		in2[6] = new ImageIcon("Hero02 Attack02.png");
		in2[7] = new ImageIcon("Hero02 Attack02.png");
		in2[8] = new ImageIcon("Hero02 Defence.png");
		in2[9] = new ImageIcon("Hero02 Defence.png");
		in2[10] = new ImageIcon("Hero02 Attack01.png");
		in2[11] = new ImageIcon("Hero02 Die.png");
		ImageIcon[] inBullet1 = new ImageIcon[3];
		inBullet1[0] = new ImageIcon("B1fire02.png");
		inBullet1[1] = new ImageIcon("B1fire03.png");
		inBullet1[2] = new ImageIcon("B1fire05.png");
		ImageIcon[] inBullet2 = new ImageIcon[5];
		inBullet2[0] = new ImageIcon("20.png");
		inBullet2[1]= new ImageIcon("50.png");
		inBullet2[2]= new ImageIcon("100.png");
		inBullet2[3]= new ImageIcon("200.png");
		inBullet2[4]= new ImageIcon("500.png");
		Hero1.settemplate(in2);
		Hero2.settemplate(in1);
		Bullet1.settemplate(inBullet2);
		Bullet2.settemplate(inBullet1);
		Hero1.setstatus(0);
		Hero2.setstatus(0);
	}
	public void initialize2() {
		//setPicture template for all hero
		//0=Normal
		//1=attacked 20 , 2 = attacked 50, 3= attacked 100
		//4=attacked 200,5=attacked 500
		//6=attack 200
		//7=attack 500
		//8 = can defend 20,50,100
		//9 = can defend 200,500
		//10 = attack 20,50,100
		//11 = die
		xHero1 = 10;
		insecondmode=true;
		ImageIcon bg = new ImageIcon("bg for one player.png");
		Background = (bg.getImage().getScaledInstance(bg.getIconWidth(), bg.getIconHeight(), Image.SCALE_DEFAULT));
		ImageIcon[] in1 = new ImageIcon[12];
		in1[0] = new ImageIcon("");
		in1[1] = new ImageIcon("");
		in1[2] = new ImageIcon("");
		in1[3] = new ImageIcon("");
		in1[4] = new ImageIcon("");
		in1[5] = new ImageIcon("");
		in1[6] = new ImageIcon("");
		in1[7] = new ImageIcon("");
		in1[8] = new ImageIcon("");
		in1[9] = new ImageIcon("");
		in1[10] = new ImageIcon("");
		in1[11] = new ImageIcon("");
		ImageIcon[] in2 = new ImageIcon[12];
		in2[0] = new ImageIcon("Hero02.png");
		in2[1] = new ImageIcon("Hero02inj.png");
		in2[2] = new ImageIcon("Hero02inj.png");
		in2[3] = new ImageIcon("Hero02inj.png");
		in2[4] = new ImageIcon("Hero02inj.png");
		in2[5] = new ImageIcon("Hero02inj.png");
		in2[6] = new ImageIcon("Hero02 Attack02.png");
		in2[7] = new ImageIcon("Hero02 Attack02.png");
		in2[8] = new ImageIcon("Hero02 Defence.png");
		in2[9] = new ImageIcon("Hero02 Defence.png");
		in2[10] = new ImageIcon("Hero02 Attack01.png");
		in2[11] = new ImageIcon("Hero02 Die.png");
		ImageIcon[] inBullet1 = new ImageIcon[3];
		inBullet1[0] = new ImageIcon("");
		inBullet1[1] = new ImageIcon("");
		inBullet1[2] = new ImageIcon("");
		ImageIcon[] inBullet2 = new ImageIcon[5];
		inBullet2[0] = new ImageIcon("20.png");
		inBullet2[1]= new ImageIcon("50.png");
		inBullet2[2]= new ImageIcon("100.png");
		inBullet2[3]= new ImageIcon("200.png");
		inBullet2[4]= new ImageIcon("500.png");
		cannotdefend(1);
		Hero1.settemplate(in2);
		Hero2.settemplate(in1);
		Bullet1.settemplate(inBullet2);
		Bullet2.settemplate(inBullet1);
		Hero1.setstatus(0);
		Hero2.setstatus(0);
	}
	public void end() {
		continuing = false;
	}
	public synchronized void cannotdefend(int player){
		if (player==1){
			Hero1candefend = false;
		}
		else {
			Hero2candefend = false;
		}
	}
	private void movebullet(){
		if (bullet1drawable){
			boolean check = checkcollision(2);
			if (check==true){
				bullet1drawable = false;
				if (Hero2candefend) {
					Hero2.setstatus(8);
					if (Bullet1.getstatus() == 0){
						Defsound20.playSound();
					}
					if (Bullet1.getstatus() == 1){
						Defsound50.playSound();
					}
					if (Bullet1.getstatus() == 2){
						Defsound100.playSound();
					}
					if (Bullet1.getstatus() == 3){
						Defsound200.playSound();
					}
					if (Bullet1.getstatus() == 4){
						Defsound500.playSound();
					}
					return;
				}
				if (Bullet1.getstatus() ==0 && Hero2candefend == false){//attack = 20
					Hero2.setstatus(1);
					Hero2candefend = true;
				}
				else if (Bullet1.getstatus() == 1&& Hero2candefend == false){//attack = 50
					Hero2.setstatus(2);
					Hero2candefend = true;
				}
				else if (Bullet1.getstatus() == 2&& Hero2candefend == false){//attack=100
					Hero2.setstatus(3);
					Hero2candefend = true;
				}
				else if (Bullet1.getstatus() == 3&& Hero2candefend == false){//attack=200
					Hero2.setstatus(4);
					Hero2candefend = true;
				}
				else if (Bullet1.getstatus() == 4&& Hero2candefend == false){//attack=500
					Hero2.setstatus(5);
					Hero2candefend = true;
				}
			}
			if (!insecondmode)xPositionforBullet1+=20;
			else xPositionforBullet1+=3;
		}
		if (bullet2drawable){
			boolean check = checkcollision(1);
			if (check==true){
				bullet2drawable = false;
				if (Hero1candefend) {
					Hero1.setstatus(8);
					if (Bullet1.getstatus() == 0){
						Defsound20.playSound();
					}
					if (Bullet1.getstatus() == 1){
						Defsound50.playSound();
					}
					if (Bullet1.getstatus() == 2){
						Defsound100.playSound();
					}
					return;
				}
				if (Bullet2.getstatus() ==0){//attack = 20
					Hero1.setstatus(1);
					Hero1candefend = true;
				}
				else if (Bullet2.getstatus() == 1){//attack = 50
					Hero1.setstatus(2);
					Hero1candefend = true;
				}
				else if (Bullet2.getstatus() == 2){//attack=100
					Hero1.setstatus(3);
					Hero1candefend = true;
				}
			}
			else {
				xPositionforBullet2-=20;
			}
		}
	}
	public void setdie(int player){
		if (player == 1)
			Hero1.setstatus(11);
		else 
			Hero2.setstatus(11);
		end();
	}
	public void shoot(int n,int bulletchoose){
		if (n==1) {
			xPositionforBullet1 = Hero1.getWidth() + xHero1;//Should be Width Of HeroPicture
			bullet1drawable = true;
			Bullet1.setstatus(bulletchoose);
			Hero1.setstatus(10);
			if (bulletchoose <=2)Hero1.setstatus(10);
			else if (bulletchoose == 3)Hero1.setstatus(6);
			else if (bulletchoose == 4)Hero1.setstatus(7);
		}
		if (n==2) {
			xPositionforBullet2 = this.getWidth() - Hero2.getWidth()-xHero2;//Should be thisWidth - Width Of HeroPicture
			bullet2drawable = true;
			Bullet2.setstatus(bulletchoose);
			xPositionforBullet2 = xPositionforBullet2 - Bullet2.getWidth();
			Hero2.setstatus(10);
		}
	}
	public void attack(int player,int score){
		if (score == 20){
			shoot(player,0);
			if (player==1) Hero1a20.playSound();
			else Hero2a20.playSound();
		}
		else if (score == 50){
			shoot(player,1);
			if (player==1) Hero1a50.playSound();
			else Hero2a50.playSound();
		}
		else if (score == 100){
			shoot(player,2);
			if (player==1) Hero1a100.playSound();
			else Hero2a100.playSound();
		}
		else if (score == 200){
			if (player==1) Hero1a200.playSound();
			else Hero2a200.playSound();
			if (player == 2){
				Hero2.setstatus(6);
				if (Hero1candefend){
					Hero1.setstatus(9);
					Defsound200.playSound();
				}
				else if (!Hero1candefend){
					gotattacked(1,200);
					Hero1candefend = true;
				}
			}
			else {
				shoot(player,3);
			}
		}
		else if (score == 500){
			if (player==1) Hero1a500.playSound();
			else Hero2a500.playSound();
			if (player == 2){
				Hero2.setstatus(7);
				if (Hero1candefend){
					Hero1.setstatus(9);
					Defsound500.playSound();
				}
				else if (!Hero1candefend){
					gotattacked(1,500);
					Hero1candefend = true;
				}
			}
			else {
				shoot(player,4);
			}
		}
	}
	public void gotattacked(int player,int score){
		if (score == 200){
			if (player == 1){
				Hero1.setstatus(4);
			}
			else {
				Hero2.setstatus(4);
			}
		}
		else if (score == 500){
			if (player == 1){
				Hero1.setstatus(5);
			}
			else {
				Hero2.setstatus(5);
			}
		}
	}
	public void run() {
		while (continuing){
			movebullet();
			repaint();
			if (insecondmode == false){
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {			}
			}
			if (insecondmode == true){
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {			}
			}
		}
		
	}
	public void paint(Graphics g){
	    super.paint(g);
	    Toolkit.getDefaultToolkit().sync();
	    Graphics2D g2d = (Graphics2D)g;
	    g2d.drawImage(Background, 0,0,this);
	    g2d.drawImage(Hero1.getimage(),xHero1 ,yHero,this);
	    if (Hero2.getstatus()!= 7 )
	    g2d.drawImage(Hero2.getimage(),this.getWidth() - Hero2.getWidth() - xHero2  ,yHero,this);
	    else 
	    g2d.drawImage(Hero2.getimage(),this.getWidth() - Hero2.getWidth() - xHero2  ,ySpecial,this);	
	    if (bullet1drawable)g2d.drawImage(Bullet1.getimage(),xPositionforBullet1 ,yBullet,this);
	    if (bullet2drawable)g2d.drawImage(Bullet2.getimage(),xPositionforBullet2 ,yBullet,this);
	    g.dispose();
	}
	private boolean checkcollision(int heronumber){
		if (heronumber==1){
		Rectangle r1 = new Rectangle(xHero1,yHero, Hero1.getWidth(), Hero1.getHeight());  		
		Rectangle r2 = new Rectangle(xPositionforBullet2, yBullet, Bullet2.getWidth(), Bullet2.getHeight()); 		
		Rectangle r3 = new Rectangle();
		Rectangle.intersect(r1, r2, r3);
		if (r3.getWidth()> 0 && r3.getHeight() > 0) return true;
		else return false;
		}
		else{
			Rectangle r1 = new Rectangle(this.getWidth() - Hero2.getWidth() - xHero2, yHero, Hero2.getWidth(), Hero2.getHeight());  		
			Rectangle r2 = new Rectangle(xPositionforBullet1, yBullet, Bullet1.getWidth(),  Bullet1.getHeight()); 		
			Rectangle r3 = new Rectangle();
			Rectangle.intersect(r1, r2, r3);
			if (r3.getWidth()> 0 && r3.getHeight() > 0) return true;
			else return false;
		}
	}
}
