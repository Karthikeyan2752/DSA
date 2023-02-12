package com.sorting;

import java.util.Arrays;

public class SelectionSort {
	static void selectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = a[i];
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < min) {
					min = a[j];
					minIndex = j;
				}
			}
			swap(a, i, minIndex);
		}
		System.out.println(Arrays.toString(a));
	}

	private static void swap(int[] a, int i, int minIndex) {
		int temp = a[i];
		a[i] = a[minIndex];
		a[minIndex] = temp;

	}
	public static void main(String[] args) {
		selectionSort(new int[] { 1, 4, 8, 2 });

	}

}
