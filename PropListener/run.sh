#!/bin/bash
antlr4 antlr/Properties.g4
javac antlr/*.java  apps/TestListener.java

java apps.TestListener tests/test1
