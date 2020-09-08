package com.iamroman.algorithms.datastructures;

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

    return node;
  }

  private class Node {
    private Node leftChild;
    private Node rightChild;
    private Integer value;

    Node(Integer value) {
      this.value = value;
    }
  }
}
