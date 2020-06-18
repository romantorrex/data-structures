package com.iamroman.algorithms.datastructures;

public class TreeNode<T extends Comparable> {
  TreeNode<T> left;
  TreeNode<T> right;
  T value;

  public TreeNode(T value) {
    this.value = value;
  }
}
