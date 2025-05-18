package org.example;

public class PrintStairPath {
    public static void main(String[] args) {
        int n =3;
        String ans = "";

        System.out.println("Jumping from Top to bottom");
        printStairPathJump(n , ans);

        System.out.println("Climbing from bottom to UP");

        printStrainPathClimb(0, "", n);
    }
    public static void printStairPathJump(int n , String ans)
    {
        if(n == 0)
        {
            System.out.println(ans);
            return;
        }

        if(n - 1 >= 0)
            printStairPathJump(n-1 , ans + "1");

        if(n-2 >= 0)
            printStairPathJump(n-2, ans +"2");
        if(n-3 >= 0)
            printStairPathJump(n-3, ans+"3");
    }

    public static void printStrainPathClimb(int ques, String ans, int n)
    {
        if(ques == n)
        {
            System.out.println(ans);
            return;
        }
        if(ques > n)
        {
            return;
        }

        printStrainPathClimb(ques + 1 , ans +"1", n);
        printStrainPathClimb(ques + 2, ans  + "2" , n);
        printStrainPathClimb(ques + 3 , ans + "3" , n);

    }
}
