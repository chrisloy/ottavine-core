package com.cloy.ottavino;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Note {
	
	private static final double step = Math.pow(2.0, 1.0/12.0);
	private static final ConcurrentMap<Integer, Float> freqMap;
	
	private static double getFreq(int i) {
		int rel = i - Key.A.rootNote;
		return 440.0 * Math.pow(step, rel);
	}
	
	static {
		freqMap = new ConcurrentHashMap<Integer, Float>(127);
		for(int i=0; i<256; i++) {
			freqMap.put(i, (float)getFreq(i));
		}
		System.out.println("Tones: " + freqMap);
	}
	
	public static final int DEFAULT_VELOCITY = 67;
	public static final int DEFAULT_DECAY = 67;
	
	private final int pitch;
	private final float freq;
	
	public Note(int pitch) {
		this.pitch = pitch;
		try {
			this.freq = freqMap.get(pitch);
		} catch (NullPointerException npe) {
			throw new RuntimeException("No freq found at " + pitch);
		}
	}
	
	public int getNoteNumber() {
		return pitch;
	}
	
	public float getFrequency() {
		return freq;
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
