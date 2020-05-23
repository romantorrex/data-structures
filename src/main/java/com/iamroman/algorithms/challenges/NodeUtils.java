package com.iamroman.algorithms.challenges;

import com.iamroman.algorithms.challenges.LinkedListChallenges.Node;

/** Utility methods that are used mostly to test the solutions to LinkedList challenges */
public abstract class NodeUtils {
  public static int countNodes(Node first) {
    int count = 0;
    Node current = first;
    while (current != null) {
      count++;
      current = current.next;
    }

    return count;
  }

  public static Node toListOfNodes(String[] array) {
    Node first = new Node("first");

    Node current = first;
    for (String data : array) {
      current.next = new Node(data);
      current = current.next;
    }
    return first.next;
  }

  public static String toString(Node first) {
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
