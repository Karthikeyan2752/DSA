package com.sorting;
import java.util.Arrays;

public class RadixSort {

	private void countingSort(int[] a, int place, int max) {

		int[] result = new int[a.length + 1];
		int[] count = new int[10];

		for (int i : a) {

			count[(i / place) % 10]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = a.length - 1; i >= 0; i--) {
			result[count[(a[i] / place) % 10] - 1] = a[i];
			count[(a[i] / place) % 10]--;
		}

		for (int i = 0; i < a.length; i++) {
			a[i] = result[i];
		}

	}

	public void radixSort(int[] a) {

		boolean containsNegative = false;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i : a) {
			min = Math.min(i, min);
		}
		if (min < 0) {
			containsNegative = true;
		}

		for (int i = 0; i < a.length; i++) {
			if (containsNegative) {
				a[i] -= min;
			}
			max = Math.max(max, a[i]);
		}


		for (int place = 1; max / place > 0; place *= 10) {
			countingSort(a, place, max);
		}

		if (containsNegative) {
			for (int i = 0; i < a.length; i++) {
				a[i] += min;
			}

		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4, 6, 10, 300, 2234, -988, 4, 110, 0 };
		RadixSort r = new RadixSort();
		r.radixSort(a);
		System.out.println(Arrays.toString(a));

	}

}


