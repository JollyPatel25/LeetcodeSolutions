class Solution {
    public char RepeatedCharacter(String s) {
        int mask = 0;
        foreach (char c in s.ToCharArray()) {
            int bit = 1 << (c - 'a');
            if ((mask & bit) != 0) return c;
            mask |= bit;
        }
        return ' '; // never reached
    }
}

