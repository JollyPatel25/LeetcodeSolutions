class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++)
        {
            if(i == 0) {
                list.add(intervals[i]);
                continue;
            }
            int[] temp = list.get(list.size() - 1);
            if(temp[1] >= intervals[i][0]){
                temp[1] = Math.max(temp[1], intervals[i][1]);
                continue;
            }
            list.add(intervals[i]);
            
        }

        int result[][] = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++)
        {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1]; 
        }
        return result;
    }
}
