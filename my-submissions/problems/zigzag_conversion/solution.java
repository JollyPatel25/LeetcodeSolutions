class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int length = s.length();
        int cycleLen = 2 * numRows - 2;
        int sum = (length / cycleLen + 1) * (numRows - 1);
        int k = 0, y = 0;
        char[][] chars = new char[numRows][sum];
        boolean isMain = true;
        for (int i = 0; i < sum && k < length; i++) {
            if (isMain) {
                for (int j = 0; j < numRows && k < length; j++) {
                    chars[j][i] = s.charAt(k++);
                    if (j == numRows - 1) {
                        isMain = false;
                        y = j - 1;
                    }
                }
            } 
            else {
                if (y == 0) {
                    isMain = true;
                    i--;
                    continue;
                }
                chars[y][i] = s.charAt(k++);
                y--;
                if (y == 0) {
                    isMain = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] row : chars) {
            for (char ch : row) {
                if (ch != 0)
                    sb.append(ch);
            }
        }
        return sb.toString();
    }
}
