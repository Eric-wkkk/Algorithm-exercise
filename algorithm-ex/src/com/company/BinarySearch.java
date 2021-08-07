package com.company;


/*
* 二分搜素： 在有序数组中查找特定元素
* O(log2N) 优势是 性能平均
* */
public class BinarySearch {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int index = search(num,0, num.length-1, 1);
        if(index != -1){
            System.out.println(index);
        }else{
            System.out.println("no record");
        }

    }
    public static int search(int[]num, int start, int end, int target){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(num[mid] == target){
            return mid;
        }else if(num[mid]>target){
            return search(num, start, mid-1, target);
        }else{
            return search(num, mid+1, end, target);
        }
    }

}
