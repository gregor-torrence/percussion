package com.gregortorrence.percussion.sources;

import java.util.Random;
import static com.gregortorrence.percussion.sources.OscillatorType.createOscillator;

import static java.lang.Math.abs;

/**
 * An oscillator where each cycle of the oscillator has a random frequency.
 *
 * Created by Gregor Torrence on 11/11/17.
 */
public class VariantOscillatorSource extends AbstractSampleSource {

    private OscillatorType oscillatorType = OscillatorType.SINE;

    private final double[] samples;

    public VariantOscillatorSource(long sampleRate, double minHertz, double maxHertz, double seconds) {
        Random random = new Random();
        int sampleSize = (int)(sampleRate * seconds) + 1;
        samples = new double[sampleSize];
        int i=0;

        while (i<sampleSize) {
            double hertz = random.nextDouble() * abs(maxHertz - minHertz) + minHertz;
            AbstractOscillator oscillator = createOscillator(oscillatorType, sampleRate, hertz, 1.0);
            int waveLength = (int) (sampleRate / hertz);
            for (int j=0; j<waveLength && i<sampleSize; j++, i++) {
                samples[i] = oscillator.sample(j);
            }
        }
    }

    public OscillatorType getOscillatorType() {
        return oscillatorType;
    }

    public void setOscillatorType(OscillatorType oscillatorType) {
        this.oscillatorType = oscillatorType;
    }

    public double sample(int i) {
        return samples[i % samples.length];
    }

}
