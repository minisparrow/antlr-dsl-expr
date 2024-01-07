package graph;

import org.antlr.v4.runtime.misc.*; 
import java.util.Set;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import java.lang.Runtime;
import java.lang.Process; 
import java.lang.StringBuilder;

public class Graph {
  public Set<String> nodes = new OrderedHashSet<String>();  // list of functions
  MultiMap<String, String> edges = new MultiMap<String, String>();

  public void edge(String src, String target) {
    edges.map(src, target);
  }

  public String toDot() {
    StringBuilder buf = new StringBuilder();

    buf.append("digraph G{\n");
    for (String node: nodes) {
      buf.append(node);
      buf.append(';');
    }

    buf.append('\n');


    for(String src: edges.keySet()) {
      for (String target: edges.get(src)) {
        buf.append(" ");
        buf.append(src);
        buf.append("->");
        buf.append(target);
        buf.append(";\n");
      }
    }

    buf.append("}\n");
    return buf.toString();
  }

  public void drawDot(String dotString) {
    String dotFile = "tmp.dot";

    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(dotFile));
        writer.write(dotString);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    try {
        String[] command = {"dot", "tmp.dot", "-Tpng", "-o",  "tmp.png"};
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();
        
        // Wait for command execute finished
        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Execute Success");
        } else {
            System.out.println("Exucute Failed");
        }
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }

  }
}

