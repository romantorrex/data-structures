package com.iamroman.algorithms.challenges.ctci;

import static org.assertj.core.api.Assertions.assertThat;

import com.iamroman.algorithms.challenges.ctci.LinkedListChallenges;
import com.iamroman.algorithms.challenges.ctci.LinkedListChallenges.Node;
import com.iamroman.algorithms.challenges.ctci.NodeUtils;
import org.junit.Test;

public class LinkedListChallengesTest {

  @Test
  public void deleteDuplicates_success() {
    Node<String> nodeList = NodeUtils.toListOfNodes(new String[] {"a", "b", "c", "b", "d", "a"});

    LinkedListChallenges.deleteDuplicates(nodeList);

    assertThat(NodeUtils.countNodes(nodeList)).isEqualTo(4);
    assertThat(NodeUtils.toString(nodeList)).isEqualTo("[a, b, c, d]");
  }

  @Test
  public void sumLists_success() {
    Node<Integer> listA = NodeUtils.toListOfNodes(new Integer[] {2, 8, 3}); // 382 (2 -> 8 -> 3)
    Node<Integer> listB = NodeUtils.toListOfNodes(new Integer[] {9, 4, 5}); // 549 (0 -> 4 -> 5)

    Node<Integer> listC = LinkedListChallenges.sumLists(listA, listB);

    assertThat(NodeUtils.toString(listC)).isEqualTo("[1, 3, 9]"); // 931 ( 1 -> 3 -> 9)
  }
}
