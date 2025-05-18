package org.example;

public class GetStairPath {
    public static void main(String[] args) {
        int n = 3;
        int res = getStairPaths(0, n);
        System.out.println(res);
    }
    public static int getStairPaths(int currentStair, int destinationStair)
    {
        if(currentStair == destinationStair)
        {
            return 1;
        }

        if(currentStair > destinationStair)
        {
            return 0;
        }
        // 1 step allowed
        int way1 = getStairPaths(currentStair + 1, destinationStair);

        // 2steps at a time allowed
        int way2 = getStairPaths(currentStair +2, destinationStair);

        // 3steps at a time allowed
        int way3 = getStairPaths(currentStair +3, destinationStair);

        return way1 + way2 +way3;
    }
}
