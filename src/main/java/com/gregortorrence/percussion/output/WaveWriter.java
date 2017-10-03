package com.gregortorrence.percussion.output;

import com.sun.media.sound.WaveFileWriter;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Converts floating point sample data into a wave file.
 *
 * Created by Gregor Torrence on 9/27/17.
 */
public class WaveWriter {

    public void write(File file, List<Double> values) throws IOException {
        WaveFileWriter waveFileWriter = new WaveFileWriter();
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            waveFileWriter.write(toAudioInputStream(values), AudioFileFormat.Type.WAVE, outputStream);
        }
    }

    private AudioInputStream toAudioInputStream(List<Double> samples) {
        byte[] data = new byte[2 * samples.size()];
        for (int i = 0; i < samples.size(); i++) {
            int temp = (short) (samples.get(i) * 32767);
            data[2*i    ] = (byte) temp;
            data[2*i + 1] = (byte) (temp >> 8);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        AudioFormat format = new AudioFormat(44100, 16, 1, true, false);
        return new AudioInputStream(byteArrayInputStream, format, samples.size());
    }
}
