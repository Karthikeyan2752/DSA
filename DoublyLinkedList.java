package com.linkedlist;


public class DoublyLinkedList {
	Node head;
	Node tail;
	static int size;

	class Node {
		int data;
		Node next;
		Node prev;


		Node(int value) {
			data = value;
			next = null;
			prev = null;
		}
	}

	DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addFirst(int val) {
		size++;
		Node node = new Node(val);
		node.next = head;
		if (head == null) {
			tail=node;
		} else {
			head.prev = node;
		}
		head = node;

	}


	public void addLast(int val) {
		size++;
		Node temp = new Node(val);
		if (head == null) {
			head = temp;
			tail = temp;
		} else {
			Node node = tail;
			node.next = temp;
			tail = temp;
			tail.prev = node;
		}
	}

	public void deleteFirst() {

		if (head == null) {
			return;
		}
		size--;
		head = head.next;
		if (head == null) {
			tail = null;
		} else {
			head.prev = null;
		}
	}

	public void deleteLast() {

		if (head == null) {
			throw new IndexOutOfBoundsException();
		}
		size--;
		head = head.next;
		if (head == null) {
			tail = null;
		} else {
			head.prev = null;
		}

	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void printReverse() {
		Node temp = tail;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
		System.out.println();
	}

	public int size() {
		return size;
	}

	public void insert(int pos, int val) {
		size++;
		if (pos == 0) {
			addFirst(val);
			return;
		}
		if (pos == size - 1) {
			addLast(val);
			return;
		}
		Node node = new Node(val);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			Node temp = head;
			for (int i = 1; i < pos; i++) {
				temp = temp.next;
				if (temp == null) {
					throw new IndexOutOfBoundsException();
				}
			}
			node.next = temp.next;
			node.prev = temp;
			temp.next = node;

		}
	}

	public void delete(int pos) {
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}

			size--;
			if (pos == 0) {
				deleteFirst();
				return;
			}
			Node temp = head;
			Node prev = null;
			for (int i = 0; i < pos; i++) {
				prev = temp;
				temp = temp.next;
				if (temp == null) {
					throw new IndexOutOfBoundsException();
				}
			}
			prev.next = temp.next;
			if (temp.next == null) {
				tail = prev;
			} else {
				temp.next.prev = prev;
			}

	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addLast(4);
		list.insert(4, 5);
		list.delete(0);
		
		System.out.println(list.size());
		list.print();
		list.printReverse();
		// list.deleteLast();

	}

}
