package com.iamroman.algorithms.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** A directed graph implementation using an adjacency list. */
public class Graph {
  private final Map<String, Set<Node>> adjacencies = new HashMap<>();

  public void addNode(String label) {
    adjacencies.putIfAbsent(label, new HashSet<>());
  }

  public void addEdge(String from, String to) {
    if (adjacencies.containsKey(from)) {
      throw new IllegalArgumentException(
          String.format("Node %s does not exist in this graph.", from));
    }

    if (!adjacencies.containsKey(to)) {
      throw new IllegalArgumentException(String.format("Node %s does not exist in this graph", to));
    }

    adjacencies.get(from).add(new Node(to));
  }

  private class Node {
    private String label;

    Node(String label) {
      this.label = label;
    }
  }
}
