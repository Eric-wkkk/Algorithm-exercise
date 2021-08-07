package com.company;

import java.util.BitSet;

public class FindDuplicate {
    public static void main(String[] args) {

        //BitSet是位操作的对象，值只有0或1即false和true
        BitSet bitSet=new BitSet();
        int[] nums={1,2,3,4,5,6,1,2};

        for (int num : nums) {
            //如用重复 get会返回1或者true
            if(bitSet.get(num)){
                System.out.println(num);
                //break;
            }else {
                bitSet.set(num);
            }
        }
    }
}
