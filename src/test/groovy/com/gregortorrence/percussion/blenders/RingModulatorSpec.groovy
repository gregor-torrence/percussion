package com.gregortorrence.percussion.blenders

import com.gregortorrence.percussion.AbstractModelSpec
import com.gregortorrence.percussion.output.WaveWriter
import com.gregortorrence.percussion.processors.Normalizer
import com.gregortorrence.percussion.processors.VolumeEnvelope
import com.gregortorrence.percussion.sources.SineOscillator
import com.gregortorrence.percussion.sources.WhiteNoiseSource

import static com.gregortorrence.percussion.TestConstants.SAMPLE_RATE

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class RingModulatorSpec extends AbstractModelSpec {

    def 'generate white noise ring modulated by a sine wave'() {
        given:
        RingModulator ringModulator = new RingModulator()
        def whiteNoiseSource = new WhiteNoiseSource()
        def sineOscillator = new SineOscillator(SAMPLE_RATE, 50, 1.0)
        def samples = ringModulator.mix([whiteNoiseSource, sineOscillator], SAMPLE_RATE, 1.0)
        new Normalizer().process(samples)
        new VolumeEnvelope().process(samples)

        when:
        new WaveWriter().write(new File("ring-mod.wav"), samples)

        then:
        noExceptionThrown()
    }

}
