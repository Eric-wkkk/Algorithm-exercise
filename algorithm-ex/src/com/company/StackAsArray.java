package com.company;

public class StackAsArray {
    static final int capacity = 1000;
    int top;
    int stack[];

    public StackAsArray(){
        // top is the index of the last element in array
        this.top = -1;
        stack = new int[capacity];
    }

    //add the new element to the end of array
    public boolean push(int val){
        if(top>=capacity){
            System.out.println("Stack Overflow");
            return false;
        }
        stack[++top] = val;
        return true;
    }

    public int pop(){
        if(top<0){
            System.out.println("Stack Underflow");
            return 0;
        }
        int element = stack[top--];
        return element;
    }

    public int peek(){
        if(top<0){
            System.out.println("Stack underflow");
            return 0;
        }
        int element = stack[top];
        return element;
    }

    public boolean isEmpty(){
        return top<0;
    }

    public static void main(String[] args) {
        StackAsArray stack = new StackAsArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());

    }

}
