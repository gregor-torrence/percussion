package com.gregortorrence.percussion.oscillators;

import java.util.ArrayList;
import java.util.List;

/**
 * Create sample data from a supplied list of oscillators. This is the "additive" part of additive synthesis.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class Mixer {

    public List<Double> mix(List<? extends AbstractSampleSource> oscillators, long sampleRate, double seconds) {
        int length = (int)((double)sampleRate * seconds);
        List<Double> samples = new ArrayList<>();
        for (int i=0; i<length; i++) {
            final int index = i;
            samples.add(oscillators.stream().mapToDouble(oscillator -> oscillator.sample(index)).sum());
        }
        return samples;
    }

}
