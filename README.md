# Additive Synthesis of percussion

Experimental tool to use additive synthesis to create audio sample files of percussion noises.
The long term goal is to implement this as serverless REST endpoint that can be invoked from a static front end.

#### Terminology
* `Oscillator` A simple oscillator with no envelope functionality.
* `Model` A class for creating oscillators whose output is to be added with a Mixer.
* `Mixer` Creates sampled data for processing.
* `Processor` A class for processing sample data to produce a volume envelop, normalize the sample data, etc.
