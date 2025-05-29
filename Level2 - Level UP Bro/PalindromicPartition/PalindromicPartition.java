package KPartitionsProblems;

public class PalindromicPartition {
    public static void main(String[] args) {
        String s = "abaaba";
        String partitionSoFar = "";
        solve( s, partitionSoFar);
    }
    public static void solve( String ques, String partitionSoFar)
    {
        if(ques.length() == 0)
        {
            System.out.println(partitionSoFar);
            return;
        }
        for(int i = 0 ;i <ques.length();i++)
        {
            String prefix = ques.substring(0, i+1);
            if(isPalindrome(prefix))
            {
                String roq = ques.substring(i + 1);
                solve(roq, partitionSoFar + "(" + prefix + ")");

            }
        }
    }
    public static boolean isPalindrome(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }
}
