#!/bin/bash
# Written by: Joe McAdams

# Compile each file, building out packages
javac -d . BaseApproach.java 
javac -d . BruteForce.java  
javac -d . MyApproach.java
javac -d . MergeSort.java 
javac -d . TransformNConquer.java
javac -d . TestCases.java

# Run the main method, piping the results to a local .txt file
java approaches.TestCases > results.txt
