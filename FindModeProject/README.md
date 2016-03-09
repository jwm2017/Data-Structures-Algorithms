# Introduction

For this assignment, I implemented three approaches to finding a mode and its frequency in an array of integer values. All Approach classes inherit from the BaseApproach class which has one abstract method CalculateMode(), and the fields Mode, FreqOfMode, and List. Also included is a slightly modified MergeSort implementation that handles array inputs (as Java's Collections.sort() method only works with ArrayLists). The TestCases class holds the main method for the project.

# Setup

Because Java's package system is pretty painful, I wrote a simple shell script to take care of compiling and creating package dependencies. To run the script properly, make sure you are in the parent directory .../FindModeProject/ then type "./compileAndRun" into a terminal window. This should create a directory called "approaches" which will hold all the .class files. 

# TL;DR

Go to ../FindModeProject

Then type "./compileAndRun" in a terminal window

A new file "results.txt" should be added; this will contain the results of the main method in TestCases.java
