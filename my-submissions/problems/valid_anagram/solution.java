class Solution {
    public boolean isAnagram(String s, String t) {
        int letters[] = new int[26];
        for( int i = 0; i < s.length(); i++)
        {
            letters[(int)s.charAt(i)- 97]++;
        }
        for(int i = 0; i < t.length(); i++)
        {
            letters[(int)t.charAt(i) - 97]--;
        }
        for(int i = 0 ; i < 26; i++)
        {
            if(letters[i] != 0)
            {
                return false;
            }
        }
        return true;
    }
}