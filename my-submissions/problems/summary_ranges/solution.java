class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> list = new ArrayList<String>();
        if(nums.length > 0)
        {
            boolean isContinuous = false, arrowDone = false;
            int current, prev = nums[0];
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < nums.length; i++)
            {
                current = nums[i];
                if(i == 0)
                    sb.append(current);
                if(current ==  prev + 1)
                    isContinuous = true;
                else
                    isContinuous = false;
                if(isContinuous && !arrowDone)
                {
                    sb.append("->");
                    arrowDone = true;
                }
                else if(i != 0 && !isContinuous)
                {
                    if(arrowDone)
                        sb.append(prev);
                    list.add(sb.toString());
                    sb.setLength(0);
                    sb.append(current);
                    arrowDone = false;
                }
                prev = current;
                if(i == nums.length - 1)
                    if(arrowDone)
                        sb.append(current);
            }
            if(sb.length() != 0)
                list.add(sb.toString());
        }
        return list;
    }
}