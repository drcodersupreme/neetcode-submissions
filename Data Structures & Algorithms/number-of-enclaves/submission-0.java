class Solution {
    class Pair {
        int row, col;

        public Pair(int n, int m) {
            this.row = n;
            this.col = m;
        }
    }

    public int bfs(int board[][]) {
        int count = 0;
        Queue<Pair> q = new LinkedList<>();

        boolean vis[][] = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (i == 0 || i == board.length - 1 ||
                    j == 0 || j == board[0].length - 1) {

                    if (board[i][j] == 1) {
                        vis[i][j] = true;
                        q.offer(new Pair(i, j));
                    }
                }
            }
        }

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {

                int nr = p.row + delRow[i];
                int nc = p.col + delCol[i];

                if (nr < board.length && nr >= 0 &&nc < board[0].length && nc >= 0 && !vis[nr][nc] && board[nr][nc] == 1) { 

                    q.offer(new Pair(nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 1 && !vis[i][j]) {
                    count ++;
                }
            }
        }
        return count ;
    }

    public int numEnclaves(int[][] grid) {
        return bfs(grid);
    }
}