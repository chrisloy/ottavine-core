package com.cloy.ottavino;

public class Melody {
	
	private final Note[] notes;
	
	public Melody(Note...notes) {
		this.notes = notes;
	}
	
	public Note[] getNotes() {
		return notes;
	}
	
	public Melody transpose(int offset) {
		Note[] newNotes = new Note[notes.length];
		for(int i=0; i<notes.length; i++) {
			if(notes[i] == null)
				newNotes[i] = null;
			else
				newNotes[i] = notes[i].transpose(offset);
		}
		return new Melody(newNotes);
	}
}
