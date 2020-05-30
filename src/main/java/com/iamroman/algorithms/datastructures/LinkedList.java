package com.iamroman.algorithms.datastructures;

// TODO: Add methods addLast(), addFirst, removeLast(), removeFirst()
public class LinkedList {
  private Node<String> first;
  private int size = 0;

  public void add(String data) {
    Node<String> node = new Node<>(data);
    size++;
    if (first == null) {
      first = node;
      return;
    }

    Node<String> current = first;
    while (current.next != null) {
      current = current.next;
    }

    current.next = node;
  }

  public int indexOf(String data) {
    int index = 0;
    Node<String> current = first;
    while (current != null) {
      if (data.equals(current.data)) {
        return index;
      }
      index++;
      current = current.next;
    }

    return -1;
  }

  public void delete(String data) {

    while (first != null && data.equals(first.data)) {
      first = first.next;
      size--;
    }

    Node<String> previous = first;
    Node<String> current = first;
    while (current != null) {
      if (data.equals(current.data)) {
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
