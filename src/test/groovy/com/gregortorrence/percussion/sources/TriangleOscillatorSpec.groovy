package com.gregortorrence.percussion.sources

import com.gregortorrence.percussion.AbstractSourceSpec

import static com.gregortorrence.percussion.TestConstants.*

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class TriangleOscillatorSpec extends AbstractSourceSpec {

    def "generate triangle wave"() {
        when:
        generateFromSource(new TriangleOscillator(SAMPLE_RATE, 300, 1.0), 1.0, "triangle.wav")
        then:
        noExceptionThrown()
    }

}
