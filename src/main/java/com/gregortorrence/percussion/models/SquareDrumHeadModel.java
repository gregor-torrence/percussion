package com.gregortorrence.percussion.models;

import com.gregortorrence.percussion.oscillators.AbstractOscillator;
import com.gregortorrence.percussion.oscillators.SawtoothOscillator;
import com.gregortorrence.percussion.oscillators.SineOscillator;
import com.gregortorrence.percussion.oscillators.SquareOscillator;
import com.gregortorrence.percussion.oscillators.TriangleOscillator;

import java.util.ArrayList;
import java.util.List;

/**
 * Uses zeros of Eigen functions for the overtone series of a vibrating square drum head.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class SquareDrumHeadModel extends AbstractAdditiveModel {

    private static final double MULTIPLIER = 1.047132947365208326458208436598376;

    @Override
    public List<? extends AbstractOscillator> getOscillators(final int sampleRate, final int hertz) {
        List<AbstractOscillator> oscillators = new ArrayList<>();
        for (double harmonic = 1.0; harmonic<2.0; harmonic*=MULTIPLIER) {
            oscillators.add(createOscillator(sampleRate, hertz, harmonic));
        }

        return oscillators;
    }

    private AbstractOscillator createOscillator(int sampleRate, double hertz, double harmonic) {
        switch (getOscillatorType()) {
            case SINE:
                return new SineOscillator(sampleRate, hertz * harmonic, 1.0 / (harmonic * harmonic));
            case SQUARE:
                return new SquareOscillator(sampleRate, hertz * harmonic, 1.0 / (harmonic * harmonic));
            case SAWTOOTH:
                return new SawtoothOscillator(sampleRate, hertz * harmonic, 1.0 / (harmonic * harmonic));
            case TRIANGLE:
                return new TriangleOscillator(sampleRate, hertz * harmonic, 1.0 / (harmonic * harmonic));
            default:
                throw new IllegalStateException("Unhandled OscillatorType " + getOscillatorType());
        }
    }

}
