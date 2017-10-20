package com.gregortorrence.percussion.oscillators;

import static java.lang.Math.*;

/**
 * Generates a size wave at the supplied frequency and amplitude.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class SawtoothOscillator extends AbstractOscillator {

    public SawtoothOscillator(long sampleRate, double hertz, double amplitude) {
        super(sampleRate, hertz, amplitude);
    }

    public double sample(int i) {
        double x = (hertz * i * 2.0 * PI) / (sampleRate);
        return -amplitude * atan(1.0 / tan(x + PI/2.0));
    }

}
