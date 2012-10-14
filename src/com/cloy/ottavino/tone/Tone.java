package com.cloy.ottavino.tone;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public abstract class Tone extends ToneInstrument {

	private Clip clip;

	private void resetClip() throws LineUnavailableException {
		if (clip != null) {
			clip.stop();
			clip.close();
		} else {
			clip = AudioSystem.getClip();
		}
	}
	
	@Override
	public void stop() throws LineUnavailableException {
		resetClip();
	}

	@Override
	public void generateTone(float f) throws LineUnavailableException, IOException {
		resetClip();
		float sr = 44100;
		float a = 20;
		
		AudioFormat af = new AudioFormat(sr, 8, 1, true, false);
		
		int w = (int)(sr / f) + 1;
		int x = 200;
		byte[] b = new byte[x * w];
		
		for(int j = 0; j < x; j++) {
			int offs = j * w;
			for(int i = 0; i < w ; i++) {
				float p = f * (i) / sr;
				b[i + offs] = (byte)getAmplitude(p, a);
			}
		}
		
		AudioInputStream ais = new AudioInputStream(new ByteArrayInputStream(b), af, b.length/2);
		resetClip();
		clip.open(ais);
		clip.setFramePosition(0);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	protected abstract double getAmplitude(float position, float ampl);
}
