class Solution {
    public String shortestSuperstring(String[] words) {
        int[][] dp = new int[1 << words.length][words.length];
        int[][] parent = new int[1 << words.length][words.length];
        for (int i = 0; i < (1 << words.length); i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 0; i < words.length; i++) dp[1 << i][i] = words[i].length();

        for(int mask = 0; mask < (1 << words.length); mask++)
        {
            for (int i = 0; i < words.length; i++)
            {
                if((mask & (1 << i)) == 0) continue;
                int prevMask = mask & ~(1 << i);
                for (int j = 0; j < words.length; j++)
                {
                    if((prevMask & (1 << j)) == 0) continue;
                    if(dp[prevMask][j] == Integer.MAX_VALUE) continue;
                    int newCost = dp[prevMask][j] + words[i].length() - overlap(words[j], words[i]);
                    if(dp[mask][i] > newCost)
                    {
                        dp[mask][i] = newCost;
                        parent[mask][i] = j;
                    }
                }
            }
        }
        int fullMask = (1 << words.length) - 1;
        int minLen = Integer.MAX_VALUE;
        int bestEnd = -1;
        for (int i = 0; i < words.length; i++) {
            if(dp[fullMask][i] < minLen)
            {
                minLen = dp[fullMask][i];
                bestEnd = i;
            }
        }
        StringBuilder result = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();
        int currentMask = fullMask, currentWord = bestEnd;
        while((currentMask & (currentMask - 1)) != 0)
        {
            list.add(currentWord);
            int prevWord = parent[currentMask][currentWord];
            currentMask = currentMask & ~(1 << currentWord);
            currentWord = prevWord;
        }
        list.add(currentWord);
        Collections.reverse(list);

        result.append(words[list.get(0)]);
        for (int i = 1; i < list.size(); i++)
        {
            String prev = words[list.get(i - 1)];
            String curr  =words[list.get(i)];
            int ov = overlap(prev, curr);
            result.append(curr.substring(ov, curr.length()));
        }
        return result.toString();
    }
    public int overlap(String s1, String s2)
    {
        int maxLen = Math.min(s1.length(), s2.length());
        for (int len = maxLen; len > 0; len--)
        {
            if(s1.endsWith(s2.substring(0, len))) return len;
        }
        return 0;
    }
}
