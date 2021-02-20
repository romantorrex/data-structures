package com.iamroman.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortingTest {
  private static String SORTED_AVERAGE_CASE = "[0, 2, 5, 6, 7]";
  private static String SORTED_WORST_CASE = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]";

  private int[] numbers;
  private int[] worstCase;

  @BeforeEach
  public void setUp() {
    numbers = new int[] {5, 2, 7, 6, 0};
    worstCase = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
  }

  @Test
  public void insertionSort() {
    Sorting.insertionSort(numbers);
    Sorting.insertionSort(worstCase);

    assertThat(Arrays.toString(numbers)).isEqualTo(SORTED_AVERAGE_CASE);
    assertThat(Arrays.toString(worstCase)).isEqualTo(SORTED_WORST_CASE);
  }

  @Test
  public void bubbleSort() {
    Sorting.bubbleSort(numbers);
    Sorting.bubbleSort(worstCase);

    assertThat(Arrays.toString(numbers)).isEqualTo(SORTED_AVERAGE_CASE);
    assertThat(Arrays.toString(worstCase)).isEqualTo(SORTED_WORST_CASE);
  }

  @Test
  public void mergeSort() {
    int[] sortedNumbers = Sorting.mergeSort(numbers);

    assertThat(Arrays.toString(sortedNumbers)).isEqualTo(SORTED_AVERAGE_CASE);

    sortedNumbers = Sorting.mergeSort(worstCase);
    assertThat(Arrays.toString(sortedNumbers)).isEqualTo(SORTED_WORST_CASE);
  }
}
