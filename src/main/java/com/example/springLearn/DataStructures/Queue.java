package com.example.springLearn.DataStructures;

class MyQueue{

    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public MyQueue(int capacity){
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
        front = 0;
        rear = -1;
    }

    public void enqueue(int value){
        if (isFull()){
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }

    public int dequeue(){
        if (isEmpty()){
            return -1;
        }
        int removedValue = arr[front];
        front = (front + 1) % capacity;
        size--;
        return removedValue;
    }

    public int peek(){
        if (isEmpty()){
            return -1;
        }
        return arr[front];
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == capacity;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = front; i<= rear; i++){
            str.append(arr[i]);
            if (i != rear){
                str.append(", ");
            }
        }
        return str.toString();
    }
}

public class Queue {

    public static void main(String [] args){

        var queue = new MyQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue);
        System.out.println("top value: " + queue.peek());
        System.out.println("popped value: " + queue.dequeue());
        System.out.println("top value: " + queue.peek());
        System.out.println(queue);

    }
}
