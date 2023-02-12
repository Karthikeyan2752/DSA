package com.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] a, int low, int high) {
		if (low >= high) {
			return;
		}

		int start = low;
		int end = high;
		int mid = (start + end) / 2;
		int pivot = a[mid];

		while (start <= end) {

			while (a[start] < pivot) {
				start++;
			}
			while (a[end] > pivot) {
				end--;
			}

			if (start <= end) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
				start++;
				end--;
			}
		}
		quickSort(a, low, end);
		quickSort(a, start, high);
	}

	public static void main(String[] args) {
		int[] a = { 3, 1, 2, -5 };
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

	}

}
