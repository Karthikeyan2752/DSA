package com.sorting;

public class BubbleSort {
	static void bubbleSort(int arr[]) {
		while (true) {
			boolean sorted = true;
			for (int i = 0; i < arr.length - 1; i++)// i i + 1
			{
				if (arr[i] > arr[i + 1]) {
					sorted = false;
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}

			if (sorted) {
				break;
			}
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
