package com.company;

public class QueueAsArray {
    int front, rear, size;
    int queue[];
    int capacity;
    public QueueAsArray(int capacity){
        this.capacity = capacity;
        front = rear = size = 0;
        queue = new int[capacity];
    }

    public void enqueue(int item){
        if(isFull()){
            System.out.println("The queue is full");
            return;
        }
        queue[rear] = item;
        rear = (rear+1)%capacity;
        size++;
        System.out.println("item is enqueued");
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Empty queue");
            return Integer.MIN_VALUE;
        }
        int value = queue[front];
        front = (front+1)%capacity;
        size--;
        return value;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Empty queue");
            return Integer.MIN_VALUE;
        }
        int value = queue[front];
        return value;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        QueueAsArray queue = new QueueAsArray(100);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        //rear 指向队列最后一个元素的下一位
        System.out.println(queue.rear);
        queue.dequeue();

        System.out.println(queue.peek());
    }
}
