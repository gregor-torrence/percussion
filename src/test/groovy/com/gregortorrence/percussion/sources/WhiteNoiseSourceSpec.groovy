package com.gregortorrence.percussion.sources
/**
 * Created by Gregor Torrence on 11/1/17.
 */
class WhiteNoiseSourceSpec extends AbstractSourceSpec {

    def "generate white noise"() {
        when:
        generateFromSource(new WhiteNoiseSource(), 0.5, "white-noise.wav")
        then:
        noExceptionThrown()
    }

}
