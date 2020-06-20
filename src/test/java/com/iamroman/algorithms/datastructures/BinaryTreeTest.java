package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

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
}
