package com.iamroman.algorithms.challenges.ctci;

import com.iamroman.algorithms.datastructures.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/** Solves the interview question 3.3 (Stack of Plates) of the book CTCI */
public class SetOfStacks<T> {
  private List<Stack<T>> stacks = new ArrayList<>();
  private int capacity;
  private int count;
  private int currentStackIndex = 0;

  public SetOfStacks(int capacityOfEachStack) {
    capacity = capacityOfEachStack;
  }

  public void push(T value) {
    Stack<T> currentStack = getCurrentStack();

    currentStack.push(value);
    count++;
  }

  public T pop() {
    Stack<T> currentStack = stacks.get(currentStackIndex);

    T value = currentStack.pop();

    if (currentStack.size() == 0) {
      stacks.remove(currentStackIndex--);
    }

    return value;
  }

  // TODO: Handle the stacks that are below capacity after poping out the element.
  public T popAt(int index) {
    if (index >= stacks.size() || stacks.get(index).size() == 0) {
      throw new NoSuchElementException();
    }
    count--;

    return stacks.get(index).pop();
  }

  public int size() {
    return count;
  }

  private Stack<T> getCurrentStack() {

    if (isEmpty()) {
      stacks.add(new Stack<>());
    }

    Stack<T> currentStack = stacks.get(currentStackIndex);

    if (currentStack.size() >= capacity) {
      stacks.add(++currentStackIndex, new Stack<>());
    }

    return stacks.get(currentStackIndex);
  }

  private boolean isEmpty() {
    return count == 0;
  }
}
