package com.cloy.ottavino;

public enum Key {
	C  (60),
	Cs (61),
	D  (62),
	Ds (63),
	E  (64),
	F  (65),
	Fs (66),
	G  (67),
	Gs (68),
	A  (69),
	As (70),
	B  (71);
	
	final int rootNote;
	
	private Key(int rootNote) {
		this.rootNote = rootNote;
	}
	
	public int getRootNote(Octave octave) {
		return rootNote + octave.offset;
	}
	
	public static Key getFromRootNote(int rootNote) {
		for(Key k : values())
			if(k.rootNote == rootNote)
				return k;
		return C;
	}
	
	public Octave getOctave(int note) {
		Octave result = Octave.values()[0];
		for(Octave o : Octave.values()) {
			if(getRootNote(o) > note)
				return result;
			else
				result = o;
		}
		return Octave.values()[Octave.values().length-1];
	}
}
