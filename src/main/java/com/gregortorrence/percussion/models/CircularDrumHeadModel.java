package com.gregortorrence.percussion.models;

import com.google.common.collect.ImmutableList;
import com.gregortorrence.percussion.oscillators.AbstractOscillator;
import com.gregortorrence.percussion.oscillators.SawtoothOscillator;
import com.gregortorrence.percussion.oscillators.SineOscillator;
import com.gregortorrence.percussion.oscillators.SquareOscillator;
import com.gregortorrence.percussion.oscillators.TriangleOscillator;

import java.util.ArrayList;
import java.util.List;

/**
 * Uses zeros of Bessel functions for the overtone series of a vibrating circular drum head.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class CircularDrumHeadModel extends AbstractAdditiveModel {

    private static final double DIVISOR = 2.40482555769577;

//    private final List<Double> j0  = ImmutableList.of(2.40482555769577, 5.52007811028631, 8.65372791291101, 11.7915344390142, 14.9309177084877);
//    private final List<Double> j1  = ImmutableList.of(3.83170597020751, 7.01558666981561, 10.1734681350627, 13.3236919363142, 16.4706300508776);
//    private final List<Double> j2  = ImmutableList.of(5.13562230184068, 8.41724414039986, 11.6198411721490, 14.7959517823512, 17.9598194949878);
//    private final List<Double> j3  = ImmutableList.of(6.38016189592398, 9.76102312998166, 13.0152007216984, 16.2234661603187, 19.4094152264350);
//    private final List<Double> j4  = ImmutableList.of(7.58834243450380, 11.0647094885011, 14.3725366716175, 17.6159660498048, 20.8269329569623);
//    private final List<Double> j5  = ImmutableList.of(8.77148381595995, 12.3386041974669, 15.7001740797116, 18.9801338751799, 22.2177998965612);
//    private final List<Double> j6  = ImmutableList.of(9.93610952421768, 13.5892901705412, 17.0038196678160, 20.3207892135665, 23.5860844355813);
//    private final List<Double> j7  = ImmutableList.of(11.0863700192450, 14.8212687270131, 18.2875828324817, 21.6415410198484, 24.9349278876730);
//    private final List<Double> j8  = ImmutableList.of(12.2250922640046, 16.0377741908877, 19.5545364309970, 22.9451731318746, 26.2668146411766);
//    private final List<Double> j9  = ImmutableList.of(13.3543004774353, 17.2412203824891, 20.8070477892641, 24.2338852577505, 27.5837489635730);
//    private final List<Double> j10 = ImmutableList.of(14.4755006865545, 18.4334636669665, 22.0469853646978, 25.5094505541828, 28.8873750635304);
//
//    private final List<List<Double>> roots = ImmutableList.of(j0, j1, j2, j3, j4, j5, j6, j7, j8, j9, j10);

    private final List<Double> m0 = ImmutableList.of(2.40482555769577, 3.83170597020751, 5.13562230184068, 6.38016189592398, 7.58834243450380, 8.77148381595995, 9.93610952421768, 11.0863700192450, 12.2250922640046, 13.3543004774353, 14.4755006865545);
    private final List<Double> m1 = ImmutableList.of(5.52007811028631, 7.01558666981561, 8.41724414039986, 9.76102312998166, 11.0647094885011, 12.3386041974669, 13.5892901705412, 14.8212687270131, 16.0377741908877, 17.2412203824891, 18.4334636669665);
    private final List<Double> m2 = ImmutableList.of(8.65372791291101, 10.1734681350627, 11.6198411721490, 13.0152007216984, 14.3725366716175, 15.7001740797116, 17.0038196678160, 18.2875828324817, 19.5545364309970, 20.8070477892641, 22.0469853646978);
    private final List<Double> m3 = ImmutableList.of(11.7915344390142, 13.3236919363142, 14.7959517823512, 16.2234661603187, 17.6159660498048, 18.9801338751799, 20.3207892135665, 21.6415410198484, 22.9451731318746, 24.2338852577505, 25.5094505541828);
    private final List<Double> m4 = ImmutableList.of(14.9309177084877, 16.4706300508776, 17.9598194949878, 19.4094152264350, 20.8269329569623, 22.2177998965612, 23.5860844355813, 24.9349278876730, 26.2668146411766, 27.5837489635730, 28.8873750635304);

    private final List<List<Double>> roots = ImmutableList.of(m0, m1, m2, m3, m4);

    @Override
    public List<? extends AbstractOscillator> getOscillators(final int sampleRate, final int hertz) {
        List<AbstractOscillator> oscillators = new ArrayList<>();
        for (int m = 0; m<roots.size(); m++) {
            for (int j=0; j<roots.get(m).size(); j++) {
                double harmonic = roots.get(m).get(j) / DIVISOR;
                oscillators.add(createOscillator(sampleRate, hertz, m, j, harmonic));
            }
        }

        return oscillators;
    }

    private AbstractOscillator createOscillator(int sampleRate, double hertz, int m, int j, double harmonic) {
        switch (getOscillatorType()) {
            case SINE:
                return new SineOscillator(sampleRate, hertz * harmonic, 1.0 / (harmonic * harmonic * (m+1) * (j+1)));
            case SQUARE:
                return new SquareOscillator(sampleRate, hertz * harmonic, 1.0 / (harmonic * harmonic * (m+1) * (j+1)));
            case SAWTOOTH:
                return new SawtoothOscillator(sampleRate, hertz * harmonic, 1.0 / (harmonic * harmonic * (m+1) * (j+1)));
            case TRIANGLE:
                return new TriangleOscillator(sampleRate, hertz * harmonic, 1.0 / (harmonic * harmonic * (m+1) * (j+1)));
            default:
                throw new IllegalStateException("Unhandled OscillatorType " + getOscillatorType());
        }
    }

}
