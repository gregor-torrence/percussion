package com.gregortorrence.percussion.examples

import com.gregortorrence.percussion.processors.Normalizer
import com.gregortorrence.percussion.processors.VolumeEnvelope
import com.gregortorrence.percussion.sources.BoundedNoiseSource
import com.gregortorrence.percussion.sources.TransientSource

import static com.gregortorrence.percussion.TestConstants.SAMPLE_RATE

class HiHatSpec extends AbstractExampleSpec {

    def 'create hi-hats from bounded noise'() {
        given:
        def sources = [
                new TransientSource(SAMPLE_RATE, 100, 2.0, TransientSource.TransientType.TRIANGLE),
                new BoundedNoiseSource(SAMPLE_RATE, 3000.0, 15000.0, 100, 0.75)
        ]
        def processors = [
                new Normalizer(),
                new VolumeEnvelope(),
                new VolumeEnvelope()
        ]

        when:
        writeFromSources(
                sources,
                processors,
                "example-hi-hat-open-bounded-noise.wav",
                1.0
        )
        writeFromSources(
                sources,
                processors,
                "example-hi-hat-closed-bounded-noise.wav",
                0.1
        )

        then:
        noExceptionThrown()
    }

}
