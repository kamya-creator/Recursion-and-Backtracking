package classicProblms;

public class MaximumScoreWordsFormedbyLetters {

        public static int maxScoreWords(String[] words, char[] letters, int[] score) {
            int[] freq = new int[26];
            for(int i = 0; i< letters.length;i++)
            {
                char c = letters[i];
                freq[c-'a']++;
            }
            int findMaxScoreSubset = solve(words,letters,0, score, freq);

            return findMaxScoreSubset;
        }
        public static int solve(String[] words, char[] letters, int index, int[] score, int[] freq)
        {
            if(index == words.length)
            {
                return 0;
            }
            int sayNo = 0 + solve(words, letters, index + 1, score, freq);

            // say Yess ki call
            String word = words[index];
            int wordScore = 0;
            boolean flag = true;
            boolean canUse = true;
            int[] wordFreqReq = new int[26];
            for(char c : word.toCharArray())
            {
                wordFreqReq[c - 'a']++;
                if(wordFreqReq[c - 'a'] > freq[c- 'a'])
                {
                    canUse = false;
                    break;
                }
            }
            if(canUse)
            {
                for(int i =0; i < word.length() ; i++ )
                {
                    char ch = word.charAt(i);
                    if(freq[ch - 'a'] > 0)
                    {
                        freq[ch - 'a']--;

                        wordScore+= score[ch - 'a'];
                    }

                }
            }
            int sayYes = 0;

            if(canUse)
            {
                sayYes = wordScore + solve(words, letters, index + 1 , score , freq);
                for(int i =0; i< word.length();i++)
                {
                    char ch = word.charAt(i);
                    freq[ch - 'a']++;
                }
            }
            //  System.out.print("YesScore "+ sayYes +" NoScore " +sayNo);
            return Math.max(sayNo, sayYes);

        }

    public static void main(String[] args) {
        String[] words ={"dog","cat","dad","good"};
        char[] letter = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int maxScoreWordsRes = maxScoreWords(words, letter, score);
        System.out.println(maxScoreWordsRes);
    }
}
