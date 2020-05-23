package com.iamroman.algorithms.challenges;

import static org.assertj.core.api.Assertions.assertThat;

import com.iamroman.algorithms.challenges.LinkedListChallenges.Node;
import org.junit.Test;

public class LinkedListChallengesTest {

  @Test
  public void deleteDuplicates_success() {
    Node<String> nodeList = NodeUtils.toListOfNodes(new String[] {"a", "b", "c", "b", "d", "a"});

    LinkedListChallenges.deleteDuplicates(nodeList);

    assertThat(NodeUtils.countNodes(nodeList)).isEqualTo(4);
    assertThat(NodeUtils.toString(nodeList)).isEqualTo("[a, b, c, d]");
  }
}
