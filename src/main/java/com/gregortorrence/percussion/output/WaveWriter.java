package com.gregortorrence.percussion.output;

import com.musicg.wave.Wave;
import com.musicg.wave.WaveFileManager;
import com.musicg.wave.WaveHeader;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Converts floating point sample data into a wave file.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class WaveWriter {

    public void write(File file, List<Double> values) throws IOException {
        WaveHeader header = new WaveHeader();
        header.setSampleRate(44100);
        header.setSubChunk1Size(16);
        header.setSubChunk2Size(values.size() * 2);

        Wave wave = new Wave(header, toBytes(values));

        WaveFileManager waveFileManager = new WaveFileManager(wave);
        waveFileManager.saveWaveAsFile(file.getAbsolutePath());
    }

    private byte[] toBytes(List<Double> samples) {
        byte[] data = new byte[2 * samples.size()];
        for (int i = 0; i < samples.size(); i++) {
            double sample = samples.get(i);
            if (sample > 1.0 || sample < -1.0) {
                throw new IllegalArgumentException("Supplied samples are not normalized");
            }
            int temp = (short) (sample * 32767);
            data[2*i    ] = (byte) temp;
            data[2*i + 1] = (byte) (temp >> 8);
        }
        return data;
    }

}
