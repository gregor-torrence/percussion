package com.gregortorrence.percussion

import com.gregortorrence.percussion.generators.AbstractGenerator
import com.gregortorrence.percussion.generators.Mixer
import com.gregortorrence.percussion.generators.SawtoothGenerator
import com.gregortorrence.percussion.generators.TriangleGenerator
import com.gregortorrence.percussion.models.CircularDrumHeadModel
import com.gregortorrence.percussion.output.WaveWriter
import com.gregortorrence.percussion.processors.Envelope
import com.gregortorrence.percussion.processors.Normalizer
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
        Envelope envelope = new Envelope()
        Normalizer normalizer = new Normalizer()
        Mixer mixer = new Mixer()
        CircularDrumHeadModel model = new CircularDrumHeadModel()

        List<? extends AbstractGenerator> generators = model.getGenerators(SAMPLE_RATE, 150)
        List<Double> samples = mixer.mix(generators, SAMPLE_RATE, SECONDS)
        envelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File("round-drum.wav"), samples)

        then:
        noExceptionThrown()
    }

    def "generate sawtooth"() {
        when:
        Envelope envelope = new Envelope()
        Normalizer normalizer = new Normalizer()
        SawtoothGenerator generator = new SawtoothGenerator(SAMPLE_RATE, 300, 1.0)
        Mixer mixer = new Mixer()

        def samples = mixer.mix([generator], SAMPLE_RATE, 1.5)
        envelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File("sawtooth.wav"), samples)

        then:
        noExceptionThrown()
    }

    def "generate triangle"() {
        when:
        Envelope envelope = new Envelope()
        Normalizer normalizer = new Normalizer()
        TriangleGenerator generator = new TriangleGenerator(SAMPLE_RATE, 300, 1.0)
        Mixer mixer = new Mixer()

        def samples = mixer.mix([generator], SAMPLE_RATE, 1.5)
        envelope.process(samples)
        normalizer.process(samples)

        new WaveWriter().write(new File("triangle.wav"), samples)

        then:
        noExceptionThrown()
    }

}
