package com.gregortorrence.percussion.models;

import com.gregortorrence.percussion.sources.AbstractOscillator;

import java.util.ArrayList;
import java.util.List;

import static com.gregortorrence.percussion.sources.OscillatorType.createOscillator;

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
            oscillators.add(createOscillator(getOscillatorType(), sampleRate, hertz*harmonic, 1.0 / (harmonic * harmonic)));
        }

        return oscillators;
    }

}
