public class Solution {
    public bool Makesquare(int[] matchsticks) {
        int n = matchsticks.Length;
        if (n < 4) return false;

        int total = 0;
        foreach (int m in matchsticks) total += m;
        if (total % 4 != 0) return false;

        int side = total / 4;

        // Sort descending for faster pruning
        Array.Sort(matchsticks);
        Array.Reverse(matchsticks);

        int[] sides = new int[4];

        bool backtrack(int index) {
            if (index == n) {
                return sides[0] == side &&
                       sides[1] == side &&
                       sides[2] == side &&
                       sides[3] == side;
            }

            for (int i = 0; i < 4; i++) {
                if (sides[i] + matchsticks[index] > side) continue;

                sides[i] += matchsticks[index];
                if (backtrack(index + 1)) return true;
                sides[i] -= matchsticks[index];
                if(sides[i] == 0) break;
            }

            return false;
        }

        return backtrack(0);
    }
}

