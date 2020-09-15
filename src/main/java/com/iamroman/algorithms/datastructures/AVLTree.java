package com.iamroman.algorithms.datastructures;

import static java.lang.Math.max;

// TODO: Add unit tests
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

    setHeight(node);

    return balance(node);
  }

  private static void setHeight(Node node) {
    node.height = 1 + max(heightOf(node.leftChild), heightOf(node.rightChild));
  }

  private Node balance(Node node) {
    if (isLeftHeavy(node)) {
      if (balanceFactor(node.leftChild) < 0) {
        node.leftChild = rotateLeft(node.leftChild);
      }

      return rotateRight(node);
    } else if (isRightHeavy(node)) {
      if (balanceFactor(node.rightChild) > 0) {
        node.rightChild = rotateRight(node.rightChild);
      }

      return rotateLeft(node);
    }

    return node;
  }

  private boolean isRightHeavy(Node node) {
    return balanceFactor(node) < 0;
  }

  private boolean isLeftHeavy(Node node) {
    return balanceFactor(node) > 0;
  }

  private Node rotateRight(Node root) {
    Node newRoot = root.leftChild;
    root.leftChild = newRoot.rightChild;
    newRoot.rightChild = root;
    setHeight(newRoot);
    setHeight(root);

    return newRoot;
  }

  private Node rotateLeft(Node root) {
    Node newRoot = root.rightChild;
    root.rightChild = newRoot.leftChild;
    newRoot.leftChild = root;
    setHeight(newRoot);
    setHeight(root);

    return newRoot;
  }

  private static int balanceFactor(Node node) {
    return (node == null) ? 0 : heightOf(node.leftChild) - heightOf(node.rightChild);
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
