#!/bin/bash
# compile
antlr4 antlr/tinyc.g4
javac antlr/*.java  apps/CallGraph.java

#run
java apps.CallGraph tests/test1.c
