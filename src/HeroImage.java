import java.awt.Image;

import javax.swing.ImageIcon;


public class HeroImage {
	private Image[] Herotemplate;
	private int status = 0;
	private int[] memwidth;
	private int[] memheight;
	public void settemplate(ImageIcon[] in ) {
		Herotemplate = new Image[in.length];
		memwidth = new int[in.length];
		memheight = new int[in.length];
		for (int i = 0 ; i < in.length ; i++){
		Herotemplate[i] = (in[i].getImage().getScaledInstance(in[i].getIconWidth(), in[i].getIconHeight(), Image.SCALE_DEFAULT));
		memwidth[i] = in[i].getIconWidth();
		memheight[i] = in[i].getIconWidth();
		}
	}
	public void setstatus(int n){
		if (n>=0 && n <Herotemplate.length) status = n;
	}
	public int getstatus() {
		return status;
	}
	public Image getimage(){
		return Herotemplate[status];
	}
	public int getWidth() {
		return memwidth[status];
	}
	public int getHeight() {
		return memheight[status];
	}
	public void memwidth(int in,int image) {
		memwidth[image] = in;
	}
	public void memheight(int in,int image) {
		memheight[image] = in;
	}
}
