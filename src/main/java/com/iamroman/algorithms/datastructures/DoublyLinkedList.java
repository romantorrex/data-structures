package com.iamroman.algorithms.datastructures;

public final class DoublyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public void addLast(T value) {
    Node<T> node = new Node<>(value);
    size++;
    if (isEmpty()) {
      head = tail = node;
      return;
    }

    tail.next = node;
    node.previous = tail;
    tail = node;
  }

  private boolean isEmpty() {
    return head == null && tail == null;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    Node<T> current = head;
    while (current != null) {
      stringBuilder.append(current.value);
      if (current.next != null) {
        stringBuilder.append(", ");
      }
      current = current.next;
    }
    stringBuilder.append("]");
    return stringBuilder.toString();
  }

  private class Node<T> {
    private T value;
    Node next;
    Node previous;

    Node(T value) {
      this.value = value;
    }
  }
}
