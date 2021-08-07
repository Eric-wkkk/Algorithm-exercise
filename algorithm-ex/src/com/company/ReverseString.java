package com.company;

public class ReverseString {
    public static void main(String[] args) {
        String msg = "www.eric.com";
        reverse(msg);
    }

    public static void reverse(String msg){
        String msg2 = new StringBuilder(msg).reverse().toString();
        System.out.println(msg2);
    }

}
