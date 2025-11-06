public class Solution {
    private int[] parent;
    private int[] size;
    private SortedSet<int>[] compOnline;  // for each root, the set of online station-IDs

    private int Find(int x) {
        return parent[x] == x ? x : parent[x] = Find(parent[x]);
    }

    private void Union(int a, int b) {
        int ra = Find(a), rb = Find(b);
        if (ra == rb) return;
        if (size[ra] < size[rb]) {
            parent[ra] = rb;
            size[rb] += size[ra];
            // merge online sets
            foreach (var v in compOnline[ra]) compOnline[rb].Add(v);
        } else {
            parent[rb] = ra;
            size[ra] += size[rb];
            foreach (var v in compOnline[rb]) compOnline[ra].Add(v);
        }
    }

    public int[] ProcessQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        size   = new int[c + 1];
        compOnline = new SortedSet<int>[c + 1];

        // init
        for (int i = 1; i <= c; i++) {
            parent[i] = i;
            size[i] = 1;
            compOnline[i] = new SortedSet<int>(){i};  // initially all online
        }

        // build connectivity
        foreach(var edge in connections) {
            int u = edge[0], v = edge[1];
            Union(u, v);
        }

        var resultList = new List<int>();
        var online = new bool[c + 1];
        for (int i = 1; i <= c; i++) online[i] = true;

        foreach(var q in queries) {
            int t = q[0], x = q[1];
            if (t == 1) {
                int root = Find(x);
                if (!online[x]) {
                    // station x is offline → pick smallest online in its component
                    if (compOnline[root].Count == 0) resultList.Add(-1);
                    else resultList.Add(compOnline[root].Min);
                } else {
                    // x is online → resolves by itself
                    resultList.Add(x);
                }
            } else if (t == 2) {
                // station x goes offline
                if (online[x]) {
                    online[x] = false;
                    int root = Find(x);
                    compOnline[root].Remove(x);
                }
            }
        }

        return resultList.ToArray();
    }
}
