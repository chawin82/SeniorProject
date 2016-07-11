import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HighScorePanel extends JPanel{
	class TheMouseListener implements MouseListener {
		public void mouseClicked(MouseEvent arg0) {	
			showunit = new JTextArea();
			sameshowunit = new JTextArea();
			if (in != null)
			in.close();
			Frame.toMain();
		}
		public void mouseEntered(MouseEvent arg0) {
			Back.playSound();
			tostate(1);
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
	private ImageIcon folder[] = new ImageIcon[2];
	private JLabel background[] = new JLabel[2];
	private int width=1340;
	private int height = 700;
	private int status = 0;
	private JTextArea showunit = new JTextArea();
	private JTextArea sameshowunit = new JTextArea();
	private Font displayfont;
	private File input = new File("Stat.txt");
	private AudioWav Back = new AudioWav("Cancel2.wav");
	private Scanner in ;
	public synchronized int getStatus() {
		return status;
	}
	public synchronized void initialize() {
		folder[0] = new ImageIcon("High score Back.jpg");
		folder[1] = new ImageIcon("High score Link.jpg");
		setSize(width,height);
		setLayout(null);
		showunit.setBackground(new Color(255,255,255));
		showunit.setEditable(false);
		showunit.setBounds(750,145,560,470);
		showunit.setVisible(true);
		sameshowunit.setBackground(new Color(255,255,255));
		sameshowunit.setEditable(false);
		sameshowunit.setBounds(750,145,560,470);
		sameshowunit.setVisible(true);
		for (int i = 0 ; i < background.length ; i++){ 
			background[i] = new JLabel(folder[i]);
			background[i].setBounds(10,0,0,0);
			background[i].setSize(width,height);
			add(background[i]);
			background[i].setVisible(false);
		}
		background[0].add(showunit);
		background[1].add(sameshowunit);
		JLabel one = new JLabel();
		one.setBounds(520,545,220,120);
		one.addMouseListener(new TheMouseListener());
		add(one);
		displayfont = new Font("Century",Font.PLAIN,18);
		try {
			display();
		} catch (FileNotFoundException e) { 	}
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
	}
	public void setArena(GameArena t){
		Frame = t;
	}
	public void display() throws FileNotFoundException {
		in = new Scanner(input);
		showunit.setTabSize(10);
		sameshowunit.setTabSize(10);
		showunit.setFont(displayfont);
		sameshowunit.setFont(displayfont);
		add("            Name\t     Score\tLevel Difference");
		in.nextLine();
		for (int i = 1 ; i <= 9 ; i++){
			add("\n");
			add("" + i + ".");
			if (in.hasNext()){
				String temp = in.nextLine() ;
				int gap1 = temp.indexOf(" ",0);
				int gap2 = temp.indexOf(" ",gap1 + 1);
				add("      " + temp.substring(0,gap1));
				add("\t      " + temp.substring(gap1,gap2).trim());
				add("\t          " + temp.substring(gap2,temp.length()).trim());
			}
			add("\n");
		}
		add("\n");
		add("" + 10 + ".");
		if (in.hasNext()){
			String temp = in.nextLine() ;
			int gap1 = temp.indexOf(" ",0);
			int gap2 = temp.indexOf(" ",gap1 + 1);
			add("      " + temp.substring(0,gap1));
			add("\t      " + temp.substring(gap1,gap2).trim());
			add("\t          " + temp.substring(gap2,temp.length()).trim());
		}
		add("\n");
	}
	private void add(String in) {
		showunit.append(in);
		sameshowunit.append(in);
	}
	public void datasave(String name,int score,int level) throws FileNotFoundException {
		Scanner dataread= new Scanner(input);
		ArrayList<String> temp = new ArrayList<String>();
		String amount = dataread.nextLine();
		if ((Integer.parseInt(amount) < 10)){
			temp.add((Integer.parseInt(amount) + 1 )+ "");
		}
		else {
			temp.add("" + 10);
		}
		while (dataread.hasNext()){
			temp.add(dataread.nextLine());
		}
			 if (temp.size() > 1){
			 for (int i = 1 ; i < temp.size() ; i++){
					int gap1 = temp.get(i).indexOf(" ",0);
					int gap2 = temp.get(i).indexOf(" ", gap1 + 1);
				 int oldscore = Integer.parseInt(temp.get(i).substring(gap1,gap2).trim());
				 int oldlevel = Integer.parseInt(temp.get(i).substring(gap2,temp.get(i).length()).trim());
				 if (score > oldscore)  temp.add(i ,name + " " + score + " " + level);
				 if (score == oldscore) { 
					 if (level > oldlevel){
						 temp.add(i ,name + " " + score + " " + level);
					 }
					 else {
						 temp.add(i + 1 ,name + " " + score + " " + level);
					 }
				 }
			}
			}
			if (temp.size() > 11){
				int be = temp.size();
				for (int i = 11 ; i < be; i++){
					temp.remove(12);
				}
			}
			if (temp.size() == 1){
				temp.add(name + " " + score + " " + level);
			}
		dataread.close();
		PrintWriter out = new PrintWriter(input);
		for (int j = 0 ; j < temp.size() ; j++){
				if (temp.get(j) == null) break;
				out.println(temp.get(j));
			}
		out.close();
	}
	public int getLowestLevelDiff() throws FileNotFoundException {
		Scanner dataread= new Scanner(input);
		int i = Integer.parseInt(dataread.nextLine());
		if (i == 0) return -1;
		String temp = "";
		while (dataread.hasNext()){
			temp = dataread.nextLine();
		}
			int gap1 = temp.indexOf(" ",0);
			int gap2 = temp.indexOf(" ", gap1 + 1);
			return Integer.parseInt(temp.substring(gap2,temp.length()).trim());
	}
	public int getLowestScore() throws FileNotFoundException {
		Scanner dataread= new Scanner(input);
		int i = Integer.parseInt(dataread.nextLine());
		if (i == 0) return -1;
		String temp = "";
		while (dataread.hasNext()){
			temp = dataread.nextLine();
		}
			int gap1 = temp.indexOf(" ",0);
			int gap2 = temp.indexOf(" ", gap1 + 1);
			return Integer.parseInt(temp.substring(gap1,gap2).trim());
	}
}
