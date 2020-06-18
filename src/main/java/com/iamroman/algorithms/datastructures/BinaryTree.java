package com.iamroman.algorithms.datastructures;

// TODO: Implement method to delete a node.
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

  public void inOrderTraversal() {
    inOrderTraversal(root);
  }

  private void inOrderTraversal(TreeNode<Integer> node) {

    if (node == null) {
      return;
    }

    inOrderTraversal(node.left);
    visitNode(node);
    inOrderTraversal(node.right);
  }

  public void visitNode(TreeNode<Integer> node) {
    System.out.println(node.value);
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
}
