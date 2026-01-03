package com.example.springLearn.DataStructures;

import lombok.Data;

public class LLDs {

    @Data
    static class Node{
        int data;
        Node next = null;

        public Node(int value) {
            this.data = value;
        }
    }

    static Node head;

    public static void main(String[] args) {
        /**
         * Must-know operations:
         *
         * Insert (beginning, end, position)
         * Delete (by value, position)
         * Reverse linked list
         * Detect cycle (Floyd’s algorithm)
         * Find middle element
         */

        LLDs ll = new LLDs();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        ll.addFirst(0);
        ll.addFirst(-1);

        ll.addAtIndex(25, 4);

        ll.print();

        System.out.println();
        ll.deleteByValue(25);
        ll.print();

    }

    public void print(){
        var temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void addFirst(int value){
        var newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int value){
        var newNode = new Node(value);
        if (head == null){
            head = newNode;
            return;
        }
        var temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtIndex(int value, int position){
        var newNode = new Node(value);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        var temp = head;
        var count = 1;
        while (count < position - 1 && temp.next != null){
            temp = temp.next;
            count++;
        }
        if (count != position-1){
            System.out.println("Position out of range");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteByValue(int value){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        if (head.data == value){
            head = head.next;
            return;
        }
        var temp = head;
        while (temp.next != null && temp.next.data != value){
            temp = temp.next;
        }
        if (temp.next == null){
            System.out.println("Element didnt exist in the list");
            return;
        }
        temp.next = temp.next.next;
    }
}
