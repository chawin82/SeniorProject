
public class TheData {
	private String t = "";
	public synchronized void setText(String in){
		t= in;
	}
	public synchronized String getText(){
		return t;
	}
	public synchronized void  hold() {
		try {
			wait();
		} catch (InterruptedException e) {		}
	}
	public synchronized void hold (int n){
		try {
			wait();
		} catch (InterruptedException e) {		}
	}
	public synchronized void wake() {
		notifyAll();
	}
}
