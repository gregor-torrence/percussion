package com.gregortorrence.percussion.oscillators;

/**
 * Base class for for a tone oscillator.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public abstract class AbstractOscillator extends AbstractSampleSource {
    protected long sampleRate;
    protected double hertz;
    protected double amplitude;

    public AbstractOscillator(long sampleRate, double hertz, double amplitude) {
        this.sampleRate = sampleRate;
        this.hertz = hertz;
        this.amplitude = amplitude;
    }

}
