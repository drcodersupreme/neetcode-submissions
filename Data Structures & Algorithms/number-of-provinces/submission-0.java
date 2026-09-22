class Solution {
    private ArrayList<ArrayList<Integer>> adj(int[][] isConnected){
        int n = isConnected.length;
        int m = isConnected[0].length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= isConnected.length; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(isConnected[i][j] == 1 && i != j){
                    graph.get(i+1).add(j+1);
                }
            }
        }
        return graph;
    }
    private void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean visited[]){
        visited[node] = true;
        for(int i : graph.get(node)){
            if(!visited[i]){
                dfs(graph, i, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> graph = adj(isConnected);
        int n = graph.size() - 1;
        boolean visited[] = new boolean[graph.size() + 1];
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                ans++;
                dfs(graph, i, visited);
            }
        }
        return ans;

    }
}