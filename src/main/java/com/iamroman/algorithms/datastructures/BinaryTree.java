package com.iamroman.algorithms.datastructures;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

// TODO: Implement method to delete a node.
// Traversal methods return a list with the node values in the order they were visited
// so they can be unit tested.
public class BinaryTree {
  private TreeNode<Integer> root;

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

  public List<Integer> inOrderTraversal() {
    List<Integer> items = new ArrayList<>();
    inOrderTraversal(root, items);

    return items;
  }

  private void inOrderTraversal(TreeNode<Integer> node, List<Integer> items) {
    if (node == null) {
      return;
    }

    inOrderTraversal(node.left, items);
    items.add(node.value);
    inOrderTraversal(node.right, items);
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

  public List<Integer> preOrderTraversal() {
    List<Integer> visitedItems = new ArrayList<>();
    preOrderTraversal(root, visitedItems);
    return visitedItems;
  }

  private void preOrderTraversal(TreeNode<Integer> node, List<Integer> visitedNodes) {
    if (node == null) {
      return;
    }

    visitedNodes.add(node.value);
    preOrderTraversal(node.left, visitedNodes);
    preOrderTraversal(node.right, visitedNodes);
  }

  public List<Integer> postOrderTraversal() {

    ArrayList<Integer> visitedNodes = new ArrayList<>();
    postOrderTraversal(root, visitedNodes);
    return visitedNodes;
  }

  private void postOrderTraversal(TreeNode<Integer> node, List<Integer> visitedNodes) {
    if (node == null) {
      return;
    }

    postOrderTraversal(node.left, visitedNodes);
    postOrderTraversal(node.right, visitedNodes);
    visitedNodes.add(node.value);
  }

  public int height() {
    return height(root);
  }

  private int height(TreeNode<Integer> node) {
    if (node == null || (node.left == null && node.right == null)) {
      return 0;
    }

    return 1 + max(height(node.left), height(node.right));
  }
}
