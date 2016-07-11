
public class ThreadManager implements Runnable{
	private GamePanel G1;
	private GamePanel G2;
	private boolean continuing = true;
	public ThreadManager(GamePanel p1,GamePanel p2){
		G1 = p1;
		G2 = p2;
	}
	public void run() {
		while (continuing){
		G2.requestFocus(true);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {		}
		G1.requestFocus(true);		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {		}
		}
	}
	public void end() {
		continuing = false;
	}
}
