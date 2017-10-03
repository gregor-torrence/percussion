package com.gregortorrence.percussion.models;

import com.gregortorrence.percussion.generators.AbstractGenerator;

import java.util.List;

/**
 * A Model is an object that creates Generators for additive synthesis.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public abstract class AbstractModel {

    public abstract List<? extends AbstractGenerator> getGenerators(int sampleRate, int hertz);

}
