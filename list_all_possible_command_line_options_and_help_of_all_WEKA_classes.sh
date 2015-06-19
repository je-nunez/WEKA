#!/usr/bin/env bash

# Supposing that the "weka.jar" file is in the current directory

export CLASSPATH="$CLASSPATH:weka.jar"
unset DISPLAY
for weka_java_class in $( jar -tf weka.jar | grep  '\.class$'   | sed '/\$/d;  s/\.class$//; s#/#.#g'  )
do 
      echo "Listing help of all possible command-line options of WEKA class: $weka_java_class" 
      java  "$weka_java_class"  -h  </dev/null
done


