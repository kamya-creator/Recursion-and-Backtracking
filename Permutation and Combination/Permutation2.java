package PnC;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Permutation2 {
    public static void main(String[] args) {
        String str = "aabb";
        char[] boxes = new char[str.length()];
        Arrays.fill(boxes, '0');
        int index = 0;
        solve(str, index, boxes);
    }
    public static void solve(String str, int index, char[] box)
    {
        if(index == str.length())
        {
            System.out.println(Arrays.toString(box));
            return;
        }

        char ch = str.charAt(index);
        String s = new String(box);
        int start = s.indexOf(ch);

        for(int i = start + 1; i<box.length;i++)
        {
            if(box[i] == '0')
            {
                box[i] = ch;
                solve(str, index + 1, box);
                box[i] = '0';
            }
        }
    }
}
