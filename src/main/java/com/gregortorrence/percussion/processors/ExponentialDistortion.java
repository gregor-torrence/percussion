package com.gregortorrence.percussion.processors;

import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.signum;

/**
 * Applies exponential distortion to the supplied list of normalized samples
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class ExponentialDistortion extends AbstractProcessor {

    double exponent;

    /**
     * exponent > 1.0 means the sound is thinner
     * exponent < 1.0 means the sound is fatter
     * exponent 1.0 means no distortion
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
            samples.set(i, pow(abs(sample), 1.0) * signum(sample));
        }

        return samples;
    }

}
