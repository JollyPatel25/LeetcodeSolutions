public class Solution {
    public IList<string> AmbiguousCoordinates(string s) {
        s = s.Substring(1, s.Length - 2);
        IList<string> result = new List<string>();

        void backtrack(int index) {
            if (index >= s.Length - 1) return;

            List<string> firsts = GenerateAll(index, true);
            List<string> seconds = GenerateAll(index, false);

            foreach (string x in firsts) {
                foreach (string y in seconds) {
                    result.Add($"({x}, {y})");
                }
            }

            backtrack(index + 1);
        }

        List<string> GenerateAll(int index, bool isFirst) {
            List<string> list = new List<string>();
            string part;

            if (isFirst)
                part = s.Substring(0, index + 1);
            else
                part = s.Substring(index + 1);

            //Integer-only case
            if (IsValidInteger(part))
                list.Add(part);

            //Decimal cases
            for (int i = 1; i < part.Length; i++) {
                string left = part.Substring(0, i);
                string right = part.Substring(i);

                if (IsValidInteger(left) && IsValidDecimal(right)) {
                    list.Add(left + "." + right);
                }
            }

            return list;
        }
        bool IsValidInteger(string s) {
            return s.Length == 1 || s[0] != '0';
        }
        bool IsValidDecimal(string s) {
            return s.Length > 0 && s[s.Length - 1] != '0';
        }
        backtrack(0);
        return result;
    }
}

