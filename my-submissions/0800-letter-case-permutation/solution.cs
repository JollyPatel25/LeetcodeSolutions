using System.Text.RegularExpressions;
public class Solution {
    public IList<string> LetterCasePermutation(string s) {
        IList<string> list = new List<string>();
        StringBuilder sb = new StringBuilder();
        void backtrack(int index)
        {
            if(index == s.Length)
            {
                list.Add(sb.ToString());
                return;
            }
            if(char.IsDigit(s[index])) {
                sb.Append(s[index]);
                backtrack(index + 1);
                sb.Length--;
            }
            else{
                sb.Append((s[index] + "").ToLower());
                backtrack(index + 1);
                sb.Length--; 
                sb.Append((s[index] + "").ToUpper());
                backtrack(index + 1);
                sb.Length--;
            }
        }
        backtrack(0);
        return list;
    }
}
