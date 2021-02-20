package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

public class GraphTest {
  private Graph graph = new Graph();

  @Test
  public void addNode() {
    graph.addNode("a");
    graph.addNode("b");
    graph.addNode("c");

    assertThat(graph.nodesAsString()).isEqualTo("(a), (b), (c)");
  }

  @Test
  public void addNode_alreadyInTheGraph() {
    graph.addNode("a");
    graph.addNode("a");

    assertThat(graph.nodesAsString()).isEqualTo("(a)");
  }

  @Test
  public void removeNode() {
    graph.addNode("a");
    graph.addNode("b");
    graph.addNode("c");

    graph.removeNode("b");

    assertThat(graph.nodesAsString()).isEqualTo("(a), (c)");
  }

  @Test
  public void removeNode_whenLabelDoesNotExist_throwsException() {
    Throwable throwable = catchThrowable(() -> graph.removeNode("c"));

    assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    assertThat(throwable).hasMessage("Node c does not exist in this graph.");
  }

  @Test
  public void addEdge() {
    graph.addNode("a");
    graph.addNode("b");
    graph.addNode("c");

    graph.addEdge("a", "b");
    graph.addEdge("a", "c");
    graph.addEdge("b", "c");

    assertThat(graph.edgesAsString()).isEqualTo("(a) -> [(b), (c)], (b) -> [(c)], (c) -> []");
  }

  @Test
  public void removeEdge() {
    graph.addNode("a");
    graph.addNode("b");
    graph.addNode("c");
    graph.addEdge("a", "b");
    graph.addEdge("a", "c");
    graph.addEdge("b", "c");

    graph.removeEdge("a", "b");

    assertThat(graph.edgesAsString()).isEqualTo("(a) -> [(c)], (b) -> [(c)], (c) -> []");
  }
}
