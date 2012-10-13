package com.cloy.ottavino;

public class Note {
	
	public static final int DEFAULT_VELOCITY = 67;
	public static final int DEFAULT_DECAY = 67;
	
	private final int pitch;
	
	public Note(int pitch) {
		this.pitch = pitch;
	}
	
	public int getNoteNumber() {
		return pitch;
	}
	
	public int getVelocity() {
		return DEFAULT_VELOCITY;
	}
	
	public int getDecay() {
		return DEFAULT_DECAY;
	}
	
	public Note transpose(int offset) {
		return new Note(pitch + offset);
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null)
			return false;
		if(this == object)
			return true;
		if(!(object instanceof Note))
			return false;
		Note other = (Note)object;
		if(other.pitch != this.pitch)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return Integer.toString(pitch);
	}
}
