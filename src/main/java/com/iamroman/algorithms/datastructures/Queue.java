package com.iamroman.algorithms.datastructures;

import java.util.NoSuchElementException;

public class Queue<T> {
  private Node<T> front;
  private Node<T> back;
  private int count;

  public void enqueue(T data) {
    Node<T> newNode = new Node<>(data);
    count++;
    if (front == null) {
      front = newNode;
      back = front;
      return;
    }

    back.next = newNode;
    back = newNode;
  }

  public T dequeue() {
    checkEmpty();
    Node<T> firstNode = front;

    if (front == back) {
      front = null;
      back = null;
    } else {
      front = front.next;
    }
    count--;

    return firstNode.data;
  }

  public T peek() {
    checkEmpty();
    return front.data;
  }

  public int size() {
    return count;
  }

  private void checkEmpty() {
    if (front == null) {
      throw new NoSuchElementException();
    }
  }
}
