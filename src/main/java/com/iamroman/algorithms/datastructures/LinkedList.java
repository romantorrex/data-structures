package com.iamroman.algorithms.datastructures;

// TODO: Add methods addLast(), addFirst, removeLast(), removeFirst()
public class LinkedList<T> {
  private Node<T> first;
  private int size = 0;

  public void add(T element) {
    Node<T> node = new Node<>(element);
    size++;
    if (first == null) {
      first = node;
      return;
    }

    Node<T> current = first;
    while (current.next != null) {
      current = current.next;
    }
    current.next = node;
  }

  public int indexOf(T element) {
    int index = 0;
    Node<T> current = first;
    while (current != null) {
      if (element.equals(current.data)) {
        return index;
      }
      index++;
      current = current.next;
    }

    return -1;
  }

  public void delete(T element) {
    while (first != null && element.equals(first.data)) {
      first = first.next;
      size--;
    }

    Node<T> previous = first;
    Node<T> current = first;
    while (current != null) {
      if (element.equals(current.data)) {
        previous.next = current.next;
        size--;
      } else {
        previous = current;
      }
      current = current.next;
    }
  }

  public int size() {
    return size;
  }
}
