package org.example;

public class LastIndexOfEle {
    public static int findEleLast(int[] arr, int index, int key)
    {
        if(index == arr.length -1)
        {
            if(arr[index] == key)
                return index;
            return -1;
        }
        int found1 = findEleLast(arr, index + 1, key);
        int found2 =-1;
        if(found1 != -1)
            return found1;
        else{
            if(arr[index] == key)
            {
                found2 = index;
            }
        }
        return found2;
    }
    static  int  findInFaith(int[] arr, int index, int key)
    {
        if(arr.length == index)
        {
            return  -1;
        }

        int findINFAITH = findInFaith(arr,index+1, key);
        if(findINFAITH != -1)
        {
            return findINFAITH;
        }
        else{
            if(arr[index] == key)
                return index;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,9,3,7,6,4,12,7,3,8,8,8,8,8,8,8,8,8};
        System.out.println(findEleLast(arr, 0, 8));
        System.out.println(findInFaith(arr, 0, 8));
    }
}
