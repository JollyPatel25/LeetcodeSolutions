class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0 ; i <= rowIndex; i++)
        {
            List<Integer> newList = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++)
            {
                if(j == 0 || j == i)
                    newList.add(1);
                else 
                {
                    newList.add((list.get(i - 1).get(j - 1)) + (list.get(i - 1).get(j)));
                }
            }
            if(i == rowIndex)
                return newList;
            list.add(newList);
        }
        return null;
    }
}