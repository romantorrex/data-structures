package com.iamroman.algorithms.datastructures;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
  private BinaryTree tree;

  // creates a tree that is used to test traversal methods
  @Before
  public void setUp() {
    tree = new BinaryTree();

    tree.insert(3);
    tree.insert(10);
    tree.insert(6);
    tree.insert(1);
    tree.insert(25);
    tree.insert(12);
    tree.insert(13);
    tree.insert(2);
    tree.insert(0);
  }

  @Test
  public void insert() {
    tree = new BinaryTree();

    tree.insert(10);
    tree.insert(5);
    tree.insert(13);

    assertThat(tree.search(5)).isTrue();
  }

  @Test
  public void search_whenTreeIsEmpty_returnsFalse() {
    tree = new BinaryTree();

    assertThat(tree.search(1)).isFalse();
  }

  @Test
  public void inOrderTraversal() {
    assertThat(tree.inOrderTraversal()).containsExactly(0, 1, 2, 3, 6, 10, 12, 13, 25);
  }

  @Test
  public void preOrderTraversal() {
    assertThat(tree.preOrderTraversal()).containsExactly(3, 1, 0, 2, 10, 6, 25, 12, 13);
  }

  @Test
  public void postOrderTraversal() {
    assertThat(tree.postOrderTraversal()).containsExactly(0, 2, 1, 6, 13, 12, 25, 10, 3);
  }

  @Test
  public void height() {
    assertThat(tree.height()).isEqualTo(4);
  }

  @Test
  public void min_success() {
    assertThat(tree.min()).isEqualTo(0);
  }

  @Test
  public void min_whenTreeIsEmpty_throwsException() {
    BinaryTree tree = new BinaryTree();

    Throwable throwable = catchThrowable(() -> tree.min());

    assertThat(throwable).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void min_whenTreeHasASingleNode_success() {
    BinaryTree tree = new BinaryTree();
    tree.insert(20);

    assertThat(tree.min()).isEqualTo(20);
  }

  @Test
  public void equals_withNull_returnsFalse() {
    assertThat(tree.equals(null)).isFalse();
  }

  @Test
  public void equals_whenBothTreesAreEqual_returnsTrue() {
    BinaryTree first = new BinaryTree();
    first.insert(100);
    first.insert(150);
    first.insert(30);
    BinaryTree second = new BinaryTree();
    second.insert(100);
    second.insert(150);
    second.insert(30);

    System.out.println(first);
    System.out.println(second);

    assertThat(first.equals(second)).isTrue();
  }

  @Test
  public void equals_whenBothTreesAreDifferent_returnsFalse() {
    BinaryTree other = new BinaryTree();
    other.insert(100);
    other.insert(150);
    other.insert(30);

    assertThat(tree.equals(other)).isFalse();
  }

  // TODO: Add negative test for isBinarySearchTree()
  @Test
  public void isBinarySearchTree_success() {
    assertThat(BinaryTree.isBinarySearchTree(tree)).isTrue();
  }

  @Test
  public void getNodesAtDistance_success() {
    assertThat(tree.getNodesAtDistance(10)).isEmpty();
    assertThat(tree.getNodesAtDistance(2)).hasSameElementsAs(asList(0, 2, 6, 25));
    assertThat(tree.getNodesAtDistance(4)).hasSameElementsAs(asList(13));
  }
}
