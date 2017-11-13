package com.gregortorrence.percussion.sources;

import java.util.Random;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.sin;

/**
 * Generates frequency bounded noise by summing sine waves of a random frequency and phase.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class BoundedNoiseSource extends AbstractSampleSource {

    private final double[] samples;

    public BoundedNoiseSource(long sampleRate, double minHertz, double maxHertz, int density, double seconds) {
        Random random = new Random();
        int sampleSize = (int)(sampleRate * seconds) + 1;
        samples = new double[sampleSize];

        for (int h=0; h<density; h++) {
            double hertz = random.nextDouble() * abs(maxHertz - minHertz) + minHertz;
            double phase = random.nextDouble()*2.0*PI;
            for (int i = 0; i < samples.length; i++) {
                double x = (hertz * i * 2.0 * PI) / sampleRate;
                samples[i] += sin(x + phase);
            }
        }
    }

    public double sample(int i) {
        return samples[i % samples.length];
    }

}
