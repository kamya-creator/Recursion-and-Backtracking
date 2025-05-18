package org.example;

public class FirstIndexOfELe {
    static int findEle(int[] arr, int index, int key)
    {
        if(index == arr.length -1)
        {
            if(arr[index] == key)
                return index;
            else return -1;
        }
        int found1 = findEle(arr, index +1, key);
        int found2 = -1;
        if(arr[index] == key) found2 = index;

        if(found2 != -1)
            return found2;

        return found1;

    }

    public static int firstIndex(int[] arr, int key, int index)
    {
        if(index == arr.length)
        {
            return  -1;
        }
        if(arr[index] == key)
        {
            return index;
        }
        int found = firstIndex(arr, key,index +1);
        return found;
    }
    public static void main(String[] args) {
        int[] arr = {2,13,9,13,7,6,4,12,7,3,18};
        System.out.println(findEle(arr, 0, 8));
        System.out.println(firstIndex(arr, 3, 0));
    }
}
