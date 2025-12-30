public class Solution {
    public int NumTilePossibilities(string tiles) {
        int[] count = new int[26];
        foreach (char c in tiles)
            count[c - 'A']++;

        return Backtrack(count);
    }

    private int Backtrack(int[] count) {
        int total = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            total++;
            count[i]--;
            total += Backtrack(count);
            count[i]++;
        }

        return total;
    }
}

