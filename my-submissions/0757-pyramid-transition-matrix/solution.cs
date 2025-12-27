public class Solution {
    public bool PyramidTransition(string bottom, IList<string> allowed) {
        Dictionary<string, IList<char>> dict = new Dictionary<string, IList<char>>();
        Dictionary<string, bool> memo = new Dictionary<string, bool>();
        foreach (string s in allowed)
        {
            string key = s.Substring(0, 2);
            char top = s[2];
            if(!dict.ContainsKey(key))
                dict[key] = new List<char>();
            dict[key].Add(top);
        }
        bool Backtrack(string row)
        {
            if(row.Length == 1) return true;
            if(memo.ContainsKey(row)) return memo[row];
            List<string> nextRows = new List<string>();
            BuildNextRows(0, row, new StringBuilder(), nextRows);
            foreach (string s in nextRows){
                if(Backtrack(s)){
                    memo[row] = true;
                    return true;
                }
            }
            memo[row] = false;
            return false;
        }
        void BuildNextRows(int index, string row, StringBuilder current, List<string> result)
        {
            if(index == row.Length - 1)
            {
                result.Add(current.ToString());
                return;
            }
            string key = row.Substring(index, 2);
            if(!dict.ContainsKey(key)) return;
            foreach (char c in dict[key])
            {
                current.Append(c);
                BuildNextRows(index + 1, row, current, result);
                current.Length--;
            }
        }
        return Backtrack(bottom);
    }
}
