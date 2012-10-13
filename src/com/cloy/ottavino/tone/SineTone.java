package com.cloy.ottavino.tone;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class SineTone implements Tone {

	private Clip clip;

	private void resetClip() throws LineUnavailableException {
		if (clip != null) {
			clip.stop();
			clip.close();
		} else {
			clip = AudioSystem.getClip();
		}
	}

	public void generateTone(float f) throws LineUnavailableException, IOException {
		resetClip();
		float sampleRate = 44100f;
		AudioFormat af = new AudioFormat(sampleRate, 8, 1, true, false);
		
		float sr = 44100;
		float t = 2;
		float a = 127;
		
		float w = sr / f;
		
		//byte[] b = new byte[(int)(sr * t)];
		byte[] b = new byte[(int)w];
		
		for(int i = 0; i < b.length ; i++) {
			b[i] = (byte)(a * Math.sin(2 * Math.PI * f * i / sr));
		}
		
		Map<Byte, Integer> m = new TreeMap<Byte, Integer>();
		for(byte ba : b) {
			if(!m.containsKey(ba))
				m.put(ba, 0);
			int i = m.get(ba);
			m.put(ba, i+1);
		}
		System.out.println(m);
		
		AudioInputStream ais = new AudioInputStream(new ByteArrayInputStream(b), af, b.length/2);
		clip.open(ais);
		clip.setFramePosition(0);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public static void main(String... args) throws Exception {
		System.out.println("STARTING");
		new SineTone().generateTone(261);
		Thread.sleep(4000);
		System.out.println("DONE");
	}
}
