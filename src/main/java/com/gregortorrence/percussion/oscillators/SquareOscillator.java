package com.gregortorrence.percussion.oscillators;

import static java.lang.Math.PI;
import static java.lang.Math.signum;
import static java.lang.Math.sin;

/**
 * Generates a size wave at the supplied frequency and amplitude.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class SquareOscillator extends AbstractOscillator {

    public SquareOscillator(long sampleRate, double hertz, double amplitude) {
        super(sampleRate, hertz, amplitude);
    }

    public double sample(int i) {
        double x = (hertz * i * 2.0 * PI) / sampleRate;
        return amplitude * signum(sin(x));
    }

}
