package com.iamroman.datastructures;

import java.util.NoSuchElementException;

// TODO: Add methods addLast(), addFirst, removeLast(), removeFirst()
public class LinkedList {
  private Node first;
  private int size = 0;

  public void add(String data) {
    Node node = new Node(data);
    size++;
    if (first == null) {
      first = node;
      return;
    }

    Node current = first;
    while (current.next != null) {
      current = current.next;
    }

    current.next = node;
  }

  public int indexOf(String data) {
    int index = 0;
    Node current = first;
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

    if (first != null && data.equals(first.data)) {
      first = first.next;
      size--;
      return;
    }

    Node previous = first;
    Node current = first;
    while (current != null) {
      if (data.equals(current.data)) {
        previous.next = current.next;
        size--;
        return;
      }
      previous = current;
      current = current.next;
    }

    throw new NoSuchElementException("Data not found.");
  }

  public int size() {
    return size;
  }
}

class Node {
  String data;
  Node next;

  Node(String data) {
    this.data = data;
  }
}
