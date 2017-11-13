package com.gregortorrence.percussion.processors;

import java.util.List;

/**
 * Applies to linear fade to the supplied samples. A logarithmic fade would be more realistic.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class VolumeEnvelope implements Processor {

    @Override
    public List<Double> process(List<Double> samples) {
        for (int i=0; i<samples.size(); i++) {
            Double sample = samples.get(i);
            double size = samples.size();
            samples.set(i, sample * (size - i)/ size);
        }
        return samples;
    }

}
