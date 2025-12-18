public class Solution {
    public int CountNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int result = 10;      // for n = 1
        int unique = 9;      // choices for first digit
        int available = 9;   // remaining digits

        for (int i = 2; i <= n && available > 0; i++) {
            unique *= available;
            result += unique;
            available--;
        }

        return result;
    }
}

