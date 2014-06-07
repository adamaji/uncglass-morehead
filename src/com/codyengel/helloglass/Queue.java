package com.codyengel.helloglass;

public interface Queue<T> {
	public int size();
	public boolean isEmpty();
	public void enqueue(T d);
	public T dequeue() throws IndexOutOfBoundsException;
}
