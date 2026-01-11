public class Solution {
    public long CountPairs(string[] words) {
        string[] arr = words; 
        Dictionary<string, long> freq = new Dictionary<string, long>();
        foreach (string word in arr) {
            string key = Normalize(word);
            if (!freq.ContainsKey(key))
                freq[key] = 0;
            freq[key]++;
        }
        long count = 0;
        foreach (var f in freq.Values) {
            if (f > 1)
                count += f * (f - 1) / 2;
        }
        return count;
    }
    private string Normalize(string s) {
        int shift = s[0] - 'a';
        char[] arr = new char[s.Length];
        for (int i = 0; i < s.Length; i++) {
            int diff = (s[i] - 'a' - shift + 26) % 26;
            arr[i] = (char)('a' + diff);
        }
        return new string(arr);
    }
}
