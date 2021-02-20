package com.iamroman.algorithms.datastructures;

import java.util.Arrays;

/**
 * A complete binary tree in which every node's value is greater that the values of its descendants.
 *
 * <p>This implementation uses and array for storing the elements.
 */
public class MaxHeap {
  private int[] items = new int[128];
  private int size = 0;

  /** Converts the given {@code array} into a Max Heap. */
  public static void heapify(int[] array) {
    for (int i = array.length / 2 - 1; i >= 0; i--) {
      heapify(array, i);
    }
  }

  /** Returns the position of the k-th largest value in the given {@code array}. */
  public static int getKthLargestElement(int[] array, int k) {
    if (k > array.length && k < 0) {
      throw new IllegalArgumentException(
          String.format("K must be greater or equal to 1 and less equal to %s", array.length));
    }

    MaxHeap maxHeap = new MaxHeap();
    for (int element : array) {
      maxHeap.insert(element);
    }

    while (k > 1) maxHeap.remove();

    return maxHeap.getMax();
  }

  /** Adds a node with the given {@code value} to this max heap. */
  public void insert(int value) {
    items[size++] = value;
    int child = size - 1;
    int parent = (child - 1) / 2;

    while (parent >= 0 && items[child] > items[parent]) {
      swap(parent, child);
      child = parent;
      parent = (child - 1) / 2;
    }
  }

  /** Removes the node with the maximum value from this max heap. */
  public int remove() {
    int rootValue = items[0];
    items[0] = items[--size];

    bubbleDown();

    return rootValue;
  }

  /** Returns the max value in this heap. */
  public int getMax() {
    return items[0];
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOf(items, size));
  }

  private void bubbleDown() {
    int current = 0;
    int maxChildIndex = maxChildIndexOf(current);
    while (maxChildIndex > 0 && items[maxChildIndex] > items[current]) {
      swap(current, maxChildIndex);
      current = maxChildIndex;
      maxChildIndex = maxChildIndexOf(current);
    }
  }

  private int maxChildIndexOf(int current) {
    int leftIndex = current * 2 + 1;
    int rightIndex = current * 2 + 2;

    if (leftIndex >= size && rightIndex >= size) return -1;
    if (rightIndex >= size || items[leftIndex] > items[rightIndex]) {
      return leftIndex;
    } else {
      return rightIndex;
    }
  }

  private void swap(int first, int second) {
    int temp = items[first];
    items[first] = items[second];
    items[second] = temp;
  }

  private static void swap(int[] array, int first, int second) {
    int temp = array[first];
    array[first] = array[second];
    array[second] = temp;
  }

  private static void heapify(int[] array, int index) {
    int maxChildIndex = index;

    int leftChildIndex = index * 2 + 1;
    if (leftChildIndex < array.length && array[leftChildIndex] > array[maxChildIndex]) {
      maxChildIndex = leftChildIndex;
    }

    int rightChildIndex = index * 2 + 2;
    if (rightChildIndex < array.length && array[rightChildIndex] > array[maxChildIndex]) {
      maxChildIndex = rightChildIndex;
    }

    if (index == maxChildIndex) return;

    swap(array, index, maxChildIndex);
    heapify(array, maxChildIndex);
  }
}
