package com.iamroman.algorithms.datastructures;

import java.util.Arrays;

/** Implementation of a binary max heap using an array */
public class MaxHeap {
  private int[] items = new int[128];
  private int size = 0;

  public void insert(int item) {
    items[size++] = item;
    int child = size - 1;
    int parent = (child - 1) / 2;

    while (parent >= 0 && items[child] > items[parent]) {
      swap(parent, child);
      child = parent;
      parent = (child - 1) / 2;
    }
  }

  public int remove() {
    int rootValue = items[0];
    items[0] = items[--size];

    bubbleDown();

    return rootValue;
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

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOf(items, size));
  }

  private void swap(int first, int second) {
    int temp = items[first];
    items[first] = items[second];
    items[second] = temp;
  }
}
