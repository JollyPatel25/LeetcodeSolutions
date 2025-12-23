public class Solution {
    public int ShoppingOffers(IList<int> price, IList<IList<int>> special, IList<int> needs) {

        Dictionary<string, int> memo = new Dictionary<string, int>();

        int dfs(IList<int> currNeeds)
        {
            string key = string.Join(",", currNeeds);
            if (memo.ContainsKey(key))
                return memo[key];

            // Base cost: buy remaining items individually
            int minCost = 0;
            for (int i = 0; i < price.Count; i++)
                minCost += currNeeds[i] * price[i];

            // Try every special offer
            for (int s = 0; s < special.Count; s++)
            {
                bool valid = true;
                List<int> newNeeds = new List<int>(currNeeds);

                for (int i = 0; i < price.Count; i++)
                {
                    if (special[s][i] > currNeeds[i])
                    {
                        valid = false;
                        break;
                    }
                    newNeeds[i] -= special[s][i];
                }

                if (valid)
                {
                    minCost = Math.Min(
                        minCost,
                        special[s][price.Count] + dfs(newNeeds)
                    );
                }
            }

            memo[key] = minCost;
            return minCost;
        }

        return dfs(needs);
    }
}

