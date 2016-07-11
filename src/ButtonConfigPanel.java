import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class ButtonConfigPanel extends JPanel {
	private JTextField[] keySet = new JTextField[8];
	private JTextField[] keySet2 = new JTextField[8];
	private JTextField[] keySetRes = new JTextField[8];
	private JTextField[] keySetRes2 = new JTextField[8];
 	private ImageIcon[] i = new ImageIcon[6];
	private JLabel[] label = new JLabel[6];
	private JLabel next;
	private JLabel back;
	private String[] key = new String[8];// 0 - 3 is attackkey
					     				 // 4 - 7 is defendkey
	private GameArena Frame;
	private AudioWav Next = new AudioWav("Cursor2.wav");
	private AudioWav Back = new AudioWav("Cancel2.wav");
	private String[] key2 = new String[8];
	private int width = 1340;
	private int height = 700;
	public void setGameArena (GameArena in){
		Frame = in;
	}
	public  void initialize(int n) {
		setSize(1340,700);
		setLayout(null);
		i[0] = new ImageIcon("KeySet01.jpg");
		i[1] = new ImageIcon("KeySet02.jpg");
		i[2] = new ImageIcon("KeySet01 Next.jpg");
		i[3] = new ImageIcon("KeySet02 Next.jpg");
		i[4] = new ImageIcon("KeySet01 Back.jpg");
		i[5] = new ImageIcon("KeySet02 Back.jpg");
		for(int j = 0; j < label.length; j++) {
			label[j] = new JLabel(i[j]);
			label[j].setSize(width, height);
			add(label[j]);
			label[j].setVisible(false);
		}
		if(n==0) {
			tostate(0);
			for(int j = 0; j < keySet.length; j++ ) {
				keySet[j] = new JTextField();
				keySet[j].setText("");
				keySet[j].setFont(new Font("Cordia New", Font.BOLD, 70));
				keySet[j].addKeyListener(new TheKeyListener(keySet[j],keySet));
				keySet[j].addMouseListener(new TheMouseListenerTokey(keySet[j]));
				add(keySet[j]);
			}
			
			keySet[0].setBounds(785 + 10,25,100- 10,70);
			keySet[1].setBounds(785 + 10,200 - 30 - 30 - 2,100 - 10,70);
			keySet[2].setBounds(785 + 10,(140 - 25)*2 + 25 + 5 ,100 - 10,70);
			keySet[3].setBounds(785 + 10,(140 - 25)*3 + 25 + 24,100 - 10,70);
			keySet[4].setBounds(1130 + 8,25,100 - 10,70);
			keySet[5].setBounds(1130 + 8,200 - 30 - 30,100 - 10,70);
			keySet[6].setBounds(1130 + 8,(140 - 25)*2 + 25 + 5,100 - 10,70);
			keySet[7].setBounds(1130 + 8,(140 - 25)*3 + 25 + 24,100 - 10,70);
			for(int j = 0; j < keySet.length; j++ ) {
				keySetRes[j] = new JTextField();
				keySetRes[j].setText("");
				keySetRes[j].setFont(new Font("Cordia New", Font.BOLD, 70));
				keySetRes[j].addKeyListener(new TheKeyListener(keySetRes[j],keySetRes));
				keySetRes[j].addMouseListener(new TheMouseListenerTokey(keySetRes[j]));
				keySetRes[j].setVisible(false);
				add(keySetRes[j]);
			}
			keySetRes[0].setBounds(785 + 10,25,100- 10,70);
			keySetRes[1].setBounds(785 + 10,200 - 30 - 30 - 2,100 - 10,70);
			keySetRes[2].setBounds(785 + 10,(140 - 25)*2 + 25 + 5 ,100 - 10,70);
			keySetRes[3].setBounds(785 + 10,(140 - 25)*3 + 25 + 24,100 - 10,70);
			keySetRes[4].setBounds(1130 + 8,25,100 - 10,70);
			keySetRes[5].setBounds(1130 + 8,200 - 30 - 30,100 - 10,70);
			keySetRes[6].setBounds(1130 + 8,(140 - 25)*2 + 25 + 5,100 - 10,70);
			keySetRes[7].setBounds(1130 + 8,(140 - 25)*3 + 25 + 24,100 - 10,70);
			next = new JLabel();
			next.setBounds(0,350 - 20,280,280 + 20);
			next.addMouseListener(new TheMouseListener(2,0));
			add(next);
			back = new JLabel();
			back.setBounds(280,360,280 - 20,280);
			back.addMouseListener(new TheMouseListener(4,0));
			add(back);
		}
		else {
			tostate(1);
			for(int j = 0; j < keySet.length; j++ ) {
				keySet[j] = new JTextField();
				keySet[j].setText("");
				keySet[j].setFont(new Font("Cordia New", Font.BOLD, 70));
				keySet[j].addKeyListener(new TheKeyListener(keySet[j],keySet));
				keySet[j].addMouseListener(new TheMouseListenerTokey(keySet[j]));
				add(keySet[j]);
			}
			keySet[0].setBounds(785 + 10,25,100- 10,70);
			keySet[1].setBounds(785 + 10,200 - 30 - 30 - 2,100 - 10,70);
			keySet[2].setBounds(785 + 10,(140 - 25)*2 + 25 + 5 ,100 - 10,70);
			keySet[3].setBounds(785 + 10,(140 - 25)*3 + 25 + 24 - 16,100 - 10,70);
			keySet[4].setBounds(1130 + 8,25,100 - 10,70);
			keySet[5].setBounds(1130 + 8,200 - 30 - 30,100 - 10,70);
			keySet[6].setBounds(1130 + 8,(140 - 25)*2 + 25 + 5,100 - 10,70);
			keySet[7].setBounds(1130 + 8,(140 - 25)*3 + 25 + 24 - 16,100 - 10,70);
			for(int j = 0; j < keySet.length; j++ ) {
				keySetRes[j] = new JTextField();
				keySetRes[j].setText("");
				keySetRes[j].setFont(new Font("Cordia New", Font.BOLD, 70));
				keySetRes[j].addKeyListener(new TheKeyListener(keySetRes[j],keySetRes));
				keySetRes[j].addMouseListener(new TheMouseListenerTokey(keySetRes[j]));
				keySetRes[j].setVisible(false);
				add(keySetRes[j]);
			}
			keySetRes[0].setBounds(785 + 10,25,100- 10,70);
			keySetRes[1].setBounds(785 + 10,200 - 30 - 30,100 - 10,70);
			keySetRes[2].setBounds(785 + 10,(140 - 25)*2 + 25 + 5 ,100 - 10,70);
			keySetRes[3].setBounds(785 + 10,(140 - 25)*3 + 25 + 24 - 16,100 - 10,70);
			keySetRes[4].setBounds(1130 + 8,25,100 - 10,70);
			keySetRes[5].setBounds(1130 + 8,200 - 30 - 30,100 - 10,70);
			keySetRes[6].setBounds(1130 + 8,(140 - 25)*2 + 25 + 5,100 - 10,70);
			keySetRes[7].setBounds(1130 + 8,(140 - 25)*3 + 25 + 24 - 16,100 - 10,70);
			//
			for(int j = 0; j < keySet2.length; j++ ) {
				keySet2[j] = new JTextField();
				keySet2[j].setText("");
				keySet2[j].setFont(new Font("Cordia New", Font.BOLD, 70));
				keySet2[j].addKeyListener(new TheKeyListener(keySet2[j],keySet2));
				keySet2[j].addMouseListener(new TheMouseListenerTokey(keySet2[j]));
				add(keySet2[j]);
			}
			keySet2[0].setBounds(157,25 - 6,100- 10,70);
			keySet2[1].setBounds(157,200 - 30 - 30 - 2,100 - 10,70);
			keySet2[2].setBounds(157,(140 - 25)*2 + 25 + 5 - 2 ,100 - 10,70);
			keySet2[3].setBounds(157,(140 - 25)*3 + 25 + 24 - 16,100 - 10,70);
			keySet2[4].setBounds(510,25 - 2,100 - 10,70);
			keySet2[5].setBounds(510,200 - 30 - 30 - 2,100 - 10,70);
			keySet2[6].setBounds(510,(140 - 25)*2 + 25 + 5,100 - 10,70);
			keySet2[7].setBounds(510,(140 - 25)*3 + 25 + 24 - 16,100 - 10,70);
			for(int j = 0; j < keySet2.length; j++ ) {
				keySetRes2[j] = new JTextField();
				keySetRes2[j].setText("");
				keySetRes2[j].setFont(new Font("Cordia New", Font.BOLD, 70));
				keySetRes2[j].addKeyListener(new TheKeyListener(keySetRes2[j],keySetRes2));
				keySetRes2[j].addMouseListener(new TheMouseListenerTokey(keySetRes2[j]));
				keySetRes2[j].setVisible(false);
				add(keySetRes2[j]);
			}
			keySetRes2[0].setBounds(157,25 - 6,100- 10,70);
			keySetRes2[1].setBounds(157,200 - 30 - 30,100 - 10,70);
			keySetRes2[2].setBounds(157,(140 - 25)*2 + 25 + 5 - 2 ,100 - 10,70);
			keySetRes2[3].setBounds(157,(140 - 25)*3 + 25 + 24 - 16,100 - 10,70);
			keySetRes2[4].setBounds(510,25 - 2,100 - 10,70);
			keySetRes2[5].setBounds(510,200 - 30 - 30 - 2,100 - 10,70);
			keySetRes2[6].setBounds(510,(140 - 25)*2 + 25 + 5,100 - 10,70);
			keySetRes2[7].setBounds(510,(140 - 25)*3 + 25 + 24 - 16,100 - 10,70);
			//
			next = new JLabel();
			next.setBounds(0,700 - 280,280,280);
			next.addMouseListener(new TheMouseListener(3,1));
			add(next);
			back = new JLabel();
			back.setBounds(280,700 - 200,200,200);
			back.addMouseListener(new TheMouseListener(5,1));
			add(back);
		}
		setVisible(true);
	}
	public String[] getKeyArr() {
		return key;
	}
	public String[] getKey2Arr() {
		return key2;
	}
	public String getKey(int j) {
		return key[j];
	}	
	public String getKey2(int j) {
		return key2[j];
	}
	public void setKey(String s, int j) {
		key[j] = s;
	}
	public void setKey2(String s,int j) {
		key2[j] = s;
	}
	class TheMouseListenerTokey implements MouseListener {
		private JTextField text;
		TheMouseListenerTokey(JTextField text) {
			this.text = text;
		}		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
				text.setEditable(true);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class TheKeyListener implements KeyListener {
		JTextField text;
		JTextField[] text2;
		TheKeyListener(JTextField text, JTextField[] text2) {
			this.text = text;
			this.text2 = text2;
		}
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			int c = 0;
			for(int j = 0; j < text2.length; j++) {
				if(text2[j].getText().length() != 0 && arg0.getKeyChar() == (int)(text2[j].getText().charAt(0)) ) c++;
			}
			if(text.getText().length() != 0 && arg0.getKeyCode() != KeyEvent.VK_BACK_SPACE || c > 0 ){
				text.setEditable(false);
				text.setBackground(Color.white);
			} else text.setEditable(true);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}
		
	}
	class TheMouseListener implements MouseListener {
		private int image;
		private int nextTo;
		public TheMouseListener(int m,int n){
			image = m;
			nextTo = n;
		}
		public void mouseClicked(MouseEvent arg0) {		
			if ( image == 2 || image == 3) {//Click to next(link to frame)
				 							//2 is 0ne Player (Next to = 0)
											//3 is Two Player (Next to = 1)
				if(nextTo == 0) {
					for(int j = 0; j < keySet.length; j++) {
						setKey(keySet[j].getText(),j);
					}
					String[] toFrame1 = new String[4];
					String[] toFrame2 = new String[4];
					for (int i = 0 ; i < toFrame1.length ; i++){
						toFrame1[i] = getKey(i);
					}
					for (int i = 4 ; i < 8 ; i++){
						toFrame2[i-4] = getKey(i);
					}
					Frame.SetPlayeronekey(toFrame1,toFrame2);
				} 
				if(nextTo == 1) {
					String[] toFrame1 = new String[4];
					String[] toFrame2 = new String[4];
					String[] toFrame3 = new String[4];
					String[] toFrame4 = new String[4];
					for(int j = 0; j < 8; j++) {
						setKey(keySet[j].getText(),j);
					}
					for(int j = 0; j < 8; j++) {
						setKey2(keySet2[j].getText(),j);
					}
					for (int i = 0 ; i < toFrame1.length ; i++){
						toFrame1[i] = keySet[i].getText();
					}
					for (int i = 4 ; i < 8 ; i++){
						toFrame2[i-4] = keySet[i].getText();
					}
					for (int i = 0 ; i < toFrame3.length ; i++){
						toFrame3[i] = keySet2[i].getText();
					}
					for (int i = 4 ; i < 8 ; i++){
						toFrame4[i-4] = keySet2[i].getText();
					}
					Frame.SetPlayertwokey(toFrame1,toFrame2);
					Frame.SetPlayeronekey(toFrame3,toFrame4);
				}
				Frame.gamestart();
			}
			else if ( image == 4 || image == 5){//link to Frame
							    				//Back = 4,5 (One Player,Two Player)
				Frame.playerselect();
			}
		}
		public void mouseEntered(MouseEvent arg0) {
			if (image==4 || image ==5){
				Back.playSound();
			}
			if (image==2 || image==3){
				Next.playSound();
			}
			if(nextTo == 0) { 
				tostate(image);
				for(int j = 0; j < keySet.length; j++) {
					keySetRes[j].setText(keySet[j].getText());
					//System.out.print(keySetRes[j].getText());
					keySet[j].setVisible(false);
					keySetRes[j].setVisible(true);
					//System.out.print(true);
					keySet[j].setEditable(false);
					keySetRes[j].setEditable(false);
					keySet[j].setBackground(Color.WHITE);
					keySetRes[j].setBackground(Color.WHITE);
				}
				for(int j = 0 ; j < keySet2.length; j++) {
					if(keySet[j].getText() != null)key[j] = (keySet[j].getText());
				}
			} else if(nextTo == 1){
				tostate(image);
				for(int j = 0; j < keySet.length; j++) {
					keySetRes[j].setText(keySet[j].getText());
					keySetRes2[j].setText(keySet2[j].getText());
					keySet[j].setVisible(false);
					keySet2[j].setVisible(false);
					keySetRes[j].setVisible(true);
					keySetRes2[j].setVisible(true);
					keySet[j].setEditable(false);
					keySet2[j].setEditable(false);
					keySetRes[j].setEditable(false);
					keySetRes2[j].setEditable(false);
					keySet[j].setBackground(Color.WHITE);
					keySet2[j].setBackground(Color.WHITE);
					keySetRes[j].setBackground(Color.WHITE);
					keySetRes2[j].setBackground(Color.WHITE);
				}
				for(int j = 0 ; j < keySet2.length; j++) {
					if(keySet[j].getText() != null) key[j] = (keySet[j].getText());
					if(keySet2[j].getText() != null) key2[j] = (keySet2[j].getText());
				}
			}
		}
		public void mouseExited(MouseEvent arg0) {
			if(nextTo == 0) { 
				tostate(0);
				for(int j = 0; j < keySet.length; j++) {
					keySet[j].setText(keySetRes[j].getText());
					keySetRes[j].setVisible(false);
					keySet[j].setVisible(true);
					keySet[j].setEditable(false);
					keySetRes[j].setEditable(false);
					keySet[j].setBackground(Color.WHITE);
					keySetRes[j].setBackground(Color.WHITE);
				}
				
			} else if(nextTo == 1){
				tostate(1);
				for(int j = 0; j < keySet.length; j++) {
					keySet[j].setText(keySetRes[j].getText());
					keySet2[j].setText(keySetRes2[j].getText());
					keySetRes[j].setVisible(false);
					keySetRes2[j].setVisible(false);
					keySet[j].setVisible(true);
					keySet2[j].setVisible(true);
					keySet[j].setEditable(false);
					keySet2[j].setEditable(false);
					keySetRes[j].setEditable(false);
					keySetRes2[j].setEditable(false);
					keySet[j].setBackground(Color.WHITE);
					keySet2[j].setBackground(Color.WHITE);
					keySetRes[j].setBackground(Color.WHITE);
					keySetRes2[j].setBackground(Color.WHITE);
				}
				
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
