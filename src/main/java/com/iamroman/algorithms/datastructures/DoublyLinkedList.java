package com.iamroman.algorithms.datastructures;

public final class DoublyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int size;

  public void addLast(T value) {
    Node<T> newNode = new Node<>(value);

    size++;
    if (isEmpty()) {
      head = tail = newNode;
      return;
    }

    tail.next = newNode;
    newNode.previous = tail;
    tail = newNode;
  }

  public void addFirst(T value) {
    Node<T> newNode = new Node<>(value);

    size++;
    if (isEmpty()) {
      head = tail = newNode;
      return;
    }

    newNode.next = head;
    head.previous = newNode;
    head = newNode;
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

  public T removeFirst() {
    if (isEmpty()) {
      throw new IllegalStateException("List is empty.");
    }

    T removedValue = head.value;
    size--;
    if (head == tail) {
      head = tail = null;
    } else {
      head = head.next;
      head.previous = null;
    }

    return removedValue;
  }

  public T removeLast() {
    if (isEmpty()) {
      throw new IllegalStateException("List is empty.");
    }

    T removedValue = tail.value;
    size--;
    if (head == tail) {
      head = tail = null;
    } else {
      tail = tail.previous;
      tail.next = null;
    }

    return removedValue;
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
