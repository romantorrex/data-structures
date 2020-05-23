package com.iamroman.algorithms.challenges;

public abstract class LinkedListChallenges {

  /** Solves the interview question 2.1 (Remove Dups) from book "Cracking the Coding Interview" */
  public static void deleteDuplicates(Node<String> first) {
    var current = first;

    while (current.next != null) {
      current.next = deleteData(current.next, current.data);
      current = current.next;
    }
  }

  private static Node<String> deleteData(Node<String> first, String data) {
    while (first != null && data.equals(first.data)) {
      first = first.next;
    }

    var current = first;
    var previous = first;

    while (current != null) {
      if (data.equals(current.data)) {
        previous.next = current.next;
      } else {
        previous = current;
      }

      current = current.next;
    }

    return first;
  }

  public static class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }
}
