package com.gregortorrence.percussion.processors;

import java.util.List;

/**
 * Base class for process a set of sample data.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public abstract class AbstractProcessor {

    public abstract List<Double> process(List<Double> samples);

}
