package com.sorting;

import java.util.Arrays;

public class MergeSort {

	public static int[] mergeSort(int[] a) {
		if (a.length == 1) {
			return a;
		}

		int mid = a.length / 2;
		int[] left = mergeSort(Arrays.copyOfRange(a, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(a, mid, a.length));

		return merge(right, left);
	}

	private static int[] merge(int[] right, int[] left) {
		int[] join = new int[left.length + right.length];
		int i = 0, j = 0;
		int k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				join[k++] = left[i++];
			} else {
				join[k++] = right[j++];
			}
		}

		while (i < left.length) {
			join[k++] = left[i++];
		}
		while (j < right.length) {
			join[k++] = right[j++];
		}

		return join;
	}

	public static void mergeSortInPlace(int[] a, int start, int end) {
		if (end - start == 1) {
			return;
		}

		int mid = (start + end) / 2;

		mergeSortInPlace(a, start, mid);
		mergeSortInPlace(a, mid, end);

		mergeInPlace(a, start, mid, end);
	}

	private static void mergeInPlace(int[] a, int start, int mid, int end) {
		int[] joined = new int[end - start];
		int i = start, j = mid;
		int k = 0;

		while (i < mid && j < end) {
			if (a[i] < a[j]) {
				joined[k++] = a[i++];
			} else {
				joined[k++] = a[j++];
			}
		}
		while (i < mid) {
			joined[k++] = a[i++];
		}
		while (j < end) {
			joined[k++] = a[j++];
		}

		for (k = 0; k < joined.length; k++) {
			a[start + k] = joined[k];
		}

	}

	public static void main(String[] args) {
		int[] a = { 3, 5, 8, 2, 1, 3, -1, -4, 6 };
		mergeSortInPlace(a, 0, a.length);
		System.out.println(Arrays.toString((a)));

	}

}
