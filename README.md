# foggy

A Clojure library designed to calculate the Gunning-Fog index of a
short block of text. It attempts to keep the main functions
composable and free of dependencies on one another. However,
a basic-fog-score function is provided that utilizes default
helper functions.

## Usage

(basic-fog-score block-of-text)

NOTE: The default syllable parsing function is very rough
and will miscalculate for certain English words that don't
conform to the basic pattern of vowel groupings

## License

Copyright © 2013 Justin Overfelt

Distributed under the Eclipse Public License, the same as Clojure.
