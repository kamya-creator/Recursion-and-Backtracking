package classicProblms;

public class LexicographicalSort {
    public static void main(String[] args) {

        int n = 100;
        for (int i = 1; i < 10; i++) {

            // 1 2 3 4 5 6 7 8 9
            solve(i,n);

        }
    }
    public static void solve(int curr,int n)
    {
        if(curr > n)
        {
            return;
        }

        // Print parent root
        System.out.print(curr + " ");


        // print subtree
        /*
        1
        10   11
        100  111
        101  112
        102  113
        103
        104
        105
        106
        109  119

         */
        for(int i = 0;i<10;i++)
        {
            int next = curr*10 + i;
            solve(next, n);
        }
    }
}
