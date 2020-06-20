package com.iamroman.algorithms.datastructures;

public class PriorityQueue {
  private Node<Integer> head;
  private int count;

  public void enqueue(int data) {
    Node<Integer> newNode = new Node<>(data);
    count++;

    // In both cases the new node should be inserted in the head of the queue
    if (head == null || data < head.data) {
      newNode.next = head;
      head = newNode;
      return;
    }

    Node<Integer> previous = head;
    Node<Integer> current = head.next;
    while (current != null) {
      if (data < current.data) {
        previous.next = newNode;
        newNode.next = current;
        return;
      }
      previous = current;
      current = current.next;
    }
    // inserts the new data at the end since it is the one with highest value.
    previous.next = newNode;
  }

  public int dequeue() {
    count--;
    Node<Integer> oldNode = head;
    head = head.next;
    return oldNode.data;
  }

  public int peek() {
    return head.data;
  }

  public int size() {
    return count;
  }
}
