package com.gregortorrence.percussion.sources

import com.gregortorrence.percussion.AbstractSourceSpec

import static com.gregortorrence.percussion.TestConstants.*

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class SawtoothOscillatorSpec extends AbstractSourceSpec {

    def "generate sawtooth wave"() {
        when:
        generateFromSource(new SawtoothOscillator(SAMPLE_RATE, 300, 1.0), 1.0, "unit-test-sawtooth.wav")
        then:
        noExceptionThrown()
    }

}
