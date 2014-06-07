/*
 * Doubly-linked queue designed to hold DisplayObjects.
 * @author Adam Aji
 * @author Dayton Bobbitt
 * @author Sifron Benjamin
 * @author Whitney Jenkins
 * @version 1.0
 * @since 2014-03-28
 */
package com.codyengel.helloglass;

public class LinkedQueue<T> implements Queue<T> {
	public static class Node<T> {
		Node<T> prev, next;
		T data;
		public Node(T d, Node<T> p, Node<T> n) {
			prev = p;
			next = n;
			data = d;
		}
	}
	
	private Node<T> headerNode, tailNode;
	private int size;
	
	public LinkedQueue() {
		headerNode = new Node<T>(null, null, tailNode);
		tailNode = new Node<T>(null, headerNode, null);
		size = 0;
	}
	public int size() { 
		return size; 
	}
	public boolean isEmpty() { 
		return size == 0; 
	}
	public void enqueue(T d) {
		tailNode.prev = tailNode.prev.next = new Node<T>(d, tailNode.prev, tailNode);
		size++;
	}
	public T dequeue() throws IndexOutOfBoundsException {
		if (!isEmpty()) {
			T front = headerNode.next.data;
			Node<T> tmp = headerNode.next.next;
			tmp.prev = headerNode;
			headerNode.next = tmp;
			size--;
			return front;
		} else {
			throw new IndexOutOfBoundsException("Queue is empty.");
		}
	}
}
