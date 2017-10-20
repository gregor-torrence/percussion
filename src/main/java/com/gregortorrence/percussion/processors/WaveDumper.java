package com.gregortorrence.percussion.processors;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;

/**
 * For debugging purposes. Writes normalized floating point sample data to stdout, and a crude 80 column graph.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class WaveDumper extends AbstractProcessor{

    @Override
    public List<Double> process(List<Double> samples) {
        for (int i=0; i<samples.size(); i++) {
            Double sample = samples.get(i);
            System.out.printf("%7d %+2.8f %s\n", i, sample, createGraphPoint(sample));
        }
        return samples;
    }

    private String createGraphPoint(Double sample) {
        if (abs(sample) > 1.0) {
            throw new IllegalArgumentException("Supplied samples are not normalized");
        }
        char[] graph = new char[80];
        Arrays.fill(graph, ' ');
        graph[39] = '|';
        graph[(int)((sample * 39.9) + 40.0)] = '*';
        return "|" + new String(graph) + "|";
    }

}
