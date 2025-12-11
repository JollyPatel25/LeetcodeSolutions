public class Solution {
    Dictionary<char, string> dict  = new Dictionary<char, string>();
    public Solution()
    {
        dict.Add('2', "abc");
        dict.Add('3', "def");
        dict.Add('4', "ghi");
        dict.Add('5', "jkl");
        dict.Add('6', "mno");
        dict.Add('7', "pqrs");
        dict.Add('8', "tuv");
        dict.Add('9', "wxyz");
    }
    public IList<string> LetterCombinations(string digits) {
        List<string> list = new List<string>();
        backtrack(digits, 0, "", list);
        return list;
    }
    public void backtrack(string digits, int index, string current, IList<string> list)
    {
        if(index == digits.Length)
        {
            list.Add(current);
            return;
        }
        string chars = dict[digits[index]];
        foreach(char ch in chars)
        {
            backtrack(digits, index + 1, current + ch, list);
        }
        return;
    }
}
