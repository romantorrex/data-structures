package com.iamroman.algorithms;

import java.util.Arrays;

public abstract class Sorting {

  public static void insertionSort(int[] data) {
    for (int i = 1; i < data.length; i++) {
      int position = i;
      int value = data[i];

      while (position > 0 && data[position - 1] > value) {
        data[position] = data[position - 1];
        position--;
      }

      data[position] = value;
    }
  }

  public static void bubbleSort(int[] array) {
    boolean sorted = false;

    while (!sorted) {
      sorted = true;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1]) {
          swap(array, i, i + 1);
          sorted = false;
        }
      }
    }
  }

  // TODO: Implement using the input array to store the sorted values.
  public static int[] mergeSort(int[] array) {
    if (array.length == 1) {
      return array;
    }

    int middle = array.length / 2;
    int[] leftArray = Arrays.copyOfRange(array, 0, middle);
    int[] rightArray = Arrays.copyOfRange(array, middle, array.length);
    return merge(mergeSort(leftArray), mergeSort(rightArray));
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private static int[] merge(int[] left, int[] right) {
    int result[] = new int[left.length + right.length];
    int i = 0; // index for the resulting ordered array
    int j = 0; // index for left array items
    int k = 0; //  index for right array items
    while (j < left.length && k < right.length) {
      if (left[j] < right[k]) {
        result[i++] = left[j++];
      } else {
        result[i++] = right[k++];
      }
    }

    // copy the remaining items of array b
    while (j < left.length) {
      result[i++] = left[j++];
    }

    // copy the remaining items of array b
    while (k < right.length) {
      result[i++] = right[k++];
    }

    return result;
  }
}
