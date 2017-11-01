package com.gregortorrence.percussion.oscillators;

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

    private Random random = new Random();
    private double[] loop = new double[50000];

    public BoundedNoiseSource(long sampleRate, double minHertz, double maxHertz) {
        for (int h=0; h<100; h++) {
            double hertz = random.nextDouble() * abs(maxHertz - minHertz) + minHertz;
            double phase = random.nextDouble()*2.0*PI;
            for (int i = 0; i < loop.length; i++) {
                double x = (hertz * i * 2.0 * PI) / sampleRate;
                loop[i] += sin(x + phase);
            }
        }
    }

    public double sample(int i) {
        return loop[i % loop.length];
    }

}
