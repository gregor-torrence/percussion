package com.gregortorrence.percussion.generators;

/**
 * Base class for for a tone generator. Provide method for getting sample data at a given index.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public abstract class AbstractGenerator  {
    protected long sampleRate;
    protected double hertz;
    protected double amplitude;

    public AbstractGenerator(long sampleRate, double hertz, double amplitude) {
        this.sampleRate = sampleRate;
        this.hertz = hertz;
        this.amplitude = amplitude;
    }

    public abstract double sample(int i);

}
