package com.iamroman.algorithms.challenges;

import com.iamroman.algorithms.challenges.LinkedListChallenges.Node;

/** Utility methods that are used mostly to test the solutions to LinkedList challenges */
public abstract class NodeUtils {
  public static int countNodes(Node<?> first) {
    int count = 0;
    var current = first;
    while (current != null) {
      count++;
      current = current.next;
    }

    return count;
  }

  public static Node<String> toListOfNodes(String[] array) {
    Node<String> first = new Node<>("first");

    Node<String> current = first;
    for (String data : array) {
      current.next = new Node<>(data);
      current = current.next;
    }
    return first.next;
  }

  public static Node<Integer> toListOfNodes(Integer[] array) {
    Node<Integer> first = new Node<>(0);

    Node<Integer> current = first;
    for (Integer data : array) {
      current.next = new Node<>(data);
      current = current.next;
    }
    return first.next;
  }

  public static String toString(Node<?> first) {
    StringBuilder builder = new StringBuilder("[");

    Node current = first;
    while (current != null) {
      builder.append(current.data);
      if (current.next != null) {
        builder.append(", ");
      }
      current = current.next;
    }
    return builder.append("]").toString();
  }
}
