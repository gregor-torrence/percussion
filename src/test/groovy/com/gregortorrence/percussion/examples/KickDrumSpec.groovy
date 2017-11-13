package com.gregortorrence.percussion.examples

import com.gregortorrence.percussion.models.CircularDrumHeadModel
import com.gregortorrence.percussion.models.SquareDrumHeadModel
import com.gregortorrence.percussion.processors.Normalizer
import com.gregortorrence.percussion.processors.VolumeEnvelope
import com.gregortorrence.percussion.sources.AbstractSampleSource
import com.gregortorrence.percussion.sources.OscillatorType
import com.gregortorrence.percussion.sources.SineOscillator
import com.gregortorrence.percussion.sources.TransientSource
import com.gregortorrence.percussion.sources.TriangleOscillator
import com.gregortorrence.percussion.sources.VariantOscillatorSource

import static com.gregortorrence.percussion.TestConstants.SAMPLE_RATE

class KickDrumSpec extends AbstractExampleSpec {

    def 'create sine kick drum'() {
        when:
        writeFromSources(
                [
                        new TransientSource(SAMPLE_RATE, 100, 2.0, OscillatorType.TRIANGLE),
                        new SineOscillator(SAMPLE_RATE, 70, 1.0)
                ],
                [
                        new Normalizer(),
                        new VolumeEnvelope()
                ],
                "example-kick-drum-sine.wav",
                1.0
        )

        then:
        noExceptionThrown()
    }

    def 'create variant kick drum'() {
        when:
        writeFromSources(
                [
                        new TransientSource(SAMPLE_RATE, 100, 2.0, OscillatorType.TRIANGLE),
                        new VariantOscillatorSource(SAMPLE_RATE, 50, 90, 1.0)
                ],
                [
                        new Normalizer(),
                        new VolumeEnvelope()
                ],
                "example-kick-drum-variant.wav",
                1.0
        )

        then:
        noExceptionThrown()
    }

    def 'create triangle kick drum'() {
        when:
        writeFromSources(
                [
                        new TransientSource(SAMPLE_RATE, 100, 2.0, OscillatorType.SQUARE),
                        new TriangleOscillator(SAMPLE_RATE, 70, 1.0)
                ],
                [
                        new Normalizer(),
                        new VolumeEnvelope()
                ],
                "example-kick-drum-triangle.wav",
                1.0
        )

        then:
        noExceptionThrown()
    }

    def 'create circular membrane kick drum'() {
        when:
        List<? extends AbstractSampleSource> sources = new CircularDrumHeadModel().getOscillators(SAMPLE_RATE, 70)
        sources.add(new TransientSource(SAMPLE_RATE, 100, 2.0, OscillatorType.TRIANGLE))

        writeFromSources(
                sources,
                [
                        new Normalizer(),
                        new VolumeEnvelope()
                ],
                "example-kick-drum-circular-membrane.wav",
                1.0
        )

        then:
        noExceptionThrown()
    }

    def 'create square membrane kick drum'() {
        when:
        List<? extends AbstractSampleSource> sources = new SquareDrumHeadModel().getOscillators(SAMPLE_RATE, 70)
        sources.add(new TransientSource(SAMPLE_RATE, 100, 2.0, OscillatorType.TRIANGLE))

        writeFromSources(
                sources,
                [
                        new Normalizer(),
                        new VolumeEnvelope()
                ],
                "example-kick-drum-square-membrane.wav",
                1.0
        )

        then:
        noExceptionThrown()
    }

}
