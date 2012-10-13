package com.cloy.ottavino;

import java.util.Arrays;

public class Chord {
	
	private final Note[] notes;
	
	public Chord(Note...notes) {
		this.notes = notes;
	}
	
	public Chord(int...notes) {
		this.notes = new Note[notes.length];
		for(int i=0; i<notes.length; i++)
			this.notes[i] = new Note(notes[i]);
	}
	
	public Note[] getNotes() {
		return notes;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(notes);
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null)
			return false;
		if(this == object)
			return true;
		if(!(object instanceof Chord))
			return false;
		Chord that = (Chord)object;
		if(this.notes.length != that.notes.length)
			return false;
		if(!Arrays.equals(this.notes, that.notes))
			return false;
		return true;
	}
}
