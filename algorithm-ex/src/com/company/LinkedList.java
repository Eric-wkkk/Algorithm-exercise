package com.company;

public class LinkedList {
    static class ListNode{
        int value;
        ListNode next;
        public ListNode(int val){
            this.value = val;
        }
    }

    ListNode head;
    ListNode tail;
    int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void append(int value){
        ListNode newNode = new ListNode(value);
        if(tail == null){
            tail = head = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int update(int oldVal, int newVal){
        if(head == null){
            System.out.println("Empty list");
            return -1;
        }
        ListNode temp = head;
        int index = 0;
        while(temp!=null){
            if(temp.value == oldVal){
                temp.value = newVal;
                return index;
            }
            temp = temp.next;
            index++;
        }
        System.out.println("value not found");
        return -1;
    }

    public void insert(int position, int value){
        ListNode newNode = new ListNode(value);
        if(position > size){
            System.out.println("out of bound error");
            return;
        }
        // 头部插入
        if(position == 0){
            newNode.next = head;
            head = newNode;
            if(tail == null){
                tail = newNode;
            }
            size++;
        }
        // 尾部插入
        else if(position == size){
            this.append(value);
        }else // 中间插入
        {
            int index = 0;
            ListNode temp = head;
            while(index < position-1){
                temp = temp.next;
                index ++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    public void delete(int val){
        if(size == 0){
            System.out.println("Empty List");
            return;
        }
        if(head.value == val){
            head = head.next;
            size --;
            if(size == 0){
                tail = head; // 都为null
            }
        }else{
            ListNode prev = head;
            ListNode target = head.next;
            while(target != null){
                if(target.value == val){
                    if(target == tail){
                        tail = prev;
                    }
                    prev.next = target.next;
                    size--;
                    return;
                }
                prev = target;
                target = target.next;
            }
            System.out.println("value not found");
        }
    }

    public int search(int val){
        if(head == null){
            System.out.println("Empty list");
            return -1;
        }
        ListNode target = head;
        int index = 0;
        while(target != null){
            if(target.value == val){
                return index;
            }
            target = target.next;
            index ++;
        }
        System.out.println("target not found");
        return -1;
    }

    public void printList(){
        if(head == null){
            System.out.println("Empty list");
            return;
        }
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        //list.delete(1);
        list.update(3,4);
        list.insert(2,3);
        list.printList();
        //int target = list.search(3);
        //System.out.println("position is:"+target);


    }
}
