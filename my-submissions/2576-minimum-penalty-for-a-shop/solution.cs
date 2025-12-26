public class Solution {
    public int BestClosingTime(string customers) {
        int prefixN = 0;
        int suffixY = 0;
        int index = 0;
        foreach(char c in customers)
        {
            if(c == 'Y') suffixY++;
        }
        int min = suffixY;
        for(int i = 0; i < customers.Length; i++)
        {
            if(customers[i] == 'N') prefixN++;
            else suffixY--;
            int sum = prefixN + suffixY;
            if(min > sum)
            {
                min = sum;
                index = i + 1;
            }
        }
        return index;
    }
}


