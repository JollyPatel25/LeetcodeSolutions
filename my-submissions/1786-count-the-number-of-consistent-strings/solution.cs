public class Solution {
    public int CountConsistentStrings(string allowed, string[] words) {
        int count = 0, mask = 0;
        for(int i = 0 ; i < allowed.Length; i++)
        {
            mask |= 1 << (allowed[i] - 'a');
        }
        for(int i = 0; i < words.Length; i++)
        {
            bool isConsistent = true;
            for(int j = 0; j < words[i].Length; j++)
            {
                if(((1 << (words[i][j] - 'a')) & mask) == 0) isConsistent = false;
            }
            if(isConsistent) count++;
        }
        return count;
    }
}
