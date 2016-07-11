
import sun.audio.*;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioWav {

    private  String filename;

    public AudioWav(String file) {
        filename = file;
    }

    public  synchronized void playSound() {
        new Thread(new Runnable() {
          public void run() {
            try {
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(filename));
              clip.open(inputStream);
              clip.start(); 
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
      }
    /*public static void main(String[] args) {
    	playSound();
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/
}