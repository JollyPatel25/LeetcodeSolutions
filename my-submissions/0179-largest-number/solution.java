class Solution {
    public String largestNumber(int[] nums) {
        boolean isZero = true;
        String[] str = new String[nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0) isZero = false;
            str[i] = String.valueOf(nums[i]);
        }
        if(isZero) return String.valueOf(0);
        Arrays.sort(str, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : str) sb.append(s);

        return sb.toString();
    }
}
