package com.gregortorrence.percussion.blenders;

import com.gregortorrence.percussion.sources.AbstractSampleSource;

import java.util.List;

/**
 * Interface defining how sample sources are combined into sample data.
 *
 * Created by Gregor Torrence on 11/1/17.
 */
public interface Blender {
    List<Double> mix(List<? extends AbstractSampleSource> sampleSources, long sampleRate, double seconds);
}
