package com.company;

public class StackAsList {
    static class StackNode{
        int value;
        StackNode next;
        StackNode(int val){
            this.value = val;
        }
    }
    StackNode top;
    public StackAsList(){
        top = null;
    }

    public void push(int val){
        StackNode newNode = new StackNode(val);
        if(top == null){
            top = newNode;
        }else{
            StackNode temp = top;
            top = newNode;
            newNode.next=temp;
        }
    }

    public int pop(){
        if(top==null){
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }
        int value = top.value;
        top=top.next;
        return value;
    }

    public int peek(){
        if(top==null){
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }
        int value = top.value;
        return value;
    }

    public boolean isEmpty(){
        return top==null;
    }


    public static void main(String[] args) {
        StackAsList stack = new StackAsList();
        // stack{4->3->2->1}
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
    }
}
