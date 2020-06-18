package com.iamroman.algorithms.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BinaryTreeTest {
  private BinaryTree tree;

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
    tree = new BinaryTree();

    tree.insert(8);
    tree.insert(15);
    tree.insert(3);
    tree.insert(0);

    tree.inOrderTraversal();
  }
}
