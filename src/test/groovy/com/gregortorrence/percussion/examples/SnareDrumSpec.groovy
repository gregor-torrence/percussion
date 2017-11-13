package com.gregortorrence.percussion.examples

import com.gregortorrence.percussion.sources.BoundedNoiseSource
import com.gregortorrence.percussion.sources.OscillatorType
import com.gregortorrence.percussion.sources.TransientSource
import com.gregortorrence.percussion.sources.WhiteNoiseSource

import static com.gregortorrence.percussion.TestConstants.SAMPLE_RATE

class SnareDrumSpec extends AbstractExampleSpec {

    def 'create circular membrane kick drum'() {
        when:
        def seconds = 1.0
        writeFromSources(
                [
                        new TransientSource(SAMPLE_RATE, 150, 2, OscillatorType.TRIANGLE),
                        new BoundedNoiseSource(SAMPLE_RATE, 300.0,  350.0, 50, seconds),
                        new BoundedNoiseSource(SAMPLE_RATE, 300.0,  350.0, 50, seconds),
                        new BoundedNoiseSource(SAMPLE_RATE, 150.0,  450.0, 50, seconds),
                        new BoundedNoiseSource(SAMPLE_RATE, 100.0,  900.0, 50, seconds),
                        new BoundedNoiseSource(SAMPLE_RATE, 80.0,  1500.0, 50, seconds),
                        new WhiteNoiseSource()
                ],
                normalProcessors,
                "example-snare-drum-noise.wav",
                seconds
        )

        then:
        noExceptionThrown()
    }

}
