package com.cloy.ottavino;

import java.util.Arrays;

/**
 * Defines the notes between 0 and 11 that are allowed
 * on the scale;
 * 
 * 
 * @author chrisloy
 */
public enum Scale {
	
	Major(0, 2, 4, 5, 7, 9, 11),
	Minor(0, 2, 3, 5, 7, 8, 11);
	
	private final int[] notes;
	
	private Scale(int...notes) {
		this.notes = notes;
	}
	
	public int[] getNotes(Key key, Octave o) {
		int[] result = new int[notes.length];
		int root = key.getRootNote(o);
		for(int i=0; i<notes.length; i++)
			result[i] = root + notes[i];
		return result;
	}
	
	public int moveNote(Key key, int startNote, int change) {
		Octave oct = key.getOctave(startNote);
		int[] startOctaveNotes = getNotes(key, oct);
		int position = Arrays.binarySearch(startOctaveNotes, startNote) + change;
		if(position < 0) {
			int octaveOffset = (position / notes.length) - 1;
			int newPosition = (position % notes.length) + notes.length - 1;
			return notes[newPosition] + key.getRootNote(oct) + octaveOffset * 12;
		}
		else if(position >= notes.length) {
			int octaveOffset = position / notes.length;
			position = (position % notes.length);
			return notes[position] + key.getRootNote(oct) + octaveOffset * 12;
		}
		else {
			return notes[position] + key.getRootNote(oct);
		}
	}
}
