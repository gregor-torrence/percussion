package com.gregortorrence.percussion

import com.gregortorrence.percussion.models.AbstractAdditiveModel
import com.gregortorrence.percussion.output.WaveWriter
import com.gregortorrence.percussion.processors.Normalizer
import com.gregortorrence.percussion.processors.VolumeEnvelope
import com.gregortorrence.percussion.sources.AbstractOscillator
import com.gregortorrence.percussion.blenders.Mixer
import spock.lang.Specification

import static com.gregortorrence.percussion.TestConstants.*

/**
 * Created by Gregor Torrence on 11/1/17.
 */
abstract class AbstractModelSpec extends Specification {

    protected static def generateFromModel(AbstractAdditiveModel model, int hertz, double seconds, String filename) {
        VolumeEnvelope volumeEnvelope = new VolumeEnvelope()
        Normalizer normalizer = new Normalizer()
        Mixer mixer = new Mixer()

        List<? extends AbstractOscillator> oscillators = model.getOscillators(SAMPLE_RATE, hertz)
        List<Double> samples = mixer.mix(oscillators, SAMPLE_RATE, seconds)
        volumeEnvelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File(filename), samples)
    }

}
