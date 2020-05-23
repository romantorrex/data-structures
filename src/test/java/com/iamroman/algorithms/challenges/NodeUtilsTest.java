package com.iamroman.algorithms.challenges;

import static org.assertj.core.api.Assertions.assertThat;

import com.iamroman.algorithms.challenges.LinkedListChallenges.Node;
import org.junit.Test;

public class NodeUtilsTest {

  @Test
  public void countNodes_nullNode_returnsZero() {
    Node node = null;
    assertThat(NodeUtils.countNodes(node)).isEqualTo(0);
  }

  @Test
  public void countNodes_success() {
    Node node = new Node("a");
    node.next = new Node("b");

    assertThat(NodeUtils.countNodes(node)).isEqualTo(2);
  }

  @Test
  public void toListOfNodes_success() {
    String[] array = {"a", "b", "c"};

    Node nodeList = NodeUtils.toListOfNodes(array);

    assertThat(NodeUtils.countNodes(nodeList)).isEqualTo(3);
  }

  @Test
  public void toListOfNodes_emptyArray_returnsNull() {
    String[] array = {};

    Node nodeList = NodeUtils.toListOfNodes(array);
    assertThat(nodeList).isNull();
  }

  @Test
  public void toString_success() {
    Node node = NodeUtils.toListOfNodes(new String[] {"1", "2", "3"});
    assertThat(NodeUtils.toString(node)).isEqualTo("[1, 2, 3]");
  }

  @Test
  public void toString_nullNode_success() {
    Node node = null;
    assertThat(NodeUtils.toString(node)).isEqualTo("[]");
  }
}
