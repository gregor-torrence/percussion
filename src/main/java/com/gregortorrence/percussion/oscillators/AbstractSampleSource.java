package com.gregortorrence.percussion.oscillators;

/**
 * Base class for for any oscillator or noise source. Provides the method for getting sample data at a given index.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public abstract class AbstractSampleSource {

    public abstract double sample(int i);

}
