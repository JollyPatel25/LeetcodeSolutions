public class Solution {
    public int ResiduePrefixes(string s) {
        bool[] alphabets = new bool[26];
        int count = 0, residue = 0;
        for(int i = 0; i < s.Length; i++)
        {
            int index = s[i] - 'a';
            if(!alphabets[index]){
                alphabets[index] = true;
                count++;
            }
            if((i + 1) % 3 == count) residue++;
        }
        return residue;
    }
}
