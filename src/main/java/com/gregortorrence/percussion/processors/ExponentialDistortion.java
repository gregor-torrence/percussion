package com.gregortorrence.percussion.processors;

import java.util.List;

import static java.lang.Math.*;

/**
 * Applies exponential distortion to the supplied list of normalized samples
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class ExponentialDistortion extends AbstractProcessor {

    double exponent;

    /**
     * exponent < 1.0 means the sound is fatter.
     * exponent = 1.0 means no distortion.
     * exponent > 1.0 means the sound is thinner.
     * Pleasing values range roughly from 0.5 to 10.
     * Be sure to experiment with the VolumeEnvelope coming before or after the distortion.
     */
    public ExponentialDistortion(double exponent) {
        this.exponent = exponent;
    }

    @Override
    public List<Double> process(List<Double> samples) {

        for (int i=0; i<samples.size(); i++) {
            Double sample = samples.get(i);
            if (abs(sample) > 1.0) {
                throw new IllegalArgumentException("Supplied samples are not normalized");
            }
            samples.set(i, pow(abs(sample), exponent) * signum(sample));
        }

        return samples;
    }

}
