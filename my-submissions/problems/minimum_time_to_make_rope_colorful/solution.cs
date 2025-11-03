public class Solution {
    public int MinCost(string colors, int[] neededTime) {
        int sum = 0;
        int max = -1;
        bool flag = false;
        for(int i = 1 ; i < colors.Length; i++)
        {
            if(flag){
                if(colors[i].Equals(colors[i - 1]))
                {
                    sum += neededTime[i];
                    max = max < neededTime[i] ? neededTime[i] : max;
                }
                else{
                    sum = sum - max;
                    flag = false;
                }
            }
            else if(colors[i].Equals(colors[i - 1]))
            {
                sum += (neededTime[i - 1] + neededTime[i]);
                flag = true;
                max = neededTime[i - 1] > neededTime[i] ? neededTime[i - 1] : neededTime[i];
            }
        }
        if(flag)
            sum -= max;
        return sum;
    }
}