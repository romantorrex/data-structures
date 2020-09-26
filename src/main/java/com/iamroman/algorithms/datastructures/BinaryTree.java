package com.iamroman.algorithms.datastructures;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.List;

// TODO: Implement method to delete a node.
// Traversal methods return a list with the node values in the order they were visited
// so they can be unit tested.
public class BinaryTree {
  private TreeNode<Integer> root;

  public static boolean isBinarySearchTree(BinaryTree tree) {

    return isBinarySearchTree(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean isBinarySearchTree(TreeNode<Integer> root, int min, int max) {

    if (root == null) return true;

    if (root.value < min || root.value > max) return false;

    return isBinarySearchTree(root.left, min, root.value - 1)
        && isBinarySearchTree(root.right, root.value + 1, max);
  }

  public void insert(Integer value) {
    root = insert(root, value);
  }

  // TODO: Implement this method recursively.
  public boolean search(Integer value) {
    TreeNode<Integer> current = root;

    while (current != null) {
      if (current.value.equals(value)) {
        return true;
      }

      current = value < current.value ? current.left : current.right;
    }

    return false;
  }

  private boolean isEmpty() {
    return root == null;
  }

  public List<Integer> inOrderTraversal() {
    List<Integer> items = new ArrayList<>();
    inOrderTraversal(root, items);

    return items;
  }

  public List<Integer> preOrderTraversal() {
    List<Integer> visitedItems = new ArrayList<>();
    preOrderTraversal(root, visitedItems);
    return visitedItems;
  }

  public List<Integer> postOrderTraversal() {

    ArrayList<Integer> visitedNodes = new ArrayList<>();
    postOrderTraversal(root, visitedNodes);
    return visitedNodes;
  }

  public int height() {
    return height(root);
  }

  public int min() {
    if (isEmpty()) {
      throw new IllegalStateException("The three does not have any nodes");
    }

    return min(root);
  }

  public boolean equals(BinaryTree other) {
    if (other == null) {
      return false;
    }

    return equals(root, other.root);
  }

  public List<Integer> getNodesAtDistance(int distance) {
    List<Integer> nodes = new ArrayList<>();
    getNodesAtDistance(root, distance, nodes);
    return nodes;
  }

  private TreeNode<Integer> insert(TreeNode<Integer> node, Integer value) {
    if (node == null) {
      return new TreeNode<Integer>(value);
    }

    if (value < node.value) {
      node.left = insert(node.left, value);
    } else if (value > node.value) {
      node.right = insert(node.right, value);
    }

    return node;
  }

  private void inOrderTraversal(TreeNode<Integer> node, List<Integer> items) {
    if (node == null) {
      return;
    }

    inOrderTraversal(node.left, items);
    items.add(node.value);
    inOrderTraversal(node.right, items);
  }

  private void preOrderTraversal(TreeNode<Integer> node, List<Integer> visitedNodes) {
    if (node == null) {
      return;
    }

    visitedNodes.add(node.value);
    preOrderTraversal(node.left, visitedNodes);
    preOrderTraversal(node.right, visitedNodes);
  }

  private void postOrderTraversal(TreeNode<Integer> node, List<Integer> visitedNodes) {
    if (node == null) {
      return;
    }

    postOrderTraversal(node.left, visitedNodes);
    postOrderTraversal(node.right, visitedNodes);
    visitedNodes.add(node.value);
  }

  private int height(TreeNode<Integer> node) {
    if (node == null || (node.left == null && node.right == null)) {
      return 0;
    }

    return 1 + max(height(node.left), height(node.right));
  }

  private static int min(TreeNode<Integer> node) {
    if (node.left == null) {
      return node.value;
    }

    return min(node.left);
  }

  private static boolean equals(TreeNode<Integer> first, TreeNode<Integer> second) {
    if (first == null && second == null) {
      return true;
    }

    if (first == null || second == null) {
      return false;
    }

    return first.value.equals(second.value)
        && equals(first.left, second.left)
        && equals(first.right, second.right);
  }

  private static void getNodesAtDistance(
      TreeNode<Integer> root, int distance, List<Integer> nodes) {
    if (root == null) return;

    if (distance == 0) {
      nodes.add(root.value);
    }

    getNodesAtDistance(root.left, distance - 1, nodes);
    getNodesAtDistance(root.right, distance - 1, nodes);
  }
}
