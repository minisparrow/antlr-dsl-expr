#!/bin/bash
antlr4 antlr/CSV.g4
javac antlr/*.java  apps/LoadCSVApp.java

java apps.LoadCSVApp tests/test1
