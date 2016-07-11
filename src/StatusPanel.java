import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StatusPanel extends JPanel{
	private JLabel[] Status = new JLabel[0];
	private ImageIcon[] template;
	public void setstatus(int n){
		if ( n >= Status.length || n < 0) {
			for (int i = 0 ; i < Status.length ; i++){
				Status[i].setVisible(false);
			}
			return;
		}
		else {
			for (int i = 0 ; i < Status.length ; i++){
				Status[i].setVisible(false);
			}
			Status[n].setVisible(true);
		}
	}
	public void initialize() {
		ImageIcon a20 = new ImageIcon("att20.png");
		ImageIcon a50= new ImageIcon("att50.png");
		ImageIcon a100= new ImageIcon("att100.png");
		ImageIcon a200= new ImageIcon("att200.png");
		ImageIcon a500= new ImageIcon("att500.png");
		ImageIcon d20= new ImageIcon("def20.png");
		ImageIcon d50= new ImageIcon("def50.png");
		ImageIcon d100= new ImageIcon("def100.png");
		ImageIcon d200= new ImageIcon("def200.png");
		ImageIcon d500= new ImageIcon("def500.png");
		Status = new JLabel[10];
		Status[0] = new JLabel(a20);
		Status[1] = new JLabel(a50);
		Status[2] = new JLabel(a100);
		Status[3] = new JLabel(a200);
		Status[4] = new JLabel(a500);
		Status[5] = new JLabel(d20);
		Status[6] = new JLabel(d50);
		Status[7] = new JLabel(d100);
		Status[8] = new JLabel(d200);
		Status[9] = new JLabel(d500);
		add(Status[0]);
		add(Status[1]);
		add(Status[3]);
		add(Status[4]);
		add(Status[5]);
		add(Status[6]);
		add(Status[7]);
		add(Status[8]);
		add(Status[9]);
		for (int i = 0 ; i < Status.length ; i++){
			Status[i].setVisible(false);
		}
		setOpaque(false);
	}
	public void settemplate(ImageIcon[] in){
		template = new ImageIcon[in.length];
		Status = new JLabel[in.length];
		for (int i = 0 ; i < in.length ; i++){
			template[i] = in[i];
			Status[i] = new JLabel(template[i]);
		}
	}
	public void initialize2() {
		ImageIcon a20 = new ImageIcon("20silde.png");
		ImageIcon a50= new ImageIcon("20silde.png");
		ImageIcon a100= new ImageIcon("50slide.png");
		ImageIcon a200= new ImageIcon("100slide.png");
		ImageIcon a500= new ImageIcon("200slide.png");
		ImageIcon d20= new ImageIcon("500slide.png");
		Status = new JLabel[6];
		Status[0] = new JLabel(a20);
		Status[1] = new JLabel(a50);
		Status[2] = new JLabel(a100);
		Status[3] = new JLabel(a200);
		Status[4] = new JLabel(a500);
		Status[5] = new JLabel(d20);
		add(Status[0]);
		add(Status[1]);
		add(Status[3]);
		add(Status[4]);
		add(Status[5]);
		for (int i = 0 ; i < Status.length ; i++){
			Status[i].setVisible(false);
		}
		setOpaque(false);
	}
}
