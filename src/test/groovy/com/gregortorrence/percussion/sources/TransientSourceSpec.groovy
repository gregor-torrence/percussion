package com.gregortorrence.percussion.sources

import com.gregortorrence.percussion.AbstractSourceSpec

import static com.gregortorrence.percussion.TestConstants.SAMPLE_RATE

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class TransientSourceSpec extends AbstractSourceSpec {

    def "generate transient"() {
        when:
        generateFromSource(new TransientSource(SAMPLE_RATE, 300, 1.0, OscillatorType.TRIANGLE), 1.0, "unit-test-transient.wav")
        then:
        noExceptionThrown()
    }

}
