package KPartitionsProblems;

import java.util.ArrayList;

public class FriendPairing {
    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> partitions = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            partitions.add(new ArrayList<>());
        }
        solvewithKPartitions(1, n, partitions);



        boolean[] visited = new boolean[n + 1];
        String pairingSoFar = "";
        solveWithVistedArray(1, n, pairingSoFar, visited);
    }

    public static  void solveWithVistedArray(int level, int n , String pairingSoFar, boolean[] visited)
    {


        if(level > n)
        {
            System.out.println(pairingSoFar);
            return;
        }

        if(visited[level] == true)
        {
            solveWithVistedArray(level + 1, n , pairingSoFar, visited);
        }
        else if(visited[level] == false)
        {
            // stay single ki call
            visited[level] = true;
            solveWithVistedArray(level + 1, n, pairingSoFar + "(" + level+")", visited);
            visited[level] = false;

            // pair up ki call
            for(int j = level + 1;j<=n;j++)
            {
                if(visited[j] == false)
                {
                    visited[level] = true;
                    visited[j] = true;
                    solveWithVistedArray(level + 1, n, pairingSoFar + "(" + level +"-"+ j+")", visited);
                    visited[level] = false;
                    visited[j] = false;
                }
            }

        }
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
