package com.cloy.ottavino.tone;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

import com.cloy.ottavino.Instrument;

public abstract class ToneInstrument implements Instrument {
	
	public void start(float freq) {
		try {
			generateTone(freq);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void stop(float freq) {
		try {
			stop();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected abstract void generateTone(float freq) throws LineUnavailableException, IOException;
	
	protected abstract void stop() throws LineUnavailableException;
}
