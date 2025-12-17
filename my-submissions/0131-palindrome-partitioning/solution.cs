public class Solution {
    public IList<IList<string>> Partition(string s) {
        IList<IList<string>> result = new List<IList<string>>();
        IList<string> current = new List<string>();
        void Backtrack(int start)
        {
            if(start == s.Length)
            {
                result.Add(new List<string>(current));
                return;
            }
            for(int i = start; i < s.Length; i++)
            {
                string sub = s.Substring(start, i - start + 1);
                if(IsPallindrome(sub))
                {
                    current.Add(sub);
                    Backtrack(i + 1);
                    current.RemoveAt(current.Count - 1);
                }
            }
        }
        Backtrack(0);
        return result;
    }
    bool IsPallindrome(string str)
    {
        int left = 0, right = str.Length - 1;
        while(left < right)
        {
            if(str[left] != str[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
