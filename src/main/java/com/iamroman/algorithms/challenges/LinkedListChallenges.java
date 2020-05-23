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

  // TODO: Solve the problem where the numbers are stored in forward order.
  // TODO: Solve it recursively.
  /**
   * Solves interview question 2.5 (Sum Lists). Numbers are stored in reverse order. For Example 359
   * is stored as (9 -> 5 -> 3).
   */
  public static Node<Integer> sumLists(Node<Integer> listA, Node<Integer> listB) {
    Node<Integer> listC = new Node(0);

    Node<Integer> result = listC;
    int carry = 0;
    while (listA != null || listB != null) {
      int a = (listA == null) ? 0 : listA.data;
      int b = (listB == null) ? 0 : listB.data;
      int sum = a + b + carry;

      result.next = new Node<>(0);
      result = result.next;
      result.data = sum % 10; // stores only one digit in the node
      carry = sum / 10;

      listA = listA.next;
      listB = listB.next;
    }

    return listC.next;
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
