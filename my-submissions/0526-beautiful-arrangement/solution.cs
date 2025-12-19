public class Solution {
    public int CountArrangement(int n) {
        int count = 0;
        IList<int> current = new List<int>();
        IList<int> unused = new List<int>();
        for(int i = 1; i <= n; i++)
        {
            unused.Add(i);
        }
        void backtrack(int index)
        {
            if(current.Count == n)
            {
                count++;
                return;
            }
            for(int i = 0; i < unused.Count; i++)
            {
                int element = unused[i];
                if(element % index != 0 && index % element != 0) continue;
                current.Add(element);
                unused.RemoveAt(i);
                backtrack(index + 1);
                unused.Insert(i, element);
                current.RemoveAt(current.Count - 1);
            }
        }
        backtrack(1);
        return count;
    }
}
