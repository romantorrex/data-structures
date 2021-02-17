package com.iamroman.algorithms.datastructures;

import java.util.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

/** Undirected graph with weights in its edges */
public class WeightedGraph {
  private Map<String, Node> nodes = new HashMap<>();

  public void addNode(String label) {
    nodes.putIfAbsent(label, new Node(label));
  }

  public void addEdge(String from, String to, int weight) {
    var fromNode = nodes.get(from);
    if (fromNode == null) {
      throw new IllegalStateException(String.format("Node %s does not exist.", from));
    }

    var toNode = nodes.get(to);
    if (toNode == null) {
      throw new IllegalStateException(String.format("Node %s does not exist", to));
    }

    fromNode.addEdge(toNode, weight);
    toNode.addEdge(fromNode, weight);
  }

  // TODO: Add unit tests
  public int shortestDistance(String from, String to) {
    Node fromNode = nodes.get(from);
    HashMap<String, Integer> distances = new HashMap<>();
    HashSet<Node> visited = new HashSet<>();
    PriorityQueue<NodeEntry> queue =
        new PriorityQueue<>(Comparator.comparingInt(entry -> entry.priority));

    for (Node node : nodes.values()) {
      distances.put(node.label, Integer.MAX_VALUE);
    }
    distances.replace(from, 0);

    queue.add(new NodeEntry(fromNode, 0));
    while (!queue.isEmpty()) {
      Node currentNode = queue.remove().node;

      for (Edge edge : currentNode.edges) {
        if (visited.contains(edge.to)) {
          continue;
        }

        int newDistance = distances.get(currentNode.label) + edge.weight;
        if (newDistance < distances.get(edge.to.label)) {
          distances.replace(edge.to.label, newDistance);
          queue.add(new NodeEntry(edge.to, newDistance));
        }
      }
    }
    return distances.get(to);
  }

  private static class Node {
    private String label;
    private List<Edge> edges = new ArrayList<>();

    public Node(String label) {
      this.label = label;
    }

    public void addEdge(Node to, int weight) {
      edges.add(new Edge(this, to, weight));
    }
  }

  @SuppressWarnings("unused") // TODO: Solve error prone error.
  private static class Edge {
    private Node from;
    private Node to;
    private int weight;

    public Edge(Node from, Node to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }

  private static class NodeEntry {
    private Node node;
    private int priority;

    public NodeEntry(Node node, int priority) {
      this.node = node;
      this.priority = priority;
    }
  }
}
