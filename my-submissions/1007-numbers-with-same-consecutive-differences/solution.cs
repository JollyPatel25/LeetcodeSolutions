public class Solution {
    public int[] NumsSameConsecDiff(int n, int k) {
        IList<int> list = new List<int>();
        int num = 0;
        void backtrack(int index)
        {
            if(index == n){
                list.Add(num);
                return;
            }
            for(int i = 0; i <= 9; i++)
            {
                if(index == 0 && i == 0) continue;
                if(index == 0)
                {
                    num = i;
                    backtrack(index + 1);
                    num = 0;
                }
                else
                {
                    int last = (num % 10) - i;
                    if(last == -k || last == k)
                    {
                        num *= 10;
                        num += i;
                        backtrack(index + 1);
                        num /= 10;
                    }
                }
            }
        }
        backtrack(0);
        return list.ToArray();
    }
}
