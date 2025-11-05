public class Solution
{
    // comparer: sort by freq asc, then value asc
    private readonly Comparer<(int freq, int value)> _comparer;
    private readonly SortedSet<(int freq, int value)> topElements;
    private readonly SortedSet<(int freq, int value)> remainingElements;
    private readonly Dictionary<int, int> frequencyMap = new Dictionary<int, int>();
    private long currentSum = 0;

    public Solution()
    {
        _comparer = Comparer<(int freq, int value)>.Create((a, b) =>
        {
            if (a.freq != b.freq) return a.freq.CompareTo(b.freq);
            return a.value.CompareTo(b.value);
        });

        topElements = new SortedSet<(int freq, int value)>(_comparer);
        remainingElements = new SortedSet<(int freq, int value)>(_comparer);
    }

    public long[] FindXSum(int[] nums, int k, int x)
    {
        int n = nums.Length;
        long[] result = new long[n - k + 1];

        for (int i = 0; i < n; i++)
        {
            int currentValue = nums[i];

            // Remove current entry (if present) before updating its frequency
            RemoveFromSets(currentValue);

            // increment frequency
            frequencyMap[currentValue] = frequencyMap.GetValueOrDefault(currentValue, 0) + 1;

            // add back with new frequency
            AddToSets(currentValue);

            int windowStartIndex = i - k + 1;
            if (windowStartIndex < 0)
                continue;

            // Balance sets so topElements has at most x items (and fill if < x)
            while (remainingElements.Count > 0 && topElements.Count < x)
            {
                var elem = remainingElements.Max;
                remainingElements.Remove(elem);
                currentSum += (long)elem.freq * elem.value;
                topElements.Add(elem);
            }

            while (topElements.Count > x)
            {
                var elem = topElements.Min;
                topElements.Remove(elem);
                currentSum -= (long)elem.freq * elem.value;
                remainingElements.Add(elem);
            }

            result[windowStartIndex] = currentSum;

            // Slide: remove the outgoing element (the one at windowStartIndex)
            int outNum = nums[windowStartIndex];

            // Remove its current pair from sets (based on current freq)
            RemoveFromSets(outNum);

            // decrement its frequency in the map
            if (frequencyMap.TryGetValue(outNum, out int oldF))
            {
                if (oldF <= 1) frequencyMap.Remove(outNum);
                else frequencyMap[outNum] = oldF - 1;
            }

            // add back updated frequency (if still present)
            AddToSets(outNum);
        }

        return result;
    }

    private void RemoveFromSets(int value)
    {
        if (!frequencyMap.TryGetValue(value, out int f)) return;
        var pair = (freq: f, value: value);

        // Try remove from topElements; if removed, subtract from sum
        if (topElements.Remove(pair))
        {
            currentSum -= (long)pair.freq * pair.value;
        }
        else
        {
            // remove from remaining if present (safe if not present)
            remainingElements.Remove(pair);
        }
    }

    private void AddToSets(int value)
    {
        if (!frequencyMap.TryGetValue(value, out int f)) return;
        var pair = (freq: f, value: value);

        // If topElements has minimum smaller than this pair, move it into topElements
        if (topElements.Count > 0 && _comparer.Compare(topElements.Min, pair) < 0)
        {
            topElements.Add(pair);
            currentSum += (long)pair.freq * pair.value;
        }
        else
        {
            remainingElements.Add(pair);
        }
    }
}
