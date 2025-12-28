public class Solution {
    public IList<IList<int>> AllPathsSourceTarget(int[][] graph) {
        IList<IList<int>> result = new List<IList<int>>();
        List<int> current = new List<int>();
        void backtrack(int index)
        {
            current.Add(index);
            if(index == graph.Length - 1) result.Add(new List<int>(current));
            else{
                for(int i = 0; i < graph[index].Length; i++)
                {
                    backtrack(graph[index][i]);
                }
            }
            current.RemoveAt(current.Count - 1);
            
        }
        backtrack(0);
        return result;
    }
}
