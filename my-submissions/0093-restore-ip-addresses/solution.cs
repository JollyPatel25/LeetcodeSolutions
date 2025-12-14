public class Solution {
    public IList<string> RestoreIpAddresses(string s) {
        IList<string> result = new List<string>();
        StringBuilder sb = new StringBuilder();
        if(s.Length < 4 || s.Length > 12) return result;
        void backtrack(int index, int dots)
        {
            if(dots == 0)
            {
                string last = s.Substring(index);
                if(IsValid(last))
                {
                    result.Add(sb.ToString() + last);
                }
                return;
            }

            for(int i = 1; i <= 3 && (index + i) < s.Length; i++)
            {
                string part = s.Substring(index, i);
                int before = sb.Length;
                if(!IsValid(part)) continue;
                sb.Append(part + ".");
                backtrack(index + i, dots - 1);
                sb.Length = before;
            }
            return;
        }
        backtrack(0, 3);
        return result;
    }
    private bool IsValid(String part)
    {
        if(part.Length > 1 && part[0] == '0') return false;
        int value = int.Parse(part); 
        return value >= 0 && value <= 255;
    }
}
