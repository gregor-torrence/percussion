package com.gregortorrence.percussion.sources

import static com.gregortorrence.percussion.TestConstants.*

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class SineOscillatorSpec extends AbstractSourceSpec {

    def "generate sine wave"() {
        when:
        generateFromSource(new SineOscillator(SAMPLE_RATE, 300, 1.0), 1.0, "sine.wav")
        then:
        noExceptionThrown()
    }

}
