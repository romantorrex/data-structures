package com.iamroman.algorithms.datastructures;

import java.util.NoSuchElementException;

/** A data structure in which elements are inserted in the back and removed from the front. */
public final class Queue<T> {
  private Node<T> front;
  private Node<T> back;
  private int count;

  /** Inserts an element in the back of this queue. */
  public void enqueue(T element) {
    Node<T> newNode = new Node<>(element);
    count++;
    if (front == null) {
      front = newNode;
      back = front;
      return;
    }

    back.next = newNode;
    back = newNode;
  }

  /** Removes the first element in the front of this queue. */
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

  /**
   * Returns the first element in the front of this queue.
   *
   * <p>The element returned is not removed.
   */
  public T peek() {
    checkEmpty();
    return front.data;
  }

  /** Returns the number of elements in this queue. */
  public int size() {
    return count;
  }

  private void checkEmpty() {
    if (front == null) {
      throw new NoSuchElementException();
    }
  }
}
