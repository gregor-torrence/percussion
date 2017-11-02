package com.gregortorrence.percussion.models

import com.gregortorrence.percussion.AbstractModelSpec

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
