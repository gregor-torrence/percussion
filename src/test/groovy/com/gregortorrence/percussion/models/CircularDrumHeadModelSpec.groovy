package com.gregortorrence.percussion.models

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class CircularDrumHeadModelSpec extends AbstractModelSpec {

    def "generate circular drum head"() {
        when:
        generateFromModel(new CircularDrumHeadModel(), 80, 0.25, "circular-drum.wav")
        then:
        noExceptionThrown()
    }

}
