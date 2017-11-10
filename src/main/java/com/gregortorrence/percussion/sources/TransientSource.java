package com.gregortorrence.percussion.sources;

/**
 * Adds a single oscillation at the beginning of a sample source. Adds the attack transients that typically
 * would come from a stick striking an instrument.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class TransientSource extends AbstractSampleSource {

    public enum TransientType {
        SINE, TRIANGLE, SQUARE, SAWTOOTH
    }

    protected long sampleRate;
    protected double hertz;
    protected double amplitude;
    protected AbstractOscillator oscillator;
    protected double[] transientSamples;

    public TransientSource(long sampleRate, double hertz, double amplitude, TransientType type) {
        this.sampleRate = sampleRate;
        this.hertz = hertz;
        this.amplitude = amplitude;

        switch (type) {
            case SINE:
                oscillator = new SineOscillator(sampleRate, hertz, amplitude);
                break;
            case SQUARE:
                oscillator = new SquareOscillator(sampleRate, hertz, amplitude);
                break;
            case TRIANGLE:
                oscillator = new TriangleOscillator(sampleRate, hertz, amplitude);
                break;
            case SAWTOOTH:
                oscillator = new SawtoothOscillator(sampleRate, hertz, amplitude);
                break;
        }

        int transientLength = (int)(sampleRate / (double)hertz);
        transientSamples = new double[transientLength];
        for (int i=0; i<transientLength; i++) {
            transientSamples[i] = oscillator.sample(i);
        }

    }

    public double sample(int i) {
        if (i < transientSamples.length) {
            return transientSamples[i];
        } else {
            return 0.0;
        }
    }

}
