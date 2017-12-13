package com.gregortorrence.percussion.sources

import com.gregortorrence.percussion.AbstractSourceSpec

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class WhiteNoiseSourceSpec extends AbstractSourceSpec {

    def "generate white noise"() {
        when:
        generateFromSource(new WhiteNoiseSource(), 0.5, "unit-test-white-noise.wav")
        then:
        noExceptionThrown()
    }

}
