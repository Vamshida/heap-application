package com.datastructure.maxAndMinheap.Service;

import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;
    
	public MinHeap() {
			
		}

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    

	public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        // Add the new element to the end of the heap
        heap[size] = value;

        // Heapify to maintain min-heap property
        int currentIndex = size;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap[currentIndex] < heap[parentIndex]) {
                // Swap the current element with its parent
                int temp = heap[currentIndex];
                heap[currentIndex] = heap[parentIndex];
                heap[parentIndex] = temp;
                currentIndex = parentIndex;
            } else {
                // The heap property is satisfied
                break;
            }
        }

        size++;
    }

    public int deleteMin() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot delete.");
            return -1; // Return a sentinel value to indicate an error
        }

        int minValue = heap[0];

        // Replace the root with the last element in the heap
        heap[0] = heap[size - 1];
        size--;

        // Heapify to maintain min-heap property
        int currentIndex = 0;
        while (true) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            int smallestIndex = currentIndex;

            if (leftChildIndex < size && heap[leftChildIndex] < heap[smallestIndex]) {
                smallestIndex = leftChildIndex;
            }
            if (rightChildIndex < size && heap[rightChildIndex] < heap[smallestIndex]) {
                smallestIndex = rightChildIndex;
            }

            if (smallestIndex != currentIndex) {
                // Swap the current element with the smallest child
                int temp = heap[currentIndex];
                heap[currentIndex] = heap[smallestIndex];
                heap[smallestIndex] = temp;
                currentIndex = smallestIndex;
            } else {
                // The heap property is satisfied
                break;
            }
        }

        return minValue;
    }
    
    public int delete(int value) {
        int indexToDelete = -1;

        // Find the index of the element to delete
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Element not found in MinHeap.");
            return -1; // Element not found, return a sentinel value
        }

        int deletedValue = heap[indexToDelete];

        // Replace the element to delete with the last element in the heap
        heap[indexToDelete] = heap[size - 1];
        size--;

        // "Bubble down" to maintain min-heap property
        int currentIndex = indexToDelete;
        while (true) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            int smallestIndex = currentIndex;

            if (leftChildIndex < size && heap[leftChildIndex] < heap[smallestIndex]) {
                smallestIndex = leftChildIndex;
            }
            if (rightChildIndex < size && heap[rightChildIndex] < heap[smallestIndex]) {
                smallestIndex = rightChildIndex;
            }

            if (smallestIndex != currentIndex) {
                // Swap the current element with the smallest child
                int temp = heap[currentIndex];
                heap[currentIndex] = heap[smallestIndex];
                heap[smallestIndex] = temp;
                currentIndex = smallestIndex;
            } else {
                // The heap property is satisfied
                break;
            }
        }

        return deletedValue;
    }


    public int[] toArray() {
        return Arrays.copyOf(heap, size);
    }
}