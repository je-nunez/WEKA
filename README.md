# WEKA

WEKA ((c) The University of Waikato, Hamilton, New Zealand) is available at this URL:

     http://www.cs.waikato.ac.nz/ml/weka/

WEKA can interact with Big Data, e.g., send map-and-reduce jobs to Hadoop to train or test a classifier or a regressor in WEKA:

     http://www.cs.waikato.ac.nz/ml/weka/bigdata.html
     http://markahall.blogspot.co.nz/2013/10/weka-and-hadoop-part-1.html

A book about WEKA is available from the authors of this system:

     Data Mining: Practical Machine Learning Tools and Techniques

# Description of this script

It is possible to call several WEKA classes not from its graphical interface, but to call them in batch (either in the command-line or controlled by another program). E.g., to call the decision tree `J48` (similar to Ross Quinlan's `C4.5` decision tree) with a `confidence level` of 0.5 (if the enthropy of our input data allowed this confidence level):

     set CLASSPATH=%CLASSPATH%;C:\WEKA\weka.jar
     java weka.filters.unsupervised.attribute.Remove -i source_file.arff  -R 2,5,6 > temp_file.arff
     java weka.classifiers.trees.J48 -t temp_file.arff  -c 4 -C 0.5 > resulting_report.txt
     del temp_file.arff

(it is possible also to call WEKA through `popen()` or other calls), but in all cases it is necessary to know what are the available WEKA classes to be called from the command-line and their options.

The current script is for knowing all the classes that WEKA offers and the command-line options and arguments to call each of them. The script in this repository is designed for Linux/Mac OS-X/Unix.

WEKA currently has over one thousand public classes (and more than that quantity in nested classes). Some classes are graphical for which there are not command-line help, like:

     weka.gui.arffviewer.ArffViewer  (the ARFF file viewer)
     weka.classifiers.bayes.net.GUI  (Bayesian net classifier)
     weka.clusterers.forOPTICSAndDBScan.OPTICS_GUI.OPTICS_Visualizer
     weka.gui.boundaryvisualizer.BoundaryVisualizer
     weka.gui.DatabaseConnectionDialog
     weka.experiment.PairedCorrectedTTester (setup, run, and analyze experiments)
     weka.gui.experiment.DistributeExperimentPanel (distribute experiments across several hosts)
     weka.gui.beans.KnowledgeFlow  (the main WEKA interface -> Knowledge Flow)
     weka.gui.explorer.Explorer (the WEKA Explorer)
     weka.gui.GUIChooser (the main WEKA interface, like to the Explorer)
     weka.gui.SimpleCLI (the WEKA command-line interface)

Some classes take other subclasses (are a batch pipeline):

     weka.clusterers.ClusterEvaluation

A few classes naturally need to load slowler because all the drivers they need, like:

     weka.core.converters.DatabaseLoader

# Other

WEKA can also be used naturally as a library from Java, avoiding to fork an external process. E.g., this is the documentation for the `J48` decision tree invoked above:

     http://weka.sourceforge.net/doc.dev/weka/classifiers/trees/J48.html

There is a simple example in this repository of a WEKA J48 decision tree in Scala (file `weka_j48_decision_tree.scala`).

