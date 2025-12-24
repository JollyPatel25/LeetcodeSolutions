public class Solution {
    public string LargestTimeFromDigits(int[] arr) {
        IList<int> unused = new List<int>();
        foreach (int i in arr)
            unused.Add(i);

        string latest = "";        // store best result
        StringBuilder sb = new StringBuilder();

        void backtrack(int index)
        {
            if (index == 4)
            {
                string curr = sb.ToString();
                if (IsValid(curr))
                {
                    if (latest == "" ||
                        string.Compare(curr, latest, StringComparison.Ordinal) > 0)
                    {
                        latest = curr;
                    }
                }
                return;
            }

            for (int i = 0; i < unused.Count; i++)
            {
                int val = unused[i];
                sb.Append(val);
                unused.RemoveAt(i);

                backtrack(index + 1);

                sb.Length--;
                unused.Insert(i, val);
            }
        }

        backtrack(0);

        return latest == "" ? "" : $"{latest.Substring(0,2)}:{latest.Substring(2,2)}";
    }

    bool IsValid(string sb)
    {
        int hour = int.Parse(sb.Substring(0, 2));
        int minute = int.Parse(sb.Substring(2, 2));
        return hour <= 23 && minute <= 59;
    }
}

