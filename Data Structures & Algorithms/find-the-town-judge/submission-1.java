class Solution {
    public int findJudge(int n, int[][] trust) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int[] indegree = new int[n + 1];

        for(int i = 0; i < trust.length; i++) {
            int person = trust[i][0];
            int trusted = trust[i][1];

            graph.get(person).add(trusted);
            indegree[trusted]++;
        }

        for(int i = 1; i <= n; i++) {

            if(graph.get(i).isEmpty() && indegree[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}