package com.gregortorrence.percussion.models;

import com.gregortorrence.percussion.oscillators.AbstractOscillator;

import java.util.List;

/**
 * A Model is an object that creates Oscillators for additive synthesis.
 * SineOscillators are used by default, but that can be changed.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public abstract class AbstractAdditiveModel {

    public enum OscillatorType {
        SINE, SQUARE, TRIANGLE, SAWTOOTH
    }

    private OscillatorType oscillatorType = OscillatorType.SINE;

    public OscillatorType getOscillatorType() {
        return oscillatorType;
    }

    public void setOscillatorType(OscillatorType oscillatorType) {
        this.oscillatorType = oscillatorType;
    }

    public abstract List<? extends AbstractOscillator> getOscillators(int sampleRate, int hertz);

}
