package com.iamroman.algorithms.datastructures;

import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/** A directed graph implementation using an adjacency list. */
public class Graph {
  private final Map<String, List<Node>> adjacencyMap = new HashMap<>();

  public void addNode(String label) {
    adjacencyMap.putIfAbsent(label, new ArrayList<>());
  }

  public void addEdge(String from, String to) {
    if (!adjacencyMap.containsKey(from)) {
      throw new IllegalArgumentException(
          String.format("Node %s does not exist in this graph.", from));
    }

    if (!adjacencyMap.containsKey(to)) {
      throw new IllegalArgumentException(
          String.format("Node %s does not exist in this graph.", to));
    }

    adjacencyMap.get(from).add(new Node(to));
  }

  public void removeNode(String label) {
    if (!adjacencyMap.containsKey(label)) {
      throw new IllegalArgumentException(
          String.format("Node %s does not exist in this graph.", label));
    }

    var node = new Node(label);
    adjacencyMap.values().forEach(targets -> targets.remove(node));
    adjacencyMap.remove(label);
  }

  public void removeEdge(String from, String to) {
    if (!adjacencyMap.containsKey(from)) {
      throw new IllegalArgumentException(
          String.format("Node %s does not exist in this graph.", from));
    }
    if (!adjacencyMap.containsKey(to)) {
      throw new IllegalArgumentException(
          String.format("Node %s does not exist in this graph.", to));
    }

    var node = new Node(to);
    adjacencyMap.get(from).remove(node);
  }

  public String nodesAsString() {
    return adjacencyMap.keySet().stream()
        .map(nodeLabel -> String.format("(%s)", nodeLabel))
        .collect(Collectors.joining(", "));
  }

  public String edgesAsString() {
    return adjacencyMap.entrySet().stream()
        .map(entry -> String.format("(%s) -> %s", entry.getKey(), entry.getValue()))
        .collect(Collectors.joining(", "));
  }

  private class Node {
    private String label;

    Node(String label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return String.format("(%s)", label);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Node node = (Node) o;
      return Objects.equals(label, node.label);
    }

    @Override
    public int hashCode() {
      return Objects.hash(label);
    }
  }
}
