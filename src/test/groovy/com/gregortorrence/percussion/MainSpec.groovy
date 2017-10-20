package com.gregortorrence.percussion

import com.gregortorrence.percussion.models.CircularDrumHeadModel
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

    def "generate round drum head"() {
        when:
        VolumeEnvelope volumeEnvelope = new VolumeEnvelope()
        Normalizer normalizer = new Normalizer()
        Mixer mixer = new Mixer()
        CircularDrumHeadModel model = new CircularDrumHeadModel()

        List<? extends AbstractOscillator> oscillators = model.getOscillators(SAMPLE_RATE, 150)
        List<Double> samples = mixer.mix(oscillators, SAMPLE_RATE, SECONDS)
        volumeEnvelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File("round-drum.wav"), samples)

        then:
        noExceptionThrown()
    }

    def "generate sine"() {
        when:
        VolumeEnvelope volumeEnvelope = new VolumeEnvelope()
        Normalizer normalizer = new Normalizer()
        SineOscillator oscillator = new SineOscillator(SAMPLE_RATE, 300, 1.0)
        Mixer mixer = new Mixer()

        def samples = mixer.mix([oscillator], SAMPLE_RATE, 1.5)
        volumeEnvelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File("sine.wav"), samples)

        then:
        noExceptionThrown()
    }

    def "generate sawtooth"() {
        when:
        VolumeEnvelope volumeEnvelope = new VolumeEnvelope()
        Normalizer normalizer = new Normalizer()
        SawtoothOscillator oscillator = new SawtoothOscillator(SAMPLE_RATE, 300, 1.0)
        Mixer mixer = new Mixer()

        def samples = mixer.mix([oscillator], SAMPLE_RATE, 1.5)
        volumeEnvelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File("sawtooth.wav"), samples)

        then:
        noExceptionThrown()
    }

    def "generate triangle"() {
        when:
        VolumeEnvelope volumeEnvelope = new VolumeEnvelope()
        Normalizer normalizer = new Normalizer()
        TriangleOscillator oscillator = new TriangleOscillator(SAMPLE_RATE, 300, 1.0)
        Mixer mixer = new Mixer()

        def samples = mixer.mix([oscillator], SAMPLE_RATE, 1.5)
        volumeEnvelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File("triangle.wav"), samples)

        then:
        noExceptionThrown()
    }

    def "generate square"() {
        when:
        VolumeEnvelope volumeEnvelope = new VolumeEnvelope()
        Normalizer normalizer = new Normalizer()
        SquareOscillator oscillator = new SquareOscillator(SAMPLE_RATE, 300, 1.0)
        Mixer mixer = new Mixer()

        def samples = mixer.mix([oscillator], SAMPLE_RATE, 1.5)
        volumeEnvelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File("square.wav"), samples)

        then:
        noExceptionThrown()
    }

}
