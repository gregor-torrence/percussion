package com.gregortorrence.percussion;

import com.gregortorrence.percussion.generators.AbstractGenerator;
import com.gregortorrence.percussion.models.CircularDrumHeadModel;
import com.gregortorrence.percussion.processors.WaveDumper;
import com.gregortorrence.percussion.output.WaveWriter;
import com.gregortorrence.percussion.processors.Envelope;
import com.gregortorrence.percussion.generators.Mixer;
import com.gregortorrence.percussion.processors.Normalizer;

import java.io.File;
import java.util.List;

/**
 * Created by Gregor Torrence on 9/27/17.
 */
public class Main {

    public static final int SAMPLE_RATE = 44100;
    public static final double SECONDS = 1.0;

    /**
     * Work in progress. No arguments handled yet. Generates wave file according to hard coded values.
     */
    public static void main(String[] args) throws Exception {
        Envelope envelope = new Envelope();
        Normalizer normalizer = new Normalizer();
        WaveDumper waveDumper = new WaveDumper();
        Mixer mixer = new Mixer();
        CircularDrumHeadModel model = new CircularDrumHeadModel();

        List<? extends AbstractGenerator> generators = model.getGenerators(SAMPLE_RATE, 150);
        List<Double> samples = mixer.mix(generators, SAMPLE_RATE, SECONDS);
        envelope.process(samples);
        normalizer.process(samples);
        waveDumper.process(samples);

        new WaveWriter().write(new File("wavefile.wav"), samples);
    }

}
