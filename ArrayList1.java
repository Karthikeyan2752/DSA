package com.linkedlist;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList1<T> implements Iterable<T> {

	private static final int initialCapacity = 16;
	private T[] a;
	private int size;
	private int capacity;

	ArrayList1() {
		a = (T[]) new Object[initialCapacity];
		size = 0;
		capacity = initialCapacity;
	}

	public void add(T element) {
		if (size == capacity) {
			expand();
		}
		a[size++] = element;
	}

	private void expand() {
		capacity *= 2;
		a = Arrays.copyOf(a, capacity);
	}

	private void shrink() {
		capacity /= 2;
		a = Arrays.copyOf(a, capacity);
	}

	public void insert(T element, int pos) {
		if (size == capacity) {
			expand();
		}
		for (int i = size - 1; i >= pos; i--) {
			a[i + 1] = a[i];
		}
		a[pos] = element;
		size++;
	}

	public void update(T element, int pos) {
		a[pos] = element;
	}

	public void clear() {
		size = 0;
	}

	public boolean contains(T element) {
		for (int i = 0; i < size; i++) {
			if (a[i] == element) {
				return true;
			}
		}
		return false;
	}

	public int search(T element) {

		for (int i = 0; i < size; i++) {
			if (a[i] == element) {
				return i;
			}
		}
		return -1;
	}

	public void delete(int pos) {

		for (int i = pos; i < size; i++) {
			a[i] = a[i + 1];
		}
		size--;
		if (capacity > initialCapacity && capacity > size * 3) {
			shrink();
		}
	}

	public void addFirst(T element) {
		insert(element, 0);
		size++;
	}

	public void addLast(T element) {
		insert(element, size);
		size++;
	}

	public void deleteFirst(T element) {
		delete(0);
		size--;
	}

	public void deleteLast(T element) {
		delete(size - 1);
		size--;
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {
			int index = 0;

			@Override
			public T next() {
				return a[index++];
			}

			@Override
			public boolean hasNext() {
				return index < size;
			}
		};
	}

	public T get(int pos) {
		return a[pos];
	}

	public static void main(String[] args) {
		ArrayList1<Integer> al = new ArrayList1<>();
		al.add(1);
		al.insert(1, 1);
		al.add(12);
		al.print();
		Iterator<Integer> i = al.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}

	}
}
