package com.company;

public class QueueAsList {
    QueueNode front;
    QueueNode rear;
    static class QueueNode{
        int value;
        QueueNode next;
        public QueueNode(int val){
            this.value=val;
        }
    }

    public void enqueue(int val){
        QueueNode newNode = new QueueNode(val);
        if(this.rear == null){ //empty queue
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        rear = newNode;
    }

    public void peek(){
        System.out.println("the first one is: "+this.front.value);
    }

    public int dequeue(){
        if(this.rear == null){ //empty queue
            System.out.println("Empty queue");
            return Integer.MIN_VALUE;
        }
        int value = this.front.value;
        this.front = this.front.next;
        if(this.front == null){
            this.rear = null;
        }
        return value;
    }

    public static void main(String[] args) {
        QueueAsList queue = new QueueAsList();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.peek();

        queue.dequeue();
        queue.peek();
    }
}
