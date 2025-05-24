package classicProblms;

public class PrintAbb {
    public static void main(String[] args) {


        String s = "ANKS";
        String ssf = "";
        int count = 0;

        abb(s, ssf, count);
    }
    public  static void abb(String s , String ssf, int count)
    {
        if(s.length() == 0)
        {
            if(count > 0)
            {
                System.out.println(ssf + count);
                return;
            } else if (count == 0) {
                System.out.println(ssf);
                return;
            }
        }
        char c = s.charAt(0);
        String roq = s.substring(1);


        if(count > 0)
        {
            int newcount =0;
            abb(roq, ssf + count + c , newcount);
        }
        else{
            abb(roq, ssf + c ,count);
        }

        abb(roq, ssf, count + 1);
    }
}
