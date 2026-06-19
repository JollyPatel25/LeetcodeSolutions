class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> distance(b) - distance(a));
        for (int i = 0; i < points.length; i++)
        {
            maxHeap.offer(points[i]);
            if(maxHeap.size() > k) maxHeap.poll();
        }
        for (int i = 0; i < k; i++)
        {
            result[i] = maxHeap.poll();
        }
        return result;
    }
    int distance(int point[])
    {
        return point[0] * point[0] + point[1] * point[1];
    }
}
