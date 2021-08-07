package com.company;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9, -1, 10, 12, 3, 7};
        //如何选择堆类型： 升序用最大堆， 降序用最小堆
        //堆排序时间复杂度：  O(Nlog2N)
        System.out.println("排序前：" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void heapSort(int arr[]){
        int temp = 0;
        System.out.println("堆排序！");
        for(int i =arr.length/2 -1; i>=0; i--){
            adjustHeap(arr, i, arr.length);
        }


        for(int j = arr.length-1; j>0; j--){
            //大顶堆完成后，最大值在顶部
            //交换顶部与最后一个值， 将最大值放在最后
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;

            //交换后继续将数组调整成大顶堆
            // j递减： 排好序的数不再参与
            adjustHeap(arr, 0 ,j);
        }
    }

    /*
    * 将一个数组（二叉树）调整成一个大顶堆
    * 功能： 将一个以i对应的非叶子结点为顶的树调整成最大堆
    * @param arr：待调整的数组
    * @param i：表示非叶子结点在数组中的索引
    * @param length 表示对多少个元素继续调整 （逐渐减少）
    */
    public static void adjustHeap(int arr[], int i, int length){
        int temp = arr[i]; //将当前元素保存在临时变量
        //开始调整
        // k起始为 i 的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1){
            if(k+1<length && arr[k] < arr[k+1]){//如果左子节点的值小于右子节点
                k++; //k指向右子节点
            }
            if(arr[k]>temp){ // 如果子节点大于父节点
                arr[i] = arr[k]; //把较大的值赋给父节点
                i = k; //i指向k，继续循环
            }
            else{
                break;
            }
        }
        //当for循环结束后，以i为父节点的树（局部调整）的最大值放在了最顶
        arr[i] = temp; //将temp值放到i调整后的位置
    }
}
