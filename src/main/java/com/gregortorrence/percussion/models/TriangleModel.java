package com.gregortorrence.percussion.models;

import com.gregortorrence.percussion.generators.AbstractGenerator;
import com.gregortorrence.percussion.generators.SineGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Begins to approximate a triangle wave by summing even numbered harmonics.
 * Not terribly useful, but it proves that additive synthesis does what we want it to.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class TriangleModel extends AbstractModel{

    @Override
    public List<? extends AbstractGenerator> getGenerators(int sampleRate, int hertz) {
        List<SineGenerator> generators = new ArrayList<>();
        for (int i=0; i<32; i++) {
            generators.add(new SineGenerator(sampleRate, hertz, 1.0 / (1.0 + i)));
            hertz *= 2;
        }
        return generators;
    }

}
