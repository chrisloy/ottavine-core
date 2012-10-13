package com.cloy.ottavino;

public enum ChordShape {
	
	Single(0),
	MajorThird(0, 4),
	MinorThird(0, 3),
	Major(0, 4, 7),
	Minor(0, 3, 7),
	Diminished(0, 3, 6),
	Augmented(0, 4, 8);
	
	private final int[] notes;
	
	private ChordShape(int...notes) {
		this.notes = notes;
	}
	
	public int[] getNotes(int rootNote) {
		int[] result = new int[notes.length];
		for(int i=0; i<notes.length; i++) {
			result[i] = notes[i] + rootNote;
		}
		return result;
	}
	
	public int[] getNotes(Key key, Octave octave) {
		return getNotes(key.getRootNote(octave));
	}
}
