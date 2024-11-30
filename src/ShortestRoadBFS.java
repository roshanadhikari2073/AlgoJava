import java.util.*;

public class ShortestRoadBFS {
    class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
                adj.get(i).add(i + 1);
            }

            List<Integer> resList = new ArrayList<>();
            for (int[] query : queries) {
                adj.get(query[0]).add(query[1]);
                resList.add(shortestPath(adj, n));
            }

            return resList.stream().mapToInt(Integer::intValue).toArray();
        }

        private int shortestPath(List<List<Integer>> adj, int n) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0, 0}); // node, length
            Set<Integer> visit = new HashSet<>();
            visit.add(0);

            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int cur = curr[0];
                int length = curr[1];

                if (cur == n - 1) return length;

                for (int nei : adj.get(cur)) {
                    if (!visit.contains(nei)) {
                        q.offer(new int[]{nei, length + 1});
                        visit.add(nei);
                    }
                }
            }
            return -1;
        }
    }
}

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int lastNode = n - 1;
        // keeps next nodes for each node
        int[][] adjacencyArray = new int[lastNode][];
        // keeps the count of next nodes for each node
        int[] adjacencyIndexes = new int[lastNode];
        // keeps the min distance from the start node for each node
        int[] minDistanceFromStart = new int[n];
        // space optimization: precalculate size of adjacent nodes for each node
        // in order to allocate the minimal array sizes
        for (int i = 0; i < queries.length; i++) {
            adjacencyIndexes[queries[i][0]]++;
        }
        for (int i = 0; i < lastNode; i++) {
            adjacencyArray[i] = new int[adjacencyIndexes[i] + 1];
            adjacencyIndexes[i] = 0;
            minDistanceFromStart[i] = i;
            adjacencyArray[i][adjacencyIndexes[i]++] = i + 1;
        }
        minDistanceFromStart[lastNode] = lastNode;
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int startNode = queries[i][0];
            int endNode = queries[i][1];
            // new minDistance will take advantage of the new query connection
            int currentDistanceFromStart = minDistanceFromStart[startNode] + 1;
            if (minDistanceFromStart[endNode] > currentDistanceFromStart) {
                minDistanceFromStart[endNode] = currentDistanceFromStart;
                calculateDistanceFromStart(endNode, adjacencyArray, adjacencyIndexes, minDistanceFromStart);
            }
            adjacencyArray[startNode][adjacencyIndexes[startNode]++] = endNode;
            result[i] = minDistanceFromStart[lastNode];
        }
        return result;
    }

    private static void calculateDistanceFromStart(int node, int[][] adjacencyArray, int[] adjacencyIndexes,
                                                   int[] minDistanceFromStart) {
        if (node == adjacencyArray.length)
            return;
        for (int i = 0; i < adjacencyIndexes[node]; i++) {
            int nextNode = adjacencyArray[node][i];
            int currentDistanceFromStart = minDistanceFromStart[node] + 1;
            if (currentDistanceFromStart < minDistanceFromStart[nextNode]) {
                minDistanceFromStart[nextNode] = currentDistanceFromStart;
                calculateDistanceFromStart(nextNode, adjacencyArray, adjacencyIndexes, minDistanceFromStart);
            }
        }
    }
}
