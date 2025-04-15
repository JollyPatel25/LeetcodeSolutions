class Solution {
    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE, current = 0;
        for(int i = 0; i < gain.length; i++){
            current += gain[i];
            if(current > max)
                max = current;
        }
        return max > 0 ? max : 0;
    }
}