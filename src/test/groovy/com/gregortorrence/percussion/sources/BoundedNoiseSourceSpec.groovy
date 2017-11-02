package com.gregortorrence.percussion.sources

import static com.gregortorrence.percussion.TestConstants.*

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class BoundedNoiseSourceSpec extends AbstractSourceSpec {

    def "generate bounded noise"() {
        given:
        def seconds = 0.5
        when:
        generateFromSource(new BoundedNoiseSource(SAMPLE_RATE, 4000.0, 15000.0, seconds), seconds, "bounded-noise.wav")
        then:
        noExceptionThrown()
    }

}
