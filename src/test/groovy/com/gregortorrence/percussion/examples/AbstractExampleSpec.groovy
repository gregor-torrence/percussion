package com.gregortorrence.percussion.examples

import com.gregortorrence.percussion.blenders.Mixer
import com.gregortorrence.percussion.output.WaveWriter
import com.gregortorrence.percussion.processors.Processor
import com.gregortorrence.percussion.sources.AbstractSampleSource
import spock.lang.Specification

import static com.gregortorrence.percussion.TestConstants.SAMPLE_RATE

abstract class AbstractExampleSpec extends Specification {

    protected static void writeFromSources(List<AbstractSampleSource> sources, List<Processor> processors, String filename, double seconds) {
        def samples = new Mixer().mix(sources, SAMPLE_RATE, seconds)
        for (Processor processor : processors) {
            processor.process(samples)
        }

        new WaveWriter().write(new File(filename), samples)
    }

}
