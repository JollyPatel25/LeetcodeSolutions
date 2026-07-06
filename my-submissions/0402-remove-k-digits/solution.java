class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            char current = num.charAt(i);

            while (sb.length() > 0 &&
                   k > 0 &&
                   sb.charAt(sb.length() - 1) > current) {
                sb.setLength(sb.length() - 1);
                k--;
            }

            sb.append(current);
        }

        // Remove remaining digits from the end if k is still left
        while (k > 0 && sb.length() > 0) {
            sb.setLength(sb.length() - 1);
            k--;
        }

        // Remove leading zeros
        int start = 0;
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }

        String result = sb.substring(start);

        return result.isEmpty() ? "0" : result;
    }
}
