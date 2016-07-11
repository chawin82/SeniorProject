import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class Patterndraw extends JPanel implements Runnable{
	private Image background;
	private ArrayList<Image> Object = new ArrayList<Image>(0);// All object to be drawn in The Pipeline
	private ArrayList<Boolean> drawable= new ArrayList<Boolean>(0);//List of Object that are allowed to be on screen
	private int xPosition = 10;
	private ArrayList<Integer> yPosition = new ArrayList<Integer>(0);
	private Image[] template = new Image[26];
	private TheData input;
	private String[] Pattern;
	private ThePipeline controller;
	private int currentPatternindex = 0;
	private int waittime = 15;
	private boolean firsttime;
	private boolean continuing = true;
	private boolean ismonitoring = false;
	private int lanenumber = 1;
	public void setPipeline(ThePipeline u){
		controller = u;
	}
	private void setImageBackground(ImageIcon n){
		background = n.getImage().getScaledInstance(n.getIconWidth(), n.getIconHeight(), Image.SCALE_DEFAULT);
	}
	public void setwaittime(int s){
		waittime = s;
	}
	public void settemplate(int in){
		lanenumber = in;
		if (in==1||in==4){
			ImageIcon a = new ImageIcon("a.png");
			ImageIcon b = new ImageIcon("b.png");
			ImageIcon c = new ImageIcon("c.png");
			ImageIcon d = new ImageIcon("d.png");
			ImageIcon e = new ImageIcon("e.png");
			ImageIcon f = new ImageIcon("f.png");
			ImageIcon g = new ImageIcon("g.png");
			ImageIcon h = new ImageIcon("h.png");
			ImageIcon i = new ImageIcon("i.png");
			ImageIcon j = new ImageIcon("j.png");
			ImageIcon k = new ImageIcon("k.png");
			ImageIcon l = new ImageIcon("l.png");
			ImageIcon m = new ImageIcon("m.png");
			ImageIcon n = new ImageIcon("n.png");
			ImageIcon o = new ImageIcon("o.png");
			ImageIcon p = new ImageIcon("p.png");
			ImageIcon q = new ImageIcon("q.png");
			ImageIcon r = new ImageIcon("r.png");
			ImageIcon s = new ImageIcon("s.png");
			ImageIcon t = new ImageIcon("t.png");
			ImageIcon u = new ImageIcon("u.png");
			ImageIcon v = new ImageIcon("v.png");
			ImageIcon w = new ImageIcon("w.png");
			ImageIcon x = new ImageIcon("x.png");
			ImageIcon y = new ImageIcon("y.png");
			ImageIcon z = new ImageIcon("z.png");
			template[0] = a.getImage().getScaledInstance(a.getIconWidth(), a.getIconHeight(), Image.SCALE_DEFAULT);
			template[1] = b.getImage().getScaledInstance(b.getIconWidth(), b.getIconHeight(), Image.SCALE_DEFAULT);
			template[2] = c.getImage().getScaledInstance(c.getIconWidth(), c.getIconHeight(), Image.SCALE_DEFAULT);
			template[3] = d.getImage().getScaledInstance(d.getIconWidth(), d.getIconHeight(), Image.SCALE_DEFAULT);
			template[4] = e.getImage().getScaledInstance(e.getIconWidth(), e.getIconHeight(), Image.SCALE_DEFAULT);
			template[5] = f.getImage().getScaledInstance(f.getIconWidth(), f.getIconHeight(), Image.SCALE_DEFAULT);
			template[6] = g.getImage().getScaledInstance(g.getIconWidth(), g.getIconHeight(), Image.SCALE_DEFAULT);
			template[7] = h.getImage().getScaledInstance(h.getIconWidth(), h.getIconHeight(), Image.SCALE_DEFAULT);
			template[8] = i.getImage().getScaledInstance(i.getIconWidth(), i.getIconHeight(), Image.SCALE_DEFAULT);
			template[9] = j.getImage().getScaledInstance(j.getIconWidth(), j.getIconHeight(), Image.SCALE_DEFAULT);
			template[10] = k.getImage().getScaledInstance(k.getIconWidth(), k.getIconHeight(), Image.SCALE_DEFAULT);
			template[11] = l.getImage().getScaledInstance(l.getIconWidth(), l.getIconHeight(), Image.SCALE_DEFAULT);
			template[12] = m.getImage().getScaledInstance(m.getIconWidth(), m.getIconHeight(), Image.SCALE_DEFAULT);
			template[13] = n.getImage().getScaledInstance(n.getIconWidth(), n.getIconHeight(), Image.SCALE_DEFAULT);
			template[14] = o.getImage().getScaledInstance(o.getIconWidth(), o.getIconHeight(), Image.SCALE_DEFAULT);
			template[15] = p.getImage().getScaledInstance(p.getIconWidth(), p.getIconHeight(), Image.SCALE_DEFAULT);
			template[16] = q.getImage().getScaledInstance(q.getIconWidth(), q.getIconHeight(), Image.SCALE_DEFAULT);
			template[17] = r.getImage().getScaledInstance(r.getIconWidth(), r.getIconHeight(), Image.SCALE_DEFAULT);
			template[18] = s.getImage().getScaledInstance(s.getIconWidth(), s.getIconHeight(), Image.SCALE_DEFAULT);
			template[19] = t.getImage().getScaledInstance(t.getIconWidth(), t.getIconHeight(), Image.SCALE_DEFAULT);
			template[20] = u.getImage().getScaledInstance(u.getIconWidth(), u.getIconHeight(), Image.SCALE_DEFAULT);
			template[21] = v.getImage().getScaledInstance(v.getIconWidth(), v.getIconHeight(), Image.SCALE_DEFAULT);
			template[22] = w.getImage().getScaledInstance(w.getIconWidth(), w.getIconHeight(), Image.SCALE_DEFAULT);
			template[23] = x.getImage().getScaledInstance(x.getIconWidth(), x.getIconHeight(), Image.SCALE_DEFAULT);
			template[24] = y.getImage().getScaledInstance(y.getIconWidth(), y.getIconHeight(), Image.SCALE_DEFAULT);
			template[25] = z.getImage().getScaledInstance(z.getIconWidth(), z.getIconHeight(), Image.SCALE_DEFAULT);
		}
		else if (in==3||in==5){
			ImageIcon a = new ImageIcon("A2.png");
			ImageIcon b = new ImageIcon("B2.png");
			ImageIcon c = new ImageIcon("C2.png");
			ImageIcon d = new ImageIcon("D2.png");
			ImageIcon e = new ImageIcon("E2.png");
			ImageIcon f = new ImageIcon("F2.png");
			ImageIcon g = new ImageIcon("G2.png");
			ImageIcon h = new ImageIcon("H2.png");
			ImageIcon i = new ImageIcon("I2.png");
			ImageIcon j = new ImageIcon("J2.png");
			ImageIcon k = new ImageIcon("K2.png");
			ImageIcon l = new ImageIcon("L2.png");
			ImageIcon m = new ImageIcon("M2.png");
			ImageIcon n = new ImageIcon("N2.png");
			ImageIcon o = new ImageIcon("O2.png");
			ImageIcon p = new ImageIcon("P2.png");
			ImageIcon q = new ImageIcon("Q2.png");
			ImageIcon r = new ImageIcon("R2.png");
			ImageIcon s = new ImageIcon("S2.png");
			ImageIcon t = new ImageIcon("T2.png");
			ImageIcon u = new ImageIcon("U2.png");
			ImageIcon v = new ImageIcon("V2.png");
			ImageIcon w = new ImageIcon("W2.png");
			ImageIcon x = new ImageIcon("X2.png");
			ImageIcon y = new ImageIcon("Y2.png");
			ImageIcon z = new ImageIcon("Z2.png");
			template[0] = a.getImage().getScaledInstance(a.getIconWidth(), a.getIconHeight(), Image.SCALE_DEFAULT);
			template[1] = b.getImage().getScaledInstance(b.getIconWidth(), b.getIconHeight(), Image.SCALE_DEFAULT);
			template[2] = c.getImage().getScaledInstance(c.getIconWidth(), c.getIconHeight(), Image.SCALE_DEFAULT);
			template[3] = d.getImage().getScaledInstance(d.getIconWidth(), d.getIconHeight(), Image.SCALE_DEFAULT);
			template[4] = e.getImage().getScaledInstance(e.getIconWidth(), e.getIconHeight(), Image.SCALE_DEFAULT);
			template[5] = f.getImage().getScaledInstance(f.getIconWidth(), f.getIconHeight(), Image.SCALE_DEFAULT);
			template[6] = g.getImage().getScaledInstance(g.getIconWidth(), g.getIconHeight(), Image.SCALE_DEFAULT);
			template[7] = h.getImage().getScaledInstance(h.getIconWidth(), h.getIconHeight(), Image.SCALE_DEFAULT);
			template[8] = i.getImage().getScaledInstance(i.getIconWidth(), i.getIconHeight(), Image.SCALE_DEFAULT);
			template[9] = j.getImage().getScaledInstance(j.getIconWidth(), j.getIconHeight(), Image.SCALE_DEFAULT);
			template[10] = k.getImage().getScaledInstance(k.getIconWidth(), k.getIconHeight(), Image.SCALE_DEFAULT);
			template[11] = l.getImage().getScaledInstance(l.getIconWidth(), l.getIconHeight(), Image.SCALE_DEFAULT);
			template[12] = m.getImage().getScaledInstance(m.getIconWidth(), m.getIconHeight(), Image.SCALE_DEFAULT);
			template[13] = n.getImage().getScaledInstance(n.getIconWidth(), n.getIconHeight(), Image.SCALE_DEFAULT);
			template[14] = o.getImage().getScaledInstance(o.getIconWidth(), o.getIconHeight(), Image.SCALE_DEFAULT);
			template[15] = p.getImage().getScaledInstance(p.getIconWidth(), p.getIconHeight(), Image.SCALE_DEFAULT);
			template[16] = q.getImage().getScaledInstance(q.getIconWidth(), q.getIconHeight(), Image.SCALE_DEFAULT);
			template[17] = r.getImage().getScaledInstance(r.getIconWidth(), r.getIconHeight(), Image.SCALE_DEFAULT);
			template[18] = s.getImage().getScaledInstance(s.getIconWidth(), s.getIconHeight(), Image.SCALE_DEFAULT);
			template[19] = t.getImage().getScaledInstance(t.getIconWidth(), t.getIconHeight(), Image.SCALE_DEFAULT);
			template[20] = u.getImage().getScaledInstance(u.getIconWidth(), u.getIconHeight(), Image.SCALE_DEFAULT);
			template[21] = v.getImage().getScaledInstance(v.getIconWidth(), v.getIconHeight(), Image.SCALE_DEFAULT);
			template[22] = w.getImage().getScaledInstance(w.getIconWidth(), w.getIconHeight(), Image.SCALE_DEFAULT);
			template[23] = x.getImage().getScaledInstance(x.getIconWidth(), x.getIconHeight(), Image.SCALE_DEFAULT);
			template[24] = y.getImage().getScaledInstance(y.getIconWidth(), y.getIconHeight(), Image.SCALE_DEFAULT);
			template[25] = z.getImage().getScaledInstance(z.getIconWidth(), z.getIconHeight(), Image.SCALE_DEFAULT);
		}
		if (in==2){
			ImageIcon a = new ImageIcon("A3.png");
			ImageIcon b = new ImageIcon("B3.png");
			ImageIcon c = new ImageIcon("C3.png");
			ImageIcon d = new ImageIcon("D3.png");
			ImageIcon e = new ImageIcon("E3.png");
			ImageIcon f = new ImageIcon("F3.png");
			ImageIcon g = new ImageIcon("G3.png");
			ImageIcon h = new ImageIcon("H3.png");
			ImageIcon i = new ImageIcon("I3.png");
			ImageIcon j = new ImageIcon("J3.png");
			ImageIcon k = new ImageIcon("K3.png");
			ImageIcon l = new ImageIcon("L3.png");
			ImageIcon m = new ImageIcon("M3.png");
			ImageIcon n = new ImageIcon("N3.png");
			ImageIcon o = new ImageIcon("O3.png");
			ImageIcon p = new ImageIcon("P3.png");
			ImageIcon q = new ImageIcon("Q3.png");
			ImageIcon r = new ImageIcon("R3.png");
			ImageIcon s = new ImageIcon("S3.png");
			ImageIcon t = new ImageIcon("T3.png");
			ImageIcon u = new ImageIcon("U3.png");
			ImageIcon v = new ImageIcon("V3.png");
			ImageIcon w = new ImageIcon("W3.png");
			ImageIcon x = new ImageIcon("X3.png");
			ImageIcon y = new ImageIcon("Y3.png");
			ImageIcon z = new ImageIcon("Z3.png");
			template[0] = a.getImage().getScaledInstance(a.getIconWidth(), a.getIconHeight(), Image.SCALE_DEFAULT);
			template[1] = b.getImage().getScaledInstance(b.getIconWidth(), b.getIconHeight(), Image.SCALE_DEFAULT);
			template[2] = c.getImage().getScaledInstance(c.getIconWidth(), c.getIconHeight(), Image.SCALE_DEFAULT);
			template[3] = d.getImage().getScaledInstance(d.getIconWidth(), d.getIconHeight(), Image.SCALE_DEFAULT);
			template[4] = e.getImage().getScaledInstance(e.getIconWidth(), e.getIconHeight(), Image.SCALE_DEFAULT);
			template[5] = f.getImage().getScaledInstance(f.getIconWidth(), f.getIconHeight(), Image.SCALE_DEFAULT);
			template[6] = g.getImage().getScaledInstance(g.getIconWidth(), g.getIconHeight(), Image.SCALE_DEFAULT);
			template[7] = h.getImage().getScaledInstance(h.getIconWidth(), h.getIconHeight(), Image.SCALE_DEFAULT);
			template[8] = i.getImage().getScaledInstance(i.getIconWidth(), i.getIconHeight(), Image.SCALE_DEFAULT);
			template[9] = j.getImage().getScaledInstance(j.getIconWidth(), j.getIconHeight(), Image.SCALE_DEFAULT);
			template[10] = k.getImage().getScaledInstance(k.getIconWidth(), k.getIconHeight(), Image.SCALE_DEFAULT);
			template[11] = l.getImage().getScaledInstance(l.getIconWidth(), l.getIconHeight(), Image.SCALE_DEFAULT);
			template[12] = m.getImage().getScaledInstance(m.getIconWidth(), m.getIconHeight(), Image.SCALE_DEFAULT);
			template[13] = n.getImage().getScaledInstance(n.getIconWidth(), n.getIconHeight(), Image.SCALE_DEFAULT);
			template[14] = o.getImage().getScaledInstance(o.getIconWidth(), o.getIconHeight(), Image.SCALE_DEFAULT);
			template[15] = p.getImage().getScaledInstance(p.getIconWidth(), p.getIconHeight(), Image.SCALE_DEFAULT);
			template[16] = q.getImage().getScaledInstance(q.getIconWidth(), q.getIconHeight(), Image.SCALE_DEFAULT);
			template[17] = r.getImage().getScaledInstance(r.getIconWidth(), r.getIconHeight(), Image.SCALE_DEFAULT);
			template[18] = s.getImage().getScaledInstance(s.getIconWidth(), s.getIconHeight(), Image.SCALE_DEFAULT);
			template[19] = t.getImage().getScaledInstance(t.getIconWidth(), t.getIconHeight(), Image.SCALE_DEFAULT);
			template[20] = u.getImage().getScaledInstance(u.getIconWidth(), u.getIconHeight(), Image.SCALE_DEFAULT);
			template[21] = v.getImage().getScaledInstance(v.getIconWidth(), v.getIconHeight(), Image.SCALE_DEFAULT);
			template[22] = w.getImage().getScaledInstance(w.getIconWidth(), w.getIconHeight(), Image.SCALE_DEFAULT);
			template[23] = x.getImage().getScaledInstance(x.getIconWidth(), x.getIconHeight(), Image.SCALE_DEFAULT);
			template[24] = y.getImage().getScaledInstance(y.getIconWidth(), y.getIconHeight(), Image.SCALE_DEFAULT);
			template[25] = z.getImage().getScaledInstance(z.getIconWidth(), z.getIconHeight(), Image.SCALE_DEFAULT);
		}
	}
	public synchronized void addPattern(String[] in){
		Pattern = new String[in.length];
		for (int i = 0 ; i < in.length ; i++){
			Pattern[i] = in[i];
			drawable.add(false);
			Object.add(template[toIndexcode(in[i])]);
			yPosition.add(-500);
		}
		drawable.add(0,true);
		drawable.remove(1);
		firsttime = true;
	}
	public int toIndexcode(String in){
		if (in.equalsIgnoreCase("a"))return 0;
		else if (in.equalsIgnoreCase("b"))return 1;
		else if (in.equalsIgnoreCase("c"))return 2;
		else if (in.equalsIgnoreCase("d"))return 3;
		else if (in.equalsIgnoreCase("e"))return 4;
		else if (in.equalsIgnoreCase("f"))return 5;
		else if (in.equalsIgnoreCase("g"))return 6;
		else if (in.equalsIgnoreCase("h"))return 7;
		else if (in.equalsIgnoreCase("i"))return 8;
		else if (in.equalsIgnoreCase("j"))return 9;
		else if (in.equalsIgnoreCase("k"))return 10;
		else if (in.equalsIgnoreCase("l"))return 11;
		else if (in.equalsIgnoreCase("m"))return 12;
		else if (in.equalsIgnoreCase("n"))return 13;
		else if (in.equalsIgnoreCase("o"))return 14;
		else if (in.equalsIgnoreCase("p"))return 15;
		else if (in.equalsIgnoreCase("q"))return 16;
		else if (in.equalsIgnoreCase("r"))return 17;
		else if (in.equalsIgnoreCase("s"))return 18;
		else if (in.equalsIgnoreCase("t"))return 19;
		else if (in.equalsIgnoreCase("u"))return 20;
		else if (in.equalsIgnoreCase("v"))return 21;
		else if (in.equalsIgnoreCase("w"))return 22;
		else if (in.equalsIgnoreCase("x"))return 23;
		else if (in.equalsIgnoreCase("y"))return 24;
		else if (in.equalsIgnoreCase("z"))return 25;
		else return -1;
	}
	public void initialize() {
	    setFocusable(true);
	    setDoubleBuffered(true);
	    setmonitorstatus(ismonitoring);
	}
	public synchronized void moveObject() {
		int temp = getIndexHighestObject() + 1;
		if (getYHighestObject() >= 20 && Object.size() > temp){
			drawable.add(temp,true);
			drawable.remove(temp + 1);
			yPosition.add(temp,-110);
			yPosition.remove(temp + 1);
		}
		if (Object.size() > 0) {
		for (int i = 0 ; i < Object.size(); i++){
			if (drawable.get(i) == true){
				yPosition.add(i,yPosition.get(i) + 1);
				yPosition.remove(i + 1);
			}
		}
		}
		if (Object.size() > 0){
		if (Object.get(0) != null){
		if (yPosition.get(0) + 130 >= this.getHeight()){
				if(input.getText().equals(Pattern[currentPatternindex])){
					Object.remove(0);
					drawable.remove(0);
					yPosition.remove(0);
					currentPatternindex++;
				}
				if (currentPatternindex >= Pattern.length){
					if (controller instanceof AttackUnit){
						controller.actionperform();
					}
					if (controller instanceof DefendingUnit){
						controller.attacksignal();
					}
					reset();
					setstatus(3);
				}
				if (Object.size() == 0)return;
		}
		if (yPosition.get(0) >= this.getHeight() && Pattern != null){
				if(input.getText().equals(Pattern[currentPatternindex])){
					Object.remove(0);
					drawable.remove(0);
					yPosition.remove(0);
					currentPatternindex++;
				}
				else {
					if (controller instanceof DefendingUnit){
						controller.actionperform();
						controller.cannotdefend();
						controller.attacksignal();
					}
					if (controller instanceof AttackUnit && ismonitoring == true){
						controller.attacksignal();
					}
					if (ismonitoring) setstatus(2);
					else {
						setstatus(0);
					}
					reset();
				}
		}
		}
		}
	}
	private synchronized int getYHighestObject() {
		if (Object.size() == 0)return -this.getHeight();
		ArrayList<Integer> temp = new ArrayList<Integer>(0);
		for (int i = 0 ; i < yPosition.size(); i++){
			if (drawable.get(i)==true){
				temp.add(yPosition.get(i));
			}
		}
		if (temp.size() == 0) return 0;
		int min = temp.get(0); 
		for (int i = 0 ; i < temp.size(); i++){
			if (temp.get(i) < min){
				min = temp.get(i);
			}
		}
		if (min >=-70 && firsttime){
			firsttime = false;
			if (ismonitoring == true)
			setstatus(1);
			else setstatus(0);
		}
		return min;
	}
	public synchronized void addImage(ImageIcon n){
		Object.add(n.getImage().getScaledInstance(n.getIconWidth(), n.getIconHeight(), Image.SCALE_DEFAULT));
		drawable.add(false);
		yPosition.add(-500);
	}
	private int getIndexHighestObject(){
		if (Object.size() == 0)return -1;
		if (yPosition == null)return -1;
		for (int i = 0 ; i < yPosition.size(); i++){
			if (yPosition.get(i) == getYHighestObject()){
				return i;
			}
		}
		return 0;
	}
	
	public void paint(Graphics g){
	    super.paint(g);
	    Toolkit.getDefaultToolkit().sync();
	    Graphics2D g2d = (Graphics2D)g;
	    if (background != null ) {
	    	g2d.drawImage(background,0,0,this); 
	    }
	    for (int i = 0 ; i < Object.size() ; i++){
	    	if (Object.get(i) != null && drawable.get(i) == true){
	    		g2d.drawImage(Object.get(i),xPosition ,yPosition.get(i),this);
	    	}
	    }
	    g.dispose();
	}
	public void setDatabase(TheData i){
		input = i;
	}
	public synchronized void reset() {
		Object = new ArrayList<Image>(0);
		drawable = new ArrayList<Boolean>(0);
		yPosition = new ArrayList<Integer>(0);
		currentPatternindex = 0;
		Pattern = null;
		controller.reset();
	}
	public void run(){
		while (continuing){
			moveObject();
			repaint();
			try {
				Thread.sleep(waittime);
			} catch (InterruptedException e) {	}
		}
		}
	public void setstatus(int n){
		ImageIcon in ;
		if (lanenumber == 1){
			if (n==0){
			    in = new ImageIcon("rail01.png");
			}
			else if (n==1){
				in = new ImageIcon("rail01 Select.png");
			}
			else if (n==2){
				in = new ImageIcon("rail01 Select WRONG.png");
			}
			else {
				in = new ImageIcon("rail01 Select YES.png");
			}
			}
		else if (lanenumber == 2){
		if (n==0){
		    in = new ImageIcon("rail02.png");
		}
		else if (n==1){
			in = new ImageIcon("rail02 Select.png");
		}
		else if (n==2){
			in = new ImageIcon("rail02 Select WRONG.png");
		}
		else {
			in = new ImageIcon("rail02 Select YES.png");
		}
		}
		else if (lanenumber == 3){
			if (n==0){
			    in = new ImageIcon("rail03.png");
			}
			else if (n==1){
				in = new ImageIcon("rail03 Select.png");
			}
			else if (n==2){
				in = new ImageIcon("rail03 Select WRONG.png");
			}
			else {
				in = new ImageIcon("rail03 Select YES.png");
			}
		}
		else if (lanenumber == 4){
			if (n==0){
			    in = new ImageIcon("rail01 for one player.png");
			}
			else if (n==1){
				in = new ImageIcon("rail01 Select for one player.png");
			}
			else if (n==2){
				in = new ImageIcon("rail01 Select WRONG for one player.png");
			}
			else {
				in = new ImageIcon("rail01 Select YES for one player.png");
			}
		}
		else {
			if (n==0){
			    in = new ImageIcon("rail02 for one player.png");
			}
			else if (n==1){
				in = new ImageIcon("rail02 Select for one player.png");
			}
			else if (n==2){
				in = new ImageIcon("rail02 Select WRONG for one player.png");
			}
			else {
				in = new ImageIcon("rail02 Select YES for one player.png");
			}
		}
		setImageBackground(in);
	}
	public void setmonitorstatus(boolean in){
		if (in == false){
			ismonitoring = false;
			setstatus(0);
		}
		else {
			ismonitoring = true;
			setstatus(1);
		}
	}
	public void endgame() {
		continuing = false;
	}
}
