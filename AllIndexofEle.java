package org.example;

import java.util.ArrayList;

public class AllIndexofEle {

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndexofEle(int[] arr, int index, int key)
    {
        if(index == arr.length)
        {
            return;
        }
        if(arr[index] == key)
        {
            list.add(index);
        }
        findAllIndexofEle(arr, index+1,key);



    }

    public static void main(String[] args) {
        int[] arr = {2,3,8, 9,3,7,6,4,12,7,3,8};
        findAllIndexofEle(arr, 0, 3);
        System.out.println(list);
    }
}
