package com.cloy.ottavino;

public enum Octave {
	
	Minus5(-5),
	Minus4(-4),
	Minus3(-3),
	Minus2(-2),
	Minus1(-1),
	Central(0),
	Plus1(1),
	Plus2(2),
	Plus3(3),
	Plus4(4),
	Plus5(5);
	
	final int offset;
	
	private Octave(int octave) {
		this.offset = octave * 12;
	}
	
	public Octave transpose(int offset) {
		return getOctave((12 * offset) + this.offset);
	}
	
	private static Octave getOctave(int octave) {
		for(Octave o : values())
			if(o.offset == octave)
				return o;
		return null;
	}
}
