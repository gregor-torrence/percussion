package com.gregortorrence.percussion.generators;

import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.Math.tan;

/**
 * Generates a size wave at the supplied frequency and amplitude.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class SawtoothGenerator extends AbstractGenerator {

    public SawtoothGenerator(long sampleRate, double hertz, double amplitude) {
        super(sampleRate, hertz, amplitude);
    }

    public double sample(int i) {
        double x = (hertz * i * 2.0 * PI) / (sampleRate);
        return -amplitude * atan(1.0 / tan(x + PI/2.0));
    }

}
