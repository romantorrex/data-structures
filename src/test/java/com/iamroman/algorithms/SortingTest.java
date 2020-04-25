package com.iamroman.algorithms;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import java.util.Arrays;

public class SortingTest {
	
	@Test
	public void insertionSort() {
		int[] numbers = {6, 2, 0, 7, 5};
		Sorting.insertionSort(numbers);

		assertThat(Arrays.toString(numbers)).isEqualTo("[0, 2, 5, 6, 7]");

		numbers = new int[] {5, 4, 3, 2, 1, 0};
		Sorting.insertionSort(numbers);

		assertThat(Arrays.toString(numbers)).isEqualTo("[0, 1, 2, 3, 4, 5]");

	}
}
