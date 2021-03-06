package com.gregortorrence.percussion.sources;

import static java.lang.Math.*;

/**
 * Generates a size wave at the supplied frequency and amplitude.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class TriangleOscillator extends AbstractOscillator {

    public TriangleOscillator(long sampleRate, double hertz, double amplitude) {
        super(sampleRate, hertz, amplitude);
    }

    public double sample(int i) {
        double x = (hertz * i * 2.0 * PI) / (sampleRate);
        return -amplitude * 2/PI * asin(sin(x));
    }

}
