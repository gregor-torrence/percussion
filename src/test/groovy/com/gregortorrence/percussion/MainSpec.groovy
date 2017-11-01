package com.gregortorrence.percussion

import com.gregortorrence.percussion.models.AbstractAdditiveModel
import com.gregortorrence.percussion.models.CircularDrumHeadModel
import com.gregortorrence.percussion.models.SquareDrumHeadModel
import com.gregortorrence.percussion.oscillators.*
import com.gregortorrence.percussion.output.WaveWriter
import com.gregortorrence.percussion.processors.*
import spock.lang.Specification

/**
 * For now, this is more of an integration/manual test class. Each method writes a wav file with a fixed set of parameters.
 *
 * Created by Gregor Torrence on 10/4/17.
 */
class MainSpec extends Specification {

    private static final int SAMPLE_RATE = 44100
    private static final double SECONDS = 1.0

    def "generate sine wave"() {
        when:
        generateFromSource(new SineOscillator(SAMPLE_RATE, 300, 1.0), "sine.wav")
        then:
        noExceptionThrown()
    }

    def "generate sawtooth wave"() {
        when:
        generateFromSource(new SawtoothOscillator(SAMPLE_RATE, 300, 1.0), "sawtooth.wav")
        then:
        noExceptionThrown()
    }

    def "generate triangle wave"() {
        when:
        generateFromSource(new TriangleOscillator(SAMPLE_RATE, 300, 1.0), "triangle.wav")
        then:
        noExceptionThrown()
    }

    def "generate square wave"() {
        when:
        generateFromSource(new SquareOscillator(SAMPLE_RATE, 300, 1.0), "square.wav")
        then:
        noExceptionThrown()
    }

    def "generate white noise"() {
        when:
        generateFromSource(new WhiteNoiseSource(), "white-noise.wav")
        then:
        noExceptionThrown()
    }

    def "generate bounded noise"() {
        when:
        generateFromSource(new BoundedNoiseSource(SAMPLE_RATE, 100.0, 400.0), "bounded-noise.wav")
        then:
        noExceptionThrown()
    }

    def "generate round drum head"() {
        when:
        generateFromModel(new CircularDrumHeadModel(), 150, "round-drum.wav")
        then:
        noExceptionThrown()
    }

    def "generate square drum head"() {
        when:
        generateFromModel(new SquareDrumHeadModel(), 150, "square-drum.wav")
        then:
        noExceptionThrown()
    }

    // ====== Utility methods for the above tests ======

    def generateFromModel(AbstractAdditiveModel model, int hertz, String filename) {
        VolumeEnvelope volumeEnvelope = new VolumeEnvelope()
        Normalizer normalizer = new Normalizer()
        Mixer mixer = new Mixer()

        List<? extends AbstractOscillator> oscillators = model.getOscillators(SAMPLE_RATE, hertz)
        List<Double> samples = mixer.mix(oscillators, SAMPLE_RATE, SECONDS)
        volumeEnvelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File(filename), samples)
    }

    def generateFromSource(AbstractSampleSource oscillator, String filename) {
        VolumeEnvelope volumeEnvelope = new VolumeEnvelope()
        Normalizer normalizer = new Normalizer()
        Mixer mixer = new Mixer()

        def samples = mixer.mix([oscillator], SAMPLE_RATE, SECONDS)
        volumeEnvelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File(filename), samples)
    }

}
