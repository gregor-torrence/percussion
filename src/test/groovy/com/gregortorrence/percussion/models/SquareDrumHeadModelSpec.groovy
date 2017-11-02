package com.gregortorrence.percussion.models

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class SquareDrumHeadModelSpec extends AbstractModelSpec {

    def "generate square drum head"() {
        when:
        generateFromModel(new SquareDrumHeadModel(), 150, 0.25, "square-drum.wav")
        then:
        noExceptionThrown()
    }

}
