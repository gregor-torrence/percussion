package com.gregortorrence.percussion.sources

import com.gregortorrence.percussion.AbstractSourceSpec

import static com.gregortorrence.percussion.TestConstants.SAMPLE_RATE

/**
 * Created by Gregor Torrence on 11/11/17.
 */
class VariantOscillatorSourceSpec extends AbstractSourceSpec {

    def "generate bounded noise"() {
        given:
        def seconds = 0.5
        when:
        generateFromSource(new VariantOscillatorSource(SAMPLE_RATE, 60.0, 100.0, seconds), seconds, "bounded-freq.wav")
        then:
        noExceptionThrown()
    }

}
