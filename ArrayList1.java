package com.linkedlist;

public class ArrayList1 {
	private static int[] a;
	private static int count;
	private static int length;

	ArrayList1() {
		a = new int[5];
		length = 5;
		count = 0;
	}

	public static void insert(int element) {
		if (count < a.length) {
			a[count++] = element;
		} else {
			int[] b = new int[a.length + 5];
			length += 5;
			for (int i = 0; i < a.length; i++) {
				b[i] = a[i];
			}
			b[count++] = element;
			a = b;
		}
	}

	public static void delete(int element) {
		int[] b = new int[a.length];
		int c = 0;
		int i = 0;
		while (i < a.length) {
			if (a[i] == element) {
				i++;
				count--;
			} else {
				b[c++] = a[i++];
			}
		}
		length--;
		a = new int[b.length];
		a = b;
	}

	public static void print() {
		System.out.print("[ ");
		for (int i = 0; i < count; i++) {
			System.out.print(a[i] + " ,");
		}
		System.out.print(" ]");
		System.out.println("length: " + count);
	}
}
