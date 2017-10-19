# Additive Synthesis of percussion

Experimental tool to use additive synthesis to create audio sample files of percussion noises.
The long term goal is to implement this as a serverless REST endpoint that can be invoked from a static front end.
At this point, there is no UI or service endpoint. There is only one [Spock](http://spockframework.org/) test that 
writes some example WAV files from hard-coded parameters. 

#### Terminology
* `Oscillator` A simple oscillator with no envelope functionality.
* `Model` A class for creating oscillators whose output is to be added with a Mixer.
* `Mixer` Creates sampled data for processing.
* `Processor` A class for processing sample data to produce a volume envelop, normalize the sample data, etc.

#### Typical data flow
* A Model is created and used to generate a List of Oscillators
* A Mixer is used to combine oscillator output into a List of floating point samples
* An Envelope is used to make the amplitude of the samples start at full volume and trail off to silence at the very end.
* A normalizer is used to scale the sample values to be bounded within a range of -1.0 to 1.0.
* A WaveWriter is used to convert the floating point values into integers and write them to a WAV file.
