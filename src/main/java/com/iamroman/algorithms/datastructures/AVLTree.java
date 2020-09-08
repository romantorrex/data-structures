package com.iamroman.algorithms.datastructures;

import static java.lang.Math.max;

public class AVLTree {
  private Node root;

  public void insert(Integer value) {
    root = insert(root, value);
  }

  private Node insert(Node node, Integer value) {
    if (node == null) {
      return new Node(value);
    }

    if (value < node.value) {
      node.leftChild = insert(node.leftChild, value);
    } else {
      node.rightChild = insert(node.rightChild, value);
    }

    node.height = 1 + max(heightOf(node.leftChild), heightOf(node.rightChild));

    return node;
  }

  private static int heightOf(Node node) {
    return (node == null) ? -1 : node.height;
  }

  private class Node {
    private Node leftChild;
    private Node rightChild;
    private Integer value;
    private int height;

    Node(Integer value) {
      this.value = value;
    }
  }
}
