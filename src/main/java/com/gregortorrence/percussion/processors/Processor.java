package com.gregortorrence.percussion.processors;

import java.util.List;

/**
 * Base class for process a set of sample data.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public interface Processor {

    List<Double> process(List<Double> samples);

}
