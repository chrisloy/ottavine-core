package com.cloy.ottavino.tone;

public class SineTone extends Tone {
	
	@Override
	protected double getAmplitude(float position, float ampl) {
		return ampl * Math.sin(2 * Math.PI * position);
	}

	public static void main(String... args) throws Exception {
		System.out.println("STARTING");
		new SawTone().generateTone(261);
		new SineTone().generateTone(261);
		new SquareTone().generateTone(261);
		Thread.sleep(4000);
		System.out.println("DONE");
	}
}
