package com.iamroman.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class SortingTest {

  private static String SORTED_ARRAY_STR = "[0, 2, 5, 6, 7]";

  public void insertionSort() {
    int[] numbers = {5, 2, 7, 6, 0};
    Sorting.insertionSort(numbers);

    assertThat(Arrays.toString(numbers)).isEqualTo("[0, 2, 5, 6, 7]");

    numbers = new int[] {5, 4, 3, 2, 1, 0};
    Sorting.insertionSort(numbers);

    assertThat(Arrays.toString(numbers)).isEqualTo("[0, 1, 2, 3, 4, 5]");
  }

  @Test
  public void bubbleSort() {
    int[] numbers = {5, 2, 7, 6, 0};

    Sorting.bubbleSort(numbers);

    assertThat(Arrays.toString(numbers)).isEqualTo(SORTED_ARRAY_STR);

    int[] worstCase = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    Sorting.bubbleSort(worstCase);
    assertThat(Arrays.toString(worstCase)).isEqualTo("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
  }
}
