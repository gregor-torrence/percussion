package com.gregortorrence.percussion.oscillators;

import java.util.Random;

/**
 * Generates simple white noise, AKA random numbers for the sample data.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class WhiteNoiseSource extends AbstractSampleSource {

    private Random random = new Random();

    public double sample(int i) {
        return random.nextDouble()*2.0 - 1.0;
    }

}
