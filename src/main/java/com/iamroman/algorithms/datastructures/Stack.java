package com.iamroman.algorithms.datastructures;

import java.util.NoSuchElementException;

/**
 * A data structure in which elements are added to the top of the stack and only the element at the
 * top can be removed.
 */
public final class Stack<T> {
  private Node<T> top;
  private int count = 0;

  /** Inserts the given {@code element} at the top of this stack. */
  public void push(T element) {
    Node<T> newNode = new Node<>(element);

    newNode.next = top;
    top = newNode;
    count++;
  }

  /** Removes the element that is in the top of this stack. */
  public T pop() {
    checkEmpty();

    T removedElement = top.data;
    top = top.next;
    count--;

    return removedElement;
  }

  /** Returns the element that is in the top of this stack. */
  public T peek() {
    checkEmpty();

    return top.data;
  }

  /** Returns the number of elements in this stack. */
  public int size() {
    return count;
  }

  private void checkEmpty() {
    if (size() == 0) {
      throw new NoSuchElementException();
    }
  }
}
