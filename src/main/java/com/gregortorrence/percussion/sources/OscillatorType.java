package com.gregortorrence.percussion.sources;

/**
 * Created by Gregor Torrence on 11/11/17.
 */
public enum OscillatorType {
    SINE,
    SQUARE,
    TRIANGLE,
    SAWTOOTH;

    public static AbstractOscillator createOscillator(OscillatorType oscillatorType, long sampleRate, double hertz, double amplitude) {
        switch (oscillatorType) {
            case SINE:
                return new SineOscillator(sampleRate, hertz, amplitude);
            case SQUARE:
                return new SquareOscillator(sampleRate, hertz, amplitude);
            case SAWTOOTH:
                return new SawtoothOscillator(sampleRate, hertz, amplitude);
            case TRIANGLE:
                return new TriangleOscillator(sampleRate, hertz, amplitude);
            default:
                throw new IllegalStateException("Unhandled OscillatorType " + oscillatorType);
        }
    }
}
