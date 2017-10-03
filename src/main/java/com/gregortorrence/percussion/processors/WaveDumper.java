package com.gregortorrence.percussion.processors;

import java.util.List;

/**
 * For debugging purposes. Writes floating point sample data to stdout.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class WaveDumper extends AbstractProcessor{

    @Override
    public List<Double> process(List<Double> samples) {
        for (int i=0; i<samples.size(); i++) {
            System.out.printf("%7d %2.8f\n", i, samples.get(i));
        }
        return samples;
    }

}
