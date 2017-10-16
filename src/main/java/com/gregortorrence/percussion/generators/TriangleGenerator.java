package com.gregortorrence.percussion.generators;

import static java.lang.Math.PI;
import static java.lang.Math.asin;
import static java.lang.Math.sin;

/**
 * Generates a size wave at the supplied frequency and amplitude.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class TriangleGenerator extends AbstractGenerator {

    public TriangleGenerator(long sampleRate, double hertz, double amplitude) {
        super(sampleRate, hertz, amplitude);
    }

    public double sample(int i) {
        double x = (hertz * i * 2.0 * PI) / (sampleRate);
        return -amplitude * 2/PI * asin(sin(x));
    }

}
