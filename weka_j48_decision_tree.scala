#!/usr/bin/env scala

// import the WEKA J48 decision tree into Scala

import _root_.weka.classifiers.trees.J48

// create a WEKA J48 decision tree in Scala

var j48_decision_tree: J48 = new J48();

// get its options
// http://weka.sourceforge.net/doc.dev/weka/classifiers/trees/J48.html

val list_options_j48 =  j48_decision_tree.listOptions();


while (list_options_j48.hasMoreElements)
{
    val j48_option = list_options_j48.nextElement.asInstanceOf[weka.core.Option]
    // println(j48_option.name)
    println("\nWEKA J48 Option: '" + j48_option.synopsis + "':")
    println(j48_option.description)
}


