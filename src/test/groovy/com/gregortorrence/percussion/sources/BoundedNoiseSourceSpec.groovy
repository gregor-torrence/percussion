package com.gregortorrence.percussion.sources

import com.gregortorrence.percussion.AbstractSourceSpec

import static com.gregortorrence.percussion.TestConstants.*

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class BoundedNoiseSourceSpec extends AbstractSourceSpec {

    def "generate bounded noise"() {
        given:
        def seconds = 0.5
        when:
        generateFromSource(new BoundedNoiseSource(SAMPLE_RATE, 4000.0, 15000.0, 100, seconds), seconds, "unit-test-bounded-noise.wav")
        then:
        noExceptionThrown()
    }

}
