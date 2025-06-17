class Solution {
    public String[] findRelativeRanks(int[] score) {
        String result[] = new String[score.length];
        Integer indices[] = new Integer[score.length];
        for(int i = 0; i < indices.length; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> Integer.compare(score[b], score[a]));
        for(int i = 0; i < indices.length; i++)
        {
            if(i == 0){
                result[indices[i]] = "Gold Medal";
            }
            else if(i == 1)
            {
                result[indices[i]] = "Silver Medal";
            }
            else if(i == 2)
            {
                result[indices[i]] = "Bronze Medal";
            }
            else
            {
                result[indices[i]] = String.valueOf(i + 1);
            }
        }
        return result;
    }
}