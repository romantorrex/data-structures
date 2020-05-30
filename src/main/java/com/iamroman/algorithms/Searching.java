package com.iamroman.algorithms;

public abstract class Searching {

	public static int binarySearch(int[] array, int x) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
		int middle = (left + right) / 2;
			if (array[middle] == x) {
				return middle;
			} else if(x < array[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}

		return -1;
	}
}
