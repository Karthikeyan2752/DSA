package com.sorting;

import java.util.Arrays;

public class InsertionSort {

	static void insertionSort(int[] a) {

		for (int i = 1; i < a.length; i++) {

			int current = a[i];
			int j = i - 1;

			while (a[j] > current && j >= 0) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = current;
		}
		System.out.println(Arrays.toString(a));

	}
	public static void main(String[] args) {
		insertionSort(new int[] { 1, 4, 8, 2 });

	}

}
