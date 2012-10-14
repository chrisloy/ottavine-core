package com.cloy.ottavino.tone;

public class SawTone extends Tone {

	@Override
	protected double getAmplitude(float p, float ampl) {
		return (p-0.5)*ampl;
	}

}
