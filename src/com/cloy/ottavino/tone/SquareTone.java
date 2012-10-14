package com.cloy.ottavino.tone;

public class SquareTone extends Tone {

	@Override
	protected double getAmplitude(float p, float ampl) {
		return p < 0.5 ? 0.5*ampl : -0.5*ampl;
	}

}
