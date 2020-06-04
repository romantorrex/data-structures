package com.iamroman.algorithms.challenges.ctci;

import com.iamroman.algorithms.datastructures.Stack;

/** Solves interview question 3.2 (Stack Min) */
public final class StackMin {
  private Stack<Integer> dataStack;
  private Stack<Integer> minsStack; // keeps track of the min value in dataStack

  public static StackMin create() {
    return new StackMin();
  }

  public void push(int data) {
    dataStack.push(data);

    if (minsStack.size() == 0 || data <= minsStack.peek()) {
      minsStack.push(data);
    }
  }

  public int pop() {
    if (dataStack.peek() == minsStack.peek()) {
      minsStack.pop();
    }

    return dataStack.pop();
  }

  public int peek() {
    return dataStack.peek();
  }

  public int size() {
    return dataStack.size();
  }

  public int min() {
    return minsStack.peek();
  }

  private StackMin() {
    dataStack = new Stack<>();
    minsStack = new Stack<>();
  }
}
