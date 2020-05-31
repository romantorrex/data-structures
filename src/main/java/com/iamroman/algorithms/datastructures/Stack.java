package com.iamroman.algorithms.datastructures;

import java.util.NoSuchElementException;

public class Stack<T> {
  private Node<T> top;
  int count = 0;

  public void push(T data) {
    Node<T> newNode = new Node<>(data);

    newNode.next = top;
    top = newNode;
    count++;
  }

  public T pop() {
    checkEmpty();

    T deletedData = top.data;
    top = top.next;
    count--;

    return deletedData;
  }

  public T peek() {
    checkEmpty();

    return top.data;
  }

  public int size() {
    return count;
  }

  private void checkEmpty() {
    if (size() == 0) {
      throw new NoSuchElementException();
    }
  }
}
