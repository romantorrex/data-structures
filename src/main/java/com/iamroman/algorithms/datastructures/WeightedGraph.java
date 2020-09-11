package com.iamroman.algorithms.datastructures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  private class Node {
    private String label;
    private List<Edge> edges;

    public Node(String label) {
      this.label = label;
    }

    public void addEdge(Node to, int weight) {
      edges.add(new Edge(this, to, weight));
    }
  }

  private class Edge {
    private Node from;
    private Node to;
    private int weight;

    public Edge(Node from, Node to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }
}
