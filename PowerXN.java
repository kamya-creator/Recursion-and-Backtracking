package org.example;

public class PowerXN {
    static long power(int x, int n)
    {
        if(n == 0)
        { return 1;
        }
        long ans = power(x, n-1);
        return x* ans;
    }
    static long powerLog(int x, int n)
    {
        if(n == 0)
        {
            return 1;
        }
        long power = power(x, n/2);
        long ans = power*power;
        if(n %2 == 1) ans = ans*x;
        return ans;
    }
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println("Power with x*x-1 "+ power(2,11));
        System.out.println(System.currentTimeMillis() - start);


        start = System.currentTimeMillis();
        System.out.println("Power with log "+powerLog(2,11));
        System.out.println(System.currentTimeMillis() - start);
    }
}
