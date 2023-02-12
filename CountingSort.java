package com.sorting;

import java.util.Arrays;

public class CountingSort {

	public void countingSort(int[] a) {

		// finding maximum and minimum
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i : a) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}

		// finding the range (finding the number of unique elements)
		int range = max - min + 1;

		// count array for taking frequency of each elements
		int[] count = new int[range];

		// resultant array
		int[] result = new int[a.length];

		for (int i : a) {
			count[i - min]++;
		}

		// calculating the cumulative sum of previous number so that we will get the
		// correct position
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = a.length - 1; i >= 0; i--) {
			result[count[a[i] - min] - 1] = a[i];
			count[a[i] - min]--;
		}

		// copying the array
		for (int i = 0; i < a.length; i++) {
			a[i] = result[i];
		}
	}

	public static void main(String[] args) {

		int[] a = new int[] { 4, 6, 10, 3, 2, 9, 4 };
		CountingSort c = new CountingSort();
		c.countingSort(a);
		System.out.println(Arrays.toString(a));
	}

}
