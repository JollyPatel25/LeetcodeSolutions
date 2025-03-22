class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hash = new HashSet<>();
        while (n != 1 && !hash.contains(n)) {
            hash.add(n);
            n = getSumOfSquares(n);
        }
        return n == 1;
    }
    public int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
