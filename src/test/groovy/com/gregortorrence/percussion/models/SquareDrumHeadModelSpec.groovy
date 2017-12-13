package com.gregortorrence.percussion.models

import com.gregortorrence.percussion.AbstractModelSpec

/**
 * Created by Gregor Torrence on 11/1/17.
 */
class SquareDrumHeadModelSpec extends AbstractModelSpec {

    def "generate square drum head"() {
        when:
        generateFromModel(new SquareDrumHeadModel(), 150, 0.25, "unit-test-square-membrane.wav")
        then:
        noExceptionThrown()
    }

}
