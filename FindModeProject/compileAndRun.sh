#!/bin/bash
# Written by: Joe McAdams

echo "Creating package dependencies..."

# Compile each file, building out packages
javac -d . BaseApproach.java 
javac -d . BruteForce.java  
javac -d . MyApproach.java
javac -d . MergeSort.java 
javac -d . TransformNConquer.java
javac -d . TestCases.java

echo "Running TestCases.java, writing results to results.txt..."

# Run the main method, piping the results to a local file
java approaches.TestCases > results.txt

echo "Completed."
