class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                arr.add(i);
                if (i != num / i) {  
                    arr.add(num / i);
                }
            }
        }
        arr.removeIf(n -> n == num);
        for(int n : arr)
        {
            sum += n;
        }
        return sum == num;
    }
}