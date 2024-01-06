#!/bin/bash
antlr4 -visitor antlr/Properties.g4
javac antlr/*.java  apps/TestVisitor.java

java apps.TestVisitor tests/test1
