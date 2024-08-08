package com.blogapp12.controller;

public class ABC {
    public static void main(String [] args){
        System.out.println("debug the application");
        int arr[]={1,2,2,3,4,5};
        int sum = getSum(arr);
        System.out.println("sum"+sum);
    }
    public static int getSum(int arr[]){
        int s=0;
        for (int i =0;i<arr.length;i++){
            s=s+arr[i];

        }

        return s;
// hey yo niggas
    }
}
