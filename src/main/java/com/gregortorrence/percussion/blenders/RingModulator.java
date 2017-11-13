package com.gregortorrence.percussion.blenders;

import com.gregortorrence.percussion.sources.AbstractSampleSource;

import java.util.ArrayList;
import java.util.List;

/**
 * In the way that a Mixer adds sample data together, a RingModulator multiplies sample data together.
 * This typically leads to a much quieter set of data badly in need of normalization.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class RingModulator implements Blender {

    @Override
    public List<Double> mix(List<? extends AbstractSampleSource> sampleSources, long sampleRate, double seconds) {
        int length = (int)((double)sampleRate * seconds);
        List<Double> samples = new ArrayList<>();
        for (int i=0; i<length; i++) {
            final int index = i;
            samples.add(sampleSources.stream().mapToDouble(oscillator -> oscillator.sample(index))
                    .reduce((left, right) -> left * right).orElse(0.0));
        }
        return samples;
    }

}
