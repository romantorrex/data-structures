package com.iamroman.algorithms.datastructures;

import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * A data structure that consist of a set of nodes and connections/relationships between some of
 * them.
 *
 * <p>This is an implementation of a directed graph using and adjacency list.
 */
public final class Graph {
  private final Map<String, List<Node>> adjacencyMap = new HashMap<>();

  /** Adds a new node with the given {@code label} to this graph. */
  public void addNode(String label) {
    adjacencyMap.putIfAbsent(label, new ArrayList<>());
  }

  /**
   * Adds an edge that connects node {@code from} with node {@code to}.
   *
   * @throws IllegalArgumentException if either node from or node to do not exist in this graph.
   */
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

  /** Removes the node that has the given {@code label} from this graph. */
  public void removeNode(String label) {
    if (!adjacencyMap.containsKey(label)) {
      throw new IllegalArgumentException(
          String.format("Node %s does not exist in this graph.", label));
    }

    var node = new Node(label);
    adjacencyMap.values().forEach(targets -> targets.remove(node));
    adjacencyMap.remove(label);
  }

  /**
   * Removes the edge that connects node {@code from} with node {@code to}, from this graph.
   *
   * @throws IllegalArgumentException if either node from or node to do not exist in this graph.
   */
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

  // TODO: Add unit tests for method depthFirstSearch
  /** Implements the depth-first algorithm to traverse this graph. */
  public void depthFirstSearch(String root) {
    if (!adjacencyMap.containsKey(root)) {
      return;
    }

    depthFirstSearch(new Node(root), new HashSet<>());
  }

  /** Implements the breath-first algorithm to traverse this graph. */
  public void breadthFirstSearch(String root) {
    if (!adjacencyMap.containsKey(root)) {
      return;
    }

    Set<Node> visitedNodes = new HashSet<>();
    Queue<Node> queue = new Queue<>();
    queue.enqueue(new Node(root));
    while (queue.size() > 0) {
      Node current = queue.dequeue();
      if (visitedNodes.contains(current)) {
        continue;
      }

      System.out.println(current);
      visitedNodes.add(current);
      adjacencyMap.get(current.label).stream()
          .filter((neighbour) -> !visitedNodes.contains(neighbour))
          .forEach(queue::enqueue);
    }
  }

  private void depthFirstSearch(Node node, Set<Node> visitedNodes) {
    visitedNodes.add(node);
    List<Node> neighbours = adjacencyMap.get(node.label);
    for (Node neighbour : neighbours) {
      if (!visitedNodes.contains(neighbour)) {
        depthFirstSearch(neighbour, visitedNodes);
      }
    }
  }

  private static class Node {
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
      if (o == null || !(o instanceof Node)) return false;
      Node node = (Node) o;
      return Objects.equals(label, node.label);
    }

    @Override
    public int hashCode() {
      return Objects.hash(label);
    }
  }
}
