package com.gregortorrence.percussion.sources

import static com.gregortorrence.percussion.TestConstants.*

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class SquareOscillatorSpec extends AbstractSourceSpec {

    def "generate square wave"() {
        when:
        generateFromSource(new SquareOscillator(SAMPLE_RATE, 300, 1.0), 1.0, "square.wav")
        then:
        noExceptionThrown()
    }

}
