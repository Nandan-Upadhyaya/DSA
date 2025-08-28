class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;
        for(int i = 0 ; i<isConnected.length ; i++) {
            if(!visited[i]) {
                provinces++;
                dfs(i, isConnected, visited);
                
            }
        }
        return provinces;
    }

    public static void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;

        for(int j = 0 ; j<isConnected.length ; j++) {
            if(isConnected[i][j] == 1 && !visited[j]) dfs(j, isConnected, visited);
        }
    }
}