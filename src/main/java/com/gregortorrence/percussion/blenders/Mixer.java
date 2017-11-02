package com.gregortorrence.percussion.blenders;

import com.gregortorrence.percussion.sources.AbstractSampleSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Create sample data from a supplied list of sources. This is the "additive" part of additive synthesis.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class Mixer implements Blender {

    @Override
    public List<Double> mix(List<? extends AbstractSampleSource> sampleSources, long sampleRate, double seconds) {
        int length = (int)((double)sampleRate * seconds);
        List<Double> samples = new ArrayList<>();
        for (int i=0; i<length; i++) {
            final int index = i;
            samples.add(sampleSources.stream().mapToDouble(sampleSource -> sampleSource.sample(index)).sum());
        }
        return samples;
    }

}
