package com.iamroman.algorithms.challenges.ctci;

import com.iamroman.algorithms.datastructures.Stack;

/** Solves interview question 3.4 (Queue via Stacks) of the book CTCI */
public class TwoStackQueue<T> {
  private final Stack<T> stack1 = new Stack<>();
  private final Stack<T> stack2 = new Stack<>();

  public void enqueue(T item) {
    stack1.push(item);
  }

  public T dequeue() {
    moveItemsToStack2();

    return stack2.pop();
  }

  public T peek() {
    moveItemsToStack2();

    return stack2.peek();
  }

  private void moveItemsToStack2() {
    // Moves items only when both there all elements but stack 2 is empty
    if (!isEmpty() && stack2.size() == 0) {
      while (stack1.size() > 0) {
        stack2.push(stack1.pop());
      }
    }
  }

  private boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return stack1.size() + stack2.size();
  }
}
