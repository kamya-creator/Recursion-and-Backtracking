package KPartitionsProblems;

import java.util.ArrayList;

public class FriendPairing {
    public static void main(String[] args) {
        int n = 10;
        ArrayList<ArrayList<Integer>> partitions = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            partitions.add(new ArrayList<>());
        }
        solvewithKPartitions(1, n, partitions);
    }
    public static void solvewithKPartitions(int level, int n , ArrayList<ArrayList<Integer>> partitions)
    {

        if(level > n)
        {
            for (int i = 0;i<partitions.size();i++)
                System.out.print(partitions.get(i));
            System.out.println();
            return;
        }

        for(int i = 0; i< partitions.size();i++)
        {
            ArrayList<Integer> currAL = partitions.get(i);
            if(currAL.isEmpty())
            {
                currAL.add(level);
                solvewithKPartitions(level + 1, n , partitions);
                currAL.remove(currAL.size()-1);
                break;
            }
            else if(currAL.size() < 2)
            {
                    currAL.add(level);
                    solvewithKPartitions(level + 1, n, partitions);
                    currAL.remove(currAL.size() - 1);
            }


        }


    }
}
