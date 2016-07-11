import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Playernameget extends JPanel {
	private JTextField enter;
	private JTextField enter2;
	private JTextField enterRes;//Res to protect when the JTesField is disappeared
	private JTextField enterRes2;
	private JLabel[] label = new JLabel[6];
	private JLabel next;
	private JLabel back;
	private ImageIcon[] i = new ImageIcon[6];
	private String name;
	private String name2;
	private GameArena Frame;
	private int width = 1340;
	private int height = 700;
	private AudioWav Next = new AudioWav("Cursor2.wav");
	private AudioWav Back = new AudioWav("Cancel2.wav");
	public void setArena(GameArena g){
		Frame = g;
	}
	public  synchronized void initialize(int n) {
		setSize(1340,700);
		setLayout(null);
		i[0] = new ImageIcon("One Player.jpg");
		i[1] = new ImageIcon("Two Player02.jpg");
		i[2] = new ImageIcon("One Player Next02.jpg");
		i[3] = new ImageIcon("Two Player Next.jpg");
		i[4] = new ImageIcon("One Player Back.jpg");
		i[5] = new ImageIcon("Two Player Back.jpg");
		for(int j = 0; j < label.length; j++) {
			label[j] = new JLabel(i[j]);
			label[j].setSize(width, height);
			add(label[j]);
			label[j].setVisible(false);
		}
		if(n==0) {
			tostate(0);
			enter = new JTextField();
			enter.setBounds(280, 575 , 650, 70);
			enter.setText("");
			enter.setFont(new Font("Cordia New", Font.BOLD, 72));
			enter.setHorizontalAlignment(JTextField.RIGHT);
			enter.setVisible(true);
			add(enter);
			enterRes = new JTextField();
			enterRes.setBounds(280, 575 , 650, 70);
			enterRes.setText("");
			enterRes.setFont(new Font("Cordia New", Font.BOLD, 72));
			enterRes.setHorizontalAlignment(JTextField.RIGHT);
			enterRes.setVisible(false);
			add(enterRes);
			//
			JLabel next = new JLabel();
			next.setBounds(975,530,1340 - 975,170);;
			next.addMouseListener(new TheMouseListener(2,0));
			add(next);
			back = new JLabel();
			back.setBounds(1175,530-200,1340-1025,200);
			back.addMouseListener(new TheMouseListener(4,0));
			add(back);
		}
		else {
			tostate(1);
			enter = new JTextField();
			enter.setBounds(0, 585, 330, 72);
			enter.setText("");
			enter.setFont(new Font("Cordia New", Font.BOLD, 70));
			enter.setHorizontalAlignment(JTextField.RIGHT);
			add(enter);
			enterRes = new JTextField();
			enterRes.setBounds(0, 585, 330, 72);
			enterRes.setText("");
			enterRes.setFont(new Font("Cordia New", Font.BOLD, 70));
			enterRes.setHorizontalAlignment(JTextField.RIGHT);
			enterRes.setVisible(false);
			add(enterRes);
			//
			enter2 = new JTextField();
			enter2.setBounds(1340 - 330, 585, 330, 72);
			enter2.setText("");
			enter2.setFont(new Font("Cordia New", Font.BOLD, 70));
			enter2.setHorizontalAlignment(JTextField.RIGHT);
			add(enter2);
			enterRes2 = new JTextField();
			enterRes2.setBounds(1340 - 330, 585, 320, 72);
			enterRes2.setText("");
			enterRes2.setFont(new Font("Cordia New", Font.BOLD, 70));
			enterRes2.setHorizontalAlignment(JTextField.RIGHT);
			enterRes2.setVisible(false);
			add(enterRes2);
			//
			next = new JLabel();
			next.setBounds(500,550,500,150);
			next.addMouseListener(new TheMouseListener(3,1));
			add(next);
			JLabel back = new JLabel();
			back.setBounds(0,0,175,175);
			back.addMouseListener(new TheMouseListener(5,1));
			add(back);
		}
		setVisible(true);
	}
	public String getName() {
		return name;
	}	
	public String getname2() {
		return name2;
	}
	public void setName(String s) {
		name = s;
	}
	public void setName2(String s) {
		name2 = s;
	}
	class TheMouseListener implements MouseListener {
		private int image;
		private int nextTo;
		public TheMouseListener(int m,int n){
			image = m;
			nextTo = n;
		}
		public void mouseClicked(MouseEvent arg0) {		
			if ( image == 2 || image == 3) {
				if(nextTo == 0) {
					Frame.setNamePlayerone(enter.getText());
					Frame.Buttonconfig();
				} 
				if(nextTo == 1) {
					Frame.setNamePlayerone(enter.getText());
					Frame.setNamePlayertwo(enter2.getText());
					Frame.Buttonconfig();
				}
			}
			else if ( image == 4 || image == 5){
				Frame.toMain();
			}
		}
		public void mouseEntered(MouseEvent arg0) {
			if (image==2 || image==3){
				Next.playSound();
			}
			if (image==4 || image==5){
				Back.playSound();
			}
			if(nextTo == 0) { 
				tostate(image);
				enterRes.setText(enter.getText());
				enter.setVisible(false);
				enterRes.setVisible(true);
			} else if(nextTo == 1){
				tostate(image);
				enterRes.setText(enter.getText());
				enterRes2.setText(enter2.getText().trim());
				enter.setVisible(false);
				enter2.setVisible(true);
				enterRes.setVisible(true);
				enterRes2.setVisible(true);
			}
		}
		public void mouseExited(MouseEvent arg0) {
			if(nextTo == 0) { 
				tostate(0);
				enter.setText(enterRes.getText());
				enterRes.setVisible(false);
				enter.setVisible(true);
			} else if(nextTo == 1){
				tostate(1);
				enter.setText(enterRes.getText());
				enter2.setText(enterRes2.getText().trim());
				enterRes.setVisible(false);
				enterRes2.setVisible(false);
				enter.setVisible(true);
				enter2.setVisible(true);
			}
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent arg0) {
			//
		}
	}
	public void tostate(int n){
		for(int j = 0; j < label.length; j++) {
			if(j != n) label[j].setVisible(false);
		}
		label[n].setVisible(true);
	}
}

