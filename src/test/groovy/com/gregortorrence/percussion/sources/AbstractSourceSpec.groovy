package com.gregortorrence.percussion.sources

import com.gregortorrence.percussion.output.WaveWriter
import com.gregortorrence.percussion.processors.Normalizer
import com.gregortorrence.percussion.processors.VolumeEnvelope
import spock.lang.Specification

import static com.gregortorrence.percussion.TestConstants.*

/**
 * Created by Gregor Torrence on 11/1/17.
 */
abstract class AbstractSourceSpec extends Specification {

    protected static def generateFromSource(AbstractSampleSource sampleSource, double seconds, String filename) {
        VolumeEnvelope volumeEnvelope = new VolumeEnvelope()
        Normalizer normalizer = new Normalizer()
        Mixer mixer = new Mixer()

        def samples = mixer.mix([sampleSource], SAMPLE_RATE, seconds)
        volumeEnvelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File(filename), samples)
    }

}
