package com.cloy.ottavino;

public class ExpressiveNote extends Note {
	
	private final int velocity;
	
	public ExpressiveNote(int note, int velocity) {
		super(note);
		this.velocity = velocity;
	}
	
	@Override
	public int getVelocity() {
		return velocity;
	}
}
