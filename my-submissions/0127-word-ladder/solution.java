class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<String>();
        Set<String> wordSet = new HashSet<String>(wordList);
        int count = 1;
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-- > 0)
            {
                String current = queue.poll();
                if(current.equals(endWord)) return count;
                char[] chars = current.toCharArray();
                for(int i = 0; i < current.length(); i++)
                {
                    char original = chars[i];
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        if(c == original) continue;
                        chars[i] = c;
                        String newWord = new String(chars);
                        if(wordSet.contains(newWord))
                        {
                            wordSet.remove(newWord);
                            queue.offer(newWord);

                        }
                    }
                    chars[i] = original;
                }
            }
            count++;
        }
        
        return 0;
    }
}
