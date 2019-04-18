# Additive Synthesis of percussion

Experimental tool to use additive synthesis to create audio sample files of percussion noises.

The long term goal is to implement this as a serverless REST endpoint that can be invoked from a static front end.
At that point, this becomes a tool for generating percussion samples for importing into any sampler software or hardware.

Currently, there is no UI or service endpoint. There are only [Spock](http://spockframework.org/) integration tests that 
writes some example WAV files from hard-coded parameters. 

#### Terminology
* `SampleSource` Any source of sample-able audio data.
* `NoiseSource` A sample source of noise. White and bounded frequency versions are implemented.
* `Oscillator` A sample source that is simple oscillator with no envelope functionality. Sine, Square, Triangle, and Sawtooth are implemented. These are the possible components of additive synthesis.
* `Model` A class for creating a List of oscillators whose output is to be summed with a Mixer. Round and square drum heads are implemented.
* `Blender` Creates sampled data from a List of sample sources. This is primarily the additive part of additive synthesis. A Mixer combines samples by addition, and a RingModulator combines by multiplication.
* `Processor` A class for processing sample data. The order in which these are applied is largely arbitrary. Volume Envelope, Normalizer, Distortion, and Debug output processors are implemented.

#### Typical data flow
* A Model is created and used to generate a List of Oscillators
* A Mixer is used to combine oscillator output into a List of floating point samples
* An Envelope is used to make the amplitude of the samples start at full volume and trail off to silence at the very end.
* A normalizer is used to scale the sample values to be bounded within a range of -1.0 to 1.0.
* A WaveWriter is used to convert the floating point values into integers and write them to a WAV file.

#### Build and run
* Java JDK 11 must be available at the command line.
* Build and run test tests with `./gradlew clean build test`

(See the package `com.gregortorrence.percussion.examples` for implemented examples.)
