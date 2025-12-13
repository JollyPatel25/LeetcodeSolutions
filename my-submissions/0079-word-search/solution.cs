public class Solution {
    public bool Exist(char[][] board, string word) {
        int m = board.Length, n = board[0].Length;
        bool[,] taken = new bool[m, n];
        bool result = false;
        bool backtrack(int i, int j, int length)
        {
            if(length == word.Length) return true;
            if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word[length] || taken[i, j]) return false;

            taken[i, j] = true;

            bool found = backtrack(i - 1, j, length + 1) ||
                        backtrack(i, j - 1, length + 1) ||
                        backtrack(i + 1, j, length + 1) ||
                        backtrack(i, j + 1, length + 1);

            taken[i, j] = false;
            return found;
        }
        for(int i = 0; i < board.Length; i++)
        {
            for(int j = 0; j < board[i].Length; j++){
                result = result || backtrack(i, j, 0);
            }
        }
        return result;
    }
}
