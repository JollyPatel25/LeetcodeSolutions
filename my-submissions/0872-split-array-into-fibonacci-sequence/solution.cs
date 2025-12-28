public class Solution {
    public IList<int> SplitIntoFibonacci(string num) {
        IList<int> result = new List<int>();
        bool backtrack(int index)
        {
            if (index >= num.Length) return result.Count >= 3;
            long curr = 0;
            for (int i = index; i < num.Length; i++)
            {
                if(i > index && num[index] == '0') break;

                curr = curr * 10 + (num[i] - '0');
                if(curr > int.MaxValue) break;

                int size = result.Count;
                if(size >= 2)
                {
                    int first = result[result.Count - 2];
                    int second = result[result.Count - 1];
                    long sum = (long)first + (long)second;
                    if(curr < sum) continue;
                    if(curr > sum) break; 
                }

                result.Add((int)curr);
                if(backtrack(i + 1)) return true;
                result.RemoveAt(result.Count - 1);
            }
            return false;
        }
        backtrack(0);
        return result;
    }
}
