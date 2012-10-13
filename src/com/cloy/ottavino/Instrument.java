package com.cloy.ottavino;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.Synthesizer;

public interface Instrument {
	
	public MidiChannel getMidiChannel(Synthesizer synth);
}
