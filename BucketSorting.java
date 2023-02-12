package com.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSorting {
	/***
	 * 
	 * @param a
	 * @param noOfBuckets
	 */

	public void bucketSort(int[] a, int noOfBuckets) {
		int offset = Integer.MAX_VALUE;
		boolean containsNegative = false;

		for (int i = 0; i < a.length; i++) {
			offset = Math.min(a[i], offset);
			if (a[i] < 0) {
				containsNegative = true;
			}
		}

		// finding the minimum and maximum
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (containsNegative) {
				a[i] -= offset;
			}
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}

		int range = max - min;
		int bucketRange = range / noOfBuckets;

		List<Integer>[] buckets = new LinkedList[noOfBuckets];

		for (int i = 0; i < noOfBuckets; i++) {
			buckets[i] = new LinkedList<>();
		}

		// adding the elements from array to the corresponding bucket
		for (int num : a) {
			buckets[hash(num, bucketRange, noOfBuckets)].add(num);
		}

		// sorting every individual bucket
		for (List<Integer> list : buckets) {
			Collections.sort(list);
		}

		int index = 0; // for insertion of element in the output array.
		for (List<Integer> bucket : buckets) {
			for (int i : bucket) {
				if (containsNegative) {
					a[index++] = i + offset;
				} else {
					a[index++] = i;
				}
			}
		}



	}

	/***
	 * 
	 * @param num
	 * @param bucketRange
	 * @param noOfBuckets
	 * @return bucketNumber
	 */

	private int hash(int num, int bucketRange, int noOfBuckets) {
		int bucketNumber = num / bucketRange;
		if (bucketNumber == noOfBuckets) {
			bucketNumber--;
		}
		return bucketNumber;
	}

	public static void main(String[] args) {
		BucketSorting b = new BucketSorting();
		int[] a = new int[] { 4, 6, 10, 3, 2, 9, 4, -10, 0 };
		b.bucketSort(a, 5);
		System.out.println(Arrays.toString(a));

	}

}
