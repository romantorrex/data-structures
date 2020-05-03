package com.iamroman.datastructures;

import java.util.Arrays;
import java.util.NoSuchElementException;

public final class ArrayList {
    private String[] elements;
    private int count;

    private ArrayList(int capacity) {
        elements = new String[capacity];
        count = 0;
    }

    public static ArrayList withCapacity(int capacity) {
        return new ArrayList(capacity);
    }

    public int size() {
        return count;
    }

    public void insert(String element) {
        if (count == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[count++] = element;
    }

    public int find(String element) {
        for (int i = 0; i < count; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        throw new NoSuchElementException(String.format("Element %s does not exist within list", element));
    }

    public String removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index has to be greater or equal than 0 but less that the current size");
        }
        String element = elements[index];
        for (int j = index; j < count-1; j++) {
            elements[j] = elements[j+1];
        }
        count--;
        return element;
    }

	/** Returns the size of the longest string */
	public int maximum() {
			if (size() <= 0)
					throw new IllegalStateException("Array is empty");
			// the lenght of a string is not negative.
			int max = elements[0].length();
			for (int i = 1; i < count; i++) {
				if (elements[i].length() > max) {
					max = elements[i].length();
				}
			}
			return max;
	}

	public void reverse() {
		for(int i=0, j=count-1; i < j; i++, j--) {
			String tempValue = elements[i];
			elements[i] = elements[j];
			elements[j] = tempValue;
		}
	}

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, count));
    }
}

