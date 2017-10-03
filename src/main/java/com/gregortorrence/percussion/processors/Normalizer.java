package com.gregortorrence.percussion.processors;

import java.util.Comparator;
import java.util.List;
import static java.lang.Math.*;

/**
 * Scales the supplied sample so that they are in the range of -1.0 to 1.0
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class Normalizer extends AbstractProcessor {

    @Override
    public List<Double> process(List<Double> samples) {
        Double max = samples.stream().max(Comparator.naturalOrder()).orElse(0.0);
        Double min = samples.stream().min(Comparator.naturalOrder()).orElse(0.0);
        double scale = max(abs(max), abs(min));

        for (int i=0; i<samples.size(); i++) {
            Double sample = samples.get(i);
            samples.set(i, sample/scale);
        }

        return samples;
    }

}
