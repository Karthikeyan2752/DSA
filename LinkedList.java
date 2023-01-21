package com.linkedlist;

public class LinkedList {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int value) {
			data = value;
			next = null;
		}
	}

	LinkedList() {
		head = null;
	}

	public void addFirst(int value) {
		Node node = new Node(value);

		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}

	}

	public void print() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}
		System.out.println();
	}

	public void addLast(int value) {
		Node node1 = new Node(value);
		Node node2 = head;
		while (node2.next != null) {
			node2 = node2.next;
		}
		node2.next = node1;

	}

	public void deleteFirst() {

		if (head == null) {
			return;
		}

		head = head.next;
	}

	public void insert(int position, int value) {
		int i = 1;
		Node node1 = new Node(value);
		Node node2 = head;
		while (i++ < position) {
			if (node2 == null) {
				return;
			}
			node2 = node2.next;

		}
		node1.next = node2.next;
		node2.next = node1;
	}

	public void deleteAtPosition(int position) {
		int i = 0;

		Node prev = null;
		Node node = head;
		while (i++ < position) {
			if (node == null) {
				return;
			}
			prev = node;
			node = node.next;

		}
		prev.next = node.next;
	}

	public static void main(String[] args) {
		/*
		 * LinkedList list = new LinkedList(); list.addFirst(1); list.addFirst(2);
		 * list.addFirst(3); list.addLast(10); list.print(); list.insert(2, 5);
		 * list.print(); list.deleteAtPosition(2); list.print();
		 */
	}
}
