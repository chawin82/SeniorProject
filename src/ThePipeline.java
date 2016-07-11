public interface ThePipeline {
	abstract void setkey (String[] in);
	abstract TheData getDatabase();
	abstract void focus(boolean n);
	abstract void release();
	abstract void actionperform();
	abstract void reset();
	abstract void cannotdefend();
	abstract void attacksignal();
	//private String[] key = new String[8];
	/*public void setKey(String[] set){
		for (int i = 0 ; i < key.length ; i++){
			key[i] = set[i];
		}
	}
	public String[] getKey() {
		return key;
	}
	public void requestFocus() { 
		super.requestFocus();
	}
	public void requestFocus(boolean in) {
		super.requestFocus(in);
	}*/
}
