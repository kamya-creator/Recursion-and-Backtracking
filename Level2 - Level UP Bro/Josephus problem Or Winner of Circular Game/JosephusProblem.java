package classicProblms;

import java.util.concurrent.CopyOnWriteArrayList;

public class JosephusProblem {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        for(int i =0;i<5;i++)
        {
            list.add(i);
        }
        solve(list, 2, 0);
        System.out.println(list);
    }
    public static void solve(CopyOnWriteArrayList<Integer> list, int k, int index)
    {
        while(list.size() > 1)
        {
             index = (index + k - 1)%list.size();
             list.remove(index);
        }
    }
}
