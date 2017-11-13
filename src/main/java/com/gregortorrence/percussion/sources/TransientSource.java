package com.gregortorrence.percussion.sources;
import static com.gregortorrence.percussion.sources.OscillatorType.createOscillator;

/**
 * Adds a single oscillation at the beginning of a sample source. Adds the attack transients that typically
 * would come from a stick striking an instrument.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class TransientSource extends AbstractSampleSource {

    private AbstractOscillator oscillator;
    private double[] transientSamples;

    public TransientSource(long sampleRate, double hertz, double amplitude, OscillatorType type) {
        oscillator = createOscillator(type, sampleRate, hertz, amplitude);
        int transientLength = (int)(sampleRate / hertz);
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
