public class Solution {
    public int VowelConsonantScore(string s) {
        int vowel = 0, consonant = 0;
        foreach(char c in s)
        {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vowel++;
            }
            else if(c >= 'a' && c <= 'z')
            {
                consonant++;
            }
        }
        if(consonant > 0)
        {
            return (int)(vowel / consonant);
        }
        return 0;
    }
}
