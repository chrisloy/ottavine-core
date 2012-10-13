package com.cloy.ottavino;

public class ChordBuilder {
	
	private Octave octave;
	
	public ChordBuilder() {
		octave = Octave.Central;
	}
	
	public Chord get(Key key, ChordShape chord) {
		int[] notes = chord.getNotes(key, octave);
		return new Chord(notes);
	}
}
