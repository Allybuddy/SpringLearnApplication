package com.example.springLearn.DataStructures;

class MyStack{
    private int maxSize;
    private int [] arr;
    private int top;

    public MyStack (int size){
        maxSize = size;
        arr = new int [size];
        top = -1;
    }

    public void push(int value){
        if(top == maxSize - 1){
            return ;
        }
        arr[++top] = value;
    }

    public int pop(){
        if (top == -1){
            return -1;
        }
        int poppedValue = arr[top--];
        return poppedValue;
    }

    public int peek(){
        if (isEmpty()){
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i< arr.length; i++){
            str.append(arr[i]);
            if(i < arr.length-1){
                str.append(", ");
            }
        }
        return str.toString();
    }
}

public class Stack {

    public static void main(String [] args){

        var stack = new MyStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
        System.out.println("top value: " + stack.peek());
        System.out.println("popped value: " + stack.pop());
        System.out.println("top value: " + stack.peek());
        System.out.println(stack);
    }


}
