package com.company;

public class TestSorting {
    public static void main(String[] args) {
        int[] arr = {5,4,3,1,2};
        for (int element:arr) {
            System.out.print(element+",");
        }
        System.out.println("\n");
        //selectionSort(arr);
        //bubbleSort(arr);
        insertionSort(arr);
        //quickSort(arr,0,arr.length-1);
        for (int element1:arr) {
            System.out.print(element1+",");
        }
    }

    //O(N^2)
    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    // 将比pivot小的放在其左边，比pivot大的放在右边
    private static int partition(int[] arr, int low, int high) {
        //选择最后一个作为pivot
        int pivot = arr[high];
        //Index of smaller element and indicates the right position
        //of pivot found so far
        int i = low-1;
        for(int j = low; j<= high-1; j++){
            //if current element is smaller than pivot
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return (i+1);
    }

    //将循环到的每个数插入到前方已排好序的数组的正确位置
    //O(N^2)
    private static void insertionSort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++){
            for(int j = i; j>0; j--){
                if(arr[j] < arr[j-1]){
                    int swap = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = swap;
                }
            }
        }
    }

    // 循环未排序，将每个数与后面一个比较，如果大则与后面交换，每次把最大值放到最后当作已排好部分
    // O(N^2)
    private static void bubbleSort(int[] arr) {
        int size = arr.length;
        boolean isSorted = false;
        for(int i = size-1; i > 0 && !isSorted; i--){
            isSorted = true;
            for(int j = 0; j < i; j++){
                // 如果没进入，说明数组已经有序，isSorted = true, 跳出下次循环，无需再排序
                if(arr[j]>arr[j+1]){
                    isSorted = false;
                    int swap = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = swap;
                }
            }
        }
    }

    // 每次遍历时选出未排序部分的最小值，放入前方已排好部分的末尾；
    //O(N^2)
    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j=i+1;j < arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int swap = arr[i];
            arr[i] = arr[min];
            arr[min] = swap;
        }
    }
}
