package com.company;

import java.util.Arrays;
import java.util.NoSuchElementException;

// 最大堆： 解决top小 问题
public class MaxHeap {
    private int size;
    private int capacity;
    private int[] array;

    public MaxHeap(int capacity){
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        System.out.println("max: " + heap.peek());
        heap.poll();
        System.out.println("max: " + heap.peek());

    }

    public void add(int val){
        // 若容量已满 扩容一倍
        if(size == capacity){
            array = Arrays.copyOf(array, capacity*2);
        }

        array[size] = val;
        size++;
        heapifyUp();
    }

    //将新加入元素向上移动 知道满足最大堆条件
    public void heapifyUp(){
        int index = size-1; //新加元素的index
        while(hasParent(index)&&array[index]>parent(index)){ //如果有父节点并且大于父节点，则交换位置
            int temp = array[index];
            array[index] = array[getParentIndex(index)];
            array[getParentIndex(index)] = temp;

            index = getParentIndex(index);
        }
    }

    //poll:删除根节点
    //然后将最后节点元素移动至最前方作为新的根节点
    //最后heapifyDown（） 将根节点向下移动至合适位置
    public void poll(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        array[0] = array[size-1];
        size--;
        heapifyDown();
    }

    public void heapifyDown(){
        int cur = 0;
        while(hasLeftChild(cur)){
            int largerChild = getLeftChildIndex(cur);
            if(hasRightChild(cur) && leftChild(cur)<rightChild(cur)){
                largerChild = getRightChildIndex(cur);
            }
            if(array[cur]<array[largerChild]){
                // switch the element with its larger child
                int temp = array[cur];
                array[cur] = array[largerChild];
                array[largerChild] = temp;
            }else{
                break;
            }
            cur = largerChild;
        }
    }

    public int peek(){
        if(size == 0){
            throw new NoSuchElementException();
        }else{
            return array[0];
        }
    }



    private int getLeftChildIndex(int parentIndex){
        return parentIndex*2 + 1;
    }

    private int getRightChildIndex(int parentIndex){
        return parentIndex*2 +2;
    }

    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index)<size;
    }

    private boolean hasRightChild(int index){
        return getRightChildIndex(index)<size;
    }

    private boolean hasParent(int index){
        return getParentIndex(index)>=0;
    }

    private int leftChild(int index){
        return array[getLeftChildIndex(index)];
    }

    private int rightChild(int index){
        return array[getRightChildIndex(index)];
    }

    private int parent(int index){
        return array[getParentIndex(index)];
    }
}
