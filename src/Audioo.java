import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
public class Audioo {
	private String name;
	private Sequencer sequencer;
	private boolean isPlay = false;
	Audioo(String name) {
		this.name = name;
	}
	public void toPlay()  {
		isPlay=true;
		  try {
		        // From file
		        Sequence sequence = MidiSystem.getSequence(new File(name));
		        // Create a sequencer for the sequence
		        sequencer = MidiSystem.getSequencer();
		        sequencer.open();
		        sequencer.setSequence(sequence);
		        sequencer.setLoopCount(4);
		    
		        // Start playing
		        sequencer.start();
		    } catch (MalformedURLException e) {
		    } catch (IOException e) {
		    } catch (MidiUnavailableException e) {
		    } catch (InvalidMidiDataException e) {
		    }
	}
	public void toStop() {
		if (!isPlay) return;
		if (isPlay == true){
			sequencer.stop();
			isPlay = false;
		}
	}
}