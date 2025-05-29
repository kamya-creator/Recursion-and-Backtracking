package KPartitionsProblems;

import java.util.ArrayList;

public class KPartitionsSubSet {

    public  static  void solve(int level, int n , ArrayList<ArrayList<Integer>> partitions, int[] counter )
    {
        if(level > n)
        {
            counter[0]++;
            for (int i = 0; i < partitions.size(); i++) {
                System.out.print(partitions.get(i));
            }
            System.out.println();
            return;
        }


        for(int i = 0;i<partitions.size();i++ )
        {
            ArrayList<Integer> currAL = partitions.get(i);
            if(currAL.size() == 0)
            {
                currAL.add(level);
                solve(level + 1, n, partitions,counter);
                currAL.remove(currAL.size() - 1);
                break;
            }
            else
            {
                currAL.add(level);
                solve(level + 1, n, partitions , counter);
                currAL.remove(currAL.size() - 1);
            }
        }

    }
    public static void main(String[] args) {
        int n = 3;
        ArrayList<ArrayList<Integer>> partitions = new ArrayList<>();
        for(int i =0;i<n;i++)
        {
            partitions.add(new ArrayList<>());
        }
        int[] counter = new int[1];
        String partitionsSOFar = "";
        solve(1, n , partitions, counter);
        System.out.println(counter[0]);
    }
}
